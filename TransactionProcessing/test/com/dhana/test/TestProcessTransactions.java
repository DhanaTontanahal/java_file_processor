package com.dhana.test;

import java.io.IOException;

import org.junit.Test;

import com.gb.cs.ProcessTransactions;

public class TestProcessTransactions {

	@Test
	public void callPTransactions() {

		try {
			ProcessTransactions.processFileTransactions();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
