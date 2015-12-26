package com.epam.olukash.module4.decorator.v2.frame;

import java.awt.*;

import javax.swing.*;

import com.epam.olukash.module4.decorator.v2.panel.AbstractPanel;
import com.epam.olukash.module4.decorator.v2.panel.AdminPanel;
import com.epam.olukash.module4.decorator.v2.panel.SimplePanel;

/**
 * @author Oleksii_Lukash
 * @date 12/21/2015
 */
public class MainFrame extends JFrame
{
	public MainFrame()
	{
		setDefaultValue();
		addPanels();
	}

	private void setDefaultValue()
	{
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(400, 400);
	}

	private void addPanels()
	{
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));

		AbstractPanel panel = new SimplePanel();
		panel.add(new JButton("simple panel"));
		panel.add(new JButton("simple panel"));

		AbstractPanel adminPanel = new AdminPanel(panel);
		adminPanel.add(new JButton("admin panel"));
		adminPanel.add(new JButton("admin panel"));

		contentPane.add(panel);
		setContentPane(contentPane);
		pack();
		setLocationRelativeTo(null);
	}
}
