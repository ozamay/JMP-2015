package com.epam.olukash.module4.decorator.v2.runner;

import javax.swing.*;

import com.epam.olukash.module4.decorator.v2.panel.AdminPanel;
import com.epam.olukash.module4.decorator.v2.panel.SimplePanel;

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
