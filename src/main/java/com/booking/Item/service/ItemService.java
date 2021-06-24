package com.booking.Item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.Item.model.Item;
import com.booking.Item.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	public Optional<Item> findItemById(int itemId) {
		return itemRepository.findById(itemId);
	}

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	public void deleteItem(int itemId) {
		itemRepository.deleteById(itemId);

	}

}
