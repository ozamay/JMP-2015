package com.epam.olukash.dao;

import static com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_USER;
import static com.epam.olukash.dao.util.SQLConstants.SQL_GET_ALl_USERS;
import static com.epam.olukash.dao.util.SQLConstants.SQL_GET_USER_BY_COUNT_OF_LIKES_AND_FRIENDS;
import static com.epam.olukash.dao.util.SQLConstants.SQL_REMOVE_USER;
import static com.epam.olukash.dao.util.SQLConstants.SQL_SELECT_USER;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.User;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class UserDAO extends AbstractDAO<User>
{
	private static final Logger logger = Logger.getLogger(OtherDAO.class);

	public List<User> getUserByFriendAndLikeCounts(int friendCount, int likeCount)
	{
		Connection conn = null;
		PreparedStatement state = null;
		ArrayList<User> users = new ArrayList<>();
		try
		{
			conn = DataSourceUtils.getConnection(dataSource);

			state = conn.prepareStatement(SQL_GET_USER_BY_COUNT_OF_LIKES_AND_FRIENDS);

			state.setInt(1, friendCount);
			state.setInt(2, likeCount);
			ResultSet rs = state.executeQuery();

			while (rs.next())
			{
				users.add(populateBean(rs));
			}
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

		return users;
	}

	@Override
	protected String getSaveSql()
	{
		return SQL_CREATE_USER;
	}

	@Override
	protected String getFindSql()
	{
		return SQL_SELECT_USER;
	}

	@Override
	protected String getFindAllSql()
	{
		return SQL_GET_ALl_USERS;
	}

	@Override
	protected String getRemoveSql()
	{
		return SQL_REMOVE_USER;
	}

	@Override
	protected void populateStatement(PreparedStatement state, User bean) throws SQLException
	{
		state.setInt(1, bean.getId());
		state.setString(2, bean.getUserName());
		state.setString(3, bean.getUserSurName());
		state.setDate(4, new Date(System.currentTimeMillis()));
	}

	@Override
	protected User populateBean(ResultSet rs) throws SQLException
	{
		User user = new User();
		user.setId(rs.getInt(1));
		user.setUserName(rs.getString(2));
		user.setUserSurName(rs.getString(3));
		user.setBirthDay(new Date(rs.getDate(4).getTime()));

		return user;
	}
}
