package main.java.com.epam.olukash.dao;

import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_POST;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.epam.olukash.dto.Post;

/**
 * @author Oleksii.Lukash
 */
public class PostDao extends AbstractDAO<Post>
{
	@Override
	protected String getSaveSql()
	{
		return SQL_CREATE_POST;
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
