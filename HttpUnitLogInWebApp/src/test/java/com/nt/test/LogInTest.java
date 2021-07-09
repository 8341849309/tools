package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class LogInTest {

	private static WebConversation conversation;
	
	@BeforeAll
	public static void setUp() {
		conversation=new WebConversation();
	}
	
	@Test
	public void testWithValidCredentials() throws Exception {
		WebResponse response=conversation.getResponse("http://localhost:8006/HttpUnitLogInWebApp/index.html");
		
		WebForm form=response.getForms()[0];
		form.setParameter("uname", "raja");
		form.setParameter("pwd", "rani");
		
		WebResponse response1=form.submit();
		String actual=response1.getText().trim();
		
		assertEquals("Valid Credentials", actual);
		
	}
	
	@Test
	public void testWithInValidCredentials() throws Exception {
		WebResponse response=conversation.getResponse("http://localhost:8006/HttpUnitLogInWebApp/index.html");
		
		WebForm form=response.getForms()[0];
		form.setParameter("uname", "raja");
		form.setParameter("pwd", "rani1");
		
		WebResponse response1=form.submit();
		String actual=response1.getText().trim();
		
		assertEquals("InValid Credentials", actual);
		
	}
	
}
