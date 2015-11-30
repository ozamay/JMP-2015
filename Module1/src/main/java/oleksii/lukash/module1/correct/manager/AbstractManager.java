package oleksii.lukash.module1.correct.manager;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public interface  AbstractManager <T>
{
	T save(T bean);
	T update(T bean);
	T get(long id);
	void remove(T bean);
}
