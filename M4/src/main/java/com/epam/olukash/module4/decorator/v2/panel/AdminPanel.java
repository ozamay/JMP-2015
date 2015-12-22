package com.epam.olukash.module4.decorator.v2.panel;

import java.awt.*;
import javax.swing.*;

/**
 * @author Oleksii_Lukash
 * @date 12/21/2015
 */
public class AdminPanel extends PanelDecorator
{
	public AdminPanel(AbstractPanel panel)
	{
		super(panel);
	}

	public Component add(final Component component)
	{
		super.add(component);

		if(component instanceof JButton)
		{
			component.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					component.setBackground(Color.GRAY);
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					component.setBackground(UIManager.getColor("control"));
				}
			});
		}

		return component;
	}
}
