package com.xebia.entity;


public class Order {
	private int milk;
	
	private int skins;
	
	public Order(){
		
	}
	public Order(int milk, int skins){
		this.milk=milk;
		this.skins=skins;
	}
	public int getMilk() {
		return milk;
	}
	public void setMilk(int milk) {
		this.milk = milk;
	}
	public int getSkins() {
		return skins;
	}
	public void setSkins(int skins) {
		this.skins = skins;
	}
	
	
}
