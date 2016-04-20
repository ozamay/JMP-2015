package com.epam.olukash.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Client;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class ClientDAO  extends AbstractDAO<Client>
{
	private static final String SQL_INSERT = "INSERT INTO CLIENT (name, surName) VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE CLIENT SET name = ?, surName = ? WHERE clientID = ?";
	private static final String SQL_FIND_BY_ID = "SELECT clientID, name, surName FROM CLIENT WHERE clientID = ?";
	private static final String SQL_FIND_ALL = "SELECT clientID, name, surName FROM CLIENT";
	private static final String SQL_REMOVE = "REMOVE FROM CLIENT WHERE clientID = ?";

	@Override
	protected String getInsertSQL()
	{
		return SQL_INSERT;
	}

	@Override
	protected String getUpdateSQL()
	{
		return SQL_UPDATE;
	}

	@Override
	protected String getRemoveSQL()
	{
		return SQL_REMOVE;
	}

	@Override
	protected String getFindSQL()
	{
		return SQL_FIND_BY_ID;
	}

	@Override
	protected String getFindAllSQL()
	{
		return SQL_FIND_ALL;
	}

	@Override
	protected void populateStatement(Client bean, PreparedStatement ps) throws SQLException
	{
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getSurName());
	}

	@Override
	protected Object[] getUpdateParam(Client bean)
	{
		return new Object[]{bean.getName(), bean.getSurName(), bean.getClientID()};
	}

	@Override
	protected List<Client> createsBeans(List<Map<String, Object>> rows)
	{
		List<Client> clientList = new ArrayList<>();
		for(Map<String,Object> row : rows){
			Client client = new Client();
			client.setClientID(Long.parseLong(String.valueOf(row.get("clientID"))));
			client.setName(String.valueOf(row.get("name")));
			client.setSurName(String.valueOf(row.get("surName")));
			clientList.add(client);
		}
		return clientList;
	}

	protected Class<? extends AbstractBean> getClazz()
	{
		return Client.class;
	}
}
