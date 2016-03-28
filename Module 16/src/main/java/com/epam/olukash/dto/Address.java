package com.epam.olukash.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Oleksii.Lukash
 */

@Embeddable
public class Address extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	@Column(name="street")
	private String street;

	@Column(name = "city", nullable=false)
	private String city;

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Address address = (Address) o;

		if (street != null ? !street.equals(address.street) : address.street != null)
			return false;
		return city != null ? city.equals(address.city) : address.city == null;

	}

	@Override
	public String toString()
	{
		return "Address{" +
				"street='" + street + '\'' +
				", city='" + city + '\'' +
				'}';
	}

	@Override
	public int hashCode()
	{
		int result = street != null ? street.hashCode() : 0;
		result = 31 * result + (city != null ? city.hashCode() : 0);
		return result;
	}
}
