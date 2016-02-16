package main.java.com.epam.olukash.dao;

import static main.java.com.epam.olukash.dao.util.SQLConstants.SQL_CREATE_FRIENDSHIP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import main.java.com.epam.olukash.dto.FriendShip;

/**
 * @author Oleksii.Lukash
 */
public class FriendshipDao extends AbstractDAO<FriendShip>
{

	@Override
	protected String getSaveSql()
	{
		return SQL_CREATE_FRIENDSHIP;
	}

	@Override
	protected void populateStatement(PreparedStatement state, FriendShip bean) throws SQLException
	{
		state.setInt(1, bean.getUserID1());
		state.setInt(2, bean.getUserID2());
		state.setDate(3, new Date(bean.getCreatedDate().getTime()));
	}

	@Override
	protected FriendShip populateBean(ResultSet rs) throws SQLException
	{
		return null;
	}
}
