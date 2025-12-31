package com.actiTime.tests;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import getdata.ExceldataFramework;
import com.actiTime.pages.LoginPage;

public class invalidloginTest extends BaseTest {

	@Test
	public void testinvalidlogin() throws Exception

	{
		String logintitle = ExceldataFramework.getdata(filepath, "Login", 1, 2);

		String errormessage = ExceldataFramework.getdata(filepath, "Login", 1, 4);

		int loginrc = ExceldataFramework.getrowcount(filepath, "Login");

		LoginPage lp = new LoginPage(driver);

		lp.verifytitle(logintitle);

		for (int i = 2; i <= loginrc; i++) {
			String user = ExceldataFramework.getdata(filepath, "Login", i, 0);

			String pass = ExceldataFramework.getdata(filepath, "Login", i, 1);

			Reporter.log("username:" + user, true);
			lp.enterusername(user);

			Reporter.log("password:" + pass, true);
			lp.enterusername(pass);
		}

		lp.clickonlogin();

		Thread.sleep(3000);

		String aerrormessage = lp.verifyerrormessage();

		Assert.assertEquals(aerrormessage, errormessage);

		Reporter.log("err message is matching " + errormessage, true);

	}

}
