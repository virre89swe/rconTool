package com.rcon.idtech3.controller;

import com.rcon.idtech3.model.SettingsModel;
import com.rcon.idtech3.view.SettingsActionListener;
import com.rcon.idtech3.view.SettingsActionEvent;
import com.rcon.idtech3.view.View;

public class Controller implements SettingsActionListener
{
	@SuppressWarnings("unused")
	private View view;
	private SettingsModel model;
	
	public Controller(View view, SettingsModel model)
	{
		this.view = view;
		this.model = model;
	}

	// Can return values or modify existing reference to the model
	@Override
	public void SaveAction(SettingsActionEvent event)
	{			
		this.model.SettingsSaveConfiguration(event.GetIp(), event.GetPort(), event.GetRconPass());
		System.out.println("Saved configuration test");
	}
	
	public void TestConnAction(SettingsActionEvent event)
	{
		this.model.SettingsTestConn();
	}
	
}
