package com.nt.dao;

public interface ILogInDAO {
	public int authenticate(String username, String password);
	public int addUser(String username,String role);
}
