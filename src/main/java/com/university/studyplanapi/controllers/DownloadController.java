package com.university.studyplanapi.controllers;


import com.university.studyplanapi.services.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DownloadController {

    @Autowired
    DownloadService service;
    @GetMapping("/downloadFile/uploaded/{schoolName}/{depName}/{fileName:.*}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName,
                                                 @PathVariable String schoolName,
                                                 @PathVariable String depName,
                                                 HttpServletRequest request) {

        String filePath = "uploaded/"+schoolName+"/"+depName+"/"+fileName;
       return service.download(filePath,request);
    }

    @GetMapping("/downloadFile/uploaded/university/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {

        String filePath = "uploaded/university/"+fileName;
        return service.download(filePath,request);
    }
    @GetMapping("/getTemplate")
    public ResponseEntity<Resource>downloadTemplate( HttpServletRequest request){
        String filePath = "templates/template.rar";
       return service.download(filePath,request);
    }
    @GetMapping("/downloadCSVPlan/{schoolName}/{departmentName}/{year}")
    public ResponseEntity<Resource>downloadCSVPlan(HttpServletRequest request,
                                                   @PathVariable String schoolName,
                                                   @PathVariable String departmentName,
                                                   @PathVariable int year){
        String filePath = "uploaded/"+schoolName+"/"+departmentName+"/"+year+".csv";
        return service.download(filePath,request);
    }
    @GetMapping("/downloadCSVUniversityPlan")
    public ResponseEntity<Resource>downloadCSVPlan(HttpServletRequest request){
        String filePath = "uploaded/university/universityPlan.csv";
        return service.download(filePath,request);
    }
}
