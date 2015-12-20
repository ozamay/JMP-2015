package com.epam.olukash.module4.runner;

import java.awt.*;
import javax.swing.*;

/**
 * @author Oleksii_Lukash
 * @date 12/20/2015
 */
public class HighlightButton extends AbstractButton
{
	protected HighlightButton(String title)
	{
		super(title);
	}

	public void addHover(final Color colorHover)
	{
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				setBackground(colorHover);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				setBackground(UIManager.getColor("control"));
			}
		});
	}
}
