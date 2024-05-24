package com.dmanso.apimTestingUtils.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dmanso.apimTestingUtils.model.Item;
import com.dmanso.apimTestingUtils.repositories.ItemsRepo;

@Service
public class ItemsServiceImpl implements ItemsService {

    ItemsRepo itemsRepository;

    public ItemsServiceImpl(ItemsRepo itemsRepository){
        this.itemsRepository = itemsRepository;
    }
    
    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        itemsRepository.findAll().forEach(items::add);
        return items;
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemsRepository.findById(id);
    }

    @Override
    public Item insert(Item item) {
        return itemsRepository.save(item);
    }

    @Override
    public void updateItem(Long id, Item item) {
        Item itemFromDb = itemsRepository.findById(id).get();
        System.out.println(itemFromDb.toString());
        itemFromDb.setListPrice(item.getListPrice());
        itemFromDb.setModelYear(item.getModelYear());
        itemFromDb.setName(item.getName());
        itemFromDb.setVendorId(item.getVendorId());
        itemsRepository.save(itemFromDb);
    }

    @Override
    public void deleteItem(Long itemId) {
        itemsRepository.deleteById(itemId);
    }
    
}
