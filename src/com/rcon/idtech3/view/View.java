package com.rcon.idtech3.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

//import com.rcon.idtech3.controller.Controller;
import com.rcon.idtech3.model.Model;
import javax.swing.JTextArea;
import java.awt.Font;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener
{
	private TextField settingsIpField;
	private TextField settingsPortField;
	private TextField settingsRconPField;
	
	private Model model;
	private JPanel contentPane;
	
	private SaveListener saveListener;
	
	// Constants
	private final String LABEL_SETTINGS_SAVE = "Save";
	private final String LABEL_SETTINGS_TEST = "Test Connection";
	private final String LABEL_CMD_GETSTATUS = "Get Status";

	public View(Model model) throws HeadlessException
	{
		super("Remote Console : Id Tech 3");
		this.model = model;
		
		
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
		this.settingsIpField.setText(this.model.GetIp());

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
		this.settingsPortField.setText(this.model.GetPort());
		
		sl_panel.putConstraint(SpringLayout.NORTH, this.settingsPortField, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, this.settingsPortField, 233, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, this.settingsPortField, 28, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, this.settingsPortField, 288, SpringLayout.WEST, panel);
		this.settingsPortField.setForeground(Color.BLACK);
		this.settingsPortField.setBackground(Color.LIGHT_GRAY);
		panel.add(this.settingsPortField);
		
		this.settingsRconPField = new TextField();
		this.settingsRconPField.setText(this.model.GetRconPass());
		
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
		srvResponseConsole.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		srvResponseConsole.setForeground(Color.WHITE);
		srvResponseConsole.setBackground(Color.DARK_GRAY);
		sl_panel_1.putConstraint(SpringLayout.NORTH, srvResponseConsole, 108, SpringLayout.SOUTH, srvCmdGetStatusBtn);
		sl_panel_1.putConstraint(SpringLayout.WEST, srvResponseConsole, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, srvResponseConsole, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, srvResponseConsole, 543, SpringLayout.WEST, panel_1);
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton mySource = (JButton)e.getSource();
		
		
		if(mySource.getText() == LABEL_SETTINGS_SAVE)
		{
			this.FireSaveSettingsEvent(new SaveSettingsEvent(this.settingsIpField.getText(),this.settingsPortField.getText(),this.settingsRconPField.getText()));
		}
		
		
		if(mySource.getText() == LABEL_CMD_GETSTATUS)
		{
			System.out.print("Ip: " + this.model.GetIp());
		}
	}

	public void SetSaveListener(SaveListener saveListener)
	{
		this.saveListener = saveListener;
		
	}
	
	public void FireSaveSettingsEvent(SaveSettingsEvent event)
	{
		if(this.saveListener != null)
		{
			this.saveListener.SaveAction(event);
		}
	}
}