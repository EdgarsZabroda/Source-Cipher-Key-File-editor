package org.sckf.editor.listeners.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringEscapeUtils;

@SuppressWarnings("deprecation")
public class SaveLangFile implements ActionListener
{
	private JTextField jtfLangCode;
	private JTextField jtfAskToSave;
	private JTextField jtfAskToSaveTitle;
	private JTextField jtfAbout;
	private JTextField jtfExit;
	private JTextField jtfFile;
	private JTextField jtfHelp;
	private JTextField jtfHelpTopics;
	private JTextField jtfLanguageEditor;
	private JTextField jtfLanguageEditorTitle;
	private JTextField jtfLanguage;
	private JTextField jtfLanguageCode;
	private JTextField jtfLanguageName;
	private JTextField jtfLanguages;
	private JTextField jtfLength;
	private JTextField jtfLoadFail;
	private JTextField jtfLoadFailTitle;
	private JTextField jtfMainTitle;
	private JTextField jtfNew;
	private JTextField jtfOpen;
	private JTextField jtfPrimaryPassword;
	private JTextField jtfRandomize;
	private JTextField jtfRestartOK;
	private JTextField jtfRestartOKTitle;
	private JTextField jtfSave;
	private JTextField jtfSaveAs;
	private JTextField jtfSaveFail;
	private JTextField jtfSaveFailTitle;
	private JTextField jtfSecondaryPassword;
	private String sSaveError;
	private String sSaveErrorTitle;
	private JDialog jDialog;
	
	public SaveLangFile(JTextField jtfLangCode,JTextField jtfAskToSave, JTextField jtfAskToSaveTitle,
			JTextField jtfAbout, JTextField jtfExit, JTextField jtfFile,
			JTextField jtfHelp, JTextField jtfHelpTopics, JTextField jtfLanguageEditor,
			JTextField jtfLanguageEditorTitle, JTextField jtfLanguage, JTextField jtfLanguageCode,
			JTextField jtfLanguageName, JTextField jtfLanguages, JTextField jtfLength,
			JTextField jtfLoadFail, JTextField jtfLoadFailTitle, JTextField jtfMainTitle,
			JTextField jtfNew, JTextField jtfOpen, JTextField jtfPrimaryPassword,
			JTextField jtfRandomize, JTextField jtfRestartOK, JTextField jtfRestartOKTitle,
			JTextField jtfSave, JTextField jtfSaveAs, JTextField jtfSaveFail,
			JTextField jtfSaveFailTitle, JTextField jtfSecondaryPassword,
			String sSaveError, String sSaveErrorTitle, JDialog jDialog)
	{
		this.jtfAbout = jtfAbout;
		this.jtfAskToSave = jtfAskToSave;
		this.jtfAskToSaveTitle = jtfAskToSaveTitle;
		this.jtfExit = jtfExit;
		this.jtfFile = jtfFile;
		this.jtfHelp = jtfHelp;
		this.jtfHelpTopics = jtfHelpTopics;
		this.jtfLangCode = jtfLangCode;
		this.jtfLanguage = jtfLanguage;
		this.jtfLanguageCode = jtfLanguageCode;
		this.jtfLanguageEditor = jtfLanguageEditor;
		this.jtfLanguageEditorTitle = jtfLanguageEditorTitle;
		this.jtfLanguageName = jtfLanguageName;
		this.jtfLanguages = jtfLanguages;
		this.jtfLength = jtfLength;
		this.jtfLoadFail = jtfLoadFail;
		this.jtfLoadFailTitle = jtfLoadFailTitle;
		this.jtfMainTitle = jtfMainTitle;
		this.jtfNew = jtfNew;
		this.jtfOpen = jtfOpen;
		this.jtfPrimaryPassword = jtfPrimaryPassword;
		this.jtfRandomize = jtfRandomize;
		this.jtfRestartOK = jtfRestartOK;
		this.jtfRestartOKTitle = jtfRestartOKTitle;
		this.jtfSave = jtfSave;
		this.jtfSaveAs = jtfSaveAs;
		this.jtfSaveFail = jtfSaveFail;
		this.jtfSaveFailTitle = jtfSaveFailTitle;
		this.jtfSecondaryPassword = jtfSecondaryPassword;
		this.sSaveError = sSaveError;
		this.sSaveErrorTitle = sSaveErrorTitle;
		this.jDialog = jDialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		String sSaveLangFile = System.getProperty("user.dir") + 
				System.getProperty("file.separator") + "langs" +
				System.getProperty("file.separator") +
				this.jtfLangCode.getText() + ".properties";
		
		try
		{
			OutputStream osOutput = new FileOutputStream(sSaveLangFile);
			Properties pStrings = new Properties();
			
			pStrings.setProperty("About", StringEscapeUtils.unescapeJava(this.jtfAbout.getText()));
			pStrings.setProperty("AskToSave", StringEscapeUtils.unescapeJava(this.jtfAskToSave.getText()));
			pStrings.setProperty("AskToSaveTitle", StringEscapeUtils.unescapeJava(this.jtfAskToSaveTitle.getText()));
			pStrings.setProperty("Exit", StringEscapeUtils.unescapeJava(this.jtfExit.getText()));
			pStrings.setProperty("File", StringEscapeUtils.unescapeJava(this.jtfFile.getText()));
			pStrings.setProperty("Help", StringEscapeUtils.unescapeJava(this.jtfHelp.getText()));
			pStrings.setProperty("HelpTopics", StringEscapeUtils.unescapeJava(this.jtfHelpTopics.getText()));
			pStrings.setProperty("Language", StringEscapeUtils.unescapeJava(this.jtfLanguage.getText()));
			pStrings.setProperty("LanguageCode", StringEscapeUtils.unescapeJava(this.jtfLanguageCode.getText()));
			pStrings.setProperty("LanguageEditor", StringEscapeUtils.unescapeJava(this.jtfLanguageEditor.getText()));
			pStrings.setProperty("LanguageEditorTitle", StringEscapeUtils.unescapeJava(this.jtfLanguageEditorTitle.getText()));
			pStrings.setProperty("LanguageName", StringEscapeUtils.unescapeJava(this.jtfLanguageName.getText()));
			pStrings.setProperty("Languages", StringEscapeUtils.unescapeJava(this.jtfLanguages.getText()));
			pStrings.setProperty("Length", StringEscapeUtils.unescapeJava(this.jtfLength.getText()));
			pStrings.setProperty("LoadFail", StringEscapeUtils.unescapeJava(this.jtfLoadFail.getText()));
			pStrings.setProperty("LoadFailTitle", StringEscapeUtils.unescapeJava(this.jtfLoadFailTitle.getText()));
			pStrings.setProperty("MainTitle", StringEscapeUtils.unescapeJava(this.jtfMainTitle.getText()));
			pStrings.setProperty("New", StringEscapeUtils.unescapeJava(this.jtfNew.getText()));
			pStrings.setProperty("Open", StringEscapeUtils.unescapeJava(this.jtfOpen.getText()));
			pStrings.setProperty("PrimaryPassword", StringEscapeUtils.unescapeJava(this.jtfPrimaryPassword.getText()));
			pStrings.setProperty("Randomize", StringEscapeUtils.unescapeJava(this.jtfRandomize.getText()));
			pStrings.setProperty("RestartOK", StringEscapeUtils.unescapeJava(this.jtfRestartOK.getText()));
			pStrings.setProperty("RestartOKTitle", StringEscapeUtils.unescapeJava(this.jtfRestartOKTitle.getText()));
			pStrings.setProperty("Save", StringEscapeUtils.unescapeJava(this.jtfSave.getText()));
			pStrings.setProperty("SaveAs", StringEscapeUtils.unescapeJava(this.jtfSaveAs.getText()));
			pStrings.setProperty("SaveFail", StringEscapeUtils.unescapeJava(this.jtfSaveFail.getText()));
			pStrings.setProperty("SaveFailTitle", StringEscapeUtils.unescapeJava(this.jtfSaveFailTitle.getText()));
			pStrings.setProperty("SecondaryPassword", StringEscapeUtils.unescapeJava(this.jtfSecondaryPassword.getText()));
			
			pStrings.store(osOutput, null);
			osOutput.close();
		}
		catch(IOException IO)
		{
			IO.printStackTrace();
			JOptionPane.showMessageDialog(this.jDialog,
					this.sSaveError, this.sSaveErrorTitle,
					JOptionPane.ERROR_MESSAGE);
			System.exit(-21);
		}
	}
}