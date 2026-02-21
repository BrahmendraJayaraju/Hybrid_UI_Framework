package com.orangeHRM.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import getdata.Exceldata;

import com.orangeHRM.generic.BaseTest;
import com.orangeHRM.pages.DashboardPage;
import com.orangeHRM.pages.LoginPage;

public class validLoginLogoutTest extends BaseTest {

	@Test
	public void testvalidloginlogout() throws Exception {

		String logintitle = Exceldata.getdata(filepath, "Login", 1, 2);

		String user = Exceldata.getdata(filepath, "Login", 1, 0);

		String pass = Exceldata.getdata(filepath, "Login", 1, 1);

		String dashboardtitle = Exceldata.getdata(filepath, "Dashboard", 1, 0);

		Reporter.log("testing:" + dashboardtitle, true);

		LoginPage lp = new LoginPage(driver);

		DashboardPage ep = new DashboardPage(driver);

		lp.verifytitle(logintitle);

		Reporter.log("user name is:" + user, true);

		lp.enterusername(user);

		Reporter.log("user pass is:" + pass, true);
		lp.enterpassword(pass);

		lp.clickonlogin();

		ep.verifydashboardtext(dashboardtitle);

		ep.clickavatar();
		ep.clicklogout();

		lp.verifytitle(logintitle);

	}
}
