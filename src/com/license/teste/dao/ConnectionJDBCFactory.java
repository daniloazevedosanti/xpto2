package com.license.teste.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBCFactory {

	private static String URL     = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String DRIVER  = "oracle.jdbc.driver.OracleDriver";
	private static String USUARIO = ""; //default = SYSTEMA 
	private static String SENHA   = "";
    
	//ORACLE
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(URL);
		return DriverManager.getConnection(DRIVER, USUARIO, SENHA);
	}
	
	public static Connection getConnectionMySQL() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
	}
	
}
