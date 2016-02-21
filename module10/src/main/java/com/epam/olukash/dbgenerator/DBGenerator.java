package main.java.com.epam.olukash.dbgenerator;

import static main.java.com.epam.olukash.dao.util.SQLConstants.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import main.java.com.epam.olukash.dao.OtherDAO;
import main.java.com.epam.olukash.dao.FriendshipDao;
import main.java.com.epam.olukash.dao.LikeDao;
import main.java.com.epam.olukash.dao.PostDao;
import main.java.com.epam.olukash.dao.UserDao;
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

	private OtherDAO otherDAO;
	private FriendshipDao friendshipDao;
	private LikeDao likeDao;
	private PostDao postDao;
	private UserDao userDao;

	public DBGenerator()
	{
		otherDAO = new OtherDAO();
		friendshipDao = new FriendshipDao();
		likeDao = new LikeDao();
		postDao = new PostDao();
		userDao = new UserDao();
	}
 	public void run()
	{
	 	dropTablesIfExist();
		createTables();
		fillUserTables();
		fillFriendShipTables();
		fillPostTables();
		fillLikeTables();

		List<User> users = userDao.getUserByFriendAndLikeCounts(70, 100);
		for(User user : users)
		{
			logger.info(user.getUserName());
		}
	}

	private void dropTablesIfExist()
	{
		otherDAO.executeStatement(SQL_DROP_USER);
		otherDAO.executeStatement(SQL_DROP_FRIENDSHIPS);
		otherDAO.executeStatement(SQL_DROP_LIKES);
		otherDAO.executeStatement(SQL_DROP_POSTS);
	}

	private void createTables()
	{
		otherDAO.executeStatement(SQL_CREATE_TABLE_USER);
		otherDAO.executeStatement(SQL_CREATE_TABLE_FRIENDSHIPS);
		otherDAO.executeStatement(SQL_CREATE_TABLE_LIKES);
		otherDAO.executeStatement(SQL_CREATE_TABLE_POSTS);
	}

	private void fillUserTables()
	{
		for(int i = 1; i <= 1000; i++)
		{
			User user = new User();
			user.setUserID(i);
			user.setUserName("userName" + i);
			user.setUserSurName("surName" + i);

			userDao.save(user);
		}
	}

	private void fillFriendShipTables()
	{
		int run = 0;
		Random random = new Random();

		while (run < 70)
		{
			List<FriendShip> friendShips = new ArrayList<>();
			for (int i = 0; i < 1000; i++)
			{
				FriendShip friendShip = new FriendShip();
				int userID1 = random.nextInt(999)+1;
				int id = random.nextInt(999)+1;
				int userID2 = id != userID1 ? id : (id+1);

				friendShip.setUserID1(userID1);
				friendShip.setUserID2(userID2);
				friendShip.setCreatedDate(new Date(System.currentTimeMillis()));

				friendShips.add(friendShip);
			}

			friendshipDao.save(friendShips);
			run++;
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
			postDao.save(post);
		}
	}

	private void fillLikeTables()
	{
		int run = 0;
		Random random = new Random();

		while (run < 3000)
		{
			List<Like> likes = new ArrayList<>();
			for (int i = 0; i < 1000; i++)
			{
				Like like = new Like();

				like.setPostID(random.nextInt(499) + 1);
				like.setUserID(random.nextInt(999) + 1);
				like.setCreateDate(DateUtil.getRandomDate(new java.util.Date(2015,01,01), new java.util.Date(2016,01,01)));

				likes.add(like);
			}

			likeDao.save(likes);
			run++;
		}
	}
}
