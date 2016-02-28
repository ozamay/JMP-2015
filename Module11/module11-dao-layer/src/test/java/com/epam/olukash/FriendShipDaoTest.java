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

import com.epam.olukash.dao.FriendshipDAO;
import com.epam.olukash.dto.FriendShip;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author Oleksii.Lukash
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-beans.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:friendshipSampleData.xml")
public class FriendShipDaoTest
{
	@Autowired
	private FriendshipDAO dao;

	@Test
	public void testSave() throws Exception
	{
		FriendShip friendShip = new FriendShip();
		friendShip.setId(3);
		friendShip.setUserID1(1);
		friendShip.setUserID2(2);
		friendShip.setCreatedDate(new Date(2015,01,01));
		dao.save(friendShip);
		assertEquals(friendShip, dao.find(3));
	}

	@Test
	public void testFind() throws Exception
	{
		FriendShip friendShip = dao.find(1);
		assertEquals(1, friendShip.getId());
		assertEquals(1, friendShip.getUserID1());
	}

	@Test
	public void testFindAll() throws Exception
	{
		assertEquals(2, dao.findAll().size());
	}

	@Test
	public void testRemove() throws Exception
	{
		dao.remove(1);
		assertNull(null, dao.find(1));
	}
}
