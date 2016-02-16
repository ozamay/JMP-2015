package main.java.com.epam.olukash.dao;

import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_FRIENDSHIP;
import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_POST;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import main.java.com.epam.olukash.dto.Post;

/**
 * @author Oleksii.Lukash
 */
public class PostDao extends AbstractDAO<Post>
{
	@Override
	protected PreparedStatement getSaveStatement(Connection conn, Post bean) throws SQLException
	{
		PreparedStatement state = conn.prepareStatement(SQL_CREATE_POST);
		populateStatement(state, bean);
		return state;
	}

	@Override
	protected PreparedStatement getSaveStatementWithBatch(Connection conn, List<Post> beans) throws SQLException
	{
		PreparedStatement state = conn.prepareStatement(SQL_CREATE_POST);

		for(Post post : beans)
		{
			populateStatement(state, post);
			state.addBatch();
		}

		return state;
	}

	@Override
	protected void populateStatement(PreparedStatement state, Post bean) throws SQLException
	{
		state.setInt(1, bean.getPostID());
		state.setInt(2, bean.getUserID());
		state.setString(3, bean.getText());
		state.setDate(4, new Date(System.currentTimeMillis()));
	}

	@Override
	protected Post populateBean(ResultSet rs) throws SQLException
	{
		return null;
	}
}
