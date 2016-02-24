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

public class UserDAOtest
{
	@Autowired
	private UserDAO userDAO;

//	@Test
//	@DatabaseSetup("classpath:userSampleData.xml")
//	public void testSave() throws Exception
//	{
//		User user = new User();
//		user.setId(3);
//		user.setUserName("piy");
//		user.setUserSurName("viy");
//		user.setBirthDay(new Date(2015,01,01));
//		userDAO.save(user);
//		assertEquals(user, userDAO.find(3));
//	}
//
//	@Test
//	@DatabaseSetup("classpath:userSampleData.xml")
//	public void testFind() throws Exception
//	{
//		User user = userDAO.find(1);
//		assertEquals(1, user.getId());
//		assertEquals("Mr", user.getUserName());
//	}
//
//	@Test
//	@DatabaseSetup("classpath:userSampleData.xml")
//	public void testFindAll() throws Exception
//	{
//		assertEquals(2, userDAO.findAll().size());
//	}
//
//	@Test
//	@DatabaseSetup("classpath:userSampleData.xml")
//	public void testRemove() throws Exception
//	{
//		userDAO.remove(1);
//		assertNull(null, userDAO.find(1));
//	}

}
