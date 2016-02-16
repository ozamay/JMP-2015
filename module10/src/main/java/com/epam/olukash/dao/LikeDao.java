package main.java.com.epam.olukash.dao;

import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_LIKE;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import main.java.com.epam.olukash.dto.Like;

/**
 * @author Oleksii.Lukash
 */
public class LikeDao extends AbstractDAO<Like>
{
	protected PreparedStatement getSaveStatement(Connection conn, Like like) throws SQLException
	{
		PreparedStatement state = conn.prepareStatement(SQL_CREATE_LIKE);
		populateStatement(state, like);
		return state;
	}

	@Override
	protected PreparedStatement getSaveStatementWithBatch(Connection conn, List<Like> beans) throws SQLException
	{
		PreparedStatement state = conn.prepareStatement(SQL_CREATE_LIKE);

		for(Like like : beans)
		{
			populateStatement(state, like);
			state.addBatch();
		}

		return state;
	}

	@Override
	protected void populateStatement(PreparedStatement state, Like bean) throws SQLException
	{
		state.setInt(1, bean.getPostID());
		state.setInt(2, bean.getUserID());
		state.setDate(3, new Date(bean.getCreateDate().getTime()));
	}

	@Override
	protected Like populateBean(ResultSet rs) throws SQLException
	{
		return null;
	}
}
