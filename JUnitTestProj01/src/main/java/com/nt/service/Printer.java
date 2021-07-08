package com.nt.service;

public class Printer {

	private static Printer printer = null;

	private Printer() {

	}

	public static Printer getInstance() {
		//if (printer == null)
			//printer = new Printer();

		return printer;
	}

}
