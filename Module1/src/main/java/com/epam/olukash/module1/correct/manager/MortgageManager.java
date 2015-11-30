package com.epam.olukash.module1.correct.manager;

import java.util.List;

import com.epam.olukash.module1.correct.bean.Mortgage;

/**
 * @author Oleksii_Lukash
 * @date 11/28/2015
 */
public interface MortgageManager extends AbstractManager<Mortgage>
{
	List<Mortgage> getBadGuys();
}
