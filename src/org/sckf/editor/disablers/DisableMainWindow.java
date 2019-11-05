package org.sckf.editor.disablers;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DisableMainWindow implements DocumentListener
{
	private JMenuItem jmiSave;
	private JMenuItem jmiSaveAs;
	private JTextArea jtaPrimaryPassword;
	
	public DisableMainWindow(JMenuItem jmiSave,
			JMenuItem jmiSaveAs, JTextArea jtaPrimaryPassword)
	{
		this.jmiSave = jmiSave;
		this.jmiSaveAs = jmiSaveAs;
		this.jtaPrimaryPassword = jtaPrimaryPassword;
	}
	
	private void checkPrimaryPassword(DocumentEvent DE)
	{
		DocumentEvent.EventType eventType = DE.getType();
		
		if(eventType.equals(DocumentEvent.EventType.CHANGE))
		{
			if(!this.jtaPrimaryPassword.getText().isEmpty())
			{
				 this.jmiSave.setEnabled(true);
				 this.jmiSaveAs.setEnabled(true);
			}
			else
			{
				this.jmiSave.setEnabled(false);
				this.jmiSaveAs.setEnabled(false);
			}
		}
		else if(eventType.equals(DocumentEvent.EventType.INSERT))
		{
			if(!this.jtaPrimaryPassword.getText().isEmpty())
			{
				 this.jmiSave.setEnabled(true);
				 this.jmiSaveAs.setEnabled(true);
			}
			else
			{
				this.jmiSave.setEnabled(false);
				this.jmiSaveAs.setEnabled(false);
			}
		}
		else if(eventType.equals(DocumentEvent.EventType.REMOVE))
		{
			if(!this.jtaPrimaryPassword.getText().isEmpty())
			{
				 this.jmiSave.setEnabled(true);
				 this.jmiSaveAs.setEnabled(true);
			}
			else
			{
				this.jmiSave.setEnabled(false);
				this.jmiSaveAs.setEnabled(false);
			}
		}
	}
	
	@Override
	public void changedUpdate(DocumentEvent DE)
	{
		this.checkPrimaryPassword(DE);
	}
	
	@Override
	public void insertUpdate(DocumentEvent DE)
	{
		this.checkPrimaryPassword(DE);
	}
	
	@Override
	public void removeUpdate(DocumentEvent DE)
	{
		this.checkPrimaryPassword(DE);
	}
}