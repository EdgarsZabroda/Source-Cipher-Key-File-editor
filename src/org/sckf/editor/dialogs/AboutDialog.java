package org.sckf.editor.dialogs;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.lang3.StringEscapeUtils;
import org.sckf.editor.listeners.dialog.CloseDialog;
import org.sckf.editor.locale.DeployLanguage;
import org.sckf.editor.locale.Language;

@SuppressWarnings("deprecation")
public class AboutDialog extends JDialog
{
	private static final long serialVersionUID = 0xDEDEBED0L;

	public AboutDialog(JFrame jfParent, boolean bModal)
	{
		super(jfParent, bModal);
		
		DeployLanguage dlLangCode = new DeployLanguage();
		Language lLocale = new Language(dlLangCode.getLanguageCode());
		
		setSize(256, 96);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(StringEscapeUtils.unescapeJava(lLocale.getAbout()));
		
		JLabel jlText1 = new JLabel("Source Cipher Key File editor");
		JLabel jlText2 = new JLabel("Version: 2.1.0");
		JLabel jlText3 = new JLabel(StringEscapeUtils.unescapeJava("©2019 Source Projects"));
		
		JButton jbOK = new JButton("OK");
		
		jbOK.addActionListener(new CloseDialog(this));
		
		JPanel jPanel = new JPanel();
		
		jPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jlText1, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jlText2, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.CENTER;
		
		jPanel.add(jlText3, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		
		jPanel.add(jbOK, gbc);
		
		getContentPane().add(jPanel, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}
}