package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.nt.service.WishMsgService;

public class WishMsgServiceTest {
	private static WishMsgService service;

	@BeforeAll
	public static void setUp() {
		System.out.println("WishMsgServiceTest.setUp()");
		service = new WishMsgService();
	}

	@ParameterizedTest
	@ValueSource(strings = { "Venkat", "Rama", "Yudhistir", "Krishna" })
	public void testWishWithArray(String user) {
		System.out.println("WishMsgServiceTest.testWish()");

		String actual = service.wish(user);
		assertEquals("Good AfterNoon " + user, actual);
	}

	@Test
	public void testWishIsEmpty() {
		System.out.println("WishMsgServiceTest.testWish()");

		assertTrue(service.isValid());
	}

	@AfterAll
	public static void clear() {
		System.out.println("WishMsgServiceTest.clear()");
		service = null;
	}

}
