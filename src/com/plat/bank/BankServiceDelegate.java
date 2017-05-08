package com.plat.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.plat.api.DBUtil;

@javax.jws.WebService(targetNamespace = "http://bank.plat.com/", serviceName = "BankServiceService", portName = "BankServicePort", wsdlLocation = "WEB-INF/wsdl/BankServiceService.wsdl")
public class BankServiceDelegate {

	com.plat.bank.BankService bankService = new com.plat.bank.BankService();

	public boolean pay(String customer, String developer) {
		return bankService.pay(customer, developer);
	}

}