package com.epam.olukash.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Book;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class BookDAO extends AbstractDAO<Book>
{
	protected Class<? extends AbstractBean> getClazz()
	{
		return Book.class;
	}

	public Book findByBookNumber(String bookNumber)
	{
		Criteria criteria = getSession().createCriteria(getClazz());
		criteria.add(Restrictions.eq("bookNumber", bookNumber));
		return (Book) criteria.uniqueResult();
	}
}
