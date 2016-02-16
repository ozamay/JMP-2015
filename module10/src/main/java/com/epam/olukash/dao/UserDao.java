package main.java.com.epam.olukash.dao;

import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_USER;
import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_GET_USER_BY_COUNT_OF_LIKES_AND_FRIENDS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import main.java.com.epam.olukash.dao.util.ConnectionUtil;
import main.java.com.epam.olukash.dto.User;

/**
 * @author Oleksii.Lukash
 */
public class UserDao extends AbstractDAO<User>
{
	private static final Logger logger = Logger.getLogger(OtherDAO.class);

	@Override
	protected PreparedStatement getSaveStatement(Connection conn, User user) throws SQLException
	{
		PreparedStatement state = conn.prepareStatement(SQL_CREATE_USER);

		state.setInt(1, user.getUserID());
		state.setString(2, user.getUserName());
		state.setString(3, user.getUserSurName());
		state.setDate(4, new Date(System.currentTimeMillis()));

		return state;
	}

	@Override
	protected PreparedStatement getSaveStatementWithBatch(Connection conn, List<User> beans) throws SQLException
	{
		PreparedStatement state = conn.prepareStatement(SQL_CREATE_USER);

		for(User user : beans)
		{
			state.setInt(1, user.getUserID());
			state.setString(2, user.getUserName());
			state.setString(3, user.getUserSurName());
			state.setDate(4, new Date(System.currentTimeMillis()));
			state.addBatch();
		}

		return state;
	}

	public List<User> getUserByFriendAndLikeCounts(int friendCount, int likeCount)
	{
		Connection conn = null;
		PreparedStatement state = null;
		ArrayList<User> users = new ArrayList<>();
		try
		{
			conn = ConnectionUtil.getConnection();

			state = conn.prepareStatement(SQL_GET_USER_BY_COUNT_OF_LIKES_AND_FRIENDS);

			state.setInt(1, friendCount);
			state.setInt(2, likeCount);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserSurName(rs.getString(3));
				user.setBirthDay(new Date(rs.getDate(4).getTime()));
				users.add(user);
			}
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

		return users;
	}
}