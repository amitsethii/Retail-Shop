package com.retail.shop.retailShop.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.retail.shop.retailShop.model.Retail;

@Service
public class RetailService {

	
	 private static List<Retail> retails = new ArrayList<Retail>();
	 private static List<Retail> wishes = new ArrayList<Retail>();
	 private static List<Retail> carts = new ArrayList<Retail>();
	    private static int cartCount = 0;
	    private static int wishCount = 0;
	    

	    static { 
	    	retails.add(new Retail(1,"Shoe","nike  best quality product here ",500));
	    	 retails.add(new Retail(2,"Shirt","puma    best quality product here ",800));
	        retails.add(new Retail(3,"Jeans","levis best quality product here ",900));
	        retails.add(new Retail(4,"Caps","jocky best quality product here ",890));
	        retails.add(new Retail(5,"Bags","nike  best quality product here ",200));
	    	 retails.add(new Retail(6,"Shirt","puma    best quality product here ",300));
	        retails.add(new Retail(7,"Glass","levis best quality product here ",400));
	        retails.add(new Retail(8,"Deo","jocky best quality product here ",600));
	        retails.add(new Retail(8,"Watches","jocky best quality product here ",700));
	    
	    }
	   
	    public boolean validateUser(String userid , String password) {
			return userid.equalsIgnoreCase("amit") && password.equalsIgnoreCase("amit123");
		}
	    
	    
	    public void addWish(int id) {
	    	Iterator<Retail> iterator = retails.iterator();
	    	while(iterator.hasNext()) {
	    		Retail retail = iterator.next();
	    		if(retail.getId() == id) {
	    			wishes.add(retail);
	    		}	
	    	}
	    }
	    
	    public void addCart(int id) {
	    	Iterator<Retail> iterator = retails.iterator();
	    	while(iterator.hasNext()) {
	    		Retail cart = iterator.next();
	    		if(cart.getId() == id) {
	    			carts.add(new Retail(++cartCount,cart.getUser(),cart.getDesc(),cart.getPrice()));	
	    		}	
	    	}
	    }
	    
	    public List<Retail> retrieveRetails() {
	    		return retails;
	    }

	    public List<Retail> retrieveWishes() {
    		return wishes;
        }
	    public List<Retail> retrieveCarts() {
    		return carts;
        }
	    
	    public String validaSearch(String search) {
	    	Iterator<Retail> iterator = retails.iterator();
	    	while(iterator.hasNext()) {
	    		Retail retail = iterator.next();
	    		if(search.equalsIgnoreCase(retail.getUser())) {
	    			return "Yes";
	    		}
	    	}
	    	return "No";
	    }
	    
	    public int cartSum() {
	    	Iterator<Retail> iterator = carts.iterator();
	    	int sum=0;
	    	while(iterator.hasNext()) {
	    		Retail cart = iterator.next();
	    		sum = sum + cart.getPrice();
	    	}
	    	return sum;
	    }
	    
	    public void removeCart(int id) {
	    	Iterator<Retail> iterator = carts.iterator();
	    	while(iterator.hasNext()) {
	    		Retail cart = iterator.next();
	    		if(cart.getId() == id) {
	    			iterator.remove();
	    		}
	    		
	    	}
	    }  
	    public void removeWish(int id) {
	    	Iterator<Retail> iterator = wishes.iterator();
	    	while(iterator.hasNext()) {
	    		Retail wish = iterator.next();
	    		if(wish.getId() == id) {
	    			iterator.remove();
	    		}
	    		
	    	}
	    }  
	
}
