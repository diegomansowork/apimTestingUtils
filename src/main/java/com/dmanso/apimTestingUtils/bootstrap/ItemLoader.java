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

    @SuppressWarnings("null")
    private void loadItems() {
        if (itemRepository.count() == 0) {
            itemRepository.save(
                    Item.builder()
                            .itemName("pencil")
                            .itemVendorId(123)
                            .itemModelYear(2004)
                            .itemListPrice(12.45)
                            .build()
            );
            itemRepository.save(
                    Item.builder()
                            .itemName("table")
                            .itemVendorId(1543)
                            .itemModelYear(2013)
                            .itemListPrice(1244.32)
                            .build()
            );
            System.out.println("Sample Items Loaded");
        }
    }
}

