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

import com.epam.olukash.dao.LikeDAO;
import com.epam.olukash.dto.Like;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author Oleksii_Lukash
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-beans.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class})
public class LikeDAOTest
{
	@Autowired
	private LikeDAO likeDAO;

	@Test
	@DatabaseSetup("classpath:likeSampleData.xml")
	public void testSave() throws Exception
	{
		Like like = new Like();
		like.setId(3);
		like.setUserID(1);
		like.setPostID(1);
		like.setCreateDate(new Date(2015,01,01));
		likeDAO.save(like);
		assertEquals(like, likeDAO.find(3));
	}

	@Test
	@DatabaseSetup("classpath:likeSampleData.xml")
	public void testFind() throws Exception
	{
		Like like = likeDAO.find(1);
		assertEquals(1, like.getUserID());
		assertEquals(1, like.getPostID());
	}

	@Test
	@DatabaseSetup("classpath:likeSampleData.xml")
	public void testFindAll() throws Exception
	{
		assertEquals(2, likeDAO.findAll().size());
	}

	@Test
	@DatabaseSetup("classpath:likeSampleData.xml")
	public void testRemove() throws Exception
	{
		likeDAO.remove(1);
		assertNull(null, likeDAO.find(1));
	}
}
