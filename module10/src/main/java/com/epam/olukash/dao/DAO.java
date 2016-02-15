package main.java.com.epam.olukash.dao;

import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_FRIENDSHIP;
import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_LIKE;
import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_POST;
import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_USER;
import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_GET_USER_BY_COUNT_OF_LIKES_AND_FRIENDS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import main.java.com.epam.olukash.dao.util.ConnectionUtil;
import main.java.com.epam.olukash.dao.util.DateUtil;
import main.java.com.epam.olukash.dto.FriendShip;
import main.java.com.epam.olukash.dto.Like;
import main.java.com.epam.olukash.dto.Post;
import main.java.com.epam.olukash.dto.User;

/**
 * @author Oleksii_Lukash
 * @date 2/14/2016
 */
public class DAO
{
	private static final Logger logger = Logger.getLogger(DAO.class);


	public void executeStatement(String sqlQuery)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = ConnectionUtil.getConnection();

			state = conn.prepareStatement(sqlQuery);
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

	public void createUser(User user)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = ConnectionUtil.getConnection();

			state = conn.prepareStatement(SQL_CREATE_USER);

			state.setInt(1, user.getUserID());
			state.setString(2, user.getUserName());
			state.setString(3, user.getUserSurName());
			state.setDate(4, new Date(System.currentTimeMillis()));

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

	public void createFriendShip(FriendShip friendShip)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = ConnectionUtil.getConnection();

			state = conn.prepareStatement(SQL_CREATE_FRIENDSHIP);

			state.setInt(1, friendShip.getUserID1());
			state.setInt(2, friendShip.getUserID2());
			state.setDate(3, new Date(System.currentTimeMillis()));

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

	public void createFriendShip(int batchSize)
	{
		int count = 0;
		boolean run = true;
		Connection conn = null;
		PreparedStatement state = null;
		Random random = new Random();
		try
		{
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			state = conn.prepareStatement(SQL_CREATE_FRIENDSHIP);

			while (run)
			{
				for (int i=1; i<=1000; i++)
				{
					int userID1 = random.nextInt(999)+1;
					int id = random.nextInt(999)+1;
					int userID2 = id != userID1 ? id : (id+1);

					state.setInt(1, userID1);
					state.setInt(2, userID2 != 1001 ? userID2 : (userID2-2));
					state.setDate(3, new Date(System.currentTimeMillis()));
					state.addBatch();

				}

				count++;

				if(count % batchSize != 0)
				{
					state.executeBatch();
					conn.commit();

				}
				else
				{
					run = false;
				}
			}

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

	public void createPost(Post post)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = ConnectionUtil.getConnection();

			state = conn.prepareStatement(SQL_CREATE_POST);

			state.setInt(1, post.getPostID());
			state.setInt(2, post.getUserID());
			state.setString(3, post.getText());
			state.setDate(4, new Date(System.currentTimeMillis()));

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

	public void createLike(Like like)
	{
		Connection conn = null;
		PreparedStatement state = null;
		try
		{
			conn = ConnectionUtil.getConnection();

			state = conn.prepareStatement(SQL_CREATE_LIKE);

			state.setInt(1, like.getPostID());
			state.setInt(2, like.getUserID());
			state.setDate(3, new Date(like.getCreateDate().getTime()));

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

	public void createLike(int batchSize)
	{
		int count = 0;
		boolean run = true;
		Connection conn = null;
		PreparedStatement state = null;
		Random random = new Random();
		try
		{
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			state = conn.prepareStatement(SQL_CREATE_LIKE);

			while (run)
			{
				for(int i=1; i<=1000; i++)
				{
					state.setInt(1, random.nextInt(499) + 1);
					state.setInt(2, random.nextInt(999) + 1);
					state.setDate(3, new Date(DateUtil.getRandomDate(new java.util.Date(2015,01,01), new java.util.Date(2016,01,01)).getTime()));
					state.addBatch();
				}

				count++;

				if(count % batchSize != 0)
				{
					state.executeBatch();
					conn.commit();

				}
				else
				{
					run = false;
				}

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
