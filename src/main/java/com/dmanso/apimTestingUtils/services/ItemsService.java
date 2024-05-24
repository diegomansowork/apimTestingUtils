package com.dmanso.apimTestingUtils.services;

import com.dmanso.apimTestingUtils.model.Item;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public interface ItemsService {
    
    List<Item> getItems();

    Optional<Item> getItemById(Long id);

    Item insert(Item item);

    void updateItem(Long id, Item item);

    void deleteItem(Long itemId);
    
}
