package com.rcon.idtech3.base;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.rcon.idtech3.controller.Controller;
import com.rcon.idtech3.model.Model;
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
	
	public static void RunApplication()
	{
		Model model = new Model();
		View view = new View(model);
		
		Controller controller = new Controller(view,model);
		
		view.SetSaveListener(controller);
	}

}
