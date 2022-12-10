package com.hitesh.quickshop.dto;

import java.io.Serializable;

public class CartDTO implements Serializable {

	private int itemId;
	private int quantity;
	private String modeOfPayment;
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
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	@Override
	public String toString() {
		return "CartDTO [itemId=" + itemId + ", quantity=" + quantity + ", modeOfPayment=" + modeOfPayment + "]";
	}
	
	public CartDTO addToCart(int itemId, int quantity, String modeOfPayment) {
		
		this.setItemId(itemId);
		this.setModeOfPayment(modeOfPayment);
		this.setQuantity(quantity);
		return this;
		
	}
}
