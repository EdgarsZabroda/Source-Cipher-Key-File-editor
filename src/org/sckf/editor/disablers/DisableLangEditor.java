package org.sckf.editor.disablers;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DisableLangEditor implements DocumentListener
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
	private JButton jbSave;
	
	public DisableLangEditor(JTextField jtfLangCode,JTextField jtfAskToSave, JTextField jtfAskToSaveTitle,
		JTextField jtfAbout, JTextField jtfExit, JTextField jtfFile,
		JTextField jtfHelp, JTextField jtfHelpTopics, JTextField jtfLanguageEditor,
		JTextField jtfLanguageEditorTitle, JTextField jtfLanguage, JTextField jtfLanguageCode,
		JTextField jtfLanguageName, JTextField jtfLanguages, JTextField jtfLength,
		JTextField jtfLoadFail, JTextField jtfLoadFailTitle, JTextField jtfMainTitle,
		JTextField jtfNew, JTextField jtfOpen, JTextField jtfPrimaryPassword,
		JTextField jtfRandomize, JTextField jtfRestartOK, JTextField jtfRestartOKTitle,
		JTextField jtfSave, JTextField jtfSaveAs, JTextField jtfSaveFail,
		JTextField jtfSaveFailTitle, JTextField jtfSecondaryPassword, JButton jbSave)
	{
		this.jbSave = jbSave;
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
	}
	
	private void commit(DocumentEvent de)
	{
		DocumentEvent.EventType eventType = de.getType();
		
		if(eventType.equals(DocumentEvent.EventType.CHANGE))
		{
			if(!this.jtfAbout.getText().isEmpty())
			{
				if(!this.jtfAskToSave.getText().isEmpty())
				{
					if(!this.jtfAskToSaveTitle.getText().isEmpty())
					{
						if(!this.jtfExit.getText().isEmpty())
						{
							if(!this.jtfFile.getText().isEmpty())
							{
								if(!this.jtfHelp.getText().isEmpty())
								{
									if(!this.jtfHelpTopics.getText().isEmpty())
									{
										if(!this.jtfLangCode.getText().isEmpty())
										{
											if(!this.jtfLanguage.getText().isEmpty())
											{
												if(!this.jtfLanguageCode.getText().isEmpty())
												{
													if(!this.jtfLanguageEditor.getText().isEmpty())
													{
														if(!this.jtfLanguageEditorTitle.getText().isEmpty())
														{
															if(!this.jtfLanguageName.getText().isEmpty())
															{
																if(!this.jtfLanguages.getText().isEmpty())
																{
																	if(!this.jtfLength.getText().isEmpty())
																	{
																		if(!this.jtfLoadFail.getText().isEmpty())
																		{
																			if(!this.jtfLoadFailTitle.getText().isEmpty())
																			{
																				if(!this.jtfMainTitle.getText().isEmpty())
																				{
																					if(!this.jtfNew.getText().isEmpty())
																					{
																						if(!this.jtfOpen.getText().isEmpty())
																						{
																							if(!this.jtfPrimaryPassword.getText().isEmpty())
																							{
																								if(!this.jtfRandomize.getText().isEmpty())
																								{
																									if(!this.jtfRestartOK.getText().isEmpty())
																									{
																										if(!this.jtfRestartOKTitle.getText().isEmpty())
																										{
																											if(!this.jtfSave.getText().isEmpty())
																											{
																												if(!this.jtfSaveAs.getText().isEmpty())
																												{
																													if(!this.jtfSaveFail.getText().isEmpty())
																													{
																														if(!this.jtfSaveFailTitle.getText().isEmpty())
																														{
																															if(!this.jtfSecondaryPassword.getText().isEmpty())
																															{
																																this.jbSave.setEnabled(true);
																															}
																															else
																															{
																																this.jbSave.setEnabled(false);
																															}
																														}
																														else
																														{
																															this.jbSave.setEnabled(false);
																														}
																													}
																													else
																													{
																														this.jbSave.setEnabled(false);
																													}
																												}
																												else
																												{
																													this.jbSave.setEnabled(false);
																												}
																											}
																											else
																											{
																												this.jbSave.setEnabled(false);
																											}
																										}
																										else
																										{
																											this.jbSave.setEnabled(false);
																										}
																									}
																									else
																									{
																										this.jbSave.setEnabled(false);
																									}
																								}
																								else
																								{
																									this.jbSave.setEnabled(false);
																								}
																							}
																							else
																							{
																								this.jbSave.setEnabled(false);
																							}
																						}
																						else
																						{
																							this.jbSave.setEnabled(false);
																						}
																					}
																					else
																					{
																						this.jbSave.setEnabled(false);
																					}
																				}
																				else
																				{
																					this.jbSave.setEnabled(false);
																				}
																			}
																			else
																			{
																				this.jbSave.setEnabled(false);
																			}
																		}
																		else
																		{
																			this.jbSave.setEnabled(false);
																		}
																	}
																	else
																	{
																		this.jbSave.setEnabled(false);
																	}
																}
																else
																{
																	this.jbSave.setEnabled(false);
																}
															}else
															{
																this.jbSave.setEnabled(false);
															}
														}else
														{
															this.jbSave.setEnabled(false);
														}
													}else
													{
														this.jbSave.setEnabled(false);
													}
												}else
												{
													this.jbSave.setEnabled(false);
												}
											}
											else
											{
												this.jbSave.setEnabled(false);
											}
										}
										else
										{
											this.jbSave.setEnabled(false);
										}
									}
									else
									{
										this.jbSave.setEnabled(false);
									}
								}
								else
								{
									this.jbSave.setEnabled(false);
								}
							}
							else
							{
								this.jbSave.setEnabled(false);
							}
						}
						else
						{
							this.jbSave.setEnabled(false);
						}
					}
					else
					{
						this.jbSave.setEnabled(false);
					}
				}
				else
				{
					this.jbSave.setEnabled(false);
				}
			}
			else
			{
				this.jbSave.setEnabled(false);
			}
		}
		else if(eventType.equals(DocumentEvent.EventType.INSERT))
		{
			if(!this.jtfAbout.getText().isEmpty())
			{
				if(!this.jtfAskToSave.getText().isEmpty())
				{
					if(!this.jtfAskToSaveTitle.getText().isEmpty())
					{
						if(!this.jtfExit.getText().isEmpty())
						{
							if(!this.jtfFile.getText().isEmpty())
							{
								if(!this.jtfHelp.getText().isEmpty())
								{
									if(!this.jtfHelpTopics.getText().isEmpty())
									{
										if(!this.jtfLangCode.getText().isEmpty())
										{
											if(!this.jtfLanguage.getText().isEmpty())
											{
												if(!this.jtfLanguageCode.getText().isEmpty())
												{
													if(!this.jtfLanguageEditor.getText().isEmpty())
													{
														if(!this.jtfLanguageEditorTitle.getText().isEmpty())
														{
															if(!this.jtfLanguageName.getText().isEmpty())
															{
																if(!this.jtfLanguages.getText().isEmpty())
																{
																	if(!this.jtfLength.getText().isEmpty())
																	{
																		if(!this.jtfLoadFail.getText().isEmpty())
																		{
																			if(!this.jtfLoadFailTitle.getText().isEmpty())
																			{
																				if(!this.jtfMainTitle.getText().isEmpty())
																				{
																					if(!this.jtfNew.getText().isEmpty())
																					{
																						if(!this.jtfOpen.getText().isEmpty())
																						{
																							if(!this.jtfPrimaryPassword.getText().isEmpty())
																							{
																								if(!this.jtfRandomize.getText().isEmpty())
																								{
																									if(!this.jtfRestartOK.getText().isEmpty())
																									{
																										if(!this.jtfRestartOKTitle.getText().isEmpty())
																										{
																											if(!this.jtfSave.getText().isEmpty())
																											{
																												if(!this.jtfSaveAs.getText().isEmpty())
																												{
																													if(!this.jtfSaveFail.getText().isEmpty())
																													{
																														if(!this.jtfSaveFailTitle.getText().isEmpty())
																														{
																															if(!this.jtfSecondaryPassword.getText().isEmpty())
																															{
																																this.jbSave.setEnabled(true);
																															}
																															else
																															{
																																this.jbSave.setEnabled(false);
																															}
																														}
																														else
																														{
																															this.jbSave.setEnabled(false);
																														}
																													}
																													else
																													{
																														this.jbSave.setEnabled(false);
																													}
																												}
																												else
																												{
																													this.jbSave.setEnabled(false);
																												}
																											}
																											else
																											{
																												this.jbSave.setEnabled(false);
																											}
																										}
																										else
																										{
																											this.jbSave.setEnabled(false);
																										}
																									}
																									else
																									{
																										this.jbSave.setEnabled(false);
																									}
																								}
																								else
																								{
																									this.jbSave.setEnabled(false);
																								}
																							}
																							else
																							{
																								this.jbSave.setEnabled(false);
																							}
																						}
																						else
																						{
																							this.jbSave.setEnabled(false);
																						}
																					}
																					else
																					{
																						this.jbSave.setEnabled(false);
																					}
																				}
																				else
																				{
																					this.jbSave.setEnabled(false);
																				}
																			}
																			else
																			{
																				this.jbSave.setEnabled(false);
																			}
																		}
																		else
																		{
																			this.jbSave.setEnabled(false);
																		}
																	}
																	else
																	{
																		this.jbSave.setEnabled(false);
																	}
																}
																else
																{
																	this.jbSave.setEnabled(false);
																}
															}else
															{
																this.jbSave.setEnabled(false);
															}
														}else
														{
															this.jbSave.setEnabled(false);
														}
													}else
													{
														this.jbSave.setEnabled(false);
													}
												}else
												{
													this.jbSave.setEnabled(false);
												}
											}
											else
											{
												this.jbSave.setEnabled(false);
											}
										}
										else
										{
											this.jbSave.setEnabled(false);
										}
									}
									else
									{
										this.jbSave.setEnabled(false);
									}
								}
								else
								{
									this.jbSave.setEnabled(false);
								}
							}
							else
							{
								this.jbSave.setEnabled(false);
							}
						}
						else
						{
							this.jbSave.setEnabled(false);
						}
					}
					else
					{
						this.jbSave.setEnabled(false);
					}
				}
				else
				{
					this.jbSave.setEnabled(false);
				}
			}
			else
			{
				this.jbSave.setEnabled(false);
			}
		}
		else if(eventType.equals(DocumentEvent.EventType.REMOVE))
		{
			if(!this.jtfAbout.getText().isEmpty())
			{
				if(!this.jtfAskToSave.getText().isEmpty())
				{
					if(!this.jtfAskToSaveTitle.getText().isEmpty())
					{
						if(!this.jtfExit.getText().isEmpty())
						{
							if(!this.jtfFile.getText().isEmpty())
							{
								if(!this.jtfHelp.getText().isEmpty())
								{
									if(!this.jtfHelpTopics.getText().isEmpty())
									{
										if(!this.jtfLangCode.getText().isEmpty())
										{
											if(!this.jtfLanguage.getText().isEmpty())
											{
												if(!this.jtfLanguageCode.getText().isEmpty())
												{
													if(!this.jtfLanguageEditor.getText().isEmpty())
													{
														if(!this.jtfLanguageEditorTitle.getText().isEmpty())
														{
															if(!this.jtfLanguageName.getText().isEmpty())
															{
																if(!this.jtfLanguages.getText().isEmpty())
																{
																	if(!this.jtfLength.getText().isEmpty())
																	{
																		if(!this.jtfLoadFail.getText().isEmpty())
																		{
																			if(!this.jtfLoadFailTitle.getText().isEmpty())
																			{
																				if(!this.jtfMainTitle.getText().isEmpty())
																				{
																					if(!this.jtfNew.getText().isEmpty())
																					{
																						if(!this.jtfOpen.getText().isEmpty())
																						{
																							if(!this.jtfPrimaryPassword.getText().isEmpty())
																							{
																								if(!this.jtfRandomize.getText().isEmpty())
																								{
																									if(!this.jtfRestartOK.getText().isEmpty())
																									{
																										if(!this.jtfRestartOKTitle.getText().isEmpty())
																										{
																											if(!this.jtfSave.getText().isEmpty())
																											{
																												if(!this.jtfSaveAs.getText().isEmpty())
																												{
																													if(!this.jtfSaveFail.getText().isEmpty())
																													{
																														if(!this.jtfSaveFailTitle.getText().isEmpty())
																														{
																															if(!this.jtfSecondaryPassword.getText().isEmpty())
																															{
																																this.jbSave.setEnabled(true);
																															}
																															else
																															{
																																this.jbSave.setEnabled(false);
																															}
																														}
																														else
																														{
																															this.jbSave.setEnabled(false);
																														}
																													}
																													else
																													{
																														this.jbSave.setEnabled(false);
																													}
																												}
																												else
																												{
																													this.jbSave.setEnabled(false);
																												}
																											}
																											else
																											{
																												this.jbSave.setEnabled(false);
																											}
																										}
																										else
																										{
																											this.jbSave.setEnabled(false);
																										}
																									}
																									else
																									{
																										this.jbSave.setEnabled(false);
																									}
																								}
																								else
																								{
																									this.jbSave.setEnabled(false);
																								}
																							}
																							else
																							{
																								this.jbSave.setEnabled(false);
																							}
																						}
																						else
																						{
																							this.jbSave.setEnabled(false);
																						}
																					}
																					else
																					{
																						this.jbSave.setEnabled(false);
																					}
																				}
																				else
																				{
																					this.jbSave.setEnabled(false);
																				}
																			}
																			else
																			{
																				this.jbSave.setEnabled(false);
																			}
																		}
																		else
																		{
																			this.jbSave.setEnabled(false);
																		}
																	}
																	else
																	{
																		this.jbSave.setEnabled(false);
																	}
																}
																else
																{
																	this.jbSave.setEnabled(false);
																}
															}else
															{
																this.jbSave.setEnabled(false);
															}
														}else
														{
															this.jbSave.setEnabled(false);
														}
													}else
													{
														this.jbSave.setEnabled(false);
													}
												}else
												{
													this.jbSave.setEnabled(false);
												}
											}
											else
											{
												this.jbSave.setEnabled(false);
											}
										}
										else
										{
											this.jbSave.setEnabled(false);
										}
									}
									else
									{
										this.jbSave.setEnabled(false);
									}
								}
								else
								{
									this.jbSave.setEnabled(false);
								}
							}
							else
							{
								this.jbSave.setEnabled(false);
							}
						}
						else
						{
							this.jbSave.setEnabled(false);
						}
					}
					else
					{
						this.jbSave.setEnabled(false);
					}
				}
				else
				{
					this.jbSave.setEnabled(false);
				}
			}
			else
			{
				this.jbSave.setEnabled(false);
			}
		}
	}
	
	@Override
	public void changedUpdate(DocumentEvent DE)
	{
		this.commit(DE);
	}
	
	@Override
	public void insertUpdate(DocumentEvent DE)
	{
		this.commit(DE);
	}
	
	@Override
	public void removeUpdate(DocumentEvent DE)
	{
		this.commit(DE);
	}
}