package com.epam.olukash.module4.v2.runner;

import java.awt.*;

import javax.swing.*;

/**
 * @author Oleksii_Lukash
 * @date 12/21/2015
 */
public abstract class PanelDecorator extends JFrame
{
	protected final JFrame frame;

	public PanelDecorator(JFrame jFrame)
	{
		this.frame = jFrame;
	}

	public Component add(Component component){
		return frame.add(component);
	}
}
