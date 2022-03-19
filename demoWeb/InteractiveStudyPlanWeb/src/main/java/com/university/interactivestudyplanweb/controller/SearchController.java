package com.university.interactivestudyplanweb.controller;

import com.university.interactivestudyplanweb.model.Plan;
import com.university.interactivestudyplanweb.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("planToSearch")
public class SearchController {

    @Autowired
    SearchService service;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String viewSearchPage() {
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String handleSearchContent(ModelMap model,
                                      @RequestParam String schoolName,
                                      @RequestParam  String department,
                                      @RequestParam  int year) {
        try {

            Plan plan = service.createPlan(schoolName, department, year);
            model.put("planToSearch", plan);
            return "redirect:index";
        }catch (Exception e){
            model.put("errorMsg",e.getMessage());
            return "redirect:error";
        }
    }


}
