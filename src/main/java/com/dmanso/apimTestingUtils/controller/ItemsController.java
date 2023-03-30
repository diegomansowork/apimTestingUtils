package com.dmanso.apimTestingUtils.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;


import com.dmanso.apimTestingUtils.model.Item;
import com.dmanso.apimTestingUtils.model.ItemsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemsController {
    
    @Autowired
    private ItemsRepo repo;

    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> getAllItems(@RequestParam("delayInSeconds") Integer delayInSeconds) {

        try {
            TimeUnit.SECONDS.sleep(delayInSeconds);

            return new ResponseEntity<>(repo.getItems(), HttpStatus.OK);    

        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

      
    }
    
    @GetMapping(value = "/target")
    public ResponseEntity<Item> getItem() {

        try {
           
            return new ResponseEntity<>(repo.getItem(), HttpStatus.OK);    

        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

      
    }

}
