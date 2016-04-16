package com.epam.olukash.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.epam.olukash.dto.AbstractBean;

/**
 * @author Oleksii.Lukash
 */
public abstract class AbstractDAO<T>
{
	private static final Logger logger = Logger.getLogger(AbstractDAO.class);

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public long save(T bean)
	{
		try
		{
			PreparedStatementCreator psc = connection -> {
				PreparedStatement ps = connection.prepareStatement(getInsertSQL(), Statement.RETURN_GENERATED_KEYS);
				populateStatement(bean, ps);
				return ps;
			};

			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(psc, holder);
			return holder.getKey().longValue();

		}
		catch (Exception e)
		{
			logger.error("Error saving bean of type " + getClazz());
			throw new DAOException("Error saving bean of type " + getClazz(), e);
		}
	}

	public T find(long beanID)
	{
		try
		{
			BeanPropertyRowMapper bprm = new BeanPropertyRowMapper<>(getClazz());
			bprm.setPrimitivesDefaultedForNullValue(true);
			return (T) jdbcTemplate.queryForObject(getFindSQL(), new Object[]{beanID}, bprm);
		}
		catch (Exception e)
		{
			logger.error("Error finding bean of type " + getClazz());
			throw new DAOException("Error finding bean of type " + getClazz(), e);
		}
	}

	public void update(T bean)
	{
		try
		{
			jdbcTemplate.update(getUpdateSQL(), getUpdateParam(bean));
		}
		catch (Exception e)
		{
			logger.error("Error updating bean of type " + getClazz());
			throw new DAOException("Error updating bean of type " +  getClazz(), e);
		}
	}

	public long delete(long beanID)
	{
		try
		{
			return jdbcTemplate.update(getRemoveSQL(), new Object[]{beanID});
		}
		catch (Exception e)
		{
			logger.error("Error removing bean of type " + getClazz());
			throw new DAOException("Error removing bean of type " + getClazz(), e);
		}
	}

	public List<T> findAll()
	{
		try
		{
			return createsBeans(jdbcTemplate.queryForList(getFindAllSQL()));
		}
		catch (Exception e)
		{
			logger.error("Error getting all beans of type " + getClazz());
			throw new DAOException("Error getting all beans of type " + getClazz(), e);
		}
	}

	protected abstract String getInsertSQL();
	protected abstract String getUpdateSQL();
	protected abstract String getRemoveSQL();
	protected abstract String getFindSQL();
	protected abstract String getFindAllSQL();
	protected abstract void populateStatement(T bean, PreparedStatement ps) throws SQLException;
	protected abstract Object[] getUpdateParam(T bean);
	protected abstract List<T> createsBeans(List<Map<String, Object>> rows);
	protected abstract Class<? extends AbstractBean> getClazz();
}
