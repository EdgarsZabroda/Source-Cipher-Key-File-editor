package org.sckf.editor.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import org.sckf.editor.globals.GlobalVariables;

public class CheckListener implements ActionListener
{
	private JCheckBox jcbRandomize;
	private JTextArea jtaSecondaryPassword;
	private JTextArea jtaPrimaryPassword;
	
	public CheckListener(JCheckBox jcbRandomize,
			JTextArea jtaSecondaryPassword,
			JTextArea jtaPrimaryPassword)
	{
		this.jcbRandomize = jcbRandomize;
		this.jtaPrimaryPassword = jtaPrimaryPassword;
		this.jtaSecondaryPassword = jtaSecondaryPassword;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(this.jcbRandomize.isSelected())
		{
			byte bBuffer[] = this.jtaPrimaryPassword.getText().getBytes();
			byte bSecondaryPassword[] = new byte[bBuffer.length];
			short sOffsets[] = GlobalVariables.getOffsets();
			
			for(int x=0;x<bBuffer.length;x++)
			{
				bSecondaryPassword[x] = bBuffer[sOffsets[x]];
			}
			
			this.jtaSecondaryPassword.setText(new String(bSecondaryPassword));
		}
		else
		{
			this.jtaSecondaryPassword.setText(null);
		}
	}
}