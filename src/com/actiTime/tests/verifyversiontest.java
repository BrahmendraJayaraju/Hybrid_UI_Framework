package com.actiTime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import getdata.ExceldataFramework;
import com.actiTime.pages.LoginPage;

public class verifyversiontest extends BaseTest {

	@Test
	public void testverifyversion() throws Exception {
		String logintitle = ExceldataFramework.getdata(filepath, "Login", 1, 2);

		String eversion = ExceldataFramework.getdata(filepath, "Login", 1, 3);

		LoginPage lp = new LoginPage(driver);

		lp.verifytitle(logintitle);

		String aversion = lp.verifyeversion();

		Assert.assertEquals(aversion, eversion);

		Reporter.log("version matching:" + aversion, true);

	}

}
