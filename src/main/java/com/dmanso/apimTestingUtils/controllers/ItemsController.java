package com.dmanso.apimTestingUtils.controllers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.dmanso.apimTestingUtils.model.Item;
import com.dmanso.apimTestingUtils.services.ItemsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(itemsService.getItemById(itemId), HttpStatus.OK);
        } catch (Exception e) {          
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        Item item1 = itemsService.insert(item);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("item", "/utils/items/" + item1.getItemId());
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
