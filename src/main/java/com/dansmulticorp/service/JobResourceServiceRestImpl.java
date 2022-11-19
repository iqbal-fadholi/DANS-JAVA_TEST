package com.dansmulticorp.service;

import com.dansmulticorp.service.exchangemodel.DansJobResourceResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class JobResourceServiceRestImpl {

    @Value("${dans.resource.job.position.url}")
    private String jpPositionUrl;


    public List<DansJobResourceResponseModel> getAllJobPosition(){
        return getDansJobPositionResource();
    }


    public DansJobResourceResponseModel getJobPosition(String id){

        List<DansJobResourceResponseModel> dansJobResourceResponseModelList = getDansJobPositionResource();

        if (!dansJobResourceResponseModelList.isEmpty()){
            for (DansJobResourceResponseModel dansJobResourceResponseModel: dansJobResourceResponseModelList) {
                if (dansJobResourceResponseModel.getId().equalsIgnoreCase(id)) return dansJobResourceResponseModel;
                else continue;
            }
            throw new NoSuchElementException("id " + id + " not found");
        }else throw new NoSuchElementException("Job position List is empty");

    }

    private List<DansJobResourceResponseModel> getDansJobPositionResource() {
        DansJobResourceResponseModel[] result;

//        RestTemplate restTemplate = createResttemplateWithTimeout(timeout);

        RestTemplate restTemplate = new RestTemplate();

        log.debug("request job position data. ");

        result = restTemplate.getForObject(jpPositionUrl, DansJobResourceResponseModel[].class);

        log.debug("Dans job position data response : " + result.toString());

        return Arrays.asList(result);
    }

}
