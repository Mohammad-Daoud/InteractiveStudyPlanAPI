package com.university.studyplanapi.io;

import com.university.studyplanapi.utils.AppLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.university.studyplanapi.io.DirectoryCreator.getResponseFolder;

public class DirectoryLoader {

    private static final AppLogger LOGGER = AppLogger.create("Directory loader logger");
    private static final String RESOURCES_FILE_PATH = "src/main/resources/";

    private DirectoryLoader() {
    }

    public static String readFile(String filePath) {
        String content = "";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(RESOURCES_FILE_PATH + filePath ))) {
            content = readFileHelper(fileReader);
        } catch (IOException e) {
            LOGGER.logError(e);
        }
        return content;
    }


    private static String readFileHelper(BufferedReader fileReader) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        String lineContent;
        while ((lineContent = fileReader.readLine()) != null) {
            fileContent.append(lineContent);
        }
        return fileContent.toString();
    }

    public static String getResourceFilePath (){
        return RESOURCES_FILE_PATH;
    }
}
