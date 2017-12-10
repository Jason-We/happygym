package services;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnector {
	
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/happygym";
	
	
	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}


	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	public Connection getConnections() {
		
		Connection con = null;
		try {
			Class.forName(getDriver());
			con = DriverManager.getConnection(getUrl(),"root","WEINAI");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
