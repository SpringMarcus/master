package com.kibo.order.data.repository.v2;

import com.kibo.order.data.entity.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
//TODO: Something important is missing from this repo...
}
