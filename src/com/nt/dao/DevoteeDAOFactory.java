package com.nt.dao;

public class DevoteeDAOFactory {

	public static DevoteeDAO getInstance() {
		return new DevoteeDAOImpl();
	}

}
