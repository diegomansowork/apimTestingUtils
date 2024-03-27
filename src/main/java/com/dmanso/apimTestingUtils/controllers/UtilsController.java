package com.dmanso.apimTestingUtils.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmanso.apimTestingUtils.model.Response;
import com.dmanso.apimTestingUtils.services.ResponseSizedService;

@RestController
@RequestMapping("/utils")
public class UtilsController {
    
    ResponseSizedService responseService;

    public UtilsController(ResponseSizedService responseService) {
        this.responseService = responseService;
    }

    @GetMapping(value = "/randomSized")
    public ResponseEntity<Response> getSizedResponse(@RequestParam("size") Integer sizeInBytes) {

        try {

            return new ResponseEntity<Response>(responseService.getSizedResponse(sizeInBytes), HttpStatus.OK);

        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/echo")
    public ResponseEntity<String> getItem() {
        try {
            return new ResponseEntity<>("Utils API ECHO", HttpStatus.OK);

        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
