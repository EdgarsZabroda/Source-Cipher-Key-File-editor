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

public class ItemExit implements ActionListener
{
	private String sAskToSave;
	private String sAskToSaveTitle;
	private String sSave;
	private String sSaveFail;
	private String sSaveFailTitle;
	private JTextArea jtaPrimaryPassword;
	private JTextField jtfLength;
	private JCheckBox jcbRandomize;
	private JFrame jfParent;
	
	public ItemExit(String sAskToSave, String sAskToSaveTitle,
			String sSave, String sSaveFail, String sSaveFailTitle,
			JTextArea jtaPrimaryPassword, JTextField jtfLength,
			JCheckBox jcbRandomize, JFrame jfParent)
	{
		this.jcbRandomize = jcbRandomize;
		this.jtaPrimaryPassword = jtaPrimaryPassword;
		this.jtfLength = jtfLength;
		this.sAskToSave = sAskToSave;
		this.sAskToSaveTitle = sAskToSave;
		this.sSave = sSave;
		this.sSaveFail = sSaveFail;
		this.sSaveFailTitle = sSaveFailTitle;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(GlobalVariables.getRequireSave())
		{
			short sLength = Short.parseShort(this.jtfLength.getText());
			
			if(sLength > 0)
			{
				int nChs = JOptionPane.showConfirmDialog(this.jfParent,
						this.sAskToSave, this.sAskToSaveTitle, JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				
				if(nChs == JOptionPane.YES_OPTION)
				{
					if(GlobalVariables.getCurrentFile() != null)
					{
						File fSaveFile = new File(GlobalVariables.getCurrentFile());
						
						try
						{
							RandomAccessFile rafSaveFile = new RandomAccessFile(fSaveFile, "rw");
							byte bSingle[] = new byte[1];
							byte bLength[] = new byte[2];
							byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
							
							if(this.jcbRandomize.isSelected())
							{
								bSingle[0] = 0x00;
							}
							else
							{
								bSingle[0] = 0x01;
							}
							
							bLength[0] = (byte)(sLength & 0xFF);
							bLength[1] = (byte)(((sLength) >> 8) & 0xFF);
							
							rafSaveFile.seek(0);
							rafSaveFile.write(bSingle, 0, 1);
							rafSaveFile.seek(1);
							rafSaveFile.write(bLength, 0, 2);
							rafSaveFile.seek(3);
							rafSaveFile.write(bPrimaryPassword, 0, sLength);
							
							if(bSingle[0] == 0x00)
							{
								short sOffsets[] = GlobalVariables.getOffsets();
								byte bOffsets[] = new byte[sLength * 2];
								short sIndex = 0;
								
								for(int x=0;x<sLength;x++)
								{
									bOffsets[sIndex] = (byte)(sOffsets[x] & 0xFF);
									bOffsets[sIndex + 1] = (byte)(((sOffsets[x]) >> 8) & 0xFF);
									sIndex += 2;
								}
								
								rafSaveFile.seek(3 + sLength);
								rafSaveFile.write(bOffsets, 0, (sLength * 2));
							}
							
							rafSaveFile.close();
						}
						catch(IOException IO)
						{
							IO.printStackTrace();
							JOptionPane.showMessageDialog(this.jfParent,
									this.sSaveFail, this.sSaveFailTitle,
									JOptionPane.ERROR_MESSAGE);
							System.exit(-25);
						}
						
						System.exit(0);
					}
					else
					{
						JFileChooser jfcSaveDialog = new JFileChooser(System.getProperty("user.dir"));
						FileNameExtensionFilter sckfFiles = new FileNameExtensionFilter("SCKF files (*.sckf)", "sckf");
						
						jfcSaveDialog.setDialogTitle(this.sSave);
						jfcSaveDialog.setAcceptAllFileFilterUsed(false);
						jfcSaveDialog.addChoosableFileFilter(sckfFiles);
						
						int nDChs = jfcSaveDialog.showSaveDialog(this.jfParent);
						
						if(nDChs == JFileChooser.APPROVE_OPTION)
						{
							File fSaveFile = jfcSaveDialog.getSelectedFile();
							
							try
							{
								RandomAccessFile rafSaveFile = new RandomAccessFile(fSaveFile, "rw");
								byte bSingle[] = new byte[1];
								byte bLength[] = new byte[2];
								byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
								
								if(this.jcbRandomize.isSelected())
								{
									bSingle[0] = 0x00;
								}
								else
								{
									bSingle[0] = 0x01;
								}
								
								bLength[0] = (byte)(sLength & 0xFF);
								bLength[1] = (byte)(((sLength) >> 8) & 0xFF);
								
								rafSaveFile.seek(0);
								rafSaveFile.write(bSingle, 0, 1);
								rafSaveFile.seek(1);
								rafSaveFile.write(bLength, 0, 2);
								rafSaveFile.seek(3);
								rafSaveFile.write(bPrimaryPassword, 0, sLength);
								
								if(bSingle[0] == 0x00)
								{
									short sOffsets[] = GlobalVariables.getOffsets();
									byte bOffsets[] = new byte[sLength * 2];
									short sIndex = 0;
									
									for(int x=0;x<sLength;x++)
									{
										bOffsets[sIndex] = (byte)(sOffsets[x] & 0xFF);
										bOffsets[sIndex + 1] = (byte)(((sOffsets[x]) >> 8) & 0xFF);
										sIndex += 2;
									}
									
									rafSaveFile.seek(3 + sLength);
									rafSaveFile.write(bOffsets, 0, (sLength * 2));
								}
								
								rafSaveFile.close();
							}
							catch(IOException IO)
							{
								IO.printStackTrace();
								JOptionPane.showMessageDialog(this.jfParent,
										this.sSaveFail, this.sSaveFailTitle,
										JOptionPane.ERROR_MESSAGE);
								System.exit(-25);
							}
							
							System.exit(0);
						}
					}
				}
				else if(nChs == JOptionPane.NO_OPTION)
				{
					System.exit(0);
				}
			}
			else
			{
				System.exit(0);
			}
		}
		else
		{
			System.exit(0);
		}
	}
}