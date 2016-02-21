package com.epam.olukash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * @author Oleksii_Lukash
 */
public abstract class AbstractDAO<T>
{
	private static final Logger logger = Logger.getLogger(OtherDAO.class);

	@Autowired
	protected DataSource dataSource;

	public void save(T bean)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = DataSourceUtils.getConnection(dataSource);
			state = conn.prepareStatement(getSaveSql());
			populateStatement(state, bean);
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

	public void save(List<T> beans)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = DataSourceUtils.getConnection(dataSource);
			conn.setAutoCommit(false);

			state = conn.prepareStatement(getSaveSql());
			for(T bean : beans)
			{
				populateStatement(state, bean);
				state.addBatch();
			}
			conn.commit();
		}
		catch (SQLException e)
		{
			logger.error(e.getMessage(), e);
		}
		finally
		{
			close(conn);
			close(state);
		}
	}

	public T find(int id)
	{
		Connection conn = null;
		PreparedStatement state = null;
		T bean = null;
		try
		{
			conn = DataSourceUtils.getConnection(dataSource);
			state = conn.prepareStatement(getFindSql());
			state.setInt(1, id);
			ResultSet rs = state.executeQuery();

			if (rs.next())
			{
				bean = populateBean(rs);
			}

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
		return bean;
	}

	public void remove(int id)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = DataSourceUtils.getConnection(dataSource);
			state = conn.prepareStatement(getRemoveSql());
			state.setInt(1, id);
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

	public List<T> findAll()
	{
		Connection conn = null;
		PreparedStatement state = null;
		List<T> beans = new ArrayList<>();
		try
		{
			conn = DataSourceUtils.getConnection(dataSource);
			state = conn.prepareStatement(getFindAllSql());
			state.execute();
			ResultSet rs = state.executeQuery();

			while (rs.next())
			{
				beans.add(populateBean(rs));
			}

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
		return beans;
	}

	protected abstract String getSaveSql();
	protected abstract String getFindSql();
	protected abstract String getFindAllSql();
	protected abstract String getRemoveSql();

	protected abstract void populateStatement(PreparedStatement state, T bean) throws SQLException;

	protected abstract T populateBean(ResultSet rs) throws SQLException;

	public void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			logger.error("ERROR: cannot close statement " + e);
		}
	}

	public void close(Connection connection) {
		try {
			if (connection != null && connection.getAutoCommit()) {
				connection.close();
			}
		} catch (SQLException e) {
			logger.error("ERROR: cannot close connection " + e);
		}
	}
}
