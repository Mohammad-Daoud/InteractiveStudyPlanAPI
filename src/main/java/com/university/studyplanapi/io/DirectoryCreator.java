package com.university.studyplanapi.io;

import com.university.studyplanapi.model.plan.Plan;
import com.university.studyplanapi.utils.AppLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryCreator {
    private static final File RESPONSE_FOLDER = new File("src/main/resources/response");
    private final AppLogger LOGGER = AppLogger.create("DirectoryCreator logger");
    private static volatile DirectoryCreator creator;

    private DirectoryCreator() {
    }

    public static DirectoryCreator getInstance() {
        if (creator == null) {
            synchronized (DirectoryCreator.class) {
                if (creator == null)
                    creator = new DirectoryCreator();
            }
        }
        return creator;
    }

    public synchronized void writeFile(Plan plan, String content) {
        String schoolName = plan.getSchoolName();
        String depName = plan.getDepartmentName();
        String year = String.valueOf(plan.getYear());

        createDirectory(schoolName);
        createDirectory(schoolName + "/" + depName);

        File file = new File(RESPONSE_FOLDER + "/" + schoolName + "/" + depName + "/" + year + ".json");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            LOGGER.logError(e);
        }
    }


    public static File getResponseFolder() {
        return RESPONSE_FOLDER;
    }

    private void createDirectory(String dirName) {
        File file = new File(RESPONSE_FOLDER + "/" + dirName);
        file.mkdir();
    }
}
