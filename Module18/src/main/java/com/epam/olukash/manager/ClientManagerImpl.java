package com.epam.olukash.manager;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.ClientDAO;
import com.epam.olukash.dto.Client;

/**
 * @author Oleksii.Lukash
 */
@Component
public class ClientManagerImpl extends AbstractManager<Client, ClientDAO> implements
		ClientManager
{
}
