package com.hitesh.quickshop.entity;

import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cart")
public class Cart {

	
	@Id
	@GenericGenerator(name = "cartIdGeneration", strategy = "increment")
	@GeneratedValue(generator = "cartIdGeneration")
	@Column(name = "cart_id")
	private int cartId;
	
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "rate")
	private double rate;
	@Column(name = "price")
	private double price;
	@Column(name = "mode_of_payment")
	private String modeOfPayment;
	@Column(name = "added_time")
	private String addedTime;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getAddedTime() {
		return addedTime;
	}
	public void setAddedTime(String addedTime) {
		this.addedTime = addedTime;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", itemId=" + itemId + ", quantity=" + quantity + ", rate=" + rate
				+ ", price=" + price + ", modeOfPayment=" + modeOfPayment + ", addedTime=" + addedTime + "]";
	}
}
	