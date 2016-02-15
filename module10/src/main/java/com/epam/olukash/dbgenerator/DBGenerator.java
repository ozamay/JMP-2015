package main.java.com.epam.olukash.dbgenerator;

import static main.java.com.epam.olukash.dao.util.SQLConstants.*;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import main.java.com.epam.olukash.dao.DAO;
import main.java.com.epam.olukash.dto.Post;
import main.java.com.epam.olukash.dto.User;

/**
 * @author Oleksii.Lukash
 */
public class DBGenerator
{
	private static final Logger logger = Logger.getLogger(DBGenerator.class);

	private DAO DAO;
	public DBGenerator()
	{
		DAO = new DAO();
	}
 	public void run()
	{
	 	dropTablesIfExist();
		createTables();
		fillUserTables();
		DAO.createFriendShip(70);
		fillPostTables();
		DAO.createLike(300);

		List<User> users = DAO.getUserByFriendAndLikeCounts(70, 100);
		for(User user : users)
		{
			logger.info(user.getUserName());
		}
	}

	private void dropTablesIfExist()
	{
		DAO.executeStatement(SQL_DROP_USER);
		DAO.executeStatement(SQL_DROP_FRIENDSHIPS);
		DAO.executeStatement(SQL_DROP_LIKES);
		DAO.executeStatement(SQL_DROP_POSTS);
	}

	private void createTables()
	{
		DAO.executeStatement(SQL_CREATE_TABLE_USER);
		DAO.executeStatement(SQL_CREATE_TABLE_FRIENDSHIPS);
		DAO.executeStatement(SQL_CREATE_TABLE_LIKES);
		DAO.executeStatement(SQL_CREATE_TABLE_POSTS);
	}

	private void fillUserTables()
	{
		for(int i = 1; i <= 1000; i++)
		{
			User user = new User();
			user.setUserID(i);
			user.setUserName("userName" + i);
			user.setUserSurName("surName" + i);

			DAO.createUser(user);
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
			DAO.createPost(post);
		}
	}
}
