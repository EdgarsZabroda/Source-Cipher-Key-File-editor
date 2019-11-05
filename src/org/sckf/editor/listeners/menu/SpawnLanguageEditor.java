package org.sckf.editor.listeners.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.sckf.editor.dialogs.LanguageEditor;

public class SpawnLanguageEditor implements ActionListener
{
	private JFrame jfParent;
	
	public SpawnLanguageEditor(JFrame jfParent)
	{
		this.jfParent = jfParent;
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		LanguageEditor le = new LanguageEditor(this.jfParent, true);
	}
}