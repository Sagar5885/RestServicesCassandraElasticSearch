package com.sagar.es.test;

public class Talk {

	String madeOff;
	Integer cost;
	
	public Talk(String madeOff, Integer cost) {
		super();
		this.madeOff = madeOff;
		this.cost = cost;
	}

	public String getMadeOff() {
		return madeOff;
	}

	public void setMadeOff(String madeOff) {
		this.madeOff = madeOff;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
}
