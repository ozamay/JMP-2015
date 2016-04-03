package com.epam.olukash.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Oleksii.Lukash
 */
@Entity
@Table(name = "Client")
public class Client extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "client_seq", sequenceName = "client_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "client_seq")
	private long id;

	@Column
	@Size(min=1, max=25, message="Name is require")
	private String name;

	@Column
	@Size(min=1, max=25, message="Name is require")
	private String surName;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
	private Book book;

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public String getSurName()
	{
		return surName;
	}

	public void setSurName(String surName)
	{
		this.surName = surName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

}
