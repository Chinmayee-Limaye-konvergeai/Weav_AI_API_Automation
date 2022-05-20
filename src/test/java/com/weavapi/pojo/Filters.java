package com.weavapi.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filters {
	
	private String opr;
	private String val;
	private Bet bet;
	
	
	
	public String getOpr() {
		return opr;
	}
	public void setOpr(String opr) {
		this.opr = opr;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public Bet getBet() {
		return bet;
	}
	public void setBet(Bet bet) {
		this.bet = bet;
	}
	

}
