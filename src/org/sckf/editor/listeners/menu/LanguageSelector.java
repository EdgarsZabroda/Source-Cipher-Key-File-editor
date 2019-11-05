package org.sckf.editor.listeners.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LanguageSelector implements ActionListener
{
	private String sRestartOK;
	private String sRestartOKTitle;
	private String sLoadFail;
	private String sLoadFailTitle;
	private JFrame jfParent;
	
	public LanguageSelector(String sRestartOK,
			String sRestartOKTitle, String sLoadFail,
			String sLoadFailTitle, JFrame jfParent)
	{
		this.sRestartOK = sRestartOK;
		this.sRestartOKTitle = sRestartOKTitle;
		this.sLoadFail = sLoadFail;
		this.sLoadFailTitle = sLoadFailTitle;
		this.jfParent = jfParent;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		String sLangCode = ae.getActionCommand();
		String sFileLocation = System.getProperty("user.dir") +
				System.getProperty("file.separator") +
				"config.properties";
		
		try
		{
			OutputStream osOutput = new FileOutputStream(sFileLocation);
			Properties pCfg = new Properties();
			
			pCfg.setProperty("LanguageCode", sLangCode);
			pCfg.store(osOutput, null);
			
			osOutput.close();
		}
		catch(IOException IO)
		{
			IO.printStackTrace();
			JOptionPane.showMessageDialog(this.jfParent,
					this.sLoadFail, this.sLoadFailTitle,
					JOptionPane.ERROR_MESSAGE);
			System.exit(-25);
		}
		
		JOptionPane.showMessageDialog(this.jfParent, this.sRestartOK,
				this.sRestartOKTitle, JOptionPane.INFORMATION_MESSAGE);
	}
}