package com.rcon.idtech3.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import com.rcon.idtech3.model.ServerCod4Model;
//import com.rcon.idtech3.controller.Controller;
import com.rcon.idtech3.model.SettingsModel;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener,TextListener
{
	// Views
	private PresentDataView presentDataView;
	
	// JLabels
	protected JLabel settingsStatusLabel;
	
	protected JLabel servername;
	protected JLabel currentMap;
	protected JLabel gametype;
	protected JLabel password;
	protected JLabel punkbuster;
	protected JLabel pure;
	
	// Fields
	private TextField settingsIpField;
	private TextField settingsPortField;
	private TextField settingsRconPField;
	
	private SettingsModel settingsModel;
	@SuppressWarnings("unused")
	private ServerCod4Model serverCod4Model;
	private JPanel contentPane;
	
	private SettingsActionListener settingsListener;
	
	// Constants
	private final String LABEL_SETTINGS_SAVE = "Save";
	private final String LABEL_SETTINGS_TEST = "Connect";
	private final String LABEL_CMD_GETSTATUS = "Get Status";

	public View(SettingsModel settingsModel, ServerCod4Model serverCod4Model) throws HeadlessException
	{
		super("Remote Console : Id Tech 3");
		
		// Initialize sub-views
		this.presentDataView = new PresentDataView(this);
		
		// AppIcon
		/*try
		{
			URL url = new URL("com/xyz/resources/camera.png");
		} catch (MalformedURLException e1)
		{
			e1.printStackTrace();
		}*/
		
		this.settingsModel = settingsModel;
		this.serverCod4Model = serverCod4Model;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 384);
		setMinimumSize(new Dimension(455, 384));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu j = new JMenu("File");
		menuBar.add(j);
		
		JMenuItem mntmTest = new JMenuItem("Exit");
		mntmTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		j.add(mntmTest);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.setFocusable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Rcon settings", null, panel, null);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		this.settingsIpField = new TextField();
		this.settingsIpField.addTextListener(this);
		this.settingsIpField.setText(this.settingsModel.GetIp());

		sl_panel.putConstraint(SpringLayout.NORTH, this.settingsIpField, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, this.settingsIpField, 79, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, this.settingsIpField, 28, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, this.settingsIpField, 187, SpringLayout.WEST, panel);
		this.settingsIpField.setBackground(Color.LIGHT_GRAY);
		this.settingsIpField.setForeground(Color.BLACK);
		panel.add(this.settingsIpField);
		
		
		JLabel lblNewLabel = new JLabel("Ip-Address :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 11, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 73, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Port :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 11, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 195, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 227, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_1);
		
		this.settingsPortField = new TextField();
		this.settingsPortField.addTextListener(this);
		this.settingsPortField.setText(this.settingsModel.GetPort());
		
		sl_panel.putConstraint(SpringLayout.NORTH, this.settingsPortField, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, this.settingsPortField, 233, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, this.settingsPortField, 28, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, this.settingsPortField, 288, SpringLayout.WEST, panel);
		this.settingsPortField.setForeground(Color.BLACK);
		this.settingsPortField.setBackground(Color.LIGHT_GRAY);
		panel.add(this.settingsPortField);
		
		this.settingsRconPField = new TextField();
		this.settingsRconPField.addTextListener(this);;
		this.settingsRconPField.setText(this.settingsModel.GetRconPass());
		
		sl_panel.putConstraint(SpringLayout.NORTH, this.settingsRconPField, 49, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, this.settingsRconPField, 79, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, this.settingsRconPField, 67, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, this.settingsRconPField, 187, SpringLayout.WEST, panel);
		this.settingsRconPField.setForeground(Color.BLACK);
		this.settingsRconPField.setBackground(Color.LIGHT_GRAY);
		panel.add(this.settingsRconPField);
		
		JLabel lblRconPass = new JLabel("Rcon Pass  :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblRconPass, 49, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblRconPass, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblRconPass, 73, SpringLayout.WEST, panel);
		panel.add(lblRconPass);
		
		JButton btnNewButton = new JButton(LABEL_SETTINGS_TEST);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		JButton btnSave = new JButton(LABEL_SETTINGS_SAVE);
		btnSave.addActionListener(this);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnSave);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -18, SpringLayout.WEST, btnSave);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnSave, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnSave, -10, SpringLayout.EAST, panel);
		panel.add(btnSave);
		
		settingsStatusLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, settingsStatusLabel, 3, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, settingsStatusLabel, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, settingsStatusLabel, 361, SpringLayout.WEST, lblNewLabel);
		settingsStatusLabel.setForeground(new Color(46, 139, 87));
		settingsStatusLabel.setFont(new Font("Arial", Font.BOLD, 13));
		panel.add(settingsStatusLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Status", null, panel_2, null);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lblMap = new JLabel("Map");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblMap, 39, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblMap, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblMap, 56, SpringLayout.WEST, panel_2);
		panel_2.add(lblMap);
		
		currentMap = new JLabel("<not active>");
		sl_panel_2.putConstraint(SpringLayout.NORTH, currentMap, 0, SpringLayout.NORTH, lblMap);
		sl_panel_2.putConstraint(SpringLayout.WEST, currentMap, 20, SpringLayout.EAST, lblMap);
		panel_2.add(currentMap);
		
		servername = new JLabel("<not active>");
		servername.setFont(new Font("Utsaah", Font.BOLD, 17));
		sl_panel_2.putConstraint(SpringLayout.NORTH, servername, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, servername, 202, SpringLayout.WEST, panel_2);
		panel_2.add(servername);
		
		JLabel lblGametype = new JLabel("Gametype");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblGametype, 18, SpringLayout.SOUTH, lblMap);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblGametype, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblGametype, 68, SpringLayout.WEST, panel_2);
		panel_2.add(lblGametype);
		
		gametype = new JLabel("<not active>");
		sl_panel_2.putConstraint(SpringLayout.NORTH, gametype, 0, SpringLayout.NORTH, lblGametype);
		sl_panel_2.putConstraint(SpringLayout.WEST, gametype, 0, SpringLayout.WEST, currentMap);
		panel_2.add(gametype);
		
		JLabel lblPassword = new JLabel("Password");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblPassword, 29, SpringLayout.SOUTH, lblGametype);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblMap);
		panel_2.add(lblPassword);
		
		JLabel lblPunkbuste = new JLabel("Punkbuster");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblPunkbuste, 24, SpringLayout.SOUTH, lblPassword);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblPunkbuste, 0, SpringLayout.WEST, lblMap);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblPunkbuste, 6, SpringLayout.EAST, lblGametype);
		panel_2.add(lblPunkbuste);
		
		JLabel lblPure = new JLabel("Pure");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblPure, 23, SpringLayout.SOUTH, lblPunkbuste);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblPure, 0, SpringLayout.WEST, lblMap);
		panel_2.add(lblPure);
		
		password = new JLabel("<not active>");
		sl_panel_2.putConstraint(SpringLayout.NORTH, password, 0, SpringLayout.NORTH, lblPassword);
		sl_panel_2.putConstraint(SpringLayout.WEST, password, 0, SpringLayout.WEST, currentMap);
		panel_2.add(password);
		
		punkbuster = new JLabel("<not active>");
		sl_panel_2.putConstraint(SpringLayout.NORTH, punkbuster, 24, SpringLayout.SOUTH, password);
		sl_panel_2.putConstraint(SpringLayout.WEST, punkbuster, 0, SpringLayout.WEST, currentMap);
		sl_panel_2.putConstraint(SpringLayout.EAST, punkbuster, 0, SpringLayout.EAST, currentMap);
		panel_2.add(punkbuster);
		
		pure = new JLabel("<not active>");
		sl_panel_2.putConstraint(SpringLayout.NORTH, pure, 0, SpringLayout.NORTH, lblPure);
		sl_panel_2.putConstraint(SpringLayout.WEST, pure, 0, SpringLayout.WEST, currentMap);
		panel_2.add(pure);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Commands", null, panel_1, null);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JButton srvCmdGetStatusBtn = new JButton(LABEL_CMD_GETSTATUS);
		srvCmdGetStatusBtn.addActionListener(this);
		sl_panel_1.putConstraint(SpringLayout.NORTH, srvCmdGetStatusBtn, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, srvCmdGetStatusBtn, 10, SpringLayout.WEST, panel_1);
		panel_1.add(srvCmdGetStatusBtn);
		
		JTextArea srvResponseConsole = new JTextArea();
		sl_panel_1.putConstraint(SpringLayout.EAST, srvResponseConsole, 543, SpringLayout.WEST, panel_1);
		srvResponseConsole.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		srvResponseConsole.setForeground(Color.WHITE);
		srvResponseConsole.setBackground(Color.DARK_GRAY);
		sl_panel_1.putConstraint(SpringLayout.NORTH, srvResponseConsole, 108, SpringLayout.SOUTH, srvCmdGetStatusBtn);
		sl_panel_1.putConstraint(SpringLayout.WEST, srvResponseConsole, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, srvResponseConsole, -10, SpringLayout.SOUTH, panel_1);
		srvResponseConsole.setText("..srv reponses go here");
		panel_1.add(srvResponseConsole);
		
		JLabel lblResponseConsole = new JLabel("Response Console");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblResponseConsole, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblResponseConsole, -6, SpringLayout.NORTH, srvResponseConsole);
		panel_1.add(lblResponseConsole);
		
		Label label = new Label("Version 0.1");
		label.setAlignment(Label.RIGHT);
		contentPane.add(label, BorderLayout.NORTH);
		
		setVisible(true);
	}
		
	/*
	 * Fires save event
	 * Sets save-status label 
	 */
	public void FireSaveSettingsEvent(SettingsActionEvent event)
	{		
		if(this.settingsListener != null)
		{
			if(this.settingsListener.SaveAction(event))
			{
				this.settingsStatusLabel.setForeground(new Color(46, 139, 87));
				this.settingsStatusLabel.setText("Configuration stored");
			}
		}
	}
	
	// Initial Connect , will set the status info if successful
	public void FireTestConnSettingsEvent(SettingsActionEvent event)
	{		
		if(this.settingsListener != null)
		{
			String response = this.settingsListener.TestConnAction(event);
			if(response == null)
			{
				this.settingsStatusLabel.setForeground(new Color(178,34,34));
				this.settingsStatusLabel.setText("Connection timeout, check port & ip");
			}
			else
			{			
				this.presentDataView.SetStatus(response);				
			}
		}
	}
	
	/*
	 * Listeners
	 */
	public void SetSettingsListener(SettingsActionListener settingsListener)
	{
		this.settingsListener = settingsListener;
		
	}
	
	/*
	 * Non-vital
	 * Changes in the input-fields represented in status-label
	 */
	@Override
	public void textValueChanged(TextEvent arg)
	{		
		if(this.settingsIpField.getText().equals(this.settingsModel.GetIp()) && 
		   this.settingsPortField.getText().equals(this.settingsModel.GetPort()) && 
		   this.settingsRconPField.getText().equals(this.settingsModel.GetRconPass()))
		{
			this.settingsStatusLabel.setForeground(new Color(46, 139, 87));
			this.settingsStatusLabel.setText("Input equals stored config");
		}
		else
		{
			this.settingsStatusLabel.setForeground(new Color(178,34,34));
			this.settingsStatusLabel.setText("Fields were modified, save to use changes");
		}
	}
	
	
	/*
	 *  Casts the source to JButton and fires relevant event(s) which bubbles to controller
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton mySource = (JButton)e.getSource();
		
		
		if(mySource.getText() == LABEL_SETTINGS_SAVE)
		{
			this.FireSaveSettingsEvent(new SettingsActionEvent(this.settingsIpField.getText(),this.settingsPortField.getText(),this.settingsRconPField.getText()));
		}
		
		
		if(mySource.getText() == LABEL_SETTINGS_TEST)
		{
			this.FireTestConnSettingsEvent(new SettingsActionEvent(this.settingsIpField.getText(),this.settingsPortField.getText(),this.settingsRconPField.getText()));
		}
	}
}