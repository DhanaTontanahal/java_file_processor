package com.dhana.test;

import org.junit.Test;

import com.gb.cs.ExtractPostfix;

public class TestExtractpF {
	
	@Test
	public  void calpostFix(String[] args) {
		
		ExtractPostfix.postFixExtract("finance_customer_transactions20171304095500.csv");
	}

}
