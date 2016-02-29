package com.epam.olukash.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class OtherDAO extends AbstractDAO
{
	private static final Logger logger = Logger.getLogger(OtherDAO.class);

	public void executeStatement(String sqlQuery)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = DataSourceUtils.getConnection(dataSource);
			state = conn.prepareStatement(sqlQuery);
			state.execute();
		}
		catch (SQLException e)
		{
			logger.error(e.getMessage(), e);
		}
		finally
		{
			close(state);
			close(conn);
		}
	}

	@Override
	protected String getSaveSql()
	{
		return null;
	}

	@Override
	protected String getFindSql()
	{
		return null;
	}

	@Override
	protected String getFindAllSql()
	{
		return null;
	}

	@Override
	protected String getRemoveSql()
	{
		return null;
	}

	@Override
	protected void populateStatement(PreparedStatement state, Object bean) throws SQLException
	{

	}

	@Override
	protected Object populateBean(ResultSet rs) throws SQLException
	{
		return null;
	}
}
