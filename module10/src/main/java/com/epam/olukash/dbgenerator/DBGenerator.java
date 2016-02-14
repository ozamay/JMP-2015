package main.java.com.epam.olukash.dbgenerator;

import static main.java.com.epam.olukash.dao.util.SQLConstants.*;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import main.java.com.epam.olukash.dao.DAO;
import main.java.com.epam.olukash.dao.util.DateUtil;
import main.java.com.epam.olukash.dto.FriendShip;
import main.java.com.epam.olukash.dto.Like;
import main.java.com.epam.olukash.dto.Post;
import main.java.com.epam.olukash.dto.User;

/**
 * @author Oleksii.Lukash
 */
public class DBGenerator
{
	private static final Logger logger = Logger.getLogger(DBGenerator.class);

	private DAO dao;
	public DBGenerator()
	{
		dao = new DAO();
	}
 	public void run()
	{
	 	dropTablesIfExist();
		createTables();
		fillUserTables();
		dao.createFriendShip(70);
		fillPostTables();
		dao.createLike(300);

		List<User> users = dao.getUserByFriendAndLikeCounts(70, 100);
		for(User user : users)
		{
			logger.info(user.getUserName());
		}
	}

	private void dropTablesIfExist()
	{
		dao.executeStatement(SQL_DROP_USER);
		dao.executeStatement(SQL_DROP_FRIENDSHIPS);
		dao.executeStatement(SQL_DROP_LIKES);
		dao.executeStatement(SQL_DROP_POSTS);
	}

	private void createTables()
	{
		dao.executeStatement(SQL_CREATE_TABLE_USER);
		dao.executeStatement(SQL_CREATE_TABLE_FRIENDSHIPS);
		dao.executeStatement(SQL_CREATE_TABLE_LIKES);
		dao.executeStatement(SQL_CREATE_TABLE_POSTS);
	}

	private void fillUserTables()
	{
		for(int i = 1; i <= 1000; i++)
		{
			User user = new User();
			user.setUserID(i);
			user.setUserName("userName" + i);
			user.setUserSurName("surName" + i);

			dao.createUser(user);
		}
	}

	private void fillFriendShipTables()
	{
		Random random = new Random();
		for(int i = 1; i <= 70000; i++)
		{
			FriendShip friendShip = new FriendShip();
			friendShip.setUserID1(random.nextInt(999)+1);
			int id = random.nextInt(999)+1;
			int userID2 = id != friendShip.getUserID1() ? id : (id+1);
			friendShip.setUserID2(userID2 != 1001 ? userID2 : (userID2-2));

			dao.createFriendShip(friendShip);
		}
	}

	private void fillPostTables()
	{
		Random random = new Random();
		for(int i = 1; i <= 500; i++)
		{
			Post post = new Post();
			post.setPostID(i);
			post.setUserID(random.nextInt(999)+1);
			post.setText("text");
			dao.createPost(post);
		}
	}

	private void fillLikeTables()
	{
		Random random = new Random();
		for(int i = 1; i <= 300000; i++)
		{
			Like like = new Like();
			like.setUserID(random.nextInt(999)+1);
			like.setPostID(random.nextInt(499)+1);
			like.setCreateDate(DateUtil.getRandomDate("2015-01-01 00:00:00", "2016-01-01 00:00:00"));
			dao.createLike(like);
		}
	}


}
