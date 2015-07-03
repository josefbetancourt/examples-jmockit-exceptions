package com.octodecillion.examples.jmockit_exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for JMockit exception test demo.
 */
public class App 
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
			Logger.getAnonymousLogger().log(Level.SEVERE, "{result:\"failure\",id:\""+ id + "\"}");
		}
		
		return name;
	}
	
	public static void main(String[] args) {
		new App().getProduct(123);
	}
}
