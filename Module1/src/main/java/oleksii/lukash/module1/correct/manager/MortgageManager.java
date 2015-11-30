package oleksii.lukash.module1.correct.manager;

import java.util.List;

import oleksii.lukash.module1.correct.bean.Mortgage;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public interface MortgageManager extends AbstractManager<Mortgage>
{
	List<Mortgage> getBadGuys();
}
