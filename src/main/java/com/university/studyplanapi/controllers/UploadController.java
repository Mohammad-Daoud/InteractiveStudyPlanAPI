package com.university.studyplanapi.controllers;

import com.university.studyplanapi.model.io.FileUpload;
import com.university.studyplanapi.services.UploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {
    @PostMapping("/uploadFile")
    public ResponseEntity<FileUpload> uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String filecode = UploadService.saveFile(fileName, multipartFile);

        FileUpload response = new FileUpload();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
