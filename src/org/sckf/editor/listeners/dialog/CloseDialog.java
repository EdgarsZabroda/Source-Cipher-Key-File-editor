package org.sckf.editor.listeners.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class CloseDialog implements ActionListener
{
	private JDialog jdDlg;
	
	public CloseDialog(JDialog jdDlg)
	{
		this.jdDlg = jdDlg;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		this.jdDlg.dispose();
	}
}