package com.hitesh.quickshop.databaseops;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hitesh.quickshop.entity.Items;
import com.hitesh.quickshop.util.SessionFactoryGiver;
import java.util.Collections;

public class ItemRepositoryHql {
	
	public Items getItemById (int id) {
		try {
			Session session = SessionFactoryGiver.getSessionFactory().openSession();
			return session.get(Items.class, id);
		}
		catch (Exception e) {
			
		}
		return null;
		
		
	}
	public void addItem(Items item) {

		try {

			Session session = SessionFactoryGiver.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();
			session.save(item);
			transaction.commit();
		
		} catch (Exception e) {

		}
		

	}
	
	public List<Items> listAll(){
		
		try {
			Session session = SessionFactoryGiver.getSessionFactory().openSession();
			
			String query = "FROM Items";
			org.hibernate.query.Query<Items> createQuery = session.createQuery(query);
			
			return createQuery.list();
		}
		catch(Exception e) {
			
		}
		return Collections.emptyList();
		
	}
	
	public void updateStockById( int currentStockAmount, int id) {
		try {
			Session session = SessionFactoryGiver.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			String query = "UPDATE Items SET totalStock =:csa WHERE id=:id ";
			Query<Items> createQuery = session.createQuery(query);
			createQuery.setParameter("csa", currentStockAmount);
			createQuery.setParameter("id", id);
			
			createQuery.executeUpdate();
			transaction.commit();
			
		}
		catch (Exception e) {}
	}
	
	 
}
