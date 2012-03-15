package com.sixcodes.dao;

import java.sql.*;

public class Conectar {

	public static String status="";

public static Connection getConnection() {
	Connection conn=null;

try{

	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	String url = "jdbc:mysql://localhost/uploader?user=root&password=";
	conn = DriverManager.getConnection(url);

	status = "Conectado";}

catch (SQLException e){
	status = e.getMessage();
}catch (ClassNotFoundException e){
	status = e.getMessage();
}catch (Exception e){
	status = e.getMessage();}

return conn;}}