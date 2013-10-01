package com.rcon.idtech3.helper;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class LoggHelper
{
	public static void InitLogger(Logger logger, String filename)
	{
		try
		{
			FileHandler fileHandler = new FileHandler(filename, true);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			logger.addHandler(fileHandler);
		} 
		catch (SecurityException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}
}
