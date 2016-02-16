package main.java.com.epam.olukash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import main.java.com.epam.olukash.dao.util.ConnectionUtil;

/**
 * @author Oleksii_Lukash
 */
public abstract class AbstractDAO<T>
{
	private static final Logger logger = Logger.getLogger(OtherDAO.class);

	public void save(T bean)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = ConnectionUtil.getConnection();
			state = getSaveStatement(conn, bean);
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

	public void save(List<T> beans)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			state = getSaveStatementWithBatch(conn, beans);
			state.executeBatch();
			conn.commit();
		}
		catch (SQLException e)
		{
			logger.error(e.getMessage(), e);
		}
		finally
		{
			ConnectionUtil.close(conn);
			ConnectionUtil.close(state);
		}
	}

	protected abstract PreparedStatement getSaveStatement(Connection conn, T bean) throws SQLException;

	protected abstract PreparedStatement getSaveStatementWithBatch(Connection conn, List<T> beans) throws SQLException;
}
