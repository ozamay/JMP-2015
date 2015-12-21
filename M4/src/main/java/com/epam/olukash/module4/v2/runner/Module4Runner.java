package com.epam.olukash.module4.v2.runner;

import javax.swing.*;

/**
 * @author Oleksii_Lukash
 * @date 12/21/2015
 */
public class Module4Runner
{
	public static void main(String[] args)
	{
		JFrame panel = new SimplePanel();
		panel.add(new JButton("simple panel"));

		JFrame admin = new AdminPanel(new SimplePanel());
		admin.add(new JButton("admin panel"));
	}
}
