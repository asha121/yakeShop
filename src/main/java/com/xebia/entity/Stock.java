package com.xebia.entity;

import java.io.Serializable;

public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double milk;
	
	private int skin;
	
	public Stock(){
		
	}
	public Stock(double milk,int skin ){
		this.skin=skin;
		this.milk=milk;
		
	}

	public double getMilk() {
		return milk;
	}

	public void addMilk(double milk) {
		this.milk =this.milk+ milk;
	}

	public int getSkin() {
		return skin;
	}

	public void addSkin(int skin) {
		this.skin =this.skin+ skin;
	}
	
	
	
	
	@Override
	public String toString() {
		return "In Stock: \n"+"\t"+milk+" liters of milk\n \t"+skin+" skins of wool";
	}
	
}
