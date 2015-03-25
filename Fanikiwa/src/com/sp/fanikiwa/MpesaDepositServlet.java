package com.sp.fanikiwa;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MpesaDepositServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		processMpesaDeposit( req,  resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		processMpesaDeposit( req,  resp);
	}
	
	private void processMpesaDeposit(HttpServletRequest req, HttpServletResponse resp)
	{
		/*
		 * 1. verify the call is from safaricom
		 * 2. retrieve the deposit parameters and create double entry transactions
		 * 3. Post. i.e  AccountEnpoint aep = new AccountEnpoint(); aep.DoubleEntry(de)
		 * */
	}
}

