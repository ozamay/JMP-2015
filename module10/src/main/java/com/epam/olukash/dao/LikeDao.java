package main.java.com.epam.olukash.dao;

import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_LIKE;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.epam.olukash.dto.Like;

/**
 * @author Oleksii.Lukash
 */
public class LikeDao extends AbstractDAO<Like>
{
	@Override
	protected String getSaveSql()
	{
		return SQL_CREATE_LIKE;
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
