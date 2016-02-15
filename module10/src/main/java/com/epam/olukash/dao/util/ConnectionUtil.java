package main.java.com.epam.olukash.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * @author Oleksii.Lukash
 */
public class ConnectionUtil
{
	private static final Logger logger = Logger.getLogger(ConnectionUtil.class);
	private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.database");

	public static Connection getConnection()
	{
		try {
			Class.forName (resourceBundle.getString("database.driver"));
		} catch (ClassNotFoundException e) {
			logger.error("ERROR: cannot load class " + e);
		}

		String url = resourceBundle.getString("database.url");

		//properties for creating connection to Oracle database
		Properties props = new Properties();
		props.setProperty("user", resourceBundle.getString("database.login"));
		props.setProperty("password", resourceBundle.getString("database.password"));

		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url,props);
		}
		catch (SQLException e)
		{
			logger.error("ERROR: cannot create connection " + e);
		}
		return  conn;
	}

	public static void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			logger.error("ERROR: cannot close statement " + e);
		}
	}

	public static void close(Connection connection) {
		try {
			if (connection != null && connection.getAutoCommit()) {
				connection.close();
			}
		} catch (SQLException e) {
			logger.error("ERROR: cannot close connection " + e);
		}
	}
}
