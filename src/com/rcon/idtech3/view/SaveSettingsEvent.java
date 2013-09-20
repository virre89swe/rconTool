package com.rcon.idtech3.view;

public class SaveSettingsEvent
{
	private String ip;
	private String port;
	private String rconPass;
	
	public SaveSettingsEvent(String ip, String port, String rconPass)
	{
		this.ip = ip;
		this.port = port;
		this.rconPass = rconPass;
	}

	public String GetIp()
	{
		return ip;
	}

	public void SetIp(String ip)
	{
		this.ip = ip;
	}

	public String GetPort()
	{
		return port;
	}

	public void SetPort(String port)
	{
		this.port = port;
	}

	public String GetRconPass()
	{
		return rconPass;
	}

	public void SetRconPass(String rconPass)
	{
		this.rconPass = rconPass;
	}
	
	
}
