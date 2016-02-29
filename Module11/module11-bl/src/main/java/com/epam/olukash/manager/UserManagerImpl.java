package com.epam.olukash.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.UserDAO;
import com.epam.olukash.dto.User;

/**
 * @author Oleksii.Lukash
 */

@Component
public class UserManagerImpl extends AbstractManager<User, UserDAO> implements UserManager
{
	public List<User> getUserByFriendAndLikeCounts(int friendCount, int likeCount)
	{
		return beanDAO.getUserByFriendAndLikeCounts(friendCount, likeCount);
	}
}
