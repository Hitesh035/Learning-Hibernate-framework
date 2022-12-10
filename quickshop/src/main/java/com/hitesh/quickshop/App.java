package com.hitesh.quickshop;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hitesh.quickshop.databaseops.CartRepository;
import com.hitesh.quickshop.databaseops.ItemRepositoryHql;
import com.hitesh.quickshop.dto.CartDTO;
import com.hitesh.quickshop.entity.Cart;
import com.hitesh.quickshop.entity.Items;

public class App {

	public static void pattern() {
		System.out.println("************************************************************");
	}

	public static void main(String[] args) {

//		Items items = new Items();
//		items.setItemName("iPhone 9s");
//		items.setModifiedTime(new SimpleDateFormat().format(new Timestamp(System.currentTimeMillis())));
//		items.setRate(89999.00);
//		items.setTotalStock(35);
//		new ItemRepositoryHql().addItem(items);
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome to Quickshop.");
		System.out.println("The items below are available.");
		pattern();
		List<Items> itemList = new ItemRepositoryHql().listAll();
		Iterator<Items> itr = itemList.iterator();

		pattern();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		pattern();
		System.out.println("Please enter the 'Item id' of the product you want to buy.");
		int itemId = scn.nextInt();
		pattern();
		System.out.println("Please enter the quantity you want to purchase.");
		System.out.println("Make sure it does not exceed the available quantity.");
		int quantity = scn.nextInt();
		pattern();
		System.out.println("Please select your mode of payment.");
		System.out.println("Press '1' for COD");
		System.out.println("Press '2' for Card Payment");
		System.out.println("Press '3' for UPI");
		int paymentSelection = scn.nextInt();
		String modeOfPayment = null;
		if (paymentSelection == 1)
			modeOfPayment = "COD";
		else if (paymentSelection == 2)
			modeOfPayment = "Card Payment";
		else if (paymentSelection == 3)
			modeOfPayment = "UPI";
		else {
			System.out.println("Don't f around by entering invalid choice.");
			return;
		}
		pattern();

		System.out.println("Press '1' to buy now.");
		System.out.println("Press '2' to exit app.");
		int finalSelection = scn.nextInt();
		pattern();
		if (finalSelection == 1) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.addToCart(itemId, quantity, modeOfPayment);
			CartRepository cart = new CartRepository();
			cart.buyNow(cartDTO);
			pattern();
			System.out.println("Thanks for shopping on Quickshop your final amount is "+ cart.cart.getPrice());
		}

	}
}
