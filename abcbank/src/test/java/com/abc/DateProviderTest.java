package com.abc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Oleksii_Lukash
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Calendar.class)
public class DateProviderTest
{
	@Test
	public void testGetInstance()
	{
		assertEquals(DateProvider.getInstance(), DateProvider.getInstance());
	}

	@Test
	@Ignore
	public void testNow()
	{
		Calendar calendar = Calendar.getInstance();

		PowerMockito.mockStatic(Calendar.class);
		when(Calendar.getInstance()).thenReturn(calendar);

		DateProvider.getInstance().now();

		PowerMockito.verifyStatic();
		Calendar.getInstance();
	}
}
