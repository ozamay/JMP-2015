package main.java.com.epam.olukash.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import main.java.com.epam.olukash.dao.util.ConnectionUtil;

/**
 * @author Oleksii.Lukash
 */
public class OtherDAO
{
	private static final Logger logger = Logger.getLogger(OtherDAO.class);


	public void executeStatement(String sqlQuery)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = ConnectionUtil.getConnection();
			state = conn.prepareStatement(sqlQuery);
			state.execute();
		}
		catch (SQLException e)
		{
			logger.error(e.getMessage(), e);
		}
		finally
		{
			ConnectionUtil.close(state);
			ConnectionUtil.close(conn);
		}
	}
}
