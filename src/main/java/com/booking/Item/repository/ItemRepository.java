package com.booking.Item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.Item.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
