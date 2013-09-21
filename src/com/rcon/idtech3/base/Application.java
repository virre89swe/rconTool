package com.rcon.idtech3.base;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.rcon.idtech3.controller.Controller;
import com.rcon.idtech3.model.ServerCod4Model;
import com.rcon.idtech3.model.SettingsModel;
import com.rcon.idtech3.view.View;

public class Application 
{
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException 
	{
		// System L&F
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		SwingUtilities.invokeLater(new Runnable() 
		{			
			public void run ()
			{
				RunApplication();
			}
		});
	}
	
	// MVC Asynchronous instance
	public static void RunApplication()
	{
		// Model(s)
		SettingsModel settingsModel = new SettingsModel();
		ServerCod4Model serverCod4Model = new ServerCod4Model();
		
		// View
		View view = new View(settingsModel,serverCod4Model);
		
		// Controller
		Controller controller = new Controller(view,settingsModel,serverCod4Model);
		
		// Listens
		view.SetSettingsListener(controller);
	}

}
