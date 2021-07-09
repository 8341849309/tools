package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nt.dao.ILogInDAO;
import com.nt.service.ILogInMgmtService;
import com.nt.service.LogInMgmtServiceImpl;

public class LogInMgmtServiceTestAnno {
	@InjectMocks
	private static LogInMgmtServiceImpl service;
	@Mock
	private static ILogInDAO daoMock;

	public LogInMgmtServiceTestAnno() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testLogInWithValidCredentials() {
		System.out.println("LogInMgmtServiceTest.testWithValidCredentials()");

		BDDMockito.given(daoMock.authenticate("raja", "rani")).willReturn(1);

		assertTrue(service.login("raja", "rani"));
	}

	@Test
	public void testLogInWithInValidCredentials() {
		System.out.println("LogInMgmtServiceTest.testWithInValidCredentials()");

		Mockito.when(daoMock.authenticate("raja", "rani1")).thenReturn(0);

		assertFalse(service.login("raja", "rani1"));
	}

	@Test
	public void testLogInWithNoCredentials() {
		System.out.println("LogInMgmtServiceTest.testWithValidCredentials()");

		assertThrows(IllegalArgumentException.class, () -> {
			service.login("", "");
		});
	}

	@Test
	public void testRegisterWithSpy() {
		ILogInDAO loginDAOSpy = Mockito.spy(ILogInDAO.class);
		ILogInMgmtService loginSerivce = new LogInMgmtServiceImpl(loginDAOSpy);
		loginSerivce.registerUser("raja", "admin");
		loginSerivce.registerUser("suresh", "visitor");
		loginSerivce.registerUser("rama", "");

		Mockito.verify(loginDAOSpy, Mockito.times(1)).addUser("raja", "admin");
		Mockito.verify(loginDAOSpy, Mockito.times(0)).addUser("suresh", "visitor");
		Mockito.verify(loginDAOSpy, Mockito.never()).addUser("rama", "");
	}

	@AfterAll
	public static void clear() {
		service = null;
		daoMock = null;
	}

}
