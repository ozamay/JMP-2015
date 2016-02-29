package com.epam.olukash.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.olukash.dto.User;

/**
 * @author Oleksii.Lukash
 */
public interface UserManager extends BeanManager<User>
{
	public List<User> getUserByFriendAndLikeCounts(int friendCount, int likeCount);
}
