package org.sckf.editor.spectators;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.sckf.editor.globals.GlobalVariables;

public class RequireSaveMain implements DocumentListener
{
	private JFrame jfMainWindow;
	private JTextArea jtaPrimaryPassword;
	private JCheckBox jcbRandomize;
	
	public RequireSaveMain(JFrame jfMainWindow, JTextArea jtaPrimaryPassword,
			JCheckBox jcbRandomize)
	{
		this.jcbRandomize = jcbRandomize;
		this.jfMainWindow = jfMainWindow;
		this.jtaPrimaryPassword = jtaPrimaryPassword;
	}
	
	private String getSourceMD5()
	{
		short sSize = (short)this.jtaPrimaryPassword.getText().length();
		byte bSingle[] = new byte[1];
		byte bLength[] = new byte[2];
		byte bPrimaryKey[] = new byte[sSize];
		byte bSecondaryKey[] = new byte[sSize * 2];
		
		String Hash = null;
		
		if(sSize > 0)
		{
			if(this.jcbRandomize.isSelected())
			{
				short sRandomBytes[] = GlobalVariables.getOffsets();
				
				if(sRandomBytes != null)
				{
					bSingle[0] = 0;
					bLength[0] = (byte)(sSize & 0xFF);
					bLength[1] = (byte)((sSize >> 8) & 0xFF);
					bPrimaryKey = this.jtaPrimaryPassword.getText().getBytes();
					
					int nIndex = 0;
					
					for(int x=0;x<sSize;x++)
					{
						bSecondaryKey[nIndex] = (byte)(sRandomBytes[x] & 0xFF);
						bSecondaryKey[nIndex + 1] = (byte)(((sRandomBytes[x]) >> 8) & 0xFF);
						nIndex += 2;
					}
					
					byte Buffer[] = new byte[3 + bPrimaryKey.length + bSecondaryKey.length];
					
					System.arraycopy(bSingle, 0, Buffer, 0, 1);
					System.arraycopy(bLength, 0, Buffer, 1, 2);
					System.arraycopy(bPrimaryKey, 0, Buffer, 3, bPrimaryKey.length);
					System.arraycopy(bSecondaryKey, 0, Buffer, (3 + bPrimaryKey.length), bSecondaryKey.length);
					
					try
					{
						MessageDigest md = MessageDigest.getInstance("MD5");
						md.update(Buffer);
						
						StringBuilder sbHash = new StringBuilder();
						
						for(byte bByte :Buffer)
						{
							sbHash.append(String.format("%02x", bByte));
						}
						
						Hash = sbHash.toString();
						Hash = Hash.toUpperCase();
					}
					catch(NoSuchAlgorithmException NSA)
					{
						NSA.printStackTrace();
					}
				}
			}
			else
			{	
				bSingle[0] = 1;
				bLength[0] = (byte)(sSize & 0xFF);
				bLength[1] = (byte)((sSize >> 8) & 0xFF);
				bPrimaryKey = this.jtaPrimaryPassword.getText().getBytes();
				
				byte Buffer[] = new byte[3 + bPrimaryKey.length];
				
				System.arraycopy(bSingle, 0, Buffer, 0, 1);
				System.arraycopy(bLength, 0, Buffer, 1, 2);
				System.arraycopy(bPrimaryKey, 0, Buffer, 3, bPrimaryKey.length);
				
				try
				{
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(Buffer);
					byte bHash[] = md.digest();
					
					StringBuilder sbHash = new StringBuilder();
					
					for(byte bByte :bHash)
					{
						sbHash.append(String.format("%02x", bByte));
					}
					
					Hash = sbHash.toString();
					Hash = Hash.toUpperCase();
				}
				catch(NoSuchAlgorithmException NSA)
				{
					NSA.printStackTrace();
					JOptionPane.showMessageDialog(null, "Can't create MD5 hash!", "MD5 Error", JOptionPane.ERROR_MESSAGE);
					System.exit(-11);
				}
			}
		}
		
		return Hash;
	}
	
	private String getDestMD5()
	{
		String sDestFile = GlobalVariables.getCurrentFile();
		String Hash = null;

		if(sDestFile != null)
		{
			File fDestFile = new File(sDestFile);
			
			if(fDestFile.exists() && fDestFile.isFile())
			{
				try
				{
					byte Buffer[] = new byte[(int)fDestFile.length()];
					RandomAccessFile rafDestFile = new RandomAccessFile(fDestFile, "r");
					
					rafDestFile.read(Buffer, 0, (int)fDestFile.length());
					
					try
					{
						MessageDigest md5 = MessageDigest.getInstance("MD5");
						md5.update(Buffer);
						byte bHash[] = md5.digest();
						
						StringBuilder sbHash = new StringBuilder();
						
						for(byte Byte :bHash)
						{
							sbHash.append(String.format("%02x", Byte));
						}
						
						Hash = sbHash.toString();
						Hash = Hash.toUpperCase();
					}
					catch(NoSuchAlgorithmException NSA)
					{
						NSA.printStackTrace();
						JOptionPane.showMessageDialog(null, "Can't create MD5 hash.",
								"MD5 hash", JOptionPane.ERROR_MESSAGE);
						System.exit(-12);
					}
					
					rafDestFile.close();
				}
				catch(IOException IO)
				{
					IO.printStackTrace();
					JOptionPane.showMessageDialog(null, "IO error.", "Error", JOptionPane.ERROR_MESSAGE);
					System.exit(-14);
				}
			}
		}
		
		return Hash;
	}
	
	private void check(DocumentEvent de)
	{
		DocumentEvent.EventType et = de.getType();
		
		if(et.equals(DocumentEvent.EventType.CHANGE))
		{
			String sSource = this.getSourceMD5();
			String sDest = this.getDestMD5();
			
			if(sSource != sDest)
			{
				char cHasStar = this.jfMainWindow.getTitle().charAt(this.jfMainWindow.getTitle().length() - 1);
				
				if(cHasStar != '*')
				{
					this.jfMainWindow.setTitle(this.jfMainWindow.getTitle() + "*");
				}
				
				GlobalVariables.setRequireSave(true);
			}
			else
			{
				char cHasStar = this.jfMainWindow.getTitle().charAt(this.jfMainWindow.getTitle().length() - 1);
				
				if(cHasStar == '*')
				{
					this.jfMainWindow.setTitle(this.jfMainWindow.getTitle().substring(0, this.jfMainWindow.getTitle().length() - 1));
				}
				GlobalVariables.setRequireSave(false);
			}
		}
		else if(et.equals(DocumentEvent.EventType.INSERT))
		{
			String sSource = this.getSourceMD5();
			String sDest = this.getDestMD5();
			
			if(sSource != sDest)
			{
				char cHasStar = this.jfMainWindow.getTitle().charAt(this.jfMainWindow.getTitle().length() - 1);
				
				if(cHasStar != '*')
				{
					this.jfMainWindow.setTitle(this.jfMainWindow.getTitle() + "*");
				}
				
				GlobalVariables.setRequireSave(true);
			}
			else
			{
				char cHasStar = this.jfMainWindow.getTitle().charAt(this.jfMainWindow.getTitle().length() - 1);
				
				if(cHasStar == '*')
				{
					this.jfMainWindow.setTitle(this.jfMainWindow.getTitle().substring(0, this.jfMainWindow.getTitle().length() - 1));
				}
				
				GlobalVariables.setRequireSave(false);
			}
		}
		else if(et.equals(DocumentEvent.EventType.REMOVE))
		{
			String sSource = this.getSourceMD5();
			String sDest = this.getDestMD5();
			
			if(sSource != sDest)
			{
				char cHasStar = this.jfMainWindow.getTitle().charAt(this.jfMainWindow.getTitle().length() - 1);
				
				if(cHasStar != '*')
				{
					this.jfMainWindow.setTitle(this.jfMainWindow.getTitle() + "*");
				}
				
				GlobalVariables.setRequireSave(true);
			}
			else
			{
				char cHasStar = this.jfMainWindow.getTitle().charAt(this.jfMainWindow.getTitle().length() - 1);
				
				if(cHasStar == '*')
				{
					this.jfMainWindow.setTitle(this.jfMainWindow.getTitle().substring(0, this.jfMainWindow.getTitle().length() - 1));
				}
				
				GlobalVariables.setRequireSave(false);
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