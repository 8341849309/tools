package com.nt.service;

import java.time.LocalDateTime;
import java.util.Random;

public class WishMsgService {

	private LocalDateTime dt=LocalDateTime.now();

	public boolean isValid() {
		return new Random().nextBoolean();
	}
	
	public String wish(String user) {
		String msg = null;
		int hour = dt.getHour();

		if (hour < 12)
			msg = "Good Mprning";
		else if (hour >= 12 && hour < 16)
			msg = "Good AfterNoon";
		else if (hour >= 16 && hour < 19)
			msg = "Good Evening";
		else
			msg = "Good Night";

		return msg + " " + user;
	}

}
