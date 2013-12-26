package com.nacorpio.pj.social.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.nacorpio.pj.social.ProjectSocial;

public class MySQL {
	private ProjectSocial pj;
	private String ip;
	private String databaseName;
	private String username;
	private String password;
	
	public Connection con;

	public MySQL(ProjectSocial pj, String ip, String databaseName, String username, String password) {
		this.pj = pj;
		this.ip = ip;
		this.databaseName = databaseName;
		this.username = username;
		this.password = password;
	}
	
	public synchronized void OpenConnection(){
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + databaseName, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			//We should stop the server because MySQL is needed in order to function.
			this.pj.getPluginLoader().disablePlugin(pj);
		}
	}

	public synchronized void CloseConnection() {
		try {
			if (con != null && con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
