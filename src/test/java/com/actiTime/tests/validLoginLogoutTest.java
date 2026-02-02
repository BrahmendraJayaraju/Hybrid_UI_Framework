package com.actiTime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import getdata.ExceldataFramework;
import com.actiTime.pages.LicensesPage;
import com.actiTime.pages.LoginPage;

public class validLoginLogoutTest extends BaseTest {

	@Test
	public void testvalidloginlogout() throws Exception {

		String logintitle = ExceldataFramework.getdata(filepath, "Login", 1, 2);

		String user = ExceldataFramework.getdata(filepath, "Login", 1, 0);

		String pass = ExceldataFramework.getdata(filepath, "Login", 1, 1);

		String licensetitle = ExceldataFramework.getdata(filepath, "Licenses", 1, 0);

		Reporter.log("testing:" + licensetitle, true);

		LoginPage lp = new LoginPage(driver);

		LicensesPage ep = new LicensesPage(driver);

		lp.verifytitle(logintitle);

		Reporter.log("user name is:" + user, true);

		lp.enterusername(user);

		Reporter.log("user pass is:" + pass, true);
		lp.enterpassword(pass);

		lp.clickonlogin();

		lp.verifytitle(licensetitle);

		ep.clickavatar();
		ep.clicklogout();

		lp.verifytitle(logintitle);

	}
}
