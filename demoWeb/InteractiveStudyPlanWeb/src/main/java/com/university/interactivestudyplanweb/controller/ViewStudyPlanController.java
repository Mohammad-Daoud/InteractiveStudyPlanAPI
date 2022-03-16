package com.university.interactivestudyplanweb.controller;

import com.university.interactivestudyplanweb.services.ViewStudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewStudyPlanController {
    @Autowired
    private ViewStudyPlanService service;
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String viewPlan(ModelMap model){
        model.addAttribute("plan",service.retrieveCSVPlan(2017));
        return "index";
    }
}
