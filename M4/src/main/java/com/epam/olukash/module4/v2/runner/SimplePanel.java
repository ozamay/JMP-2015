package com.epam.olukash.module4.v2.runner;

import java.awt.*;

import javax.swing.*;

/**
 * @author Oleksii_Lukash
 * @date 12/21/2015
 */
public class SimplePanel extends JFrame
{
	public SimplePanel()
	{
		super();
		setDefaultValue();
	}

	private void setDefaultValue()
	{
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(200, 200);
	}
}
