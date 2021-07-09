package com.nt.service;

public interface ILogInMgmtService {
	public boolean login(String username, String password);

	public String registerUser(String username, String role);
	
}
