package org.sckf.editor.listeners.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.lang3.StringEscapeUtils;

@SuppressWarnings("deprecation")
public class LoadLangFile implements ActionListener
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
	private String sLoadError;
	private String sLoadErrorTitle;
	private String sOpen;
	private JDialog jDialog;
	
	public LoadLangFile(JTextField jtfLangCode,JTextField jtfAskToSave, JTextField jtfAskToSaveTitle,
			JTextField jtfAbout, JTextField jtfExit, JTextField jtfFile,
			JTextField jtfHelp, JTextField jtfHelpTopics, JTextField jtfLanguageEditor,
			JTextField jtfLanguageEditorTitle, JTextField jtfLanguage, JTextField jtfLanguageCode,
			JTextField jtfLanguageName, JTextField jtfLanguages, JTextField jtfLength,
			JTextField jtfLoadFail, JTextField jtfLoadFailTitle, JTextField jtfMainTitle,
			JTextField jtfNew, JTextField jtfOpen, JTextField jtfPrimaryPassword,
			JTextField jtfRandomize, JTextField jtfRestartOK, JTextField jtfRestartOKTitle,
			JTextField jtfSave, JTextField jtfSaveAs, JTextField jtfSaveFail,
			JTextField jtfSaveFailTitle, JTextField jtfSecondaryPassword,
			String sLoadError, String sLoadErrorTitle, JDialog jDialog,
			String sOpen)
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
		this.sLoadError = sLoadError;
		this.sLoadErrorTitle = sLoadErrorTitle;
		this.jDialog = jDialog;
		this.sOpen = sOpen;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		JFileChooser jfcOpenDialog = new JFileChooser(System.getProperty("user.dir") +
				System.getProperty("file.separator") + "langs");
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("Language files (*.properties)", "properties");
		
		jfcOpenDialog.setDialogTitle(this.sOpen);
		jfcOpenDialog.setAcceptAllFileFilterUsed(false);
		jfcOpenDialog.addChoosableFileFilter(fnef);
		
		int nDlgChs = jfcOpenDialog.showOpenDialog(this.jDialog);
		
		if(nDlgChs == JFileChooser.APPROVE_OPTION)
		{
			File fTargetFile = jfcOpenDialog.getSelectedFile();
			
			try
			{
				InputStream isInput = new FileInputStream(fTargetFile.getPath());
				Properties pStrings = new Properties();
				
				pStrings.load(isInput);
				
				this.jtfAbout.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("About")));
				this.jtfAskToSave.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("AskToSave")));
				this.jtfAskToSaveTitle.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("AskToSaveTitle")));
				this.jtfExit.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("Exit")));
				this.jtfFile.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("File")));
				this.jtfHelp.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("Help")));
				this.jtfHelpTopics.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("HelpTopics")));
				this.jtfLangCode.setText(StringEscapeUtils.unescapeJava(fTargetFile.getName().substring(0, fTargetFile.getName().length() - 11)));
				this.jtfLanguage.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("Language")));
				this.jtfLanguageCode.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("LanguageCode")));
				this.jtfLanguageEditor.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("LanguageEditor")));
				this.jtfLanguageEditorTitle.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("LanguageEditorTitle")));
				this.jtfLanguageName.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("LanguageName")));
				this.jtfLanguages.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("Languages")));
				this.jtfLength.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("Length")));
				this.jtfLoadFail.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("LoadFail")));
				this.jtfLoadFailTitle.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("LoadFailTitle")));
				this.jtfMainTitle.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("MainTitle")));
				this.jtfNew.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("New")));
				this.jtfOpen.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("Open")));
				this.jtfPrimaryPassword.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("PrimaryPassword")));
				this.jtfRandomize.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("Randomize")));
				this.jtfRestartOK.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("RestartOK")));
				this.jtfRestartOKTitle.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("RestartOKTitle")));
				this.jtfSave.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("Save")));
				this.jtfSaveAs.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("SaveAs")));
				this.jtfSaveFail.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("SaveFail")));
				this.jtfSaveFailTitle.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("SaveFailTitle")));
				this.jtfSecondaryPassword.setText(StringEscapeUtils.unescapeJava(pStrings.getProperty("SecondaryPassword")));
				
				isInput.close();
			}
			catch(IOException IO)
			{
				IO.printStackTrace();
				JOptionPane.showMessageDialog(this.jDialog, this.sLoadError,
						this.sLoadErrorTitle, JOptionPane.ERROR_MESSAGE);
				System.exit(-23);
			}
		}
	}
}