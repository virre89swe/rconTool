package com.rcon.idtech3.model;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServerCod4Model extends ServerModel
{
	public ServerCod4Model()
	{
		try 
		{
			this.ds = new DatagramSocket();
		} 
		catch (SocketException e) 
		{
			e.printStackTrace();
		}
	}
	
	//TODO Split it out and test with specific port
	public boolean EstablishSocket(String ip)
	{		
		try 
		{
			this.ia = InetAddress.getByName(ip);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
