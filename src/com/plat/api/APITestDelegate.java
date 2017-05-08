package com.plat.api;

import java.sql.Connection;
import java.sql.PreparedStatement;

@javax.jws.WebService(targetNamespace = "http://api.plat.com/", serviceName = "APITestService", portName = "APITestPort", wsdlLocation = "WEB-INF/wsdl/APITestService.wsdl")
public class APITestDelegate {

	com.plat.api.APITest aPITest = new com.plat.api.APITest();

	public boolean createUser(String username, String password, String database) {
		return aPITest.createUser(username, password, database);
	}

}