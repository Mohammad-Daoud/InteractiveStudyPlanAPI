package com.university.interactivestudyplanweb.services;

import com.university.interactivestudyplanweb.model.Plan;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    public Plan createPlan(String schoolName,String dep,int year){
        return new Plan(schoolName,dep,year);
    }
}
