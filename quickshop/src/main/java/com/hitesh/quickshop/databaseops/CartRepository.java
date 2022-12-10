package com.hitesh.quickshop.databaseops;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hitesh.quickshop.dto.CartDTO;
import com.hitesh.quickshop.entity.Cart;
import com.hitesh.quickshop.entity.Items;
import com.hitesh.quickshop.util.SessionFactoryGiver;

public class CartRepository {

	public Cart cart = new Cart();
	public void buyNow(CartDTO cartDTO) {
		try {
			Integer itemId = cartDTO.getItemId();
			Integer quantity = cartDTO.getQuantity();
			String modeOfPayment = cartDTO.getModeOfPayment();

			Items item = new ItemRepositoryHql().getItemById(itemId);

			if (item == null)
				throw new Exception();

			try {
				if (item.getTotalStock() < quantity)
					throw new Exception();
				
				
				cart.setItemId(itemId);
				cart.setModeOfPayment(modeOfPayment);
				cart.setPrice(item.getRate()*quantity);
				cart.setQuantity(quantity);
				cart.setRate(item.getRate());
				cart.setAddedTime(new SimpleDateFormat().format(new Timestamp(System.currentTimeMillis())));
				
				new ItemRepositoryHql().updateStockById(item.getTotalStock()-quantity, itemId);
				
				Session session = SessionFactoryGiver.getSessionFactory().openSession();

				Transaction transaction = session.beginTransaction();
				session.save(cart);
				transaction.commit();

			}

			catch (Exception e2) {
				System.out.println("Item not available in sufficient quantity.");
			}
		} catch (Exception e1) {

			System.out.println("Item not available.");
		}

	}
}
