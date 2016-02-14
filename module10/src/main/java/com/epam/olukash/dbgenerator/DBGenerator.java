package main.java.com.epam.olukash.dbgenerator;

import static main.java.com.epam.olukash.dao.util.SQLConstants.*;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import main.java.com.epam.olukash.dao.DAOm;
import main.java.com.epam.olukash.dto.Post;
import main.java.com.epam.olukash.dto.User;

/**
 * @author Oleksii.Lukash
 */
public class DBGenerator
{
	private static final Logger logger = Logger.getLogger(DBGenerator.class);

	private DAOm DAOm;
	public DBGenerator()
	{
		DAOm = new DAOm();
	}
 	public void run()
	{
	 	dropTablesIfExist();
		createTables();
		fillUserTables();
		DAOm.createFriendShip(70);
		fillPostTables();
		DAOm.createLike(300);

		List<User> users = DAOm.getUserByFriendAndLikeCounts(70, 100);
		for(User user : users)
		{
			logger.info(user.getUserName());
		}
	}

	private void dropTablesIfExist()
	{
		DAOm.executeStatement(SQL_DROP_USER);
		DAOm.executeStatement(SQL_DROP_FRIENDSHIPS);
		DAOm.executeStatement(SQL_DROP_LIKES);
		DAOm.executeStatement(SQL_DROP_POSTS);
	}

	private void createTables()
	{
		DAOm.executeStatement(SQL_CREATE_TABLE_USER);
		DAOm.executeStatement(SQL_CREATE_TABLE_FRIENDSHIPS);
		DAOm.executeStatement(SQL_CREATE_TABLE_LIKES);
		DAOm.executeStatement(SQL_CREATE_TABLE_POSTS);
	}

	private void fillUserTables()
	{
		for(int i = 1; i <= 1000; i++)
		{
			User user = new User();
			user.setUserID(i);
			user.setUserName("userName" + i);
			user.setUserSurName("surName" + i);

			DAOm.createUser(user);
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
			DAOm.createPost(post);
		}
	}
}
