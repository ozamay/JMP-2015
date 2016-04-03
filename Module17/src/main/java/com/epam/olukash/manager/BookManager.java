package com.epam.olukash.manager;

import com.epam.olukash.dto.Book;

/**
 * @author Oleksii.Lukash
 */
public interface BookManager extends BeanManager<Book>
{
	Book saveNew(Book book);
	Book findByBookNumber(String bookNumber);
}
