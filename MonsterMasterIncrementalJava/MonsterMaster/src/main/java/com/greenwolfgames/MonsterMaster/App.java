package com.greenwolfgames.MonsterMaster;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class App {
	
	private static Dimension DIMENSIONS = new Dimension(1920,1080);
    public static void main(String[] args) {
    	try
		{
			MonsterManager.printTraits();
			cleanTextDoc();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        JFrame frame = new JFrame("Image with Text Example");
        frame.setSize(DIMENSIONS);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // Create a panel to hold the components
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setOpaque(false); // Make the panel transparent
        panel.setPreferredSize(DIMENSIONS);
        
        // Create a panel to hold the components
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon backgroundImage = new ImageIcon("src/assets/DarkBackground.png");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null); // We'll position the text manually
        backgroundPanel.setPreferredSize(DIMENSIONS);

        // Add the panel to the frame
        frame.add(backgroundPanel);

        // Create and add text label
        JLabel textLabel = new JLabel("Hello, World!");
        textLabel.setForeground(Color.WHITE); // Set text color
        textLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
        textLabel.setBounds(50, 50, 200, 50); // Position and size
        panel.add(textLabel);
        
        backgroundPanel.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
    
    private static void cleanTextDoc() throws IOException
    {
    	String inputFile="src/traitsFromDB.txt";
    	String outputFile="src/traitsFromDBClean.txt";
    	BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    	BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
    	String line;
    	while((line = reader.readLine()) != null)
    	{
    		line = line.trim();
    		writer.write(line);
    		writer.newLine();
    	}
    	reader.close();
    	writer.close();
    }
}