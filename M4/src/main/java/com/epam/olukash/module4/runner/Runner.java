package com.epam.olukash.module4.runner;

import java.awt.*;
import javax.swing.*;

/**
 * @author Oleksii_Lukash
 * @date 12/20/2015
 */
public class Runner
{
	public static void main(String args[])
	{
		Runnable doCreateAndShowGUI = new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		};
		SwingUtilities.invokeLater(doCreateAndShowGUI);
	}

	private static void createAndShowGUI() {
		JFrame f = new JFrame();
		f.getContentPane().setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200, 200);
		f.add(new JButton("Standard"));
		HighlightButton hb = new HighlightButton("Highlighted");
		hb.addHover(Color.BLUE);
		f.add(hb);

		f.setVisible(true);
	}
}
