package com.greenwolfgames.MonsterMaster;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Main
{
	private static JPanel promptPanel;
	private static JPanel choicesPanel;

	public static void main(String[] args)
	{
		FileReader reader = new FileReader();

		System.out.println("User: " + reader.getDBUserFromFile());
		System.out.println("Pass: " + reader.getDBPassFromFile());

		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				initialize();
				JFrame frame = new JFrame("Monster Master Incremental");
				frame.setSize(1920, 1080);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JLayeredPane layeredPane = new JLayeredPane();
				layeredPane.setPreferredSize(new Dimension(1920,1080));
				
				ImageIcon image = new ImageIcon("assets/DarkBackground.png");
				
		        JPanel panel = new JPanel() {
		            @Override
		            protected void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                // Load the background image
		                ImageIcon backgroundImage = new ImageIcon("assets/DarkBackground.png");
		                Image img = backgroundImage.getImage();
		                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		            }
		        };
		        panel.setLayout(null); // We'll position the text manually
		        panel.setPreferredSize(new Dimension(1920,1080));
		        
		        // Create and add text label
		        JLabel textLabel = new JLabel("Hello, World!");
		        textLabel.setForeground(Color.WHITE); // Set text color
		        textLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
		        textLabel.setBounds(50, 50, 200, 50); // Position and size
		        panel.add(textLabel);

		        frame.pack();
		        frame.setVisible(true);

//		        // Add the panel to the frame
//		        frame.add(panel);
//				GridBagConstraints constraints = new GridBagConstraints();
//				constraints.anchor  = GridBagConstraints.CENTER;
//				constraints.fill    = GridBagConstraints.HORIZONTAL;
//				constraints.weightx = 0.5;
//				constraints.weighty = 0.7;
//				constraints.gridx   = 0;
//				constraints.gridy   = 0;
//				panel.add(promptPanel, constraints);
//				constraints.gridy = 1;
//				panel.add(choicesPanel, constraints);
//
//
//				frame.setContentPane(panel);
//				frame.pack();
//
//				frame.setVisible(true);
			}
		});
	}

	private static void initialize()
	{
		initializePrompt(1);
		initializeChoices();
	}

	private static void initializePrompt(int scenario_id)
	{
		promptPanel = new JPanel(new GridBagLayout());
		new SQLContentRetriever();
		List<String> prompt = new ArrayList<>();
		try
		{
			prompt = new SQLContentRetriever().getPrompt(scenario_id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		List<JLabel> jLabels = new LinkedList<JLabel>();
		for (String string : prompt)
		{
			jLabels.add(new JLabel(string));
		}

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 0.2;
		constraints.weighty = 0.2;
		constraints.gridx   = 0;
		constraints.anchor  = GridBagConstraints.CENTER;
		constraints.ipady   = 40;
		Font font = new Font("Verdana", Font.BOLD, 20);
		for (int i = 0; i < jLabels.size(); i++)
		{
			constraints.gridy = i;
			jLabels.get(i).setFont(font);

			promptPanel.add(jLabels.get(i), constraints);

		}
	}

	private static void initializeChoices()
	{
		choicesPanel = new JPanel(new GridBagLayout());
		JLabel choice1 = new JLabel("Go towards the light");
		choice1.setBorder(BorderFactory.createBevelBorder(5, Color.red, Color.black));
		JLabel             choice2     = new JLabel("Embrace the darkness");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx   = 0;
		constraints.gridy   = 0;
		constraints.weightx = 0.5;
		constraints.weighty = 0.7;
		choicesPanel.add(choice1, constraints);
		constraints.gridx = 1;
		choicesPanel.add(choice2, constraints);
	}
}