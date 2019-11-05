package org.sckf.editor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.DefaultStyledDocument;

import org.apache.commons.lang3.StringEscapeUtils;
import org.sckf.editor.disablers.DisableMainWindow;
import org.sckf.editor.listeners.CheckListener;
import org.sckf.editor.listeners.menu.ItemExit;
import org.sckf.editor.listeners.menu.ItemNew;
import org.sckf.editor.listeners.menu.ItemOpen;
import org.sckf.editor.listeners.menu.ItemSave;
import org.sckf.editor.listeners.menu.ItemSaveAs;
import org.sckf.editor.listeners.menu.LanguageSelector;
import org.sckf.editor.listeners.menu.SpawnAbout;
import org.sckf.editor.listeners.menu.SpawnHelpTopics;
import org.sckf.editor.listeners.menu.SpawnLanguageEditor;
import org.sckf.editor.locale.DeployLanguage;
import org.sckf.editor.locale.Language;
import org.sckf.editor.spectators.CalculateSize;
import org.sckf.editor.spectators.DocumentSizeFilter;
import org.sckf.editor.spectators.RequireSaveMain;
import org.sckf.editor.spectators.ShuffleIfEnabled;

@SuppressWarnings("deprecation")
public class ExecutingClass extends JFrame
{
	private static final long serialVersionUID = 0x1337B1B1L;
	
	public ExecutingClass()
	{
		DeployLanguage dlLangCode = new DeployLanguage();
		Language lStrings  = new Language(dlLangCode.getLanguageCode());
		
		setSize(256, 384);
		setResizable(false);
		setTitle(StringEscapeUtils.unescapeJava(lStrings.getMainTitle()));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel jlLength = new JLabel(StringEscapeUtils.unescapeJava(lStrings.getLength()));
		JLabel jlPrimaryPassword = new JLabel(StringEscapeUtils.unescapeJava(lStrings.getPrimaryPassword()));
		JLabel jlSecondaryPassword = new JLabel(StringEscapeUtils.unescapeJava(lStrings.getSecondaryPassword()));
		
		JCheckBox jcbRandomize = new JCheckBox(StringEscapeUtils.unescapeJava(lStrings.getRandomize()));
		
		JMenuBar jmbMenuBar = new JMenuBar();
		JMenu jmFile = new JMenu(StringEscapeUtils.unescapeJava(lStrings.getFile()));
		JMenuItem jmiNew = new JMenuItem(StringEscapeUtils.unescapeJava(lStrings.getNew()));
		JMenuItem jmiOpen = new JMenuItem(StringEscapeUtils.unescapeJava(lStrings.getOpen()));
		JMenuItem jmiSave = new JMenuItem(StringEscapeUtils.unescapeJava(lStrings.getSave()));
		JMenuItem jmiSaveAs = new JMenuItem(StringEscapeUtils.unescapeJava(lStrings.getSaveAs()));
		JMenuItem jmiExit = new JMenuItem(StringEscapeUtils.unescapeJava(lStrings.getExit()));
		JMenu jmLanguage = new JMenu(StringEscapeUtils.unescapeJava(lStrings.getLanguage()));
		JMenu jmLanguages = new JMenu(StringEscapeUtils.unescapeJava(lStrings.getLanguages()));
		JMenuItem jmiLangEditor = new JMenuItem(StringEscapeUtils.unescapeJava(lStrings.getLangEditor()));
		JMenu jmHelp = new JMenu(StringEscapeUtils.unescapeJava(lStrings.getHelp()));
		JMenuItem jmiHelpTopics = new JMenuItem(StringEscapeUtils.unescapeJava(lStrings.getHelpTopics()));
		JMenuItem jmiAbout = new JMenuItem(StringEscapeUtils.unescapeJava(lStrings.getAbout()));
		
		String sAskToSave = StringEscapeUtils.unescapeJava(lStrings.getAskToSave());
		String sAskToSaveTitle = StringEscapeUtils.unescapeJava(lStrings.getAskToSaveTitle());
		String sSave = StringEscapeUtils.unescapeJava(lStrings.getSave());
		String sOpen = StringEscapeUtils.unescapeJava(lStrings.getOpen());
		String sLoadFail = StringEscapeUtils.unescapeJava(lStrings.getLoadFail());
		String sLoadFailTitle = StringEscapeUtils.escapeJava(lStrings.getLoadFailTitle());
		String sSaveFail = StringEscapeUtils.escapeJava(lStrings.getSaveFail());
		String sSaveFailTitle = StringEscapeUtils.unescapeJava(lStrings.getSaveFailTitle());
		String sRestartOK = StringEscapeUtils.escapeJava(lStrings.getRestartOK());
		String sRestartOKTitle = StringEscapeUtils.escapeJava(lStrings.getRestartOKTitle());
		
		JTextField jtfLength = new JTextField(20);
		
		JTextArea jtaPrimaryPassword = new JTextArea(6, 20);
		JTextArea jtaSecondaryPassword = new JTextArea(6, 20);
		
		jtfLength.setText("0");
		jtfLength.setEditable(false);
		jtaPrimaryPassword.setLineWrap(true);
		jtaPrimaryPassword.setWrapStyleWord(true);
		jtaSecondaryPassword.setLineWrap(true);
		jtaSecondaryPassword.setWrapStyleWord(true);
		
		JScrollPane jspPrimaryPassword = new JScrollPane(jtaPrimaryPassword,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane jspSecondaryPassword = new JScrollPane(jtaSecondaryPassword,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		jmiSave.setEnabled(false);
		jmiSave.setEnabled(false);
		
		jmbMenuBar.add(jmFile);
		
		jmFile.add(jmiNew);
		jmFile.add(jmiOpen);
		jmFile.addSeparator();
		jmFile.add(jmiSave);
		jmFile.add(jmiSaveAs);
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		
		jmbMenuBar.add(jmLanguage);
		
		jmLanguage.add(jmLanguages);
		jmLanguage.addSeparator();
		jmLanguage.add(jmiLangEditor);
		
		jmbMenuBar.add(jmHelp);
		
		jmHelp.add(jmiHelpTopics);
		jmHelp.addSeparator();
		jmHelp.add(jmiAbout);
		
		DefaultStyledDocument dsdDoc = new DefaultStyledDocument();
		
		dsdDoc.setDocumentFilter(new DocumentSizeFilter(512));
		dsdDoc.addDocumentListener(new CalculateSize(jtaPrimaryPassword, jtfLength));
		dsdDoc.addDocumentListener(new DisableMainWindow(jmiSave, jmiSaveAs,
				jtaPrimaryPassword));
		dsdDoc.addDocumentListener(new RequireSaveMain(this, jtaPrimaryPassword,
				jcbRandomize));
		dsdDoc.addDocumentListener(new ShuffleIfEnabled(jtaPrimaryPassword,
				jtaSecondaryPassword, jcbRandomize));
		
		jtaPrimaryPassword.setDocument(dsdDoc);
		jtaSecondaryPassword.setEditable(false);
		
		jmiSave.setEnabled(false);
		jmiSaveAs.setEnabled(false);
		
		jmiNew.addActionListener(new ItemNew(jtaPrimaryPassword,
				jtaSecondaryPassword, jcbRandomize, jtfLength,
				this, sAskToSave,sAskToSaveTitle, sSave));
		jmiOpen.addActionListener(new ItemOpen(jtaPrimaryPassword,
				jtaSecondaryPassword, jtfLength, jcbRandomize,
				sOpen, sSave, sSaveFail, sSaveFailTitle, sLoadFail,
				sLoadFailTitle, this, sAskToSave, sAskToSaveTitle));
		jmiSave.addActionListener(new ItemSave(jtaPrimaryPassword,
				jtfLength, jcbRandomize, this, sSave, sSaveFail,
				sSaveFailTitle));
		jmiSaveAs.addActionListener(new ItemSaveAs(jtaPrimaryPassword,
				jtfLength, jcbRandomize, this, sSave, sSaveFail,
				sSaveFailTitle));
		jmiExit.addActionListener(new ItemExit(sAskToSave, sAskToSaveTitle,
				sSave, sSaveFail, sSaveFailTitle, jtaPrimaryPassword,
				jtfLength, jcbRandomize, this));
		
		File fLangDir = new File(System.getProperty("user.dir") +
				System.getProperty("file.separator") + "langs");
		File fLangs[] = fLangDir.listFiles();
		
		for(File fLangFile :fLangs)
		{
			String sLangCodeFile = fLangFile.getName().substring(0, fLangFile.getName().length() - 11);
			String sCurrentLang = dlLangCode.getLanguageCode();
			String sLangName = null;
			
			try
			{
				InputStream isInput = new FileInputStream(fLangFile.getPath());
				Properties pLangName =  new Properties();
				
				pLangName.load(isInput);
				
				sLangName = pLangName.getProperty(StringEscapeUtils.unescapeJava("LanguageName"));
				
				isInput.close();
			}
			catch(IOException IO)
			{
				IO.printStackTrace();
				System.exit(-30);
			}
			
			JCheckBoxMenuItem jcbLang = new JCheckBoxMenuItem(sLangName);
			
			jcbLang.addActionListener(new LanguageSelector(sRestartOK, sRestartOKTitle, sLoadFail,
					sLoadFailTitle, this));
			jcbLang.setActionCommand(sLangCodeFile);
			jmLanguages.add(jcbLang);
			
			if(sLangCodeFile.equals(sCurrentLang))
			{
				jcbLang.setSelected(true);
			}
		}
		
		jmiLangEditor.addActionListener(new SpawnLanguageEditor(this));
		jmiHelpTopics.addActionListener(new SpawnHelpTopics(this));
		jmiAbout.addActionListener(new SpawnAbout(this));
		jcbRandomize.addActionListener(new CheckListener(jcbRandomize, jtaSecondaryPassword,
				jtaPrimaryPassword));
		
		jmbMenuBar.add(jmFile);
		jmbMenuBar.add(jmLanguage);
		jmbMenuBar.add(jmHelp);
		
		JPanel jPanel = new JPanel();
		
		setJMenuBar(jmbMenuBar);
		
		jPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jcbRandomize, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jlLength, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jtfLength, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jlPrimaryPassword, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jspPrimaryPassword, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jlSecondaryPassword, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jspSecondaryPassword, gbc);
		
		getContentPane().add(jPanel);
		pack();
		setVisible(true);
	}
	
	public static void setLookNFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String sArgs[])
	{
		ExecutingClass ec = new ExecutingClass();
		ExecutingClass.setLookNFeel();
	}
}