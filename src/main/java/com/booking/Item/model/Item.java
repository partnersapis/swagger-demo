package com.booking.Item.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemno")
	@ApiModelProperty(notes = "Database generated item id")
	private int itemNo;

	@Column(name = "itemname")
	@ApiModelProperty(notes = "The name of the item")
	private String itemName;

	@Column(name = "itemrate")
	@ApiModelProperty(notes = "The rate of the item")
	private int itemRate;

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemRate() {
		return itemRate;
	}

	public void setItemRate(int itemRate) {
		this.itemRate = itemRate;
	}

}
