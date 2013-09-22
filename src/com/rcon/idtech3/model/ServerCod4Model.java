package com.rcon.idtech3.model;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
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
	
	public boolean Connect(String ip, String port)
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
	
	public String SendSrvCmd(String ip, String port, String rcon, String cmd)
	{	
		String response = null;
		
		if(rcon == null)
		{
			cmd = "xxxxgetstatus";
		}
		
		int portInt = Integer.parseInt(port);
		
		if(this.Connect(ip,port))
		{
			try
			{
				byte [] buff = cmd.getBytes();
				buff[0] = (byte)0xff;
				buff[1] = (byte)0xff;
				buff[2] = (byte)0xff;
				buff[3] = (byte)0xff;
				
				
				dp = new DatagramPacket(buff, buff.length, ia, portInt);
				ds.send(dp);
				System.out.println("ConnectionWorks");
				try
				{
					buff = new byte[65507];
					dp = new DatagramPacket(buff, buff.length);
					ds.setSoTimeout(5000);
					ds.receive(dp);	
					
					response = new String(buff);
					String[] parts = response.split("\\\\");
					String part1 = parts[2];
					part1 = part1.replace("_", "");
					System.out.println(part1);
					System.out.println(response);
				}
				catch(SocketTimeoutException e)
				{
					System.out.println("Timeout with socket");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return response;
	}
}
