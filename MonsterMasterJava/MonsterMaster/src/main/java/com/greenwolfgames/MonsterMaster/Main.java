package com.greenwolfgames.MonsterMaster;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	public static void main(String[] args)
	{
		printMonsterTypesToFile();

	}
	
	private static void printMonsterTypesToFile()
	{
		List<MonsterType> monsters= MonsterManager.getMonsterTypes();
		String filePath = "monsterTypes.txt";
        // Use try-with-resources to automatically close resources
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            // Write content to the file
//            bufferedWriter.write(content);
        	for(MonsterType monsterType : monsters)
        	{
        		bufferedWriter.write(monsterType.getIndex() + "\n");
        		bufferedWriter.write(monsterType.getName() + "\n");
        		bufferedWriter.write(monsterType.getDescription() + "\n");
        		bufferedWriter.write(monsterType.getSubElement().getName() + "\n");
        		if(monsterType.getPreviousEvolution() != null)
        		{
        			bufferedWriter.write(monsterType.getPreviousEvolution().getName() + "\n");
        		}
        		else
        		{
        			bufferedWriter.write("no previous evolution\n");
        		}
        		List<MonsterType> evolutions = new ArrayList<MonsterType>();
        		if(monsterType.getPhysicalEvolution()!= null)
        		{
        			evolutions.add(monsterType.getPhysicalEvolution());
        		}
        		if(monsterType.getBalancedEvolution() != null)
        		{
        			evolutions.add(monsterType.getBalancedEvolution());
        		}
        		if(monsterType.getMagicalEvolution() != null)
        		{
        			evolutions.add(monsterType.getMagicalEvolution());
        		}
        		bufferedWriter.write("number of evolutions: " + evolutions.size() + "\n");
        		if(monsterType.getPhysicalEvolution() != null)
        		{
        			bufferedWriter.write(monsterType.getPhysicalEvolution().getName() + "\n");
        		}
        		else
        		{
        			bufferedWriter.write("no physical evolution\n");
        		}
        		if(monsterType.getBalancedEvolution() != null)
        		{
        			bufferedWriter.write(monsterType.getBalancedEvolution().getName() + "\n");
        		}
        		else
        		{
        			bufferedWriter.write("no balanced evolution\n");
        		}
        		if(monsterType.getMagicalEvolution() != null)
        		{
        			bufferedWriter.write(monsterType.getMagicalEvolution().getName() + "\n");
        		}
        		else
        		{
        			bufferedWriter.write("no magical evolution\n");
        		}
        		System.out.println("Written successfully");
        	}

            System.out.println("Content successfully written to " + filePath);

        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }
	}
}
