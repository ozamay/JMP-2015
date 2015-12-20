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
				GUICreator creator = new GUICreator(200, 200);
				creator.addButton(new JButton("Standard"));
				HighlightButton hb = new HighlightButton("Highlighted");
				hb.addHover(Color.lightGray);
				creator.addButton(hb);
			}
		};
		SwingUtilities.invokeLater(doCreateAndShowGUI);
	}

}
