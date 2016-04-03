package com.epam.olukash.dao;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Client;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class ClientDAO  extends AbstractDAO<Client>
{
	protected Class<? extends AbstractBean> getClazz()
	{
		return Client.class;
	}
}
