package com.epam.olukash.dao.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class InitialDataLoader
{
	private static final Logger logger = Logger.getLogger(InitialDataLoader.class);

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public void setUpInitialData()
	{
		try{
			BufferedReader bufferedReader = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("initialData.sql").getFile()));
			String query;
			while((query = bufferedReader.readLine()) !=null){
				jdbcTemplate.execute(query);
			}
		}
		catch (FileNotFoundException e){
			logger.error("File not found"  + e.getMessage());
		}
		catch (IOException e){
			logger.error("Smth went wrong found" + e.getMessage());
		}
	}
}
