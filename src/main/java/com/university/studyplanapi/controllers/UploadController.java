package com.university.studyplanapi.controllers;


import com.university.studyplanapi.ResponseHandler.UploadFileResponse;
import com.university.studyplanapi.model.plan.Plan;
import com.university.studyplanapi.services.IOService;
import com.university.studyplanapi.services.StudyPlanService;
import com.university.studyplanapi.utils.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UploadController {
    private final AppLogger LOGGER = AppLogger.create("UploadController ");
    @Autowired
    private IOService service;
    @Autowired
    private StudyPlanService planService;

    @PostMapping("/uploadFile/{schoolName}/{depName}/{planYear}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
                                         @PathVariable String schoolName,
                                         @PathVariable String depName,
                                         @PathVariable int planYear) {
        String fileName = service.storeFile(file,schoolName,depName,planYear);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        Plan tempPlan = new Plan(schoolName,depName,planYear);
        planService.writeStudyPlan(tempPlan);
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadUniversity")
    public UploadFileResponse uploadMultipleFiles(@RequestParam("file") MultipartFile file) {
        String fileName = service.storeUniversityFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        planService.writeUniversityPlan(fileName);
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }
}
