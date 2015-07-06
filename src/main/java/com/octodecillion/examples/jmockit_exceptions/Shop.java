package com.octodecillion.examples.jmockit_exceptions;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for JMockit exception test demo.
 */
public class Shop 
{
	private ShoppingSvc svc;
	
	/**
	 * Get product name.
	 * @param id the unique product id
	 * @return the product name
	 */
	public String getProduct(int id){
		String name = "";
		try {
			name = svc.getProductName(id);
		} catch (Exception e) {
			System.out.println("logging exception: " + e.getMessage());

			Logger.getAnonymousLogger().log(Level.SEVERE, "{result:\"failure\",id:\""+ id + "\"}");
		}
		
		return name;
	}
	
	public long getPrice(int id){
		long price = Long.MAX_VALUE;
		
		try {
			price = svc.getCost(id);
		} catch (Exception e) {
		}
		
		return price;
		
	}
	
	public static void main(String[] args) {
		Shop shop = new Shop();
		shop.getProduct(123);
		shop.getPrice(123);
	}
}
