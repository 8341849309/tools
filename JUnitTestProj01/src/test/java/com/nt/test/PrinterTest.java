package com.nt.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.nt.service.Printer;

public class PrinterTest {

	@Test
	public void testIsSingleton() {
		Printer p1 = Printer.getInstance();
		Printer p2 = Printer.getInstance();

		/*
		 * Assertions.assertNotNull(p1); 
		 * Assertions.assertNotNull(p2);
		 */

		// assertSame(p1, p2);

		if (p1 == null || p2 == null)
			fail("p1 p2 must not null");

	}

}
