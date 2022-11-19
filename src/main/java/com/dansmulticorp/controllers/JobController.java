package com.dansmulticorp.controllers;

import com.dansmulticorp.common.constant.ResponseConstant;
import com.dansmulticorp.controllers.payload.response.ResourcePayload;
import com.dansmulticorp.service.JobResourceServiceRestImpl;
import com.dansmulticorp.service.exchangemodel.DansJobResourceResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/resource")
public class JobController {
    final JobResourceServiceRestImpl jobResourceService;

    public JobController(JobResourceServiceRestImpl jobResourceService) {
        this.jobResourceService = jobResourceService;
    }

    @GetMapping("/jobAll")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ResourcePayload<List<DansJobResourceResponseModel>>> allAccess() {
        ResourcePayload<List<DansJobResourceResponseModel>> responseDto = new ResourcePayload<>();
        List<DansJobResourceResponseModel> dansJobResourceResponseListModel;
        try {
            dansJobResourceResponseListModel = jobResourceService.getAllJobPosition();
            responseDto.setElementNumber(dansJobResourceResponseListModel.size());
            responseDto.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseDto.setResposeMessage(ResponseConstant.SUCCESS_DESC);
            responseDto.setData(dansJobResourceResponseListModel);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }catch (Exception e){
            log.error("error while getting All job", e);
            responseDto.setResponseCode(ResponseConstant.ERROR_CODE);
            responseDto.setResposeMessage(e.getMessage());
            responseDto.setData(null);
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/job/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ResourcePayload<DansJobResourceResponseModel>> allAccess(@PathVariable String id) {
        ResourcePayload<DansJobResourceResponseModel> responseDto = new ResourcePayload<>();
        DansJobResourceResponseModel dansJobResourceResponseListModel;
        try {
            dansJobResourceResponseListModel = jobResourceService.getJobPosition(id);
            responseDto.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseDto.setResposeMessage(ResponseConstant.SUCCESS_DESC);
            responseDto.setElementNumber(1);
            responseDto.setData(dansJobResourceResponseListModel);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }catch (NoSuchElementException noSuchElementException){
            responseDto.setResponseCode(ResponseConstant.NOT_FOUND_CODE);
            responseDto.setResposeMessage(noSuchElementException.getMessage());
            responseDto.setData(null);
            return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            log.error("error while getting All job", e);
            responseDto.setResponseCode(ResponseConstant.ERROR_CODE);
            responseDto.setResposeMessage(e.getMessage());
            responseDto.setData(null);
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
