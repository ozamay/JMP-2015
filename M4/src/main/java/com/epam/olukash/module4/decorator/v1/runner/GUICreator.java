package com.epam.olukash.module4.decorator.v1.runner;

import java.awt.*;

import javax.swing.*;

/**
 * @author Oleksii_Lukash
 * @date 12/20/2015
 */
public class GUICreator
{
	private JFrame frame;

	public GUICreator(int wegih, int heigh)
	{
		frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(200, 200);
	}

	public void addButton(Component component)
	{
		frame.add(component);
	}
}
