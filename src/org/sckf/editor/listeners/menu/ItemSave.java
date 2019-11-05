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

public class ItemSave implements ActionListener
{
	private JTextArea jtaPrimaryPassword;
	private JTextField jtfLegth;
	private JCheckBox jcbRandomize;
	private JFrame jfMainWnd;
	private String sSave;
	private String sSaveFail;
	private String sSaveFailTitle;
	
	public ItemSave(JTextArea jtaPrimaryPassword,
			JTextField jtfLength, JCheckBox jcbRandomize,
			JFrame jfMainWnd, String sSave, String sSaveFail,
			String sSaveFailTitle)
	{
		this.jcbRandomize = jcbRandomize;
		this.jfMainWnd = jfMainWnd;
		this.jtaPrimaryPassword = jtaPrimaryPassword;
		this.jtfLegth = jtfLength;
		this.sSave = sSave;
		this.sSaveFail = sSaveFail;
		this.sSaveFailTitle = sSaveFailTitle;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(GlobalVariables.getCurrentFile() == null)
		{
			JFileChooser jfcSaveDialog = new JFileChooser(System.getProperty("user.dir"));
			FileNameExtensionFilter sckfFile = new FileNameExtensionFilter("SCKF files (*.sckf)", "sckf");
			
			jfcSaveDialog.setDialogTitle(this.sSave);
			jfcSaveDialog.setAcceptAllFileFilterUsed(false);
			jfcSaveDialog.addChoosableFileFilter(sckfFile);
			
			int nChoice = jfcSaveDialog.showSaveDialog(this.jfMainWnd);
			
			if(nChoice == JFileChooser.APPROVE_OPTION)
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
					short sLength = Short.valueOf(this.jtfLegth.getText());
					
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
						byte bOffsets[] = new byte[sLength * 2];
						short nCurrentIndex = 0;
						
						for(int x=0;x<sLength;x++)
						{
							bOffsets[nCurrentIndex] = (byte)(sOffsets[x] & 0xFF);
							bOffsets[nCurrentIndex + 1] = (byte)(((sOffsets[x]) >> 8) & 0xFF);
							nCurrentIndex += 2;
						}
						
						rafSaveFile.seek(3 + sLength);
						rafSaveFile.write(bOffsets, 0, (sLength * 2));
					}
					
					GlobalVariables.setCurrentFile(fSaveFile.getPath());
					
					rafSaveFile.close();
					
					char cHasStar = this.jfMainWnd.getTitle().charAt(this.jfMainWnd.getTitle().length() - 1);
					
					if(cHasStar == '*')
					{
						this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
					}
				}
				catch(IOException io)
				{
					io.printStackTrace();
					JOptionPane.showMessageDialog(this.jfMainWnd, this.sSaveFail,
							this.sSaveFailTitle, JOptionPane.ERROR_MESSAGE);
					System.exit(-23);
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
				RandomAccessFile rafSaveFile = new RandomAccessFile(fSaveFile, "rw");
				byte bSingle[] = new byte[1];
				byte bLength[] = new byte[2];
				byte bPrimaryPassword[] = this.jtaPrimaryPassword.getText().getBytes();
				short sLength = Short.valueOf(this.jtfLegth.getText());
				
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
					byte bOffsets[] = new byte[sLength * 2];
					short nCurrentIndex = 0;
					
					for(int x=0;x<sLength;x++)
					{
						bOffsets[nCurrentIndex] = (byte)(sOffsets[x] & 0xFF);
						bOffsets[nCurrentIndex + 1] = (byte)(((sOffsets[x]) >> 8) & 0xFF);
						nCurrentIndex += 2;
					}
					
					rafSaveFile.seek(3 + sLength);
					rafSaveFile.write(bOffsets, 0, (sLength * 2));
				}
				
				rafSaveFile.close();
				
				char cHasStar = this.jfMainWnd.getTitle().charAt(this.jfMainWnd.getTitle().length() - 1);
				
				if(cHasStar == '*')
				{
					this.jfMainWnd.setTitle(this.jfMainWnd.getTitle().substring(0, this.jfMainWnd.getTitle().length() - 1));
				}
			}
			catch(IOException io)
			{
				io.printStackTrace();
				JOptionPane.showMessageDialog(this.jfMainWnd, this.sSaveFail,
						this.sSaveFailTitle, JOptionPane.ERROR_MESSAGE);
				System.exit(-23);
			}
		}
	}
}
