package org.sckf.editor.spectators;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DocumentSizeFilter extends DocumentFilter
{
	private int nMaxChars;
	
	public DocumentSizeFilter(int nMaxChars)
	{
		this.nMaxChars = nMaxChars;
	}
	
	@Override
	public void insertString(FilterBypass filterBypass, int nOffsets,
			String string, AttributeSet attributeSet) throws BadLocationException
	{
		if((filterBypass.getDocument().getLength() + string.length()) <= this.nMaxChars)
		{
			super.insertString(filterBypass, nOffsets, string, attributeSet);
		}
	}
	
	@Override
	public void replace(FilterBypass filterBypass, int nOffsets, int nLength,
			String string, AttributeSet attributeSet) throws BadLocationException
	{
		if((filterBypass.getDocument().getLength() + string.length()) <= this.nMaxChars)
		{
			super.replace(filterBypass, nOffsets, nLength, string, attributeSet);
		}
	}
}
