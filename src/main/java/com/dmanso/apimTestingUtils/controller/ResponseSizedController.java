package com.dmanso.apimTestingUtils.controller;

import java.util.Random;
import java.util.Base64;

import com.dmanso.apimTestingUtils.model.ResponseRepo;
import com.dmanso.apimTestingUtils.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/response")
public class ResponseSizedController {
    
    @Autowired
    private ResponseRepo repo;

    @GetMapping(value = "/randomSized")
    public ResponseEntity<Response> getSizedResponse(@RequestParam("size") Integer sizeInBytes) {

        try {


            return new ResponseEntity<Response>(repo.getSizedResponse(sizeInBytes), HttpStatus.OK);    

        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

      
    }



}
