package com.epam.olukash.module4.decorator.v2.panel;

import java.awt.*;

/**
 * @author Oleksii_Lukash
 * @date 12/21/2015
 */
public class PanelDecorator extends AbstractPanel
{
	protected final AbstractPanel panel;

	public PanelDecorator(AbstractPanel jpanel)
	{
		this.panel = jpanel;
	}

	public Component add(Component component){
		return panel.add(component);
	}
}
