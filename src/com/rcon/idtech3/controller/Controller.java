package com.rcon.idtech3.controller;

import com.rcon.idtech3.model.Model;
import com.rcon.idtech3.view.SaveListener;
import com.rcon.idtech3.view.SaveSettingsEvent;
import com.rcon.idtech3.view.View;

public class Controller implements SaveListener
{
	private View view;
	private Model model;
	
	public Controller(View view, Model model)
	{
		this.view = view;
		this.model = model;
	}

	@Override
	public void SaveAction(SaveSettingsEvent event)
	{			
		this.model.SettingsSaveConfiguration(event.GetIp(), event.GetPort(), event.GetRconPass());
		System.out.println("Saved configuration test");
	}
	
}
