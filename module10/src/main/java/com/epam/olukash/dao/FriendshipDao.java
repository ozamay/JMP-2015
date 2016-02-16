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
	protected PreparedStatement getSaveStatement(Connection conn, FriendShip bean) throws SQLException
	{
		PreparedStatement state = conn.prepareStatement(SQL_CREATE_FRIENDSHIP);
		populateStatement(state, bean);
		return  state;
	}

	@Override
	protected PreparedStatement getSaveStatementWithBatch(Connection conn, List<FriendShip> beans) throws SQLException
	{
		PreparedStatement state = conn.prepareStatement(SQL_CREATE_FRIENDSHIP);

		for(FriendShip friendShip : beans)
		{
			populateStatement(state, friendShip);
			state.addBatch();
		}

		return state;
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
