package org.sckf.editor.listeners.menu;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SpawnHelpTopics implements ActionListener
{
	private JFrame jfParent;
	
	public SpawnHelpTopics(JFrame jfParent)
	{
		this.jfParent = jfParent;
	}
	
	@SuppressWarnings("resource")
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		String sJarFile = System.getProperty("java.class.path");
		
		try
		{
			JarFile jarFile = new JarFile(sJarFile, true);
			ZipEntry zEntry = jarFile.getEntry("org/sckf/editor/listeners/menu/help.pdf");
			
			if(zEntry != null)
			{
				String sThisDir = System.getProperty("user.dir");
				File fHelpFile = new File(sThisDir, zEntry.getName());
				fHelpFile = new File(sThisDir, fHelpFile.getName());
				
				if(fHelpFile.exists())
				{
					if(fHelpFile.isFile())
					{
						if(Desktop.isDesktopSupported())
						{
							Desktop.getDesktop().open(fHelpFile);
						}
						else
						{
							JOptionPane.showMessageDialog(this.jfParent, "Error opening file.",
									"Error!", JOptionPane.ERROR_MESSAGE);
							System.exit(-50);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this.jfParent, "Found a directory with the same name, "
								+ "please delete this directory or move it somewhere else.", 
								"Warning!", JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{
					try
					{
						InputStream isInput = new BufferedInputStream(jarFile.getInputStream(zEntry));
						OutputStream osOutput = new BufferedOutputStream(new FileOutputStream(fHelpFile));
						byte Buffer[] = new byte[512];
						
						for(;;)
						{
							int nBytes = isInput.read(Buffer);
							
							if(nBytes <= 0)
							{
								break;
							}
							
							osOutput.write(Buffer, 0, nBytes);
						}
						
						osOutput.flush();
						osOutput.close();
						isInput.close();
					}
					catch(IOException IO)
					{
						IO.printStackTrace();
						JOptionPane.showMessageDialog(this.jfParent, "Error occured while extracting the help file.",
								"Error!", JOptionPane.ERROR_MESSAGE);
						System.exit(-51);
					}
					
					if(Desktop.isDesktopSupported())
					{
						Desktop.getDesktop().open(fHelpFile);
					}
					else
					{
						JOptionPane.showMessageDialog(this.jfParent, "Error opening file.",
								"Error!", JOptionPane.ERROR_MESSAGE);
						System.exit(-52);
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this.jfParent, "ZipEntry zEntry is null.",
						"Error!", JOptionPane.ERROR_MESSAGE);
				System.exit(-53);
			}
		}
		catch(IOException IO)
		{
			IO.printStackTrace();
			JOptionPane.showMessageDialog(this.jfParent, "Error occured while extracting the help file.",
					"Error!", JOptionPane.ERROR_MESSAGE);
			System.exit(-54);
		}
	}
}