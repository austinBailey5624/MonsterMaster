// package com.greenwolfgames.monstermaster;

// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Font;
// import java.awt.Graphics;
// import java.awt.GridBagConstraints;
// import java.awt.GridBagLayout;
// import java.awt.Image;
// import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;

// import javax.swing.BorderFactory;
// import javax.swing.ImageIcon;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JLayeredPane;
// import javax.swing.JPanel;
// import java.io.File;

// public class Main
// {
// 	private static String prefix = "getString(context,R.string.monster_type_";
// 	private static String postfix = "_evolution_index).toInt(),\n";
// 	private static String lastPostfix = "_evolution_index).toInt())\n";
// 	public static void main(String[] args)
// 	{
// //		printMonsterTypesToFile();
// 		printKotlinIntermediateMonsterTypesToFile();

// 	}
	
// 	private static void printKotlinIntermediateMonsterTypesToFile()
// 	{
// 		List<MonsterType> monsters= MonsterManager.getMonsterTypes();
// 		String filePath = "kotlin_intermediate_monster_type_helper.txt";
//         File file = new File(filePath); 
//         if (file.delete()) {
//             System.out.println("File deleted successfully.");
//         } else {
//             System.out.println("Failed to delete the file.");
//         }
        
//         try (FileWriter fileWriter = new FileWriter(filePath);
//                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) 
//         {
//         	bufferedWriter.write(indent(2) + "fun getMonsterTypesFromFile(context: Context): List<MonsterType>\n");
//         	bufferedWriter.write(indent(2) + "{\n");
//         	bufferedWriter.write(indent(3) + "var monsterTypes: MutableList<MonsterType> = mutableListOf()\n");
//         	for(MonsterType monster : monsters)
//         	{
//         		bufferedWriter.write(indent(4) + "monsterTypes.add(\n");
//         		bufferedWriter.write(indent(5) + "MonsterType(" + monster.getIndex() + ",\n");
//         		bufferedWriter.write(indent(5) + prefix + monster.getIndex() + "_name),\n");
//         		bufferedWriter.write(indent(5) + prefix + monster.getIndex() + "_description),\n");
//         		bufferedWriter.write(indent(5) + prefix + monster.getIndex() + "_previous" + postfix);
//         		bufferedWriter.write(indent(5) + prefix + monster.getIndex() + "_physical" + postfix);
//         		bufferedWriter.write(indent(5) + prefix + monster.getIndex() + "_balanced" + postfix);
//         		bufferedWriter.write(indent(5) + prefix + monster.getIndex() + "_magical" + postfix);
//         		bufferedWriter.write(indent(5) + "R.drawable.monster_" + monster.getSubElement().getName().toString().toLowerCase() + "_" + monster.getName().toLowerCase().replace(" ", "_").replace("\'", "") + ",\n");
//         		bufferedWriter.write(indent(5) + "Element." + monster.getSubElement().getName().toString().toUpperCase() + "\n");
//         		bufferedWriter.write(indent(4) + ")\n");
//         		bufferedWriter.write(indent(3) + ")\n");
        		
//         		System.out.println("Written insert for monster " + monster.getName() + " successfully");
//         	}
//         	bufferedWriter.write(indent(3) + "return monsterTypes.toList()\n" + indent(2) + "}\n");
//             System.out.println("Content successfully written to " + filePath);
//         }
//         catch(Exception e)
//         {
//         	//do nothing
//         }
        
// 	}
	
// 	private static String indent(int indent_size)
// 	{
// 		if(indent_size == 2)
// 		{
// 			return "        ";
// 		}
// 		if(indent_size == 3)
// 		{
// 			return "            ";
// 		}
// 		if(indent_size == 4)
// 		{
// 			return "                ";
// 		}
// 		if(indent_size == 5)
// 		{
// 			return "                    ";
// 		}
// 		String result = "";
// 		for(int i = 0; i < indent_size; i++)
// 		{
// 			result.concat("    ");
// 		}
// 		return result;
// 	}
	
// 	private static void printMonsterTypesToFile()
// 	{
// 		List<MonsterType> monsters= MonsterManager.getMonsterTypes();
// 		String filePath = "monster_types_kotlin.txt";
		
//         File file = new File(filePath); 
//         if (file.delete()) {
//             System.out.println("File deleted successfully.");
//         } else {
//             System.out.println("Failed to delete the file.");
//         }
        
//         // Use try-with-resources to automatically close resources
//         try (FileWriter fileWriter = new FileWriter(filePath);
//              BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

//         	for(MonsterType monsterType : monsters)
//         	{
//         		bufferedWriter.write("    <string name=\"monster_type_" + monsterType.getIndex());
//         		bufferedWriter.write("_name\">" + filterString(monsterType.getName()) + "</string>\n");
        		
//         		bufferedWriter.write("    <string name=\"monster_type_" + monsterType.getIndex());
//         		bufferedWriter.write("_description\">" + filterString(monsterType.getDescription()));
//         		bufferedWriter.write("</string>\n");
        		
//         		bufferedWriter.write("    <string name=\"monster_type_" + monsterType.getIndex());
//         		bufferedWriter.write("_subelement\">" + monsterType.getSubElement().getName());
//         		bufferedWriter.write("</string>\n");
        		
//         		bufferedWriter.write("    <string name=\"monster_type_" + monsterType.getIndex());
//         		bufferedWriter.write("_previous_evolution_index\">");
//         		if(monsterType.getPreviousEvolution() == null)
//         		{
//         			bufferedWriter.write("-1</string>\n");
//         		}
//         		else
//         		{
//         			bufferedWriter.write(monsterType.getPreviousEvolution().getIndex() + "</string>\n");        			
//         		}
        		
//         		bufferedWriter.write("    <string name=\"monster_type_" + monsterType.getIndex());
//         		bufferedWriter.write("_physical_evolution_index\">");
//         		if(monsterType.getPhysicalEvolution() == null)
//         		{
//         			bufferedWriter.write("-1</string>\n");
//         		}
//         		else
//         		{
//         			bufferedWriter.write(monsterType.getPhysicalEvolution().getIndex() + "</string>\n");        			
//         		}
        		

//         		bufferedWriter.write("    <string name=\"monster_type_" + monsterType.getIndex());
//         		bufferedWriter.write("_balanced_evolution_index\">");
//         		if(monsterType.getBalancedEvolution() == null)
//         		{
//         			bufferedWriter.write("-1</string>\n");
//         		}
//         		else
//         		{
//         			bufferedWriter.write(monsterType.getBalancedEvolution().getIndex() + "</string>\n");        			
//         		}
        		

//         		bufferedWriter.write("    <string name=\"monster_type_" + monsterType.getIndex());
//         		bufferedWriter.write("_magical_evolution_index\">");
//         		if(monsterType.getMagicalEvolution() == null)
//         		{
//         			bufferedWriter.write("-1</string>\n");
//         		}
//         		else
//         		{
//         			bufferedWriter.write(monsterType.getMagicalEvolution().getIndex() + "</string>\n");        			
//         		}
//         		System.out.println("Written successfully");
//         	}
//             System.out.println("Content successfully written to " + filePath);
//         } catch (IOException e) {
//             e.printStackTrace(); // Handle exceptions
//         }
// 	}
	
// 	private static String filterString(String description)
// 	{
// 		return description.replace("\'", "\\\'");
// 	}
// }
