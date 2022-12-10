package com.hitesh.quickshop.entity;

import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "items")
public class Items {

	
	@Id
	@GenericGenerator(name = "itemIdGeneration", strategy = "increment")
	@GeneratedValue(generator = "itemIdGeneration")
	@Column(name = "id")
	private int id;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "rate")
	private double rate;
	@Column(name = "total_stock")
	private int totalStock;
	@Column(name = "modified_time")
	private String modifiedTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		
		
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "Item id = " + id + ", Item name = " + itemName + ", price = " + rate + ", Available Quantity = " + totalStock;
				
	}
}
