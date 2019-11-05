package org.sckf.editor.spectators;

import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.sckf.editor.globals.GlobalVariables;

public class ShuffleIfEnabled implements DocumentListener
{
	private JTextArea jtaPrimaryPassword;
	private JTextArea jtaSecondaryPassword;
	private JCheckBox jcbRandomize;
	
	public ShuffleIfEnabled(JTextArea jtaPrimaryPassword,
			JTextArea jtaSecondaryPassword,
			JCheckBox jcbRandomize)
	{
		this.jcbRandomize = jcbRandomize;
		this.jtaPrimaryPassword = jtaPrimaryPassword;
		this.jtaSecondaryPassword = jtaSecondaryPassword;
	}
	
	private void check(DocumentEvent de)
	{
		DocumentEvent.EventType et = de.getType();
		
		if(et.equals(DocumentEvent.EventType.CHANGE))
		{
			if(this.jcbRandomize.isSelected())
			{
				short sLength = (short)this.jtaPrimaryPassword.getText().length();
				byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
				byte bSecondaryPassword[] = new byte[sLength];
				short sOffsets[] = new short[sLength];
				short sCheck[] = new short[sLength];
				short sCurrent = 0;
				Random rand = new Random();
				
				while(sCurrent < sLength)
				{
					short sRandom = (short)rand.nextInt(sLength);
					
					if(sCheck[sRandom] != 1)
					{
						sOffsets[sCurrent] = sRandom;
						sCheck[sRandom] = 1;
						sCurrent++;
					}
				}
				
				GlobalVariables.setOffsets(sOffsets);
				
				for(int x=0;x<sLength;x++)
				{
					bSecondaryPassword[x] = bPrimaryPassword[sOffsets[x]];
				}
				
				this.jtaSecondaryPassword.setText(new String(bSecondaryPassword));
			}
			else
			{
				short sLength = (short)this.jtaPrimaryPassword.getText().length();
				short sOffsets[] = new short[sLength];
				short sCheck[] = new short[sLength];
				short sCurrent = 0;
				Random rand = new Random();
				
				while(sCurrent < sLength)
				{
					short sRandom = (short)rand.nextInt(sLength);
					
					if(sCheck[sRandom] != 1)
					{
						sOffsets[sCurrent] = sRandom;
						sCheck[sRandom] = 1;
						sCurrent++;
					}
				}
				
				GlobalVariables.setOffsets(sOffsets);
				
				this.jtaSecondaryPassword.setText(null);
			}
		}
		else if(et.equals(DocumentEvent.EventType.INSERT))
		{
			if(this.jcbRandomize.isSelected())
			{
				short sLength = (short)this.jtaPrimaryPassword.getText().length();
				byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
				byte bSecondaryPassword[] = new byte[sLength];
				short sOffsets[] = new short[sLength];
				short sCheck[] = new short[sLength];
				short sCurrent = 0;
				Random rand = new Random();
				
				while(sCurrent < sLength)
				{
					short sRandom = (short)rand.nextInt(sLength);
					
					if(sCheck[sRandom] != 1)
					{
						sOffsets[sCurrent] = sRandom;
						sCheck[sRandom] = 1;
						sCurrent++;
					}
				}
				
				GlobalVariables.setOffsets(sOffsets);
				
				for(int x=0;x<sLength;x++)
				{
					bSecondaryPassword[x] = bPrimaryPassword[sOffsets[x]];
				}
				
				this.jtaSecondaryPassword.setText(new String(bSecondaryPassword));
			}
			else
			{
				short sLength = (short)this.jtaPrimaryPassword.getText().length();
				short sOffsets[] = new short[sLength];
				short sCheck[] = new short[sLength];
				short sCurrent = 0;
				Random rand = new Random();
				
				while(sCurrent < sLength)
				{
					short sRandom = (short)rand.nextInt(sLength);
					
					if(sCheck[sRandom] != 1)
					{
						sOffsets[sCurrent] = sRandom;
						sCheck[sRandom] = 1;
						sCurrent++;
					}
				}
				
				GlobalVariables.setOffsets(sOffsets);
				
				this.jtaSecondaryPassword.setText(null);
			}
		}
		else if(et.equals(DocumentEvent.EventType.REMOVE))
		{
			if(this.jcbRandomize.isSelected())
			{
				short sLength = (short)this.jtaPrimaryPassword.getText().length();
				byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
				byte bSecondaryPassword[] = new byte[sLength];
				short sOffsets[] = new short[sLength];
				short sCheck[] = new short[sLength];
				short sCurrent = 0;
				Random rand = new Random();
				
				while(sCurrent < sLength)
				{
					short sRandom = (short)rand.nextInt(sLength);
					
					if(sCheck[sRandom] != 1)
					{
						sOffsets[sCurrent] = sRandom;
						sCheck[sRandom] = 1;
						sCurrent++;
					}
				}
				
				GlobalVariables.setOffsets(sOffsets);
				
				for(int x=0;x<sLength;x++)
				{
					bSecondaryPassword[x] = bPrimaryPassword[sOffsets[x]];
				}
				
				this.jtaSecondaryPassword.setText(new String(bSecondaryPassword));
			}
			else
			{
				short sLength = (short)this.jtaPrimaryPassword.getText().length();
				short sOffsets[] = new short[sLength];
				short sCheck[] = new short[sLength];
				short sCurrent = 0;
				Random rand = new Random();
				
				while(sCurrent < sLength)
				{
					short sRandom = (short)rand.nextInt(sLength);
					
					if(sCheck[sRandom] != 1)
					{
						sOffsets[sCurrent] = sRandom;
						sCheck[sRandom] = 1;
						sCurrent++;
					}
				}
				
				GlobalVariables.setOffsets(sOffsets);
				
				this.jtaSecondaryPassword.setText(null);
			}
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