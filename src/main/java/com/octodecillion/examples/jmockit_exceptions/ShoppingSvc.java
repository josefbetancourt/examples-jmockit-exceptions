package com.octodecillion.examples.jmockit_exceptions;

import java.io.IOException;

public class ShoppingSvc {
	
	public String getProductName(int id) throws IOException{
		
		return "Bozo toy";
	}

	public long getCost(int id) throws Exception{
		return Long.MAX_VALUE;
	}

}
