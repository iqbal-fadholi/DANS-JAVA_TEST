package com.dansmulticorp.service;

import com.dansmulticorp.service.exchangemodel.DansJobResourceResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class JobResourceServiceRestImpl {

    @Value("${dans.resource.job.position.url}")
    private String jpPositionUrl;


    public List<DansJobResourceResponseModel> getAllJobPosition() {
        RestTemplate restTemplate = new RestTemplate();

        log.debug("request job position data. ");

        return Arrays.asList(
                restTemplate.getForObject(jpPositionUrl + "/positions.json", DansJobResourceResponseModel[].class)
        );
    }


    public DansJobResourceResponseModel getJobPosition(String id) {

        RestTemplate restTemplate = new RestTemplate();

        log.debug("request job position data. ");

        return restTemplate.getForObject(jpPositionUrl + "/positions/" + id, DansJobResourceResponseModel.class);

    }


}
