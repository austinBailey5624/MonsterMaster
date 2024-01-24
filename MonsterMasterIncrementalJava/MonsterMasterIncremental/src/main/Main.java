package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main 
{
	public static void main(String[] args)
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
				

				
				frame.pack();
				frame.setSize(1920, 1080);
				frame.setVisible(true);
			}
		});
	}
}
