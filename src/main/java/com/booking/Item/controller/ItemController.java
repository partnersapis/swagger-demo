package com.booking.Item.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.Item.model.Item;
import com.booking.Item.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/items")
@Api(value= "Item", description = "Operations related to Items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * This method will add a new item to the item table 
	 * @param Item
	 * @return Item
	 */
	@ApiOperation(value = "Add an item", response=Item.class)
	@PostMapping("/add")
	public Item saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}

	/**
	 * This method will return an item with a given id
	 * @param itemId
	 * @return Item
	 */
	@ApiOperation(value = "Find an item with an ID", response = Item.class)
	@GetMapping("/get/{itemId}")
	public Optional<Item> findItemById(@PathVariable int itemId) {
		return itemService.findItemById(itemId);
	}

	/**
	 * This method will return a list of all items
	 * @return List<Item>
	 */
	@ApiOperation(value="View the list of available items",response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/getAllItems")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	/**
	 * This method will delete an item with given id
	 * @param itemId
	 * @return ResponseEntity
	 */
	@ApiOperation(value = "Delete an item")
	@DeleteMapping("/delete/{itemId}")
    public ResponseEntity<String> delete(@PathVariable int itemId){
        itemService.deleteItem(itemId);
        return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);

    }
}
