package com.rcon.idtech3.view;

import java.awt.Color;

public class PresentDataView
{
	private View view;

	public PresentDataView(View view)
	{
		this.view = view;
	}
	
	
	public void SetStatus (String response)
	{
		this.view.settingsStatusLabel.setForeground(new Color(46, 139, 87));
		this.view.settingsStatusLabel.setText("Connection seems ok");
		
		// Splits and gather relevant parts
		String[] parts = response.split("\\\\");
		
		String servername = parts[38];
		String map = parts[26];
		String gametype = parts[22];
		String password = parts[58];
		String punkbuster = parts[50];
		String pure = parts[52];
		
		//splitResponse = splitResponse.replace("_", "");
		
		// Set labels
		this.view.servername.setText(servername);
		this.view.currentMap.setText(map); 
		this.view.gametype.setText(gametype);
		this.view.password.setText(password);
		this.view.punkbuster.setText(punkbuster);
		this.view.pure.setText(pure);
	
	}
	
	public void SetStatusTxtMsg(String msg, boolean color)
	{
		if(color)
		{
			this.view.settingsStatusLabel.setForeground(new Color(46, 139, 87));
		}
		else
		{
			this.view.settingsStatusLabel.setForeground(new Color(178,34,34));
		}
		
		this.view.settingsStatusLabel.setText(msg);
	}
}
