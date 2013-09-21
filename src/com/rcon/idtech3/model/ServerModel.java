package com.rcon.idtech3.model;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerModel
{
	protected DatagramSocket ds;
	protected DatagramPacket dp;
	protected InetAddress ia;
	public DatagramSocket GetDs()
	{
		return ds;
	}
	public void SetDs(DatagramSocket ds)
	{
		this.ds = ds;
	}
	public DatagramPacket GetDp()
	{
		return dp;
	}
	public void SetDp(DatagramPacket dp)
	{
		this.dp = dp;
	}
	public InetAddress GetIa()
	{
		return ia;
	}
	public void SetIa(InetAddress ia)
	{
		this.ia = ia;
	}
	
	
}
