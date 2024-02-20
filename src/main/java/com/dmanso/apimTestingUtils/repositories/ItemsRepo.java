package com.dmanso.apimTestingUtils.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dmanso.apimTestingUtils.model.Item;

@Repository
public interface ItemsRepo extends CrudRepository<Item, Long>{
}
