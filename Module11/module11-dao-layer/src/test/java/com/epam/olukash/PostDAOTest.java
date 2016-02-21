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

import com.epam.olukash.dao.PostDAO;
import com.epam.olukash.dto.Post;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author Oleksii.Lukash
 */
public class PostDAOTest
{
//	@Autowired
//	private PostDAO postDAO;
//
//	@Test
//	public void testSave() throws Exception
//	{
//		Post post = new Post();
//		post.setId(3);
//		post.setUserID(1);
//		post.setText("test3");
//		post.setCreatedDate(new Date(2015,01,01));
//		postDAO.save(post);
//		assertEquals(post, postDAO.find(3));
//	}
//
//	@Test
//	@DatabaseSetup("classpath:postSampleData.xml")
//	public void testFind() throws Exception
//	{
//		Post post = postDAO.find(1);
//		assertEquals(1, post.getId());
//		assertEquals(1, post.getUserID());
//	}
//
//	@Test
//	@DatabaseSetup("classpath:postSampleData.xml")
//	public void testFindAll() throws Exception
//	{
//		assertEquals(2, postDAO.findAll().size());
//	}
//
//	@Test
//	@DatabaseSetup("classpath:postSampleData.xml")
//	public void testRemove() throws Exception
//	{
//		postDAO.remove(1);
//		assertNull(null, postDAO.find(1));
//	}
}
