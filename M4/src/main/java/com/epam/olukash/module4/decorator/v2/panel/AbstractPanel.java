package com.epam.olukash.module4.decorator.v2.panel;

import javax.swing.*;

/**
 * @author Oleksii_Lukash
 * @date 12/21/2015
 */
public abstract class AbstractPanel extends JPanel
{
	public AbstractPanel()
	{
		setDefaultValue();
	}

	private void setDefaultValue()
	{
		setVisible(true);
		setSize(200, 200);
	}
}
