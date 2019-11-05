package org.sckf.editor.listeners.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.sckf.editor.dialogs.AboutDialog;

public class SpawnAbout implements ActionListener
{
	private JFrame jfParent;
	
	public SpawnAbout(JFrame jfParent)
	{
		this.jfParent = jfParent;
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		AboutDialog ad = new AboutDialog(this.jfParent, true);
	}
}