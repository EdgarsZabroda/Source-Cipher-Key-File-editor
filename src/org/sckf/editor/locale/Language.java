package org.sckf.editor.locale;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Language
{
	private String sMainTitle;
	private String sFile;
	private String sNew;
	private String sOpen;
	private String sSave;
	private String sSaveAs;
	private String sExit;
	private String sLanguage;
	private String sLanguages;
	private String sLangEditor;
	private String sHelp;
	private String sHelpTopics;
	private String sAbout;
	private String sRandomize;
	private String sLength;
	private String sPrimaryPassword;
	private String sSecondaryPassword;
	private String sLanguageCode;
	private String sLangEditorTitle;
	private String sRestartOK;
	private String sRestartOKTitle;
	private String sSaveFail;
	private String sSaveFailTitle;
	private String sLoadFail;
	private String sLoadFailTitle;
	private String sLanguageName;
	private String sAskToSave;
	private String sAskToSaveTitle;
	
	public Language(String sLanguageCode)
	{
		String sLanguageFile = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "langs" + System.getProperty("file.separator") + sLanguageCode + ".properties";
		File fLanguageFile = new File(sLanguageFile);
		
		try
		{
			if(fLanguageFile.isFile())
			{
				try
				{
					InputStream fInputStream = new FileInputStream(fLanguageFile);
					Properties pLanguageStrings = new Properties();
					
					pLanguageStrings.load(fInputStream);
					
					this.sAbout = pLanguageStrings.getProperty("About");
					this.sAskToSave = pLanguageStrings.getProperty("AskToSave");
					this.sAskToSaveTitle = pLanguageStrings.getProperty("AskToSaveTitle");
					this.sExit = pLanguageStrings.getProperty("Exit");
					this.sFile = pLanguageStrings.getProperty("File");
					this.sHelp = pLanguageStrings.getProperty("Help");
					this.sHelpTopics = pLanguageStrings.getProperty("HelpTopics");
					this.sLangEditor = pLanguageStrings.getProperty("LanguageEditor");
					this.sLangEditorTitle = pLanguageStrings.getProperty("LanguageEditorTitle");
					this.sLanguage = pLanguageStrings.getProperty("Language");
					this.sLanguageCode = pLanguageStrings.getProperty("LanguageCode");
					this.sLanguageName = pLanguageStrings.getProperty("LanguageName");
					this.sLanguages = pLanguageStrings.getProperty("Languages");
					this.sLength = pLanguageStrings.getProperty("Length");
					this.sLoadFail = pLanguageStrings.getProperty("LoadFail");
					this.sLoadFailTitle = pLanguageStrings.getProperty("LoadFailTitle");
					this.sMainTitle = pLanguageStrings.getProperty("MainTitle");
					this.sNew = pLanguageStrings.getProperty("New");
					this.sOpen = pLanguageStrings.getProperty("Open");
					this.sPrimaryPassword = pLanguageStrings.getProperty("PrimaryPassword");
					this.sRandomize = pLanguageStrings.getProperty("Randomize");
					this.sRestartOK = pLanguageStrings.getProperty("RestartOK");
					this.sRestartOKTitle = pLanguageStrings.getProperty("RestartOKTitle");
					this.sSave = pLanguageStrings.getProperty("Save");
					this.sSaveAs = pLanguageStrings.getProperty("SaveAs");
					this.sSaveFail = pLanguageStrings.getProperty("SaveFail");
					this.sSaveFailTitle = pLanguageStrings.getProperty("SaveFailTitle");
					this.sSecondaryPassword = pLanguageStrings.getProperty("SecondaryPassword");
					
					fInputStream.close();
				}
				catch(IOException IO)
				{
					JOptionPane.showMessageDialog(null, "An error occured while reading the "
							+ "language file.", "Error", JOptionPane.ERROR_MESSAGE);
					IO.printStackTrace();
					System.exit(-1);
				}
			}
			else
			{
				throw new IOException("Language file doesn't exist.");
			}
		}
		catch(IOException IO)
		{
			JOptionPane.showMessageDialog(null, "Language file doesn't exist.", "Error.", JOptionPane.ERROR_MESSAGE);
			IO.printStackTrace();
			System.exit(-2);
		}
	}
	
	public String getAbout()
	{
		return this.sAbout;
	}
	
	public String getAskToSave()
	{
		return this.sAskToSave;
	}
	
	public String getAskToSaveTitle()
	{
		return this.sAskToSaveTitle;
	}
	
	public String getExit()
	{
		return this.sExit;
	}
	
	public String getFile()
	{
		return this.sFile;
	}
	
	public String getHelp()
	{
		return this.sHelp;
	}
	
	public String getHelpTopics()
	{
		return this.sHelpTopics;
	}
	
	public String getLangEditor()
	{
		return this.sLangEditor;
	}
	
	public String getLangEditorTitle()
	{
		return this.sLangEditorTitle;
	}
	
	public String getLanguage()
	{
		return this.sLanguage;
	}
	
	public String getLanguageCode()
	{
		return this.sLanguageCode;
	}
	
	public String getLanguageName()
	{
		return this.sLanguageName;
	}
	
	public String getLanguages()
	{
		return this.sLanguages;
	}
	
	public String getLength()
	{
		return this.sLength;
	}
	
	public String getLoadFail()
	{
		return this.sLoadFail;
	}
	
	public String getLoadFailTitle()
	{
		return this.sLoadFailTitle;
	}
	
	public String getMainTitle()
	{
		return this.sMainTitle;
	}
	
	public String getNew()
	{
		return this.sNew;
	}
	
	public String getOpen()
	{
		return this.sOpen;
	}
	
	public String getPrimaryPassword()
	{
		return this.sPrimaryPassword;
	}
	
	public String getRandomize()
	{
		return this.sRandomize;
	}
	
	public String getRestartOK()
	{
		return this.sRestartOK;
	}
	
	public String getRestartOKTitle()
	{
		return this.sRestartOKTitle;
	}
	
	public String getSave()
	{
		return this.sSave;
	}
	
	public String getSaveAs()
	{
		return this.sSaveAs;
	}
	
	public String getSaveFail()
	{
		return this.sSaveFail;
	}
	
	public String getSaveFailTitle()
	{
		return this.sSaveFailTitle;
	}
	
	public String getSecondaryPassword()
	{
		return this.sSecondaryPassword;
	}
}