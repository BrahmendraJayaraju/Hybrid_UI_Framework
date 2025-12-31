package getdata;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.annotations.Test;

public class report {
	@Test

	public void sendEmail() throws Exception

	{

		EmailAttachment attachment = new EmailAttachment();

		attachment.setPath(

				"./.html");

		attachment.setDisposition(EmailAttachment.ATTACHMENT);

		attachment.setDescription("Automation  Extent Report");

		attachment.setName("Archive.html");

		// Create the email message

		MultiPartEmail email = new MultiPartEmail();

		email.setHostName("smtp.gmail.com");

		email.setSmtpPort(587);

		// email.setHostName("smtp-mail.outlook.com");

		// email.setSmtpPort( 587);

		email.setSSLOnConnect(true);

		email.setAuthenticator(new DefaultAuthenticator("", ""));

		try

		{

			email.setFrom("");

			email.setSubject("ExecutionReport");

			email.setMsg(

					"Hi Team,\n\nplease find  automation ExtentReport. Download and open in Chrome Broswer.\n\n\nThanksRegards,\nBrahmendra jayaraju\n9886603727");

			email.addTo("");

			email.addTo("");

		}

		catch (Exception e)

		{

		}

		email.attach(attachment);

		email.send();

	}
}
