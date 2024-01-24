package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main 
{
	private static JPanel prompt;
	private static JPanel choices;

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				initialize();
				JFrame frame = new JFrame("Monster Master Incremental");
				JPanel panel = new JPanel(new GridBagLayout());
				panel.setBorder(BorderFactory.createLineBorder(Color.pink));
				GridBagConstraints constraints = new GridBagConstraints();
				constraints.anchor = GridBagConstraints.CENTER;
				constraints.fill = GridBagConstraints.HORIZONTAL;
				constraints.weightx = 0.5;
				constraints.weighty = 0.7;
				constraints.gridx = 0;
				constraints.gridy = 0;
				panel.add(prompt,constraints);
				constraints.gridy = 1;
				panel.add(choices,constraints);
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(panel);		
				frame.pack();
				frame.setSize(1920, 1080);
				frame.setVisible(true);
			}
		});
	}
	
	private static void initialize()
	{
		initializePrompt();
		initializeChoices();
	}
	
	private static void initializePromptOld()
	{
		prompt = new JPanel();
		JLabel promptLabel = new JLabel("You awaken in the darkness, with no memory or direction."
				+ "\n Time passes but you cannot grasp it;\n a week, a month, a year comes and fades again.\n\n Then there is light.");
		prompt.add(promptLabel);
	}
	
	private static void initializePrompt()
	{
		prompt = new JPanel(new GridBagLayout());
		List<JLabel> jlabels = new ArrayList<JLabel>(); 
		jlabels.add(new JLabel("You awaken in the darkness, with no memory or direction."));
		jlabels.add(new JLabel("Time passes but you cannot grasp it;"));
		jlabels.add(new JLabel("A week, a month, a year comes and fades again."));
		jlabels.add(new JLabel(" "));
		jlabels.add(new JLabel("Then, there is light"));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 0.2;
		constraints.weighty = 0.2;
		constraints.gridx = 0;
//		constraints.gridy = 0;
		
		for(int i = 0; i < jlabels.size(); i++)
		{
			constraints.gridy = i;
			prompt.add(jlabels.get(i),constraints);
		}
		
	}
	
	private static void initializeChoices()
	{
		choices = new JPanel(new GridBagLayout());
		JLabel choice1 = new JLabel("Go towards the light");
		choice1.setBorder(BorderFactory.createBevelBorder(5,Color.red, Color.black));
		JLabel choice2 = new JLabel("Embrace the darkness");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0.5;
		constraints.weighty = 0.7;
		choices.add(choice1, constraints);
		constraints.gridx = 1;
		choices.add(choice2, constraints);
	}
	
	
	private void old()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				JFrame frame = new JFrame("Monster Master Incremental");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				BufferedImage background = null;
				try {
					background = ImageIO.read(new File("Images/MonsterMasterIncrementalBackground.png"));
				} catch (IOException e) {
					System.err.println("Unable to access MonsterMasterIncrementalBackground.png");
					e.printStackTrace();
					return;
				}
				JLabel backgroundLabel = new JLabel(new ImageIcon(background));
				frame.getContentPane().add(backgroundLabel);
//				JLayeredPane layeredPane = new JLayeredPane();
//				layeredPane.add(backgroundLabel);
//				layeredPane.paint(frame.getGraphics());
//				frame.add(layeredPane);

				
				frame.pack();
				frame.setSize(1920, 1080);
				frame.setVisible(true);
			}
		});
	}
}
