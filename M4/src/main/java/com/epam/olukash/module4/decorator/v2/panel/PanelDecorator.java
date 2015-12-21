package com.epam.olukash.module4.decorator.v2.panel;

import java.awt.*;
import javax.swing.*;

/**
 * @author Oleksii_Lukash
 * @date 12/21/2015
 */
public class PanelDecorator extends JFrame
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
