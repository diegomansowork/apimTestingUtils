package com.dmanso.apimTestingUtils.controllers;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmanso.apimTestingUtils.model.Item;
import com.dmanso.apimTestingUtils.services.ItemsService;

@RestController
@RequestMapping("/utils/items")
public class ItemsController {
    
    ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(@RequestParam(required = false) Integer delayInSeconds) {
        try {
            if(delayInSeconds==null){
                delayInSeconds = 0;
            }
            TimeUnit.SECONDS.sleep(delayInSeconds);
            List<Item> items = itemsService.getItems();
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping({"/{itemId}"})
    public ResponseEntity<Item> getItem(@PathVariable Long itemId, @RequestParam(required = false) Integer delayInSeconds) {
        try {
            if(delayInSeconds==null){
                delayInSeconds = 0;
            }
            TimeUnit.SECONDS.sleep(delayInSeconds);

            Item item = itemsService.getItemById(itemId);

            if(item==null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        Item item1 = itemsService.insert(item);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("item", "/utils/items/" + item1.getId());
        return new ResponseEntity<>(item1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{itemId}"})
    public ResponseEntity<Item> updateItem(@PathVariable("itemId") Long itemId, @RequestBody Item item) {
        itemsService.updateItem(itemId, item);
        return new ResponseEntity<>(itemsService.getItemById(itemId), HttpStatus.OK);
    }

    @DeleteMapping({"/{itemId}"})
    public ResponseEntity<Item> deleteItem(@PathVariable("itemId") Long itemId) {
        itemsService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
