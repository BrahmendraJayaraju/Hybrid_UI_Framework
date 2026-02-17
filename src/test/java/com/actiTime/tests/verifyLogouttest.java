package com.actiTime.tests;


import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import getdata.ExceldataFramework;

import com.actiTime.pages.DashboardPage;
import com.actiTime.pages.LoginPage;

public class verifyLogouttest extends BaseTest {

	@Test
	public void testverifylogout() throws Exception {
		
		String user = ExceldataFramework.getdata(filepath, "Login", 1, 0);

		String pass = ExceldataFramework.getdata(filepath, "Login", 1, 1);
		
		String logintext = ExceldataFramework.getdata(filepath, "Login", 1, 3);

		
		String logintitle = ExceldataFramework.getdata(filepath, "Login", 1, 2);

	

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
