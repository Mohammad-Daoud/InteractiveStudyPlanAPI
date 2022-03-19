package com.university.studyplanapi.services;

import com.university.studyplanapi.exception.NotFoundException;
import com.university.studyplanapi.io.DirectoryCreator;
import com.university.studyplanapi.model.Course;
import com.university.studyplanapi.model.Plan;
import com.university.studyplanapi.utils.JSON;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudyPlanService implements PlanOperation<Plan> {
    private static final Map<Integer, List<Course>> STUDY_PLAN_GROUP = new HashMap<>();
    private static final DirectoryCreator DIRECTORY_WRITER = DirectoryCreator.getInstance();

    @Override
    public List<Course> getStudyPlan(Plan plan) {
        int year = plan.getYear();
        List<Course> tempPlanGroup = STUDY_PLAN_GROUP.get(year);
        if (tempPlanGroup == null || tempPlanGroup.size()==0)
            loadFromResources(plan);
        else
            return tempPlanGroup;
        return STUDY_PLAN_GROUP.get(year);
    }

    private void loadFromResources(Plan plan) {
        List<Course> planCourse = new IOService().getStudyPlan(plan);
        List<Course> tempGroup = STUDY_PLAN_GROUP.put(plan.getYear(), planCourse);
        if ( tempGroup == null || tempGroup.size() == 0 ) {
            throw new NotFoundException("PLAN "+plan.getSchoolName()
                    +" "+plan.getDepartmentName()+" "+plan.getYear()+" NOT EXIST !!\n" +
                    "make sure that all input are entered correctly ");
        } else
        DIRECTORY_WRITER.writeFile(plan, JSON.toJson(planCourse));

    }

    public static Map<Integer, List<Course>> getStudyPlanGroup() {
        return STUDY_PLAN_GROUP;
    }

}
