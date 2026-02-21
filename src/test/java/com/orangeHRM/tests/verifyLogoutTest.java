package com.orangeHRM.tests;


import org.testng.annotations.Test;

import getdata.Exceldata;

import com.orangeHRM.generic.BaseTest;
import com.orangeHRM.pages.DashboardPage;
import com.orangeHRM.pages.LoginPage;

public class verifyLogoutTest extends BaseTest {

	@Test
	public void testverifylogout() throws Exception {
		
		String user = Exceldata.getdata(filepath, "Login", 1, 0);

		String pass = Exceldata.getdata(filepath, "Login", 1, 1);
		
		String logintext = Exceldata.getdata(filepath, "Login", 1, 3);

		
		String logintitle = Exceldata.getdata(filepath, "Login", 1, 2);

	

		DashboardPage ep = new DashboardPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		lp.enterusername(user);
		lp.enterpassword(pass);
		lp.clickonlogin();
		ep.clickavatar();
		ep.clicklogout();

		lp.verifytitle(logintitle);


	
		
		lp.verifylogintext(logintext);

		

	
	}

}
