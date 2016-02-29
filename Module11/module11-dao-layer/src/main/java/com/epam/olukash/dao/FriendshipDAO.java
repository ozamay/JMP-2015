package com.epam.olukash.dao;

import static com.epam.olukash.dao.util.SQLConstants.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.FriendShip;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class FriendshipDAO extends AbstractDAO<FriendShip>
{
	@Override
	protected String getSaveSql()
	{
		return SQL_CREATE_FRIENDSHIP;
	}

	@Override
	protected String getFindSql()
	{
		return SQL_SELECT_FRIENDSHIP;
	}

	@Override
	protected String getFindAllSql()
	{
		return SQL_GET_ALl_FRIENDSHIPS;
	}

	@Override
	protected String getRemoveSql()
	{
		return SQL_REMOVE_FRIENDSHIP;
	}

	@Override
	protected void populateStatement(PreparedStatement state, FriendShip bean) throws SQLException
	{
		state.setInt(1, bean.getId());
		state.setInt(2, bean.getUserID1());
		state.setInt(3, bean.getUserID2());
		state.setDate(4, new Date(bean.getCreatedDate().getTime()));
	}

	@Override
	protected FriendShip populateBean(ResultSet rs) throws SQLException
	{
		FriendShip friendShip = new FriendShip();
		friendShip.setId(rs.getInt(1));
		friendShip.setUserID1(rs.getInt(2));
		friendShip.setUserID2(rs.getInt(3));
		friendShip.setCreatedDate(rs.getDate(4));
		return friendShip;
	}
}

