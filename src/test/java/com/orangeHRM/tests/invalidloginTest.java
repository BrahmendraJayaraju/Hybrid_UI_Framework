package com.orangeHRM.tests;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.Test;

import getdata.Exceldata;

import com.orangeHRM.generic.BaseTest;
import com.orangeHRM.pages.LoginPage;

public class invalidloginTest extends BaseTest {

	@Test
	public void testinvalidlogin() throws Exception

	{
		String logintitle = Exceldata.getdata(filepath, "Login", 1, 2);

		String errormessage = Exceldata.getdata(filepath, "Login", 1, 4);

		int loginrc = Exceldata.getrowcount(filepath, "Login");

		LoginPage lp = new LoginPage(driver);

		lp.verifytitle(logintitle);

		for (int i = 2; i <= loginrc; i++) {
			String user = Exceldata.getdata(filepath, "Login", i, 0);

			String pass = Exceldata.getdata(filepath, "Login", i, 1);

			Reporter.log("username:" + user, true);
			lp.enterusername(user);

			Reporter.log("password:" + pass, true);
			lp.enterpassword(pass);
			
			lp.clickonlogin();
		}

		lp.clickonlogin();

		Thread.sleep(3000);

		String aerrormessage = lp.verifyerrormessage();

		Assert.assertEquals(aerrormessage, errormessage);

		Reporter.log("err message is matching " + errormessage, true);

	}

}
