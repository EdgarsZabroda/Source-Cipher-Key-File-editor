package org.sckf.editor.listeners.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.sckf.editor.globals.GlobalVariables;

public class ItemNew implements ActionListener
{
	private JTextArea jtaPrimaryPassword;
	private JTextArea jtaSecondaryPassword;
	private JCheckBox jcbRandomize;
	private JTextField jtfLength;
	private JFrame jfMainWnd;
	private String sAskToSave;
	private String sAskToSaveTitle;
	private String sSave;
	
	public ItemNew(JTextArea jtaPrimaryPassword,
			JTextArea jtaSecondaryPassword,
			JCheckBox jcbRandomize, JTextField jtfLength,
			JFrame jfMainWnd, String sAskToSave,
			String sAskToSaveTitle, String sSave)
	{
		this.jcbRandomize = jcbRandomize;
		this.jfMainWnd = jfMainWnd;
		this.jtaPrimaryPassword = jtaPrimaryPassword;
		this.jtaSecondaryPassword = jtaSecondaryPassword;
		this.jtfLength = jtfLength;
		this.sAskToSave = sAskToSave;
		this.sAskToSaveTitle = sAskToSaveTitle;
		this.sSave = sSave;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(GlobalVariables.getRequireSave())
		{
			short sLength = Short.parseShort(this.jtfLength.getText());
			
			if(sLength > 0)
			{
				int nChs = JOptionPane.showConfirmDialog(this.jfMainWnd,
						this.sAskToSave, this.sAskToSaveTitle,
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(nChs == JOptionPane.YES_OPTION)
				{
					if(GlobalVariables.getCurrentFile() != null)
					{
						JFileChooser jfcSaveDialog = new JFileChooser(System.getProperty("user.dir"));
						FileNameExtensionFilter fnefFilter = new FileNameExtensionFilter("SCKF files (*.sckf)", "sckf");
						
						
						jfcSaveDialog.setAcceptAllFileFilterUsed(false);
						jfcSaveDialog.addChoosableFileFilter(fnefFilter);
						jfcSaveDialog.setDialogTitle(this.sSave);
						
						int nFCChs = jfcSaveDialog.showSaveDialog(this.jfMainWnd);
						
						if(nFCChs == JFileChooser.APPROVE_OPTION)
						{
							File fSaveFile = jfcSaveDialog.getSelectedFile();
							
							if(fSaveFile.exists())
							{
								fSaveFile.delete();
							}
							
							try
							{
								RandomAccessFile rafSaveFile = new RandomAccessFile(fSaveFile, "rw");
								byte bSingle[] = new byte[1];
								byte bLength[] = new byte[2];
								byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
								byte bSecondaryPassword[] = new byte[sLength * 2];
								
								if(this.jcbRandomize.isSelected())
								{
									bSingle[0] = 0x00;
								}
								else
								{
									bSingle[0] = 0x01;
								}
								
								bLength[0] = (byte)(sLength & 0xFF);
								bLength[1] = (byte)((sLength >> 8) & 0xFF);
								
								rafSaveFile.seek(0);
								rafSaveFile.write(bSingle, 0, 1);
								rafSaveFile.seek(1);
								rafSaveFile.write(bLength, 0, 2);
								rafSaveFile.seek(3);
								rafSaveFile.write(bPrimaryPassword, 0, sLength);
								
								if(bSingle[0] == 0x00)
								{
									short sOffsets[] = GlobalVariables.getOffsets();
									int nByteIndex = 0;
									
									for(int x=0;x<sLength;x++)
									{
										bSecondaryPassword[nByteIndex] = (byte)(sOffsets[x] & 0xFF);
										bSecondaryPassword[nByteIndex + 1] = (byte)((sOffsets[x] >> 8) & 0xFF);
										nByteIndex += 2;
									}
									
									rafSaveFile.seek(3 + sLength);
									rafSaveFile.write(bSecondaryPassword, 0, (sLength * 2));
								}
								
								rafSaveFile.close();
							}
							catch(IOException IO)
							{
								IO.printStackTrace();
								JOptionPane.showMessageDialog(null, "Input/Output error.", "IO Error", JOptionPane.ERROR_MESSAGE);
								System.exit(-20);
							}
							
							this.jcbRandomize.setSelected(false);
							this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
							this.jtfLength.setText("0");
							this.jtaPrimaryPassword.setText("");
							this.jtaSecondaryPassword.setText("");
							
							
						}
					}
					else
					{
						File fSaveFile = new File(GlobalVariables.getCurrentFile());
						
						if(fSaveFile.exists())
						{
							fSaveFile.delete();
						}
						
						try
						{
							RandomAccessFile rafSaveFile = new RandomAccessFile(fSaveFile, "rw");
							byte bSingle[] = new byte[1];
							byte bLength[] = new byte[2];
							byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
							byte bSecondaryPassword[] = new byte[sLength * 2];
							
							if(this.jcbRandomize.isSelected())
							{
								bSingle[0] = 0x00;
							}
							else
							{
								bSingle[0] = 0x01;
							}
							
							bLength[0] = (byte)(sLength & 0xFF);
							bLength[1] = (byte)((sLength >> 8) & 0xFF);
							
							rafSaveFile.seek(0);
							rafSaveFile.write(bSingle, 0, 1);
							rafSaveFile.seek(1);
							rafSaveFile.write(bLength, 0, 2);
							rafSaveFile.seek(3);
							rafSaveFile.write(bPrimaryPassword, 0, sLength);
							
							if(bSingle[0] == 0x00)
							{
								short sOffsets[] = GlobalVariables.getOffsets();
								int nByteIndex = 0;
								
								for(int x=0;x<sLength;x++)
								{
									bSecondaryPassword[nByteIndex] = (byte)(sOffsets[x] & 0xFF);
									bSecondaryPassword[nByteIndex + 1] = (byte)((sOffsets[x] >> 8) & 0xFF);
									nByteIndex += 2;
								}
								
								rafSaveFile.seek(3 + sLength);
								rafSaveFile.write(bSecondaryPassword, 0, (sLength * 2));
							}
							
							rafSaveFile.close();
						}
						catch(IOException IO)
						{
							IO.printStackTrace();
							JOptionPane.showMessageDialog(null, "Input/Output error.", "IO Error", JOptionPane.ERROR_MESSAGE);
							System.exit(-20);
						}
						
						GlobalVariables.setOffsets(null);
						GlobalVariables.setCurrentFile(null);
						
						this.jcbRandomize.setSelected(false);
						this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
						this.jtaPrimaryPassword.setText("");
						this.jtaSecondaryPassword.setText("");
						this.jtfLength.setText("0");
					}
				}
				else if(nChs == JOptionPane.NO_OPTION)
				{
					GlobalVariables.setCurrentFile(null);
					GlobalVariables.setOffsets(null);
					
					this.jcbRandomize.setSelected(false);
					this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
					this.jtaPrimaryPassword.setText("");
					this.jtaSecondaryPassword.setText("");
					this.jtfLength.setText("0");
				}
			}
			else
			{
				GlobalVariables.setCurrentFile(null);
				GlobalVariables.setOffsets(null);
				
				this.jcbRandomize.setSelected(false);
				this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
				this.jtaPrimaryPassword.setText("");
				this.jtaSecondaryPassword.setText("");
				this.jtfLength.setText("0");
			}
		}
		else
		{
			GlobalVariables.setCurrentFile(null);
			GlobalVariables.setOffsets(null);
			
			this.jcbRandomize.setSelected(false);
			this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
			this.jtaPrimaryPassword.setText("");
			this.jtaSecondaryPassword.setText("");
			this.jtfLength.setText("0");
		}
		
		GlobalVariables.setRequireSave(false);
	}
}