package com.university.interactivestudyplanweb.services;

import com.university.interactivestudyplanweb.handler.ResponseHandler;
import com.university.interactivestudyplanweb.model.Course;
import com.university.interactivestudyplanweb.model.Plan;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ViewStudyPlanService {
    private final ResponseHandler<Course> COURSE_RESPONSE = new ResponseHandler<>();

    public List<Course> retrievePlan(Plan plan){
        Map<String,Object> map = new HashMap<>();
        map.put("schoolName",plan.getSchoolName());
        map.put("departmentName",plan.getDepartmentName());
        map.put("year",plan.getYear());
        return COURSE_RESPONSE.postResponse(map,"get-plan");
    }
}
