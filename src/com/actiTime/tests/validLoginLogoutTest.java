package com.actiTime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import getdata.ExceldataFramework;
import com.actiTime.pages.EnterTimetrackPage;
import com.actiTime.pages.LoginPage;

public class validLoginLogoutTest extends BaseTest {

	@Test
	public void testvalidloginlogout() throws Exception {

		String logintitle = ExceldataFramework.getdata(filepath, "Login", 1, 2);

		String user = ExceldataFramework.getdata(filepath, "Login", 1, 0);

		String pass = ExceldataFramework.getdata(filepath, "Login", 1, 1);

		String timetracktitle = ExceldataFramework.getdata(filepath, "entertimetrack", 1, 0);

		Reporter.log("testing:" + timetracktitle, true);

		LoginPage lp = new LoginPage(driver);

		EnterTimetrackPage ep = new EnterTimetrackPage(driver);

		lp.verifytitle(logintitle);

		Reporter.log("user name is:" + user, true);

		lp.enterusername(user);

		Reporter.log("user pass is:" + pass, true);
		lp.enterpassword(pass);

		lp.clickonlogin();

		lp.verifytitle(timetracktitle);

		ep.clickavatar();
		ep.clicklogout();

		lp.verifytitle(logintitle);

	}
}
