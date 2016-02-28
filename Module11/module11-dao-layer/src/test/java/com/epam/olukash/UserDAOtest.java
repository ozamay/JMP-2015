package com.epam.olukash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.epam.olukash.dao.UserDAO;
import com.epam.olukash.dto.User;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author Oleksii.Lukash
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-beans.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:userSampleData.xml")
public class UserDAOtest
{
	@Autowired
	private UserDAO userDAO;

	@Test
	public void testSave() throws Exception
	{
		String name = "piy";
		String surname = "viy";
		User user = new User();
		user.setId(3);
		user.setUserName(name);
		user.setUserSurName(surname);
		user.setBirthDay(new Date(2015,01,01));
		userDAO.save(user);
		User savedUser = userDAO.find(3);

		assertEquals(savedUser.getId(), 3);
		assertEquals(savedUser.getUserName(), name);
		assertEquals(savedUser.getUserSurName(), surname);
	}

	@Test
	public void testFind() throws Exception
	{
		User user = userDAO.find(1);
		assertEquals(1, user.getId());
		assertEquals("Mr", user.getUserName());
	}

	@Test
	public void testFindAll() throws Exception
	{
		assertEquals(2, userDAO.findAll().size());
	}

	@Test
	public void testRemove() throws Exception
	{
		userDAO.remove(1);
		assertNull(null, userDAO.find(1));
	}

}
