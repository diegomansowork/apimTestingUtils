package com.dmanso.apimTestingUtils.bootstrap;

import com.dmanso.apimTestingUtils.model.Item;
import com.dmanso.apimTestingUtils.repositories.ItemsRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemLoader implements CommandLineRunner {
    public final ItemsRepo itemRepository;

    public ItemLoader(ItemsRepo itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadItems();
    }

    private void loadItems() {
        if (itemRepository.count() == 0) {
            itemRepository.save(
                    Item.builder()
                            .name("pencil")
                            .vendorId(123)
                            .modelYear(2004)
                            .listPrice(12.45)
                            .build()
            );
            itemRepository.save(
                    Item.builder()
                            .name("table")
                            .vendorId(1543)
                            .modelYear(2013)
                            .listPrice(1244.32)
                            .build()
            );
            System.out.println("Sample Items Loaded");
        }
    }
}

