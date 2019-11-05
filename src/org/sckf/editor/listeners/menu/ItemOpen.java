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

public class ItemOpen implements ActionListener
{
	private JTextArea jtaPrimaryPassword;
	private JTextArea jtaSecondaryPassword;
	private JTextField jtfLength;
	private JCheckBox jcbRandomize;
	private String sOpen;
	private String sSave;
	private String sSaveFail;
	private String sSaveFailTitle;
	private String sLoadFail;
	private String sLoadFailTitle;
	private JFrame jfMainWnd;
	private String sAskToSave;
	private String sAskToSaveTitle;
	
	public ItemOpen(JTextArea jtaPrimaryPassword,
			JTextArea jtaSecondaryPassword, JTextField jtfLength,
			JCheckBox jcbRandomize, String sOpen, String sSave,
			String sSaveFail, String sSaveFailTitle,
			String sLoadFail, String sLoadFailTitle,
			JFrame jfMainWnd, String sAskToSave,
			String sAskToSaveTitle)
	{
		this.jcbRandomize = jcbRandomize;
		this.jtaPrimaryPassword = jtaPrimaryPassword;
		this.jtaSecondaryPassword = jtaSecondaryPassword;
		this.jtfLength = jtfLength;
		this.sAskToSave = sAskToSave;
		this.sAskToSaveTitle = sAskToSaveTitle;
		this.sLoadFail = sLoadFail;
		this.sLoadFailTitle = sLoadFailTitle;
		this.sOpen = sOpen;
		this.sSave = sSave;
		this.sSaveFail = sSaveFail;
		this.sSaveFailTitle = sSaveFailTitle;
		this.jfMainWnd = jfMainWnd;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(GlobalVariables.getRequireSave())
		{
			short sLength = Short.valueOf(this.jtfLength.getText());
			
			if(sLength > 0)
			{
				int nChs = JOptionPane.showConfirmDialog(this.jfMainWnd,
						this.sAskToSave, this.sAskToSaveTitle,
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(nChs == JOptionPane.YES_OPTION)
				{
					if(GlobalVariables.getCurrentFile() == null)
					{
						JFileChooser jfcSaveDialog = new JFileChooser(System.getProperty("user.dir"));
						FileNameExtensionFilter fnefFilter = new FileNameExtensionFilter("SCKF files (*.sckf)", "sckf");
						
						jfcSaveDialog.setDialogTitle(this.sSave);
						jfcSaveDialog.setAcceptAllFileFilterUsed(false);
						jfcSaveDialog.addChoosableFileFilter(fnefFilter);
						
						int nDlgChs = jfcSaveDialog.showSaveDialog(this.jfMainWnd);
						
						if(nDlgChs == JFileChooser.APPROVE_OPTION)
						{
							File fSaveFile = jfcSaveDialog.getSelectedFile();
							
							if(fSaveFile.exists())
							{
								fSaveFile.delete();
							}
							
							try
							{
								byte bSingle[] = new byte[1];
								byte bLength[] = new byte[2];
								byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
								byte bSecondaryPassword[] = new byte[sLength * 2];
								RandomAccessFile rafSaveFile = new RandomAccessFile(fSaveFile, "rw");
								
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
									short sIndex = 0;
									
									for(int x=0;x<sLength;x++)
									{
										bSecondaryPassword[sIndex] = (byte)(sOffsets[x] & 0xFF);
										bSecondaryPassword[sIndex + 1] = (byte)((sOffsets[x] >> 8) & 0xFF);
										sIndex += 2;
									}
									
									rafSaveFile.seek(3 + sLength);
									rafSaveFile.write(bSecondaryPassword, 0, (sLength * 2));
								}
								
								GlobalVariables.setRequireSave(false);
								rafSaveFile.close();
							}
							catch(IOException IO)
							{
								IO.printStackTrace();
								JOptionPane.showMessageDialog(this.jfMainWnd, this.sSaveFail,
										this.sSaveFailTitle, JOptionPane.ERROR_MESSAGE);
								System.exit(-21);
							}
							
							JFileChooser jfcOpenDialog = new JFileChooser(System.getProperty("user.dir"));
							FileNameExtensionFilter sckfFilter = new FileNameExtensionFilter("SCKF files (*.sckf)", "sckf");
							
							jfcOpenDialog.setDialogTitle(this.sOpen);
							jfcOpenDialog.setAcceptAllFileFilterUsed(false);
							jfcOpenDialog.addChoosableFileFilter(sckfFilter);
							
							int nOChs = jfcOpenDialog.showOpenDialog(this.jfMainWnd);
							
							if(nOChs == JFileChooser.APPROVE_OPTION)
							{
								File fOpenFile = jfcOpenDialog.getSelectedFile();
								
								try
								{
									RandomAccessFile rafOpenFile = new RandomAccessFile(fOpenFile, "rw");
									byte bSingle[] = new byte[1];
									byte bLength[] = new byte[2];
									short sLen;
									
									rafOpenFile.seek(0);
									rafOpenFile.read(bSingle, 0, 1);
									rafOpenFile.seek(1);
									rafOpenFile.read(bLength, 0, 2);
									
									sLen = (short)(((bLength[1]) << 8) | bLength[0] & 0x00FF);
									
									byte bPrimaryPassword[] = new byte[sLen];
									
									rafOpenFile.seek(3);
									rafOpenFile.read(bPrimaryPassword, 0, sLen);
									
									this.jtfLength.setText(String.valueOf(sLen));
									this.jtaPrimaryPassword.setText(new String(bPrimaryPassword));
									
									if(bSingle[0] == 0x00)
									{
										short sOffsets[] = new short[sLen];
										byte bOffsets[] = new byte[sLen * 2];
										byte bSecondaryPassword[] = new byte[sLen];
										short sIndex = 0;
										
										rafOpenFile.seek(3 + sLen);
										rafOpenFile.read(bOffsets, 0, (sLen * 2));
										
										for(int x=0;x<sLen;x++)
										{
											sOffsets[x] = (short)(((bOffsets[sIndex + 1]) << 8) | (bOffsets[sIndex] & 0x00FF));
											sIndex += 2;
										}
										
										for(int x=0;x<sLen;x++)
										{
											bSecondaryPassword[x] = bPrimaryPassword[sOffsets[x]];
										}
										
										this.jcbRandomize.setSelected(true);
										this.jtaSecondaryPassword.setText(new String(bSecondaryPassword));
										GlobalVariables.setOffsets(sOffsets);
									}
									else
									{
										this.jcbRandomize.setSelected(false);
										this.jtaSecondaryPassword.setText(null);
										
										GlobalVariables.setOffsets(null);
									}
									
									GlobalVariables.setCurrentFile(fSaveFile.getPath());
									
									rafOpenFile.close();
								}
								catch(IOException IO)
								{
									IO.printStackTrace();
									JOptionPane.showMessageDialog(this.jfMainWnd, this.sLoadFail, this.sLoadFailTitle, JOptionPane.ERROR_MESSAGE);
									System.exit(-22);
								}
								
								this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
							}
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
							byte bSingle[] = new byte[1];
							byte bLength[] = new byte[2];
							byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
							byte bSecondaryPassword[] = new byte[sLength * 2];
							RandomAccessFile rafSaveFile = new RandomAccessFile(fSaveFile, "rw");
							
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
								short sIndex = 0;
								
								for(int x=0;x<sLength;x++)
								{
									bSecondaryPassword[sIndex] = (byte)(sOffsets[x] & 0xFF);
									bSecondaryPassword[sIndex + 1] = (byte)((sOffsets[x] >> 8) & 0xFF);
									sIndex += 2;
								}
								
								rafSaveFile.seek(3 + sLength);
								rafSaveFile.write(bSecondaryPassword, 0, (sLength * 2));
							}
							
							GlobalVariables.setRequireSave(false);
							
							rafSaveFile.close();
						}
						catch(IOException IO)
						{
							IO.printStackTrace();
							JOptionPane.showMessageDialog(this.jfMainWnd, this.sSaveFail,
									this.sSaveFailTitle, JOptionPane.ERROR_MESSAGE);
							System.exit(-21);
						}
						
						JFileChooser jfcOpenDialog = new JFileChooser(System.getProperty("user.dir"));
						FileNameExtensionFilter sckfFilter = new FileNameExtensionFilter("SCKF files (*.sckf)", "sckf");
						
						jfcOpenDialog.setDialogTitle(this.sOpen);
						jfcOpenDialog.setAcceptAllFileFilterUsed(false);
						jfcOpenDialog.addChoosableFileFilter(sckfFilter);
						
						int nOChs = jfcOpenDialog.showOpenDialog(this.jfMainWnd);
						
						if(nOChs == JFileChooser.APPROVE_OPTION)
						{
							File fOpenFile = jfcOpenDialog.getSelectedFile();
							
							try
							{
								RandomAccessFile rafOpenFile = new RandomAccessFile(fOpenFile, "rw");
								byte bSingle[] = new byte[1];
								byte bLength[] = new byte[2];
								short sLen;
								
								rafOpenFile.seek(0);
								rafOpenFile.read(bSingle, 0, 1);
								rafOpenFile.seek(1);
								rafOpenFile.read(bLength, 0, 2);
								
								sLen = (short)(((bLength[1]) << 8) | bLength[0] & 0x00FF);
								
								byte bPrimaryPassword[] = new byte[sLen];
								
								rafOpenFile.seek(3);
								rafOpenFile.read(bPrimaryPassword, 0, sLen);
								
								this.jtfLength.setText(String.valueOf(sLen));
								this.jtaPrimaryPassword.setText(new String(bPrimaryPassword));
								
								if(bSingle[0] == 0x00)
								{
									short sOffsets[] = new short[sLen];
									byte bOffsets[] = new byte[sLen * 2];
									byte bSecondaryPassword[] = new byte[sLen];
									short sIndex = 0;
									
									rafOpenFile.seek(3 + sLen);
									rafOpenFile.read(bOffsets, 0, (sLen * 2));
									
									for(int x=0;x<sLen;x++)
									{
										sOffsets[x] = (short)(((bOffsets[sIndex + 1]) << 8) | (bOffsets[sIndex] & 0x00FF));
										sIndex += 2;
									}
									
									for(int x=0;x<sLen;x++)
									{
										bSecondaryPassword[x] = bPrimaryPassword[sOffsets[x]];
									}
									
									this.jcbRandomize.setSelected(true);
									this.jtaSecondaryPassword.setText(new String(bSecondaryPassword));
									GlobalVariables.setOffsets(sOffsets);
								}
								else
								{
									this.jcbRandomize.setSelected(false);
									this.jtaSecondaryPassword.setText(null);
									
									GlobalVariables.setOffsets(null);
								}
								
								GlobalVariables.setCurrentFile(fOpenFile.getPath());
								
								rafOpenFile.close();
							}
							catch(IOException IO)
							{
								IO.printStackTrace();
								JOptionPane.showMessageDialog(this.jfMainWnd, this.sLoadFail, this.sLoadFailTitle, JOptionPane.ERROR_MESSAGE);
								System.exit(-22);
							}
							
							this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
						}
					}
				}
				else if(nChs == JOptionPane.NO_OPTION);
				{
					JFileChooser jfcOpenDialog = new JFileChooser(System.getProperty("user.dir"));
					FileNameExtensionFilter sckfFilter = new FileNameExtensionFilter("SCKF files (*.sckf)", "sckf");
					
					jfcOpenDialog.setDialogTitle(this.sOpen);
					jfcOpenDialog.setAcceptAllFileFilterUsed(false);
					jfcOpenDialog.addChoosableFileFilter(sckfFilter);
					
					int nOChs = jfcOpenDialog.showOpenDialog(this.jfMainWnd);
					
					if(nOChs == JFileChooser.APPROVE_OPTION)
					{
						File fOpenFile = jfcOpenDialog.getSelectedFile();
						
						try
						{
							RandomAccessFile rafOpenFile = new RandomAccessFile(fOpenFile, "rw");
							byte bSingle[] = new byte[1];
							byte bLength[] = new byte[2];
							short sLen;
							
							rafOpenFile.seek(0);
							rafOpenFile.read(bSingle, 0, 1);
							rafOpenFile.seek(1);
							rafOpenFile.read(bLength, 0, 2);
							
							sLen = (short)(((bLength[1]) << 8) | bLength[0] & 0x00FF);
							
							byte bPrimaryPassword[] = new byte[sLen];
							
							rafOpenFile.seek(3);
							rafOpenFile.read(bPrimaryPassword, 0, sLen);
							
							this.jtfLength.setText(String.valueOf(sLen));
							this.jtaPrimaryPassword.setText(new String(bPrimaryPassword));
							
							if(bSingle[0] == 0x00)
							{
								short sOffsets[] = new short[sLen];
								byte bOffsets[] = new byte[sLen * 2];
								byte bSecondaryPassword[] = new byte[sLen];
								short sIndex = 0;
								
								rafOpenFile.seek(3 + sLen);
								rafOpenFile.read(bOffsets, 0, (sLen * 2));
								
								for(int x=0;x<sLen;x++)
								{
									sOffsets[x] = (short)(((bOffsets[sIndex + 1]) << 8) | (bOffsets[sIndex] & 0x00FF));
									sIndex += 2;
								}
								
								for(int x=0;x<sLen;x++)
								{
									bSecondaryPassword[x] = bPrimaryPassword[sOffsets[x]];
								}
								
								this.jcbRandomize.setSelected(true);
								this.jtaSecondaryPassword.setText(new String(bSecondaryPassword));
								GlobalVariables.setOffsets(sOffsets);
							}
							else
							{
								this.jcbRandomize.setSelected(false);
								this.jtaSecondaryPassword.setText(null);
								
								GlobalVariables.setOffsets(null);
							}
							
							GlobalVariables.setCurrentFile(fOpenFile.getPath());
							
							rafOpenFile.close();
						}
						catch(IOException IO)
						{
							IO.printStackTrace();
							JOptionPane.showMessageDialog(this.jfMainWnd, this.sLoadFail, this.sLoadFailTitle, JOptionPane.ERROR_MESSAGE);
							System.exit(-22);
						}
						
						this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
						GlobalVariables.setRequireSave(false);
					}
				}
			}
			else
			{
				JFileChooser jfcOpenDialog = new JFileChooser(System.getProperty("user.dir"));
				FileNameExtensionFilter sckfFilter = new FileNameExtensionFilter("SCKF files (*.sckf)", "sckf");
				
				jfcOpenDialog.setDialogTitle(this.sOpen);
				jfcOpenDialog.setAcceptAllFileFilterUsed(false);
				jfcOpenDialog.addChoosableFileFilter(sckfFilter);
				
				int nOChs = jfcOpenDialog.showOpenDialog(this.jfMainWnd);
				
				if(nOChs == JFileChooser.APPROVE_OPTION)
				{
					File fOpenFile = jfcOpenDialog.getSelectedFile();
					
					try
					{
						RandomAccessFile rafOpenFile = new RandomAccessFile(fOpenFile, "rw");
						byte bSingle[] = new byte[1];
						byte bLength[] = new byte[2];
						short sLen;
						
						rafOpenFile.seek(0);
						rafOpenFile.read(bSingle, 0, 1);
						rafOpenFile.seek(1);
						rafOpenFile.read(bLength, 0, 2);
						
						sLen = (short)(((bLength[1]) << 8) | bLength[0] & 0x00FF);
						
						byte bPrimaryPassword[] = new byte[sLen];
						
						rafOpenFile.seek(3);
						rafOpenFile.read(bPrimaryPassword, 0, sLen);
						
						this.jtfLength.setText(String.valueOf(sLen));
						this.jtaPrimaryPassword.setText(new String(bPrimaryPassword));
						
						if(bSingle[0] == 0x00)
						{
							short sOffsets[] = new short[sLen];
							byte bOffsets[] = new byte[sLen * 2];
							byte bSecondaryPassword[] = new byte[sLen];
							short sIndex = 0;
							
							rafOpenFile.seek(3 + sLen);
							rafOpenFile.read(bOffsets, 0, (sLen * 2));
							
							for(int x=0;x<sLen;x++)
							{
								sOffsets[x] = (short)(((bOffsets[sIndex + 1]) << 8) | (bOffsets[sIndex] & 0x00FF));
								sIndex += 2;
							}
							
							for(int x=0;x<sLen;x++)
							{
								bSecondaryPassword[x] = bPrimaryPassword[sOffsets[x]];
							}
							
							this.jcbRandomize.setSelected(true);
							this.jtaSecondaryPassword.setText(new String(bSecondaryPassword));
							GlobalVariables.setOffsets(sOffsets);
						}
						else
						{
							this.jcbRandomize.setSelected(false);
							this.jtaSecondaryPassword.setText(null);
							
							GlobalVariables.setOffsets(null);
						}
						
						GlobalVariables.setCurrentFile(fOpenFile.getPath());
						
						rafOpenFile.close();
					}
					catch(IOException IO)
					{
						IO.printStackTrace();
						JOptionPane.showMessageDialog(this.jfMainWnd, this.sLoadFail, this.sLoadFailTitle, JOptionPane.ERROR_MESSAGE);
						System.exit(-22);
					}
					
					GlobalVariables.setRequireSave(false);
					this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
				}
			}
		}
		else
		{
			JFileChooser jfcOpenDialog = new JFileChooser(System.getProperty("user.dir"));
			FileNameExtensionFilter sckfFilter = new FileNameExtensionFilter("SCKF files (*.sckf)", "sckf");
			
			jfcOpenDialog.setDialogTitle(this.sOpen);
			jfcOpenDialog.setAcceptAllFileFilterUsed(false);
			jfcOpenDialog.addChoosableFileFilter(sckfFilter);
			
			int nOChs = jfcOpenDialog.showOpenDialog(this.jfMainWnd);
			
			if(nOChs == JFileChooser.APPROVE_OPTION)
			{
				File fOpenFile = jfcOpenDialog.getSelectedFile();
				
				try
				{
					RandomAccessFile rafOpenFile = new RandomAccessFile(fOpenFile, "rw");
					byte bSingle[] = new byte[1];
					byte bLength[] = new byte[2];
					short sLen;
					
					rafOpenFile.seek(0);
					rafOpenFile.read(bSingle, 0, 1);
					rafOpenFile.seek(1);
					rafOpenFile.read(bLength, 0, 2);
					
					sLen = (short)(((bLength[1]) << 8) | bLength[0] & 0x00FF);
					
					byte bPrimaryPassword[] = new byte[sLen];
					
					rafOpenFile.seek(3);
					rafOpenFile.read(bPrimaryPassword, 0, sLen);
					
					this.jtfLength.setText(String.valueOf(sLen));
					this.jtaPrimaryPassword.setText(new String(bPrimaryPassword));
					
					if(bSingle[0] == 0x00)
					{
						short sOffsets[] = new short[sLen];
						byte bOffsets[] = new byte[sLen * 2];
						byte bSecondaryPassword[] = new byte[sLen];
						short sIndex = 0;
						
						rafOpenFile.seek(3 + sLen);
						rafOpenFile.read(bOffsets, 0, (sLen * 2));
						
						for(int x=0;x<sLen;x++)
						{
							sOffsets[x] = (short)(((bOffsets[sIndex + 1]) << 8) | (bOffsets[sIndex] & 0x00FF));
							sIndex += 2;
						}
						
						for(int x=0;x<sLen;x++)
						{
							bSecondaryPassword[x] = bPrimaryPassword[sOffsets[x]];
						}
						
						this.jcbRandomize.setSelected(true);
						this.jtaSecondaryPassword.setText(new String(bSecondaryPassword));
						GlobalVariables.setOffsets(sOffsets);
					}
					else
					{
						this.jcbRandomize.setSelected(false);
						this.jtaSecondaryPassword.setText(null);
						
						GlobalVariables.setOffsets(null);
					}
					
					GlobalVariables.setCurrentFile(fOpenFile.getPath());
					
					rafOpenFile.close();
				}
				catch(IOException IO)
				{
					IO.printStackTrace();
					JOptionPane.showMessageDialog(this.jfMainWnd, this.sLoadFail, this.sLoadFailTitle, JOptionPane.ERROR_MESSAGE);
					System.exit(-22);
				}
				
				GlobalVariables.setRequireSave(false);
				this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
			}
		}
	}
}
