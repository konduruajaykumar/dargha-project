package com.nt.service;

public class DevoteeServiceFactory {
	public static DevoteeService getInstance() {
		return new DevoteeServiceImpl();

	}
}
