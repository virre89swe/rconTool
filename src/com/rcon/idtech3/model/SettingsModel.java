package com.rcon.idtech3.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

public class SettingsModel
{
	private String ip;
	private String port;
	private String rconPass;
	
	public SettingsModel()
	{
		this.SettingsLoadConfiguration();
	}
	
	
	// Save Settings
	@SuppressWarnings("deprecation")
	public boolean SettingsSaveConfiguration(String ip, String port, String rconPass)
	{
		try(FileReader reader = new FileReader("globals.properties")) 
		{
			Properties prop = new Properties();
			prop.load(reader);
			
			prop.setProperty("settingsConf.ip", ip);
			prop.setProperty("settingsConf.port", port);
			prop.setProperty("settingsConf.rcon", rconPass);
			
			prop.save(new FileOutputStream(new File("globals.properties")), "");
			
			
			this.ip = ip;
			this.port = port;
			this.rconPass = rconPass;
			return true;
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	// Load settings when initializing model
	public void SettingsLoadConfiguration()
	{
		try (FileReader reader = new FileReader("globals.properties"))
		{
			Properties prop = new Properties();
			prop.load(reader);
			
			this.ip = prop.getProperty("settingsConf.ip");
			this.port = prop.getProperty("settingsConf.port");
			this.rconPass = prop.getProperty("settingsConf.rcon");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Getters
	public String GetIp()
	{
		return this.ip;
	}
	
	public String GetPort()
	{
		return this.port;
	}
	
	public String GetRconPass()
	{
		return this.rconPass;
	}
	
}
