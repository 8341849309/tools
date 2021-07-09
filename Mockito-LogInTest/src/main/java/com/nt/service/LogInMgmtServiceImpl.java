package com.nt.service;

import com.nt.dao.ILogInDAO;

public class LogInMgmtServiceImpl implements ILogInMgmtService {

	private ILogInDAO dao;

	public LogInMgmtServiceImpl(ILogInDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean login(String username, String password) {

		if (username == "" || password == "")
			throw new IllegalArgumentException("Empty Credentials");

		int count = dao.authenticate(username, password);

		if (count == 0)
			return false;

		return true;
	}

	@Override
	public String registerUser(String username, String role) {
		if (!role.equalsIgnoreCase("") && !role.equalsIgnoreCase("visitor")) {
			dao.addUser(username, role);
			return "User Added";
		}
			return "User Not Added";
	}

}
