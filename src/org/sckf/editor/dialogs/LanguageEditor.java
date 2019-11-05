package org.sckf.editor.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultStyledDocument;

import org.apache.commons.lang3.StringEscapeUtils;
import org.sckf.editor.disablers.DisableLangEditor;
import org.sckf.editor.listeners.dialog.LoadLangFile;
import org.sckf.editor.listeners.dialog.SaveLangFile;
import org.sckf.editor.locale.DeployLanguage;
import org.sckf.editor.locale.Language;
import org.sckf.editor.spectators.DocumentSizeFilter;

@SuppressWarnings("deprecation")
public class LanguageEditor extends JDialog
{
	private static final long serialVersionUID = 0x1337DEADL;
	
	public LanguageEditor(JFrame jfParent, boolean bModal)
	{
		super(jfParent, bModal);
		
		DeployLanguage dlLangCode = new DeployLanguage();
		Language lLang = new Language(dlLangCode.getLanguageCode());
		
		setSize(256, 512);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(StringEscapeUtils.unescapeJava(lLang.getLangEditorTitle()));
		
		JLabel jlLangCode = new JLabel(StringEscapeUtils.unescapeJava(lLang.getLanguageCode()));
		JLabel jlAbout = new JLabel("About");
		JLabel jlAskToSave = new JLabel("AskToSave");
		JLabel jlAskToSaveTitle = new JLabel("AskToSaveTitle");
		JLabel jlExit = new JLabel("Exit");
		JLabel jlFile = new JLabel("File");
		JLabel jlHelp = new JLabel("Help");
		JLabel jlHelpTopics = new JLabel("HelpTopics");
		JLabel jlLanguage = new JLabel("Language");
		JLabel jlLanguageCode = new JLabel("LanguageCode");
		JLabel jlLanguageEditor = new JLabel("LanguageEditor");
		JLabel jlLanguageEditorTitle = new JLabel("LanguageEditorTitle");
		JLabel jlLanguageName = new JLabel("LanguageName");
		JLabel jlLanguages = new JLabel("Languages");
		JLabel jlLength = new JLabel("Length");
		JLabel jlLoadFail = new JLabel("LoadFail");
		JLabel jlLoadFailTitle = new JLabel("LoadFailTitle");
		JLabel jlMainTitle = new JLabel("MainTitle");
		JLabel jlNew = new JLabel("New");
		JLabel jlOpen = new JLabel("Open");
		JLabel jlPrimaryPassword = new JLabel("PrimaryPassword");
		JLabel jlRandomize = new JLabel("Randomize");
		JLabel jlRestartOK = new JLabel("RestartOK");
		JLabel jlRestartOKTitle = new JLabel("RestartOKTitle");
		JLabel jlSave = new JLabel("Save");
		JLabel jlSaveAs = new JLabel("SaveAs");
		JLabel jlSaveFail = new JLabel("SaveFail");
		JLabel jlSaveFailTitle = new JLabel("SaveFailTitle");
		JLabel jlSecondaryPassword = new JLabel("SecondaryPassword");
		
		JTextField jtfLangCode = new JTextField(20);
		JTextField jtfAbout = new JTextField(20);
		JTextField jtfAskToSave = new JTextField(20);
		JTextField jtfAskToSaveTitle = new JTextField(20);
		JTextField jtfExit = new JTextField(20);
		JTextField jtfFile = new JTextField(20);
		JTextField jtfHelp = new JTextField(20);
		JTextField jtfHelpTopics = new JTextField(20);
		JTextField jtfLanguage = new JTextField(20);
		JTextField jtfLanguageCode = new JTextField(20);
		JTextField jtfLanguageEditor = new JTextField(20);
		JTextField jtfLanguageEditorTitle = new JTextField(20);
		JTextField jtfLanguageName = new JTextField(20);
		JTextField jtfLanguages = new JTextField(20);
		JTextField jtfLength = new JTextField(20);
		JTextField jtfLoadFail = new JTextField(20);
		JTextField jtfLoadFailTitle = new JTextField(20);
		JTextField jtfMainTitle = new JTextField(20);
		JTextField jtfNew = new JTextField(20);
		JTextField jtfOpen = new JTextField(20);
		JTextField jtfPrimaryPassword = new JTextField(20);
		JTextField jtfRandomize = new JTextField(20);
		JTextField jtfRestartOK = new JTextField(20);
		JTextField jtfRestartOKTitle = new JTextField(20);
		JTextField jtfSave = new JTextField(20);
		JTextField jtfSaveAs = new JTextField(20);
		JTextField jtfSaveFail = new JTextField(20);
		JTextField jtfSaveFailTitle = new JTextField(20);
		JTextField jtfSecondaryPassword = new JTextField(20);
		
		JButton jbLoad = new JButton(StringEscapeUtils.unescapeJava(lLang.getOpen()));
		JButton jbSave = new JButton(StringEscapeUtils.unescapeJava(lLang.getSave()));
		
		String sSaveFail = StringEscapeUtils.unescapeJava(lLang.getSaveFail());
		String sSaveFailTitle = StringEscapeUtils.unescapeJava(lLang.getSaveFailTitle());
		String sOpen = StringEscapeUtils.unescapeJava(lLang.getOpen());
		String sLoadFail = StringEscapeUtils.unescapeJava(lLang.getLoadFail());
		String sLoadFailTitle = StringEscapeUtils.unescapeJava(lLang.getLoadFailTitle());
		
		jtfLangCode.setMinimumSize(new Dimension(128, 30));
		jtfAbout.setMinimumSize(new Dimension(128, 30));
		jtfAskToSave.setMinimumSize(new Dimension(128, 30));
		jtfAskToSaveTitle.setMinimumSize(new Dimension(128, 30));
		jtfExit.setMinimumSize(new Dimension(128, 30));
		jtfFile.setMinimumSize(new Dimension(128, 30));
		jtfHelp.setMinimumSize(new Dimension(128, 30));
		jtfHelpTopics.setMinimumSize(new Dimension(128, 30));
		jtfLanguageCode.setMinimumSize(new Dimension(128, 30));
		jtfLanguage.setMinimumSize(new Dimension(128, 30));
		jtfLanguageEditor.setMinimumSize(new Dimension(128, 30));
		jtfLanguageEditorTitle.setMinimumSize(new Dimension(128, 30));
		jtfLanguageName.setMinimumSize(new Dimension(128, 30));
		jtfLanguages.setMinimumSize(new Dimension(128, 30));
		jtfLength.setMinimumSize(new Dimension(128, 30));
		jtfLoadFail.setMinimumSize(new Dimension(128, 30));
		jtfLoadFailTitle.setMinimumSize(new Dimension(128, 30));
		jtfMainTitle.setMinimumSize(new Dimension(128, 30));
		jtfNew.setMinimumSize(new Dimension(128, 30));
		jtfOpen.setMinimumSize(new Dimension(128, 30));
		jtfPrimaryPassword.setMinimumSize(new Dimension(128, 30));
		jtfRandomize.setMinimumSize(new Dimension(128, 30));
		jtfRestartOK.setMinimumSize(new Dimension(128, 30));
		jtfRestartOKTitle.setMinimumSize(new Dimension(128, 30));
		jtfSave.setMinimumSize(new Dimension(128, 30));
		jtfSaveAs.setMinimumSize(new Dimension(128, 30));
		jtfSaveFail.setMinimumSize(new Dimension(128, 30));
		jtfSaveFailTitle.setMinimumSize(new Dimension(128, 30));
		jtfSecondaryPassword.setMinimumSize(new Dimension(128, 30));
		
		jbLoad.addActionListener(new LoadLangFile(jtfLangCode, jtfAskToSave, jtfAskToSaveTitle,
				jtfAbout, jtfExit, jtfFile, jtfHelp, jtfHelpTopics,
				jtfLanguageEditor, jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode, jtfLanguageName,
				jtfLanguages, jtfLength, jtfLoadFail, jtfLoadFailTitle,
				jtfMainTitle, jtfNew, jtfOpen, jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword,
				sLoadFail, sLoadFailTitle, this, sOpen));
		
		jbSave.addActionListener(new SaveLangFile(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword,
				sSaveFail, sSaveFailTitle, this));
		jbSave.setEnabled(false);
		
		DefaultStyledDocument dsdDocument = new DefaultStyledDocument();
		
		dsdDocument.setDocumentFilter(new DocumentSizeFilter(2));
		dsdDocument.addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLangCode.setDocument(dsdDocument);
		
		jtfAbout.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfAskToSave.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfAskToSaveTitle.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfExit.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfFile.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfHelp.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfHelpTopics.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLanguageCode.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLanguage.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLanguageEditor.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLanguageEditorTitle.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLanguageName.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLanguages.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLength.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLoadFail.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfLoadFailTitle.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfMainTitle.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfNew.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfOpen.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfPrimaryPassword.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfRandomize.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfRestartOK.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfRestartOKTitle.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfSave.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfSaveAs.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfSaveFail.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfSaveFailTitle.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		jtfSecondaryPassword.getDocument().addDocumentListener(new DisableLangEditor(jtfLangCode,
				jtfAskToSave, jtfAskToSaveTitle, jtfAbout, jtfExit,
				jtfFile, jtfHelp, jtfHelpTopics, jtfLanguageEditor,
				jtfLanguageEditorTitle, jtfLanguage, jtfLanguageCode,
				jtfLanguageName, jtfLanguages, jtfLength, jtfLoadFail,
				jtfLoadFailTitle, jtfMainTitle, jtfNew, jtfOpen,
				jtfPrimaryPassword, jtfRandomize, jtfRestartOK, jtfRestartOKTitle,
				jtfSave, jtfSaveAs, jtfSaveFail, jtfSaveFailTitle, jtfSecondaryPassword, jbSave));
		
		JPanel jpScrollable = new JPanel();
		
		jpScrollable.setPreferredSize(new Dimension(512, 1124));
		jpScrollable.setLayout(new GridBagLayout());
		
		JScrollPane jspScrollable = new JScrollPane(jpScrollable,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		jspScrollable.setPreferredSize(new Dimension(512, 256));
		
		GridBagConstraints gbcScrollable = new GridBagConstraints();
		
		gbcScrollable.anchor = GridBagConstraints.WEST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 0;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLangCode, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 0;
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLangCode, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 1;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlAbout, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 1;
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfAbout, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 2;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlAskToSave, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 2;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfAskToSave, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 3;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlAskToSaveTitle, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 3;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfAskToSaveTitle, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 4;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlExit, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 4;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfExit, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 5;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlFile, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 5;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfFile, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 6;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlHelp, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 6;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfHelp, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 7;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlHelpTopics, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 7;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfHelpTopics, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 8;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLanguage, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 8;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLanguage, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 9;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLanguageCode, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 9;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLanguageCode, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 10;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLanguageEditor, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 10;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLanguageEditor, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 11;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLanguageEditorTitle, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 11;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLanguageEditorTitle, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 12;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLanguageName, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 12;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLanguageName, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 13;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLanguages, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 13;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLanguages, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 14;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLength, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 14;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLength, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 15;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLoadFail, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 15;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLoadFail, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 16;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlLoadFailTitle, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 16;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfLoadFailTitle, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 17;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlMainTitle, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 17;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfMainTitle, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 18;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlNew, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 18;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfNew, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 19;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlOpen, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 19;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfOpen, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 20;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlPrimaryPassword, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 20;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfPrimaryPassword, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 21;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlRandomize, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 21;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfRandomize, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 22;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlRestartOK, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 22;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfRestartOK, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 23;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlRestartOKTitle, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 23;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfRestartOKTitle, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 24;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlSave, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 24;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfSave, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 25;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlSaveAs, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 25;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfSaveAs, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 26;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlSaveFail, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 26;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfSaveFail, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 27;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlSaveFailTitle, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 27;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfSaveFailTitle, gbcScrollable);
		
		gbcScrollable.anchor = GridBagConstraints.EAST;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 0;
		gbcScrollable.gridy = 28;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jlSecondaryPassword, gbcScrollable);
		
		gbcScrollable.fill = GridBagConstraints.HORIZONTAL;
		gbcScrollable.anchor = GridBagConstraints.CENTER;
		gbcScrollable.gridheight = 1;
		gbcScrollable.gridwidth = 1;
		gbcScrollable.gridx = 1;
		gbcScrollable.gridy = 28;
		gbcScrollable.insets = new Insets(5, 5, 5, 5);
		
		jpScrollable.add(jtfSecondaryPassword, gbcScrollable);
		jpScrollable.revalidate();
		jpScrollable.repaint();
		
		JPanel jpButtons = new JPanel();
		
		jpButtons.setLayout(new GridBagLayout());
		
		GridBagConstraints gbcButtons = new GridBagConstraints();
		
		gbcButtons.anchor = GridBagConstraints.CENTER;
		gbcButtons.gridheight = 1;
		gbcButtons.gridwidth = 1;
		gbcButtons.gridx = 0;
		gbcButtons.gridy = 0;
		gbcButtons.insets = new Insets(5, 5, 5, 5);
		
		jpButtons.add(jbLoad, gbcButtons);
		
		gbcButtons.anchor = GridBagConstraints.CENTER;
		gbcButtons.gridheight = 1;
		gbcButtons.gridwidth = 1;
		gbcButtons.gridx = 1;
		gbcButtons.gridy = 0;
		gbcButtons.insets = new Insets(5, 5, 5, 5);
		
		jpButtons.add(jbSave, gbcButtons);
		jpButtons.revalidate();
		jpButtons.repaint();
		
		JPanel jpMain = new JPanel();
		
		jpMain.setLayout(new GridBagLayout());
		
		GridBagConstraints gbcMain = new GridBagConstraints();
		
		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.gridheight = 1;
		gbcMain.gridwidth = 1;
		gbcMain.gridx = 0;
		gbcMain.gridy = 0;
		
		jpMain.add(jspScrollable, gbcMain);
		
		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.gridheight = 1;
		gbcMain.gridwidth = 1;
		gbcMain.gridx = 0;
		gbcMain.gridy = 1;
		
		jpMain.add(jpButtons, gbcMain);
		
		jpMain.revalidate();
		jpMain.repaint();
		
		getContentPane().add(jpMain, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}
}