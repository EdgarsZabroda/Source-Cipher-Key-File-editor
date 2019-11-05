package org.sckf.editor.globals;

public class GlobalVariables
{
	private static boolean requireSave;
	private static short offsets[];
	private static String sCurrentFile;
	private static boolean requireSaveLang;
	
	public static boolean getRequireSaveLang()
	{
		return GlobalVariables.requireSaveLang;
	}
	
	public static void setRequireSaveLang(boolean bBoolean)
	{
		GlobalVariables.requireSaveLang = bBoolean;
	}
	
	public static boolean getRequireSave()
	{
		return GlobalVariables.requireSave;
	}
	
	public static void setRequireSave(boolean bBoolean)
	{
		GlobalVariables.requireSave = bBoolean;
	}
	
	public static short[] getOffsets()
	{
		return GlobalVariables.offsets;
	}
	
	public static void setOffsets(short offsets[])
	{
		GlobalVariables.offsets = offsets;
	}
	
	public static String getCurrentFile()
	{
		return GlobalVariables.sCurrentFile;
	}
	
	public static void setCurrentFile(String sCurrentFile)
	{
		GlobalVariables.sCurrentFile = sCurrentFile;
	}
}