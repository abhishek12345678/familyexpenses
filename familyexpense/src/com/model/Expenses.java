package com.model;

import java.sql.Date;

public class Expenses {
public String userEmail;
	public String currentdate;
	public int food;
	public int shopping;
	public int party;
	public int travel;
	public int education;
	public int health;
	public int Utilities;
	public int perdayexpenses;
	public String monthly;
	public int year;
	public int Amount;
	
public Expenses(){
		
	}

public Expenses( String userEmail,String currentdate, int food, int shopping, int party, int travel, int education, int health, int Utilities,
		int perdayexpenses,String monthly, int year, int Amount) {
	this.userEmail=userEmail;
	this.currentdate = currentdate;
	this.food = food;
	this.shopping = shopping;
	this.party = party;
	this.travel = travel;
	this.education = education;
	this.health = health;
	this.Utilities = Utilities;
	this.perdayexpenses = perdayexpenses;
	this.monthly = monthly;
	this.year = year;
	this.Amount = Amount;

}

@Override
public String toString() {
	return "Expenses [userEmail=" + userEmail + ", currentdate=" + currentdate + ", food=" + food + ", shopping="
			+ shopping + ", party=" + party + ", travel=" + travel + ", education=" + education + ", health=" + health
			+ ", Utilities=" + Utilities + ", perdayexpenses=" + perdayexpenses + ", monthly=" + monthly + ", year="
			+ year + ", Amount=" + Amount + "]";
}






}






