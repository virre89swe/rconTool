package com.rcon.idtech3.controller;

import com.rcon.idtech3.model.ServerCod4Model;
import com.rcon.idtech3.model.SettingsModel;
import com.rcon.idtech3.view.SettingsActionEvent;
import com.rcon.idtech3.view.SettingsActionListener;
import com.rcon.idtech3.view.View;

public class Controller implements SettingsActionListener
{
	@SuppressWarnings("unused")
	private View view;
	private SettingsModel settingsModel;
	private ServerCod4Model serverCod4Model;
	
	public Controller(View view, SettingsModel settingsModel, ServerCod4Model serverCod4Model)
	{
		this.view = view;
		this.settingsModel = settingsModel;
		this.serverCod4Model = serverCod4Model;
	}

	public Controller(View view, SettingsModel settingsModel)
	{
		this.view = view;
		this.settingsModel = settingsModel;
	}

	//TODO Can return values or modify existing reference to the model
	@Override
	public boolean SaveAction(SettingsActionEvent event)
	{			
		if(this.settingsModel.SettingsSaveConfiguration(event.GetIp(), event.GetPort(), event.GetRconPass()))
		{
			System.out.println("Saved configuration test");
			return true;
		}
		return false;
	}
	
	public void TestConnAction(SettingsActionEvent event)
	{
		//this.model.SettingsTestConn();
		System.out.println(event.GetIp() + " B4..");
		boolean value = this.serverCod4Model.EstablishSocket(this.settingsModel.GetIp());
		System.out.println(event.GetIp() + " AF..");
		System.out.println("SettingsModelIpValue: " + this.settingsModel.GetIp());
		System.out.println(value);
		
	}
	
}
