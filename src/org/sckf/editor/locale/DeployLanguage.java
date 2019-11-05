package org.sckf.editor.locale;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import javax.swing.JOptionPane;

public class DeployLanguage
{
	private String sLangCode;
	
	@SuppressWarnings("resource")
	public DeployLanguage()
	{
		String sCfgFile = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "config.properties";
		File fCfgFile = new File(sCfgFile);
		
		if(fCfgFile.exists() && fCfgFile.isFile())
		{
			try
			{
				InputStream isInput = new FileInputStream(fCfgFile);
				Properties pCfgString = new Properties();
				
				pCfgString.load(isInput);
				
				this.sLangCode = pCfgString.getProperty("LanguageCode");
				
				isInput.close();
			}
			catch(IOException IO)
			{
				JOptionPane.showMessageDialog(null, "Failed to read configuration file.",
						"Error", JOptionPane.ERROR_MESSAGE);
				IO.printStackTrace();
				System.exit(-3);
			}
		}
		else
		{
			String sThisJarFile = System.getProperty("java.class.path");
			
			try
			{
				JarFile jfJarFile = new JarFile(sThisJarFile, true);
				ZipEntry zeZip = jfJarFile.getEntry("org/sckf/editor/locale/config.properties");
				
				if(zeZip != null)
				{
					String sAppPath = System.getProperty("user.dir");
					File fCfgDestination = new File(sAppPath, zeZip.getName());
					fCfgDestination = new File(sAppPath, fCfgDestination.getName());
					
					try
					{
						InputStream isInput = new BufferedInputStream(jfJarFile.getInputStream(zeZip));
						OutputStream osOutput = new BufferedOutputStream(new FileOutputStream(fCfgDestination));
						
						byte bBuffer[] = new byte[2048];
						
						for(;;)
						{
							int nBytes = isInput.read(bBuffer);
							
							if(nBytes <= 0)
							{
								break;
							}
							
							osOutput.write(bBuffer, 0, nBytes);
						}
						
						osOutput.flush();
						osOutput.close();
						isInput.close();
						
						this.sLangCode = "en";
					}
					catch(IOException IO)
					{
						JOptionPane.showMessageDialog(null, "An error occured while trying to write the configuration file.",
								"Error", JOptionPane.ERROR_MESSAGE);
						IO.printStackTrace();
						System.exit(-4);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error obtaining jar handle", "Init Error", JOptionPane.ERROR_MESSAGE);
					System.exit(-5);
				}
			}
			catch(IOException IO)
			{
				IO.printStackTrace();
				System.exit(-6);
			}
		}
		
		File fLangDir = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "langs");
		
		if(!fLangDir.isDirectory() && !fLangDir.exists())
		{
			if(fLangDir.mkdir())
			{
				String sAppName = System.getProperty("java.class.path");
				
				try
				{
					JarFile Jar = new JarFile(sAppName, true);
					ZipEntry zEntry = Jar.getEntry("org/sckf/editor/locale/en.properties");
					
					if(zEntry != null)
					{
						String sLangDir = System.getProperty("user.dir") + System.getProperty("file.separator")
						+ "langs";
						File fEnFile = new File(sLangDir, zEntry.getName());
						fEnFile = new File(sLangDir, fEnFile.getName());
						
						try
						{
							InputStream isInput = new BufferedInputStream(Jar.getInputStream(zEntry));
							OutputStream osOutput = new BufferedOutputStream(new FileOutputStream(fEnFile));
							byte Buffer[] = new byte[2048];
							
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
							
							this.sLangCode = "en";
						}
						catch(IOException IO)
						{
							IO.printStackTrace();
							System.exit(-7);
						}
					}
					else
					{
						System.exit(-8);
					}
				}
				catch(IOException IO)
				{
					IO.printStackTrace();
					System.exit(-9);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Failed to create required directories.",
						"Error", JOptionPane.ERROR_MESSAGE);
				System.exit(-10);
			}
		}
	}
	
	public String getLanguageCode()
	{
		return this.sLangCode;
	}
}