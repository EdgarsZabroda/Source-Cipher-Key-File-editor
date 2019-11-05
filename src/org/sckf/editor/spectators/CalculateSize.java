package org.sckf.editor.spectators;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CalculateSize implements DocumentListener
{
	private JTextArea jtaPrimaryPassword;
	private JTextField jtfLength;
	
	public CalculateSize(JTextArea jtaPrimaryPassword,
			JTextField jtfLength)
	{
		this.jtaPrimaryPassword = jtaPrimaryPassword;
		this.jtfLength = jtfLength;
	}
	
	private void check(DocumentEvent de)
	{
		DocumentEvent.EventType et = de.getType();
		
		if(et.equals(DocumentEvent.EventType.CHANGE))
		{
			this.jtfLength.setText(String.valueOf(this.jtaPrimaryPassword.getText().length()));
		}
		else if(et.equals(DocumentEvent.EventType.INSERT))
		{
			this.jtfLength.setText(String.valueOf(this.jtaPrimaryPassword.getText().length()));
		}
		else if(et.equals(DocumentEvent.EventType.REMOVE))
		{
			this.jtfLength.setText(String.valueOf(this.jtaPrimaryPassword.getText().length()));
		}
	}
	
	@Override
	public void changedUpdate(DocumentEvent de)
	{
		this.check(de);
	}
	
	@Override
	public void insertUpdate(DocumentEvent de)
	{
		this.check(de);
	}
	
	@Override
	public void removeUpdate(DocumentEvent de)
	{
		this.check(de);
	}
}