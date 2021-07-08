package com.nt.test;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.nt.service.BankService;

//@TestMethodOrder(value = MethodOrderer.MethodName.class)
//@TestMethodOrder(value = MethodOrderer.DisplayName.class)
//@TestMethodOrder(value = MethodOrderer.Random.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@DisplayName("Testing BankService Class")
public class BankServiceTest1 {

	private static BankService service;

	/*
	 * @BeforeEach public void setUp() {
	 * System.out.println("BankServiceTest.setUp()"); service = new BankService(); }
	 */

	@BeforeAll
	public static void setUpOnce() {
		System.out.println("BankServiceTest.setUpOnce()");
		service = new BankService();
	}

	@Test
	@Order(1)
	@DisplayName("Calculate Simple Interest With Small Numbers")
	public void testcalcSimpleInterestAmtWithSmallNumbers() {
		System.out.println("BankServiceTest.testcalcSimpleInterestAmtWithSmallNumbers()");
		double actual = service.calcSimpleInterestAmt(1000F, 2F, 2F);
		double expected = 40.0;

		Assertions.assertEquals(expected, actual, "Results are matched!!");

	}

	@Test
	@Order(2)
	@DisplayName("Calculate Simple Interest With Big Numbers")
	public void testcalcSimpleInterestAmtWithBigNumbers() {
		System.out.println("BankServiceTest.testcalcSimpleInterestAmtWithBigNumbers()");
		double actual = service.calcSimpleInterestAmt(10000000F, 2F, 2F);
		double expected = 400000.0;

		Assertions.assertEquals(expected, actual, "Results are matched");
	}
	
	@Test
	@Order(3)
	@DisplayName("Calculate Simple Interest With Invalid Inputs")
	public void testcalcSimpleInterestAmtWithInvalidInputs() {
		System.out.println("BankServiceTest.testcalcSimpleInterestAmtIllegalArgException()");
		
		Assertions.assertThrows(IllegalArgumentException.class, 
								()->{
										service.calcSimpleInterestAmt(-1000.0F, 1F, 1F);
								},
								"Exception is matched");
	}
	
	//@Disabled
	@Order(4)
	@Test
	@DisplayName("Calculate Simple Interest With Network Traffic")
	public void testcalcSimpleInterestAmtWithTimer() {
		System.out.println("BankServiceTest.testcalcSimpleInterestAmtWithTimer()");
		
		Duration timeout=Duration.ofSeconds(5);
		
		Assertions.assertTimeout(timeout, 
								()->{
									service.calcSimpleInterestAmt(10000000F, 3F, 4F);
									});
	}
	

	/*
	 * @AfterEach public void clear() {
	 * System.out.println("BankServiceTest.clear()"); service = null; }
	 */

	@AfterAll
	public static void clearOnce() {
		System.out.println("BankServiceTest.clearOnce()");
		service = null;
	}

}
