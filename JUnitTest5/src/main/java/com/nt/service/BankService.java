package com.nt.service;

public class BankService {

	public Double calcSimpleInterestAmt(Float pAmt, Float time, Float rate) {

		if (pAmt <= 0 || time <= 0 || rate <= 0)
			throw new IllegalArgumentException("Invalid Inputs");

		//network traffic
		/*
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		return (pAmt*time*rate)/100.0;
	}

}
