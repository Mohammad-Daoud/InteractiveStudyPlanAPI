package com.university.interactivestudyplanweb.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.university.interactivestudyplanweb.model.Course;

import java.util.List;

public class ResponseHandler <T>  {
    private final ObjectMapper MAPPER = new ObjectMapper();
    private final RequestHandler REQUEST = RequestHandler.create();


    public T getResponse(String responseUrl, Class<T> mappingClass){
        Object tempObject = REQUEST.doGetRequest(responseUrl);
        return MAPPER.convertValue(tempObject, mappingClass);
    }


    public List<Course> getResponse(String responseUrl){
        Object tempObject = REQUEST.doGetRequest(responseUrl);
        return MAPPER.convertValue(tempObject, new TypeReference<List<Course>>() {});
    }

    public List<Course> postResponse(String postBody,String responseUrl){
        Object tempObject = REQUEST.doPostRequest(postBody,responseUrl);
        return MAPPER.convertValue(tempObject, new TypeReference<List<Course>>() {});
    }

}
