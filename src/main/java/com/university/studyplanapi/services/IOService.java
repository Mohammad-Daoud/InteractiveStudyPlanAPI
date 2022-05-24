package com.university.studyplanapi.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.university.studyplanapi.config.FileConfig;
import com.university.studyplanapi.exception.FileStorageException;
import com.university.studyplanapi.exception.NotFoundException;
import com.university.studyplanapi.exception.NotNumberException;
import com.university.studyplanapi.model.plan.Category;
import com.university.studyplanapi.model.plan.Course;
import com.university.studyplanapi.model.plan.Plan;
import com.university.studyplanapi.utils.AppLogger;
import com.university.studyplanapi.utils.IDGenerator;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.university.studyplanapi.io.DirectoryLoader.getResourceFilePath;


@Service
public class IOService implements PlanOperation<Plan> {
    private final IDGenerator ROOT_ID_GENERATOR = IDGenerator.getInstance();
    private static final AppLogger LOGGER = AppLogger.create("IOService");
    private static final String CSV_EXTENSION = ".csv";
    private static final String JSON_EXTENSION = ".json";
    private static final String RESPONSE_FILE_PATH = getResourceFilePath() + "response/";
    private final Path fileStorageLocation;

    @Autowired
    public IOService(FileConfig fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        LOGGER.log("created" + fileStorageLocation.toAbsolutePath());
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.");
        }
    }

    @Override
    public List<Course> getUploadedStudyPlan(Plan planCriteria) {
        String csvFilePath = "uploaded/" + planCriteria.toString() + CSV_EXTENSION;
        return getCourses(csvFilePath, true);
    }

    public List<Course> getUniversityUploadedStudyPlan(String fileName) {
        return getCourses(fileName, false);
    }

    private List<Course> getCourses(String csvFilePath, boolean isFacility) {
        List<Course> coursers = new ArrayList<>();
        try (FileReader fileReader = new FileReader(getResourceFilePath() + csvFilePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            loadPlans(coursers, bufferedReader);
            rootHelper(coursers, isFacility);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return coursers;
    }

    public List<Course> getStudyPlan(Plan planCriteria) {
        return getStudyPlanHelper(planCriteria, false);
    }

    public List<Course> getUniversityPlan(Plan planCriteria) {
        return getStudyPlanHelper(planCriteria, true);
    }

    private List<Course> getStudyPlanHelper(Plan planCriteria, boolean isUniversityScope) {
        List<Course> studyPlan = new ArrayList<>();
        String fileName = RESPONSE_FILE_PATH + planCriteria.toString() + JSON_EXTENSION;
        if (isUniversityScope)
            fileName = RESPONSE_FILE_PATH + "university/universityPlan" + JSON_EXTENSION;
        try (FileReader fileReader = new FileReader(fileName)) {
            studyPlan = new Gson().fromJson(fileReader, new TypeToken<List<Course>>() {
            }.getType());
            return studyPlan;
        } catch (Exception e) {
            LOGGER.logError(e);
            return null;
        }
    }

    private void rootHelper(List<Course> courses, boolean isFacility) {
        Course tempCourse = GenerateRoot(isFacility);
        courses.add(tempCourse);
        courses.parallelStream().forEach(course -> {
            if (course.getPrerequisites().isEmpty()
                    && !Objects.equals(course.getCourseName(), "Facility Root")
                    && !Objects.equals(course.getCourseName(), "University Root"))
                course.getPrerequisites().add(tempCourse.getCourseID());
        });
    }

    private Course GenerateRoot(boolean isFacility) {
        String rootName = "University Root";
        if (isFacility)
            rootName = "Facility Root";
        return new Course.CourseBuilder()
                .category(Category.ROOT)
                .courseName(rootName)
                .courseID(ROOT_ID_GENERATOR.generateNewID())
                .creditHours(0)
                .preCount(0)
                .prerequisites(new ArrayList<>())
                .build();
    }

    private void loadPlans(List<Course> courses, BufferedReader bufferedReader) throws IOException {
        String line;
        String[] Headers = bufferedReader.readLine().split(",");
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            Course course = new Course.CourseBuilder()
                    .category(Category.getCategoryByNumber(Integer.parseInt(data[0])))
                    .courseID(Long.parseLong(data[1]))
                    .courseName(data[2])
                    .creditHours(Integer.parseInt(data[3]))
                    .preCount(Integer.parseInt(data[4]))
                    .prerequisites(prerequisiteLoadHelper(data))
                    .build();
            courses.add(course);
        }
    }

    private List<Long> prerequisiteLoadHelper(String[] data) {
        List<Long> prerequisiteGroup = new ArrayList<>();
        String[] req = new String[0];
        int iterator = 0;
        while (true) {
            try {
                if ((data[5]) != null) {
                    req = data[5].split("\\+");
                }
                prerequisiteGroup.add(Long.valueOf(req[iterator]));
                iterator++;
            } catch (IndexOutOfBoundsException e) {
                break;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return prerequisiteGroup;
    }

    public String storeFile(MultipartFile file, String schoolName, String depName, int planYear) {
        String path = "uploaded/" + schoolName + "/" + depName + "/" + planYear + ".csv";

        // Normalize file name
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        return storeFileHelper(file, fileName, path);
    }

    public String storeUniversityFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String path = "uploaded/university/" + fileName;

        // Normalize file name
        return storeFileHelper(file, fileName, path);
    }

    private String storeFileHelper(MultipartFile file, String fileName, String path) {
        if (FilenameUtils.isExtension(fileName, "csv")) {
            try {
                // Check if the file's name contains invalid characters
                if (fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }

                // Copy file to the target location (Replacing existing file with the same name)
                Path targetLocation = this.fileStorageLocation.resolve(path);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                LOGGER.log("file stored at " + targetLocation.toAbsolutePath() + " the file is " + Files.exists(targetLocation));
                return path;
            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!");
            }
        } else throw new FileStorageException("file Extension Invalid (only csv)");
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new NotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new NotFoundException("File not found " + fileName);
        }
    }
}
