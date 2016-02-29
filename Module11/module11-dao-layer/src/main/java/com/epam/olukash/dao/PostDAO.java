package com.epam.olukash.dao;

import static com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_POST;
import static com.epam.olukash.dao.util.SQLConstants.SQL_GET_ALl_POSTS;
import static com.epam.olukash.dao.util.SQLConstants.SQL_REMOVE_POST;
import static com.epam.olukash.dao.util.SQLConstants.SQL_SELECT_POST;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.Post;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class PostDAO extends AbstractDAO<Post>
{
	@Override
	protected String getSaveSql()
	{
		return SQL_CREATE_POST;
	}

	@Override
	protected String getFindSql()
	{
		return SQL_SELECT_POST;
	}

	@Override
	protected String getFindAllSql()
	{
		return SQL_GET_ALl_POSTS;
	}

	@Override
	protected String getRemoveSql()
	{
		return SQL_REMOVE_POST;
	}

	@Override
	protected void populateStatement(PreparedStatement state, Post bean) throws SQLException
	{
		state.setInt(1, bean.getId());
		state.setInt(2, bean.getUserID());
		state.setString(3, bean.getText());
		state.setDate(4, new Date(System.currentTimeMillis()));
	}

	@Override
	protected Post populateBean(ResultSet rs) throws SQLException
	{
		Post post = new Post();
		post.setId(rs.getInt(1));
		post.setUserID(rs.getInt(2));
		post.setText(rs.getString(3));
		post.setCreatedDate(rs.getDate(4));
		return post;
	}
}

