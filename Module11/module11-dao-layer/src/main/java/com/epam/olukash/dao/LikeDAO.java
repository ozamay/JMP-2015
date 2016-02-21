package com.epam.olukash.dao;

import static com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_LIKE;
import static com.epam.olukash.dao.util.SQLConstants.SQL_GET_ALl_LIKES;
import static com.epam.olukash.dao.util.SQLConstants.SQL_REMOVE_LIKE;
import static com.epam.olukash.dao.util.SQLConstants.SQL_SELECT_LIKE;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.Like;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class LikeDAO extends AbstractDAO<Like>
{
	@Override
	protected String getSaveSql()
	{
		return SQL_CREATE_LIKE;
	}

	@Override
	protected String getFindSql()
	{
		return SQL_SELECT_LIKE;
	}

	@Override
	protected String getFindAllSql()
	{
		return SQL_GET_ALl_LIKES;
	}

	@Override
	protected String getRemoveSql()
	{
		return SQL_REMOVE_LIKE;
	}

	@Override
	protected void populateStatement(PreparedStatement state, Like bean) throws SQLException
	{
		state.setInt(1, bean.getId());
		state.setInt(2, bean.getPostID());
		state.setInt(3, bean.getUserID());
		state.setDate(4, new Date(bean.getCreateDate().getTime()));
	}

	@Override
	protected Like populateBean(ResultSet rs) throws SQLException
	{
		Like like = new Like();
		like.setId(rs.getInt(1));
		like.setPostID(rs.getInt(2));
		like.setUserID(rs.getInt(3));
		like.setCreateDate(rs.getDate(4));
		return like;
	}
}
