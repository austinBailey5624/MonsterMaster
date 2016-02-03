package ver0;
import java.util.Scanner;
/**
 * @file	Bestiary.java
 * @author 	Austin Bailey <a604b997@gmail.com>
 * @dateBegun: 5/9/2016
 * @dateupdated:	5/9/2016
 */
public class Bestiary 
{
	public static MonsterType[][][][] bestiary=generateBestiary();
	public static MonsterType[] bestiary1d=convertTo1d();
	public static String[][] typeNames=defineTypes();
	public static boolean exit;
	public static int tempi;
	public static int choice;
	public static String temps;
	public static String inputError="Sorry, we didn't understand your input, be sure that you are only entering one of the values provided";
	public static Scanner myScanner= new Scanner(System.in);
	public static MonsterType[][][][] generateBestiary()
	{
		MonsterType[][][][] bestiary=new MonsterType[6][][][];
		bestiary[5]=new MonsterType[6][][];
		bestiary[4]=new MonsterType[6][][];
		bestiary[3]=new MonsterType[6][][];
		bestiary[2]=new MonsterType[6][][];
		bestiary[1]=new MonsterType[6][][];
		bestiary[0]=new MonsterType[6][][];
		bestiary[0][0]=new MonsterType[5][];
		bestiary[0][0][0]=new MonsterType[1];
		bestiary[0][0][1]=new MonsterType[1];
		bestiary[0][0][2]=new MonsterType[3];
		bestiary[0][0][3]=new MonsterType[4];
		bestiary[0][0][4]=new MonsterType[4];
		bestiary[0][0][4][0]=new MonsterType(0,0,4,0);
		bestiary[0][0][4][1]=new MonsterType(0,0,4,1);
		bestiary[0][0][4][2]=new MonsterType(0,0,4,2);
		bestiary[0][0][4][3]=new MonsterType(0,0,4,3);
		bestiary[0][0][3][0]=new MonsterType(0,0,3,0,bestiary[0][0][4][0],bestiary[0][0][4][1]);
		bestiary[0][0][3][1]=new MonsterType(0,0,3,1,bestiary[0][0][4][1]);
		bestiary[0][0][3][2]=new MonsterType(0,0,3,2,bestiary[0][0][4][2]);
		bestiary[0][0][3][3]=new MonsterType(0,0,3,2,bestiary[0][0][4][3]);
		bestiary[0][0][2][0]=new MonsterType(0,0,2,0,bestiary[0][0][3][0],bestiary[0][0][3][1]);
		bestiary[0][0][2][1]=new MonsterType(0,0,2,1,bestiary[0][0][3][2]);
		bestiary[0][0][2][2]=new MonsterType(0,0,2,2,bestiary[0][0][3][3]);
		bestiary[0][0][1][0]=new MonsterType(0,0,1,0,bestiary[0][0][2][0],bestiary[0][0][2][1],bestiary[0][0][2][2]);
		bestiary[0][0][0][0]=new MonsterType(0,0,0,0,bestiary[0][0][1][0]);
		bestiary[0][0][4][0].setEvolvesFrom(bestiary[0][0][3][0]);
		bestiary[0][0][4][1].setEvolvesFrom(bestiary[0][0][3][0]);
		bestiary[0][0][4][1].setEvolvesFrom2(bestiary[0][0][3][1]);
		bestiary[0][0][4][2].setEvolvesFrom(bestiary[0][0][3][2]);
		bestiary[0][0][4][3].setEvolvesFrom(bestiary[0][0][3][3]);
		bestiary[0][0][3][0].setEvolvesFrom(bestiary[0][0][2][0]);
		bestiary[0][0][3][1].setEvolvesFrom(bestiary[0][0][2][0]);
		bestiary[0][0][3][2].setEvolvesFrom(bestiary[0][0][2][1]);
		bestiary[0][0][3][3].setEvolvesFrom(bestiary[0][0][2][2]);
		bestiary[0][0][2][0].setEvolvesFrom(bestiary[0][0][1][0]);
		bestiary[0][0][2][1].setEvolvesFrom(bestiary[0][0][1][0]);
		bestiary[0][0][2][2].setEvolvesFrom(bestiary[0][0][1][0]);
		bestiary[0][0][1][0].setEvolvesFrom(bestiary[0][0][0][0]);
		bestiary[0][1]=new MonsterType[5][];
		bestiary[0][1][0]=new MonsterType[1];
		bestiary[0][1][1]=new MonsterType[1];
		bestiary[0][1][2]=new MonsterType[3];
		bestiary[0][1][3]=new MonsterType[3];
		bestiary[0][1][4]=new MonsterType[3];
		bestiary[0][1][4][0]=new MonsterType(0,1,4,0);
		bestiary[0][1][4][1]=new MonsterType(0,1,4,1);
		bestiary[0][1][4][2]=new MonsterType(0,1,4,2);
		bestiary[0][1][3][0]=new MonsterType(0,1,3,0,bestiary[0][1][4][0]);
		bestiary[0][1][3][1]=new MonsterType(0,1,3,1,bestiary[0][1][4][1]);
		bestiary[0][1][3][2]=new MonsterType(0,1,3,2,bestiary[0][1][4][2]);
		bestiary[0][1][2][0]=new MonsterType(0,1,2,0,bestiary[0][1][3][0]);
		bestiary[0][1][2][1]=new MonsterType(0,1,2,1,bestiary[0][1][3][1]);
		bestiary[0][1][2][2]=new MonsterType(0,1,2,2,bestiary[0][1][3][2]);		
		bestiary[0][1][1][0]=new MonsterType(0,1,1,0,bestiary[0][1][2][0],bestiary[0][1][2][1],bestiary[0][1][2][2]);
		bestiary[0][1][0][0]=new MonsterType(0,1,0,0,bestiary[0][1][1][0]);
		bestiary[0][1][4][0].setEvolvesFrom(bestiary[0][1][3][0]);
		bestiary[0][1][4][1].setEvolvesFrom(bestiary[0][1][3][1]);
		bestiary[0][1][4][2].setEvolvesFrom(bestiary[0][1][3][2]);
		bestiary[0][1][3][0].setEvolvesFrom(bestiary[0][1][2][0]);
		bestiary[0][1][3][1].setEvolvesFrom(bestiary[0][1][2][1]);
		bestiary[0][1][3][2].setEvolvesFrom(bestiary[0][1][2][2]);
		bestiary[0][1][2][0].setEvolvesFrom(bestiary[0][1][1][0]);
		bestiary[0][1][2][1].setEvolvesFrom(bestiary[0][1][1][0]);
		bestiary[0][1][2][1].setEvolvesFrom(bestiary[0][1][1][0]);
		bestiary[0][1][1][0].setEvolvesFrom(bestiary[0][1][0][0]);
		bestiary[0][2]=new MonsterType[5][];
		bestiary[0][2][0]=new MonsterType[1];
		bestiary[0][2][1]=new MonsterType[1];
		bestiary[0][2][2]=new MonsterType[3];
		bestiary[0][2][3]=new MonsterType[3];
		bestiary[0][2][4]=new MonsterType[3];
		bestiary[0][2][4][0]=new MonsterType(0,2,4,0);
		bestiary[0][2][4][1]=new MonsterType(0,2,4,1);
		bestiary[0][2][4][2]=new MonsterType(0,2,4,2);
		bestiary[0][2][3][0]=new MonsterType(0,2,3,0,bestiary[0][2][4][0]);
		bestiary[0][2][3][1]=new MonsterType(0,2,3,1,bestiary[0][2][4][1]);
		bestiary[0][2][3][2]=new MonsterType(0,2,3,2,bestiary[0][2][4][2]);
		bestiary[0][2][2][0]=new MonsterType(0,2,2,0,bestiary[0][2][3][0]);
		bestiary[0][2][2][1]=new MonsterType(0,2,2,1,bestiary[0][2][3][1]);
		bestiary[0][2][2][2]=new MonsterType(0,2,2,2,bestiary[0][2][3][2]);
		bestiary[0][2][1][0]=new MonsterType(0,2,1,0,bestiary[0][2][2][0],bestiary[0][2][2][1],bestiary[0][2][2][2]);
		bestiary[0][2][0][0]=new MonsterType(0,2,0,0,bestiary[0][2][1][0]);
		bestiary[0][2][4][0].setEvolvesFrom(bestiary[0][2][3][0]);
		bestiary[0][2][4][1].setEvolvesFrom(bestiary[0][2][3][1]);
		bestiary[0][2][4][2].setEvolvesFrom(bestiary[0][2][3][2]);
		bestiary[0][2][3][0].setEvolvesFrom(bestiary[0][2][2][0]);
		bestiary[0][2][3][1].setEvolvesFrom(bestiary[0][2][2][1]);
		bestiary[0][2][3][2].setEvolvesFrom(bestiary[0][2][2][2]);
		bestiary[0][2][2][0].setEvolvesFrom(bestiary[0][2][1][0]);
		bestiary[0][2][2][1].setEvolvesFrom(bestiary[0][2][1][0]);
		bestiary[0][2][2][2].setEvolvesFrom(bestiary[0][2][1][0]);
		bestiary[0][2][1][0].setEvolvesFrom(bestiary[0][2][0][0]);
		bestiary[0][3]=new MonsterType[5][];
		bestiary[0][3][0]=new MonsterType[1];
		bestiary[0][3][1]=new MonsterType[1];
		bestiary[0][3][2]=new MonsterType[3];
		bestiary[0][3][3]=new MonsterType[2];
		bestiary[0][3][4]=new MonsterType[1];
		bestiary[0][3][4][0]=new MonsterType(0,3,4,0);
		bestiary[0][3][3][0]=new MonsterType(0,3,3,0,bestiary[0][3][4][0]);
		bestiary[0][3][3][1]=new MonsterType(0,3,3,1,bestiary[0][3][4][0]);
		bestiary[0][3][2][0]=new MonsterType(0,3,2,0,bestiary[0][3][3][0]);
		bestiary[0][3][2][1]=new MonsterType(0,3,2,1,bestiary[0][3][3][1]);
		bestiary[0][3][2][2]=new MonsterType(0,3,2,2,bestiary[0][3][3][1]);
		bestiary[0][3][1][0]=new MonsterType(0,3,1,0,bestiary[0][3][2][0],bestiary[0][3][2][1],bestiary[0][3][2][2]);
		bestiary[0][3][0][0]=new MonsterType(0,3,0,0,bestiary[0][3][1][0]);
		bestiary[0][3][4][0].setEvolvesFrom(bestiary[0][3][3][0]);
		bestiary[0][3][4][0].setEvolvesFrom2(bestiary[0][3][3][1]);
		bestiary[0][3][3][0].setEvolvesFrom(bestiary[0][3][2][0]);
		bestiary[0][3][3][1].setEvolvesFrom(bestiary[0][3][2][1]);
		bestiary[0][3][3][1].setEvolvesFrom2(bestiary[0][3][2][2]);
		bestiary[0][3][2][0].setEvolvesFrom(bestiary[0][3][1][0]);
		bestiary[0][3][2][1].setEvolvesFrom(bestiary[0][3][1][0]);
		bestiary[0][3][2][1].setEvolvesFrom(bestiary[0][3][1][0]);
		bestiary[0][3][1][0].setEvolvesFrom(bestiary[0][3][0][0]);
		bestiary[0][4]=new MonsterType[5][];
		bestiary[0][4][0]=new MonsterType[1];
		bestiary[0][4][1]=new MonsterType[1];
		bestiary[0][4][2]=new MonsterType[2];
		bestiary[0][4][3]=new MonsterType[2];
		bestiary[0][4][4]=new MonsterType[2];
		bestiary[0][4][4][0]=new MonsterType(0,4,4,0);
		bestiary[0][4][4][1]=new MonsterType(0,4,4,1);
		bestiary[0][4][3][0]=new MonsterType(0,4,3,0,bestiary[0][4][4][0]);
		bestiary[0][4][3][1]=new MonsterType(0,4,3,1,bestiary[0][4][4][1]);
		bestiary[0][4][2][0]=new MonsterType(0,4,2,0,bestiary[0][4][3][0]);
		bestiary[0][4][2][1]=new MonsterType(0,4,2,1,bestiary[0][4][3][1]);
		bestiary[0][4][1][0]=new MonsterType(0,4,1,0,bestiary[0][4][2][0],bestiary[0][4][2][1]);
		bestiary[0][4][0][0]=new MonsterType(0,4,0,0,bestiary[0][4][1][0]);
		bestiary[0][4][4][0].setEvolvesFrom(bestiary[0][4][3][0]);
		bestiary[0][4][4][1].setEvolvesFrom(bestiary[0][4][3][1]);
		bestiary[0][4][3][0].setEvolvesFrom(bestiary[0][4][2][0]);
		bestiary[0][4][3][1].setEvolvesFrom(bestiary[0][4][2][1]);
		bestiary[0][4][2][0].setEvolvesFrom(bestiary[0][4][1][0]);
		bestiary[0][4][2][1].setEvolvesFrom(bestiary[0][4][1][0]);
		bestiary[0][4][1][0].setEvolvesFrom(bestiary[0][4][0][0]);
		bestiary[0][5]=new MonsterType[5][];
		bestiary[0][5][0]=new MonsterType[1];
		bestiary[0][5][1]=new MonsterType[1];
		bestiary[0][5][2]=new MonsterType[3];
		bestiary[0][5][3]=new MonsterType[2];
		bestiary[0][5][4]=new MonsterType[1];
		bestiary[0][5][4][0]=new MonsterType(0,5,4,0);
		bestiary[0][5][3][0]=new MonsterType(0,5,3,0,bestiary[0][5][3][0]);
		bestiary[0][5][3][1]=new MonsterType(0,5,3,1,bestiary[0][5][4][0]);
		bestiary[0][5][2][0]=new MonsterType(0,5,2,0,bestiary[0][5][4][0]);		
		bestiary[0][5][2][1]=new MonsterType(0,5,2,1,bestiary[0][5][3][0],bestiary[0][5][3][1]);
		bestiary[0][5][2][2]=new MonsterType(0,5,2,2,bestiary[0][5][3][1]);
		bestiary[0][5][1][0]=new MonsterType(0,5,1,0,bestiary[0][5][2][0],bestiary[0][5][2][1],bestiary[0][5][2][2]);
		bestiary[0][5][0][0]=new MonsterType(0,5,0,0,bestiary[0][5][1][0]);
		bestiary[0][5][4][0].setEvolvesFrom(bestiary[0][5][3][0]);
		bestiary[0][5][4][0].setEvolvesFrom2(bestiary[0][5][3][1]);
		bestiary[0][5][3][0].setEvolvesFrom(bestiary[0][5][2][0]);
		bestiary[0][5][3][0].setEvolvesFrom2(bestiary[0][5][2][1]);
		bestiary[0][5][3][1].setEvolvesFrom(bestiary[0][5][2][1]);
		bestiary[0][5][3][1].setEvolvesFrom2(bestiary[0][5][2][2]);
		bestiary[0][5][2][0].setEvolvesFrom(bestiary[0][5][1][0]);
		bestiary[0][5][2][1].setEvolvesFrom(bestiary[0][5][1][0]);
		bestiary[0][5][2][2].setEvolvesFrom(bestiary[0][5][1][0]);
		bestiary[0][5][1][0].setEvolvesFrom(bestiary[0][5][0][0]);
		bestiary[1][0]=new MonsterType[5][];
		bestiary[1][0][0]=new MonsterType[1];
		bestiary[1][0][1]=new MonsterType[1];
		bestiary[1][0][2]=new MonsterType[1];
		bestiary[1][0][3]=new MonsterType[1];
		bestiary[1][0][4]=new MonsterType[1];
		bestiary[1][0][4][0]=new MonsterType(1,0,4,0);
		bestiary[1][0][3][0]=new MonsterType(1,0,3,0,bestiary[1][0][4][0]);
		bestiary[1][0][2][0]=new MonsterType(1,0,2,0,bestiary[1][0][3][0]);
		bestiary[1][0][1][0]=new MonsterType(1,0,1,0,bestiary[1][0][2][0]);
		bestiary[1][0][0][0]=new MonsterType(1,0,0,0,bestiary[1][0][1][0]);
		bestiary[1][0][4][0].setEvolvesFrom(bestiary[1][0][3][0]);
		bestiary[1][0][3][0].setEvolvesFrom(bestiary[1][0][2][0]);
		bestiary[1][0][2][0].setEvolvesFrom(bestiary[1][0][1][0]);
		bestiary[1][0][1][0].setEvolvesFrom(bestiary[1][0][0][0]);
		bestiary[1][1]=new MonsterType[5][];
		bestiary[1][1][0]=new MonsterType[1];
		bestiary[1][1][1]=new MonsterType[1];
		bestiary[1][1][2]=new MonsterType[3];
		bestiary[1][1][3]=new MonsterType[3];
		bestiary[1][1][4]=new MonsterType[3];
		bestiary[1][1][4][0]=new MonsterType(1,1,4,0);
		bestiary[1][1][4][1]=new MonsterType(1,1,4,1);
		bestiary[1][1][4][2]=new MonsterType(1,1,4,2);
		bestiary[1][1][3][0]=new MonsterType(1,1,3,0,bestiary[1][1][4][0]);
		bestiary[1][1][3][1]=new MonsterType(1,1,3,1,bestiary[1][1][4][1]);
		bestiary[1][1][3][2]=new MonsterType(1,1,3,2,bestiary[1][1][4][2]);
		bestiary[1][1][2][0]=new MonsterType(1,1,2,0,bestiary[1][1][3][0]);
		bestiary[1][1][2][1]=new MonsterType(1,1,2,1,bestiary[1][1][3][1]);
		bestiary[1][1][2][2]=new MonsterType(1,1,2,1,bestiary[1][1][3][2]);
		bestiary[1][1][1][0]=new MonsterType(1,1,1,0,bestiary[1][1][2][0],bestiary[1][1][2][1],bestiary[1][1][2][2]);
		bestiary[1][1][0][0]=new MonsterType(1,1,0,0,bestiary[1][1][1][0]);
		bestiary[1][1][4][0].setEvolvesFrom(bestiary[1][1][3][0]);
		bestiary[1][1][4][1].setEvolvesFrom(bestiary[1][1][3][1]);
		bestiary[1][1][4][2].setEvolvesFrom(bestiary[1][1][3][2]);
		bestiary[1][1][3][0].setEvolvesFrom(bestiary[1][1][2][0]);
		bestiary[1][1][3][1].setEvolvesFrom(bestiary[1][1][2][1]);
		bestiary[1][1][3][2].setEvolvesFrom(bestiary[1][1][2][2]);
		bestiary[1][1][2][0].setEvolvesFrom(bestiary[1][1][1][0]);
		bestiary[1][1][2][1].setEvolvesFrom(bestiary[1][1][1][0]);
		bestiary[1][1][2][2].setEvolvesFrom(bestiary[1][1][1][0]);
		bestiary[1][1][1][0].setEvolvesFrom(bestiary[1][1][0][0]);
		bestiary[1][2]=new MonsterType[5][];
		bestiary[1][2][0]=new MonsterType[1];
		bestiary[1][2][1]=new MonsterType[1];
		bestiary[1][2][2]=new MonsterType[3];
		bestiary[1][2][3]=new MonsterType[3];
		bestiary[1][2][4]=new MonsterType[3];
		bestiary[1][2][4][0]=new MonsterType(1,2,4,0);
		bestiary[1][2][4][1]=new MonsterType(1,2,4,1);
		bestiary[1][2][4][2]=new MonsterType(1,2,4,2);
		bestiary[1][2][3][0]=new MonsterType(1,2,3,0,bestiary[1][2][4][0]);
		bestiary[1][2][3][1]=new MonsterType(1,2,3,1,bestiary[1][2][4][1]);
		bestiary[1][2][3][2]=new MonsterType(1,2,3,2,bestiary[1][2][4][2]);
		bestiary[1][2][2][0]=new MonsterType(1,2,2,0,bestiary[1][2][3][0]);
		bestiary[1][2][2][1]=new MonsterType(1,2,2,1,bestiary[1][2][3][1]);
		bestiary[1][2][2][2]=new MonsterType(1,2,2,2,bestiary[1][2][3][2]);
		bestiary[1][2][1][0]=new MonsterType(1,2,1,0,bestiary[1][2][2][0],bestiary[1][2][2][1],bestiary[1][2][2][2]);
		bestiary[1][2][0][0]=new MonsterType(1,2,0,0,bestiary[1][2][1][0]);
		bestiary[1][2][4][0].setEvolvesFrom(bestiary[1][2][3][0]);
		bestiary[1][2][4][1].setEvolvesFrom(bestiary[1][2][3][1]);
		bestiary[1][2][4][2].setEvolvesFrom(bestiary[1][2][3][2]);
		bestiary[1][2][3][0].setEvolvesFrom(bestiary[1][2][2][0]);
		bestiary[1][2][3][1].setEvolvesFrom(bestiary[1][2][3][1]);
		bestiary[1][2][3][2].setEvolvesFrom(bestiary[1][2][3][2]);
		bestiary[1][2][2][0].setEvolvesFrom(bestiary[1][2][1][0]);
		bestiary[1][2][2][1].setEvolvesFrom(bestiary[1][2][1][0]);
		bestiary[1][2][2][2].setEvolvesFrom(bestiary[1][2][1][0]);
		bestiary[1][2][1][0].setEvolvesFrom(bestiary[1][2][0][0]);
		bestiary[1][3]=new MonsterType[5][];
		bestiary[1][3][0]=new MonsterType[1];
		bestiary[1][3][1]=new MonsterType[1];
		bestiary[1][3][2]=new MonsterType[3];
		bestiary[1][3][3]=new MonsterType[5];
		bestiary[1][3][4]=new MonsterType[2];
		bestiary[1][3][4][0]=new MonsterType(1,3,4,0);
		bestiary[1][3][4][1]=new MonsterType(1,3,4,1);
		bestiary[1][3][3][0]=new MonsterType(1,3,3,0,bestiary[1][3][4][0]);
		bestiary[1][3][3][1]=new MonsterType(1,3,3,1,bestiary[1][3][4][0]);
		bestiary[1][3][3][2]=new MonsterType(1,3,3,2,bestiary[1][3][4][0],bestiary[1][3][4][1]);
		bestiary[1][3][3][3]=new MonsterType(1,3,3,3,bestiary[1][3][4][1]);
		bestiary[1][3][3][4]=new MonsterType(1,3,3,4,bestiary[1][3][4][1]);
		bestiary[1][3][2][0]=new MonsterType(1,3,2,0,bestiary[1][3][3][0],bestiary[1][3][3][1],bestiary[1][3][3][2]);
		bestiary[1][3][2][1]=new MonsterType(1,3,2,1,bestiary[1][3][3][2],bestiary[1][3][3][3]);
		bestiary[1][3][2][2]=new MonsterType(1,3,2,2,bestiary[1][3][3][3],bestiary[1][3][3][4]);
		bestiary[1][3][1][0]=new MonsterType(1,3,1,0,bestiary[1][3][2][0],bestiary[1][3][2][1],bestiary[1][3][2][2]);
		bestiary[1][3][0][0]=new MonsterType(1,3,0,0,bestiary[1][3][1][0]);
		bestiary[1][3][4][0].setEvolvesFrom1(bestiary[1][3][3][0]);
		bestiary[1][3][4][0].setEvolvesFrom2(bestiary[1][3][3][1]);
		bestiary[1][3][4][0].setEvolvesFrom3(bestiary[1][3][3][2]);
		bestiary[1][3][4][1].setEvolvesFrom1(bestiary[1][3][3][2]);
		bestiary[1][3][4][1].setEvolvesFrom2(bestiary[1][3][3][3]);
		bestiary[1][3][4][1].setEvolvesFrom3(bestiary[1][3][3][4]);
		bestiary[1][3][3][0].setEvolvesFrom1(bestiary[1][3][2][0]);
		bestiary[1][3][3][1].setEvolvesFrom1(bestiary[1][3][2][0]);
		bestiary[1][3][3][2].setEvolvesFrom1(bestiary[1][3][2][0]);
		bestiary[1][3][3][2].setEvolvesFrom2(bestiary[1][3][2][1]);
		bestiary[1][3][3][3].setEvolvesFrom1(bestiary[1][3][2][1]);
		bestiary[1][3][3][3].setEvolvesFrom2(bestiary[1][3][2][2]);
		bestiary[1][3][3][4].setEvolvesFrom1(bestiary[1][3][2][2]);
		bestiary[1][3][2][0].setEvolvesFrom(bestiary[1][3][1][0]);
		bestiary[1][3][2][1].setEvolvesFrom(bestiary[1][3][1][0]);
		bestiary[1][3][2][2].setEvolvesFrom(bestiary[1][3][1][0]);
		bestiary[1][3][1][0].setEvolvesFrom(bestiary[1][3][0][0]);
		bestiary[1][4]=new MonsterType[5][];
		bestiary[1][4][0]=new MonsterType[1];
		bestiary[1][4][1]=new MonsterType[1];
		bestiary[1][4][2]=new MonsterType[3];
		bestiary[1][4][3]=new MonsterType[5];
		bestiary[1][4][4]=new MonsterType[5];
		bestiary[1][4][4][0]=new MonsterType(1,4,4,0);
		bestiary[1][4][4][1]=new MonsterType(1,4,4,1);
		bestiary[1][4][4][2]=new MonsterType(1,4,4,2);
		bestiary[1][4][4][3]=new MonsterType(1,4,4,3);
		bestiary[1][4][4][4]=new MonsterType(1,4,4,4);
		bestiary[1][4][3][0]=new MonsterType(1,4,3,0,bestiary[1][4][4][0]);
		bestiary[1][4][3][1]=new MonsterType(1,4,3,1,bestiary[1][4][4][1]);
		bestiary[1][4][3][2]=new MonsterType(1,4,3,2,bestiary[1][4][4][2]);
		bestiary[1][4][3][3]=new MonsterType(1,4,3,3,bestiary[1][4][4][3]);
		bestiary[1][4][3][4]=new MonsterType(1,4,3,4,bestiary[1][4][4][4]);
		bestiary[1][4][2][0]=new MonsterType(1,4,2,0,bestiary[1][4][3][0]);
		bestiary[1][4][2][1]=new MonsterType(1,4,2,1,bestiary[1][4][3][1]);
		bestiary[1][4][2][2]=new MonsterType(1,4,2,2,bestiary[1][4][3][2],bestiary[1][4][3][3],bestiary[1][4][3][4]);
		bestiary[1][4][1][0]=new MonsterType(1,4,1,0,bestiary[1][4][2][0],bestiary[1][4][2][1],bestiary[1][4][2][2]);
		bestiary[1][4][0][0]=new MonsterType(1,4,0,0,bestiary[1][4][1][0]);
		bestiary[1][4][4][0].setEvolvesFrom(bestiary[1][4][3][0]);
		bestiary[1][4][4][1].setEvolvesFrom(bestiary[1][4][3][1]);
		bestiary[1][4][4][2].setEvolvesFrom(bestiary[1][4][3][2]);
		bestiary[1][4][4][3].setEvolvesFrom(bestiary[1][4][3][3]);
		bestiary[1][4][4][4].setEvolvesFrom(bestiary[1][4][3][4]);
		bestiary[1][4][3][0].setEvolvesFrom(bestiary[1][4][2][0]);
		bestiary[1][4][3][1].setEvolvesFrom(bestiary[1][4][2][1]);
		bestiary[1][4][3][2].setEvolvesFrom(bestiary[1][4][2][2]);
		bestiary[1][4][3][3].setEvolvesFrom(bestiary[1][4][2][2]);
		bestiary[1][4][3][3].setEvolvesFrom(bestiary[1][4][2][2]);
		bestiary[1][4][2][0].setEvolvesFrom(bestiary[1][4][1][0]);
		bestiary[1][4][2][1].setEvolvesFrom(bestiary[1][4][1][0]);
		bestiary[1][4][2][2].setEvolvesFrom(bestiary[1][4][1][0]);
		bestiary[1][4][1][0].setEvolvesFrom(bestiary[1][4][0][0]);
		bestiary[1][5]=new MonsterType[5][];
		bestiary[1][5][0]=new MonsterType[1];
		bestiary[1][5][1]=new MonsterType[1];
		bestiary[1][5][2]=new MonsterType[3];
		bestiary[1][5][3]=new MonsterType[6];
		bestiary[1][5][4]=new MonsterType[5];
		bestiary[1][5][4][0]=new MonsterType(1,5,4,0);
		bestiary[1][5][4][1]=new MonsterType(1,5,4,1);
		bestiary[1][5][4][2]=new MonsterType(1,5,4,2);
		bestiary[1][5][4][3]=new MonsterType(1,5,4,3);
		bestiary[1][5][4][4]=new MonsterType(1,5,4,4);
		bestiary[1][5][3][0]=new MonsterType(1,5,3,0,bestiary[1][5][4][0]);
		bestiary[1][5][3][1]=new MonsterType(1,5,3,1,bestiary[1][5][4][1]);
		bestiary[1][5][3][2]=new MonsterType(1,5,3,2,bestiary[1][5][4][2]);
		bestiary[1][5][3][3]=new MonsterType(1,5,3,3,bestiary[1][5][4][3]);
		bestiary[1][5][3][4]=new MonsterType(1,5,3,4,bestiary[1][5][4][4]);
		bestiary[1][5][3][5]=new MonsterType(1,5,3,5,bestiary[1][5][4][4]);
		bestiary[1][5][2][0]=new MonsterType(1,5,2,0,bestiary[1][5][3][0]);
		bestiary[1][5][2][1]=new MonsterType(1,5,2,1,bestiary[1][5][3][1],bestiary[1][5][3][2]);
		bestiary[1][5][2][2]=new MonsterType(1,5,2,2,bestiary[1][5][3][3],bestiary[1][5][3][4],bestiary[1][5][3][5]);
		bestiary[1][5][1][0]=new MonsterType(1,5,1,0,bestiary[1][5][2][0],bestiary[1][5][2][1],bestiary[1][5][2][2]);
		bestiary[1][5][0][0]=new MonsterType(1,5,0,0,bestiary[1][5][1][0]);
		bestiary[1][5][4][0].setEvolvesFrom(bestiary[1][5][3][0]);
		bestiary[1][5][4][1].setEvolvesFrom(bestiary[1][5][3][1]);
		bestiary[1][5][4][2].setEvolvesFrom(bestiary[1][5][3][2]);
		bestiary[1][5][4][3].setEvolvesFrom(bestiary[1][5][3][3]);
		bestiary[1][5][4][4].setEvolvesFrom1(bestiary[1][5][3][4]);
		bestiary[1][5][4][4].setEvolvesFrom2(bestiary[1][5][3][5]);
		bestiary[1][5][3][0].setEvolvesFrom(bestiary[1][5][2][0]);
		bestiary[1][5][3][1].setEvolvesFrom(bestiary[1][5][2][1]);
		bestiary[1][5][3][2].setEvolvesFrom(bestiary[1][5][2][1]);
		bestiary[1][5][3][3].setEvolvesFrom(bestiary[1][5][2][2]);
		bestiary[1][5][3][4].setEvolvesFrom(bestiary[1][5][2][2]);
		bestiary[1][5][3][5].setEvolvesFrom(bestiary[1][5][2][2]);
		bestiary[1][5][2][0].setEvolvesFrom(bestiary[1][5][1][0]);
		bestiary[1][5][2][1].setEvolvesFrom(bestiary[1][5][1][0]);
		bestiary[1][5][2][2].setEvolvesFrom(bestiary[1][5][1][0]);
		bestiary[1][5][1][0].setEvolvesFrom(bestiary[1][5][0][0]);
		bestiary[2][0]=new MonsterType[5][];
		bestiary[2][0][0]=new MonsterType[1];
		bestiary[2][0][1]=new MonsterType[1];
		bestiary[2][0][2]=new MonsterType[3];
		bestiary[2][0][3]=new MonsterType[3];
		bestiary[2][0][4]=new MonsterType[3];
		bestiary[2][0][4][0]=new MonsterType(2,0,4,0);
		bestiary[2][0][4][1]=new MonsterType(2,0,4,1);
		bestiary[2][0][4][2]=new MonsterType(2,0,4,2);
		bestiary[2][0][3][0]=new MonsterType(2,0,3,0,bestiary[2][0][4][0]);
		bestiary[2][0][3][1]=new MonsterType(2,0,3,1,bestiary[2][0][4][1]);
		bestiary[2][0][3][2]=new MonsterType(2,0,3,2,bestiary[2][0][4][2]);
		bestiary[2][0][2][0]=new MonsterType(2,0,2,0,bestiary[2][0][3][0]);
		bestiary[2][0][2][1]=new MonsterType(2,0,2,1,bestiary[2][0][3][1]);
		bestiary[2][0][2][2]=new MonsterType(2,0,2,2,bestiary[2][0][3][2]);
		bestiary[2][0][1][0]=new MonsterType(2,0,1,0,bestiary[2][0][2][0],bestiary[2][0][2][1],bestiary[2][0][2][2]);
		bestiary[2][0][0][0]=new MonsterType(2,0,0,0,bestiary[2][0][1][0]);
		bestiary[2][0][4][0].setEvolvesFrom(bestiary[2][0][3][0]);
		bestiary[2][0][4][1].setEvolvesFrom(bestiary[2][0][3][1]);
		bestiary[2][0][4][2].setEvolvesFrom(bestiary[2][0][3][2]);
		bestiary[2][0][3][0].setEvolvesFrom(bestiary[2][0][2][0]);
		bestiary[2][0][3][1].setEvolvesFrom(bestiary[2][0][2][1]);
		bestiary[2][0][3][2].setEvolvesFrom(bestiary[2][0][2][2]);
		bestiary[2][0][2][0].setEvolvesFrom(bestiary[2][0][1][0]);
		bestiary[2][0][2][1].setEvolvesFrom(bestiary[2][0][1][0]);
		bestiary[2][0][2][2].setEvolvesFrom(bestiary[2][0][1][0]);
		bestiary[2][0][1][0].setEvolvesFrom(bestiary[2][0][0][0]);
		bestiary[2][1]=new MonsterType[5][];
		bestiary[2][1][0]=new MonsterType[1];
		bestiary[2][1][1]=new MonsterType[1];
		bestiary[2][1][2]=new MonsterType[2];
		bestiary[2][1][3]=new MonsterType[2];
		bestiary[2][1][4]=new MonsterType[2];
		bestiary[2][1][4][0]=new MonsterType(2,1,4,0);
		bestiary[2][1][4][1]=new MonsterType(2,1,4,1);
		bestiary[2][1][3][0]=new MonsterType(2,1,3,0,bestiary[2][1][4][0]);
		bestiary[2][1][3][1]=new MonsterType(2,1,3,1,bestiary[2][1][4][1]);
		bestiary[2][1][2][0]=new MonsterType(2,1,2,0,bestiary[2][1][3][1]);
		bestiary[2][1][2][1]=new MonsterType(2,1,2,1,bestiary[2][1][3][0]);
		bestiary[2][1][1][0]=new MonsterType(2,1,1,0,bestiary[2][1][2][0],bestiary[2][1][2][1]);
		bestiary[2][1][0][0]=new MonsterType(2,1,0,0,bestiary[2][1][1][0]);
		bestiary[2][1][4][0].setEvolvesFrom(bestiary[2][1][3][0]);
		bestiary[2][1][4][1].setEvolvesFrom(bestiary[2][1][3][1]);
		bestiary[2][1][3][0].setEvolvesFrom(bestiary[2][1][2][0]);
		bestiary[2][1][3][1].setEvolvesFrom(bestiary[2][1][2][1]);
		bestiary[2][1][2][0].setEvolvesFrom(bestiary[2][1][1][0]);
		bestiary[2][1][2][1].setEvolvesFrom(bestiary[2][1][1][0]);
		bestiary[2][1][1][0].setEvolvesFrom(bestiary[2][1][0][0]);
		bestiary[2][2]=new MonsterType[5][];
		bestiary[2][2][0]=new MonsterType[1];
		bestiary[2][2][1]=new MonsterType[3];
		bestiary[2][2][2]=new MonsterType[5];
		bestiary[2][2][3]=new MonsterType[6];
		bestiary[2][2][4]=new MonsterType[7];
		bestiary[2][2][4][0]=new MonsterType(2,2,4,0);
		bestiary[2][2][4][1]=new MonsterType(2,2,4,1);
		bestiary[2][2][4][2]=new MonsterType(2,2,4,2);
		bestiary[2][2][4][3]=new MonsterType(2,2,4,3);
		bestiary[2][2][4][4]=new MonsterType(2,2,4,4);
		bestiary[2][2][4][5]=new MonsterType(2,2,4,5);//TODO change to ygrdassil
		bestiary[2][2][4][6]=new MonsterType(2,2,4,5);
		bestiary[2][2][3][0]=new MonsterType(2,2,3,0,bestiary[2][2][4][0]);
		bestiary[2][2][3][1]=new MonsterType(2,2,3,1,bestiary[2][2][4][1],bestiary[2][2][4][2]);
		bestiary[2][2][3][2]=new MonsterType(2,2,3,2,bestiary[2][2][4][3]);
		bestiary[2][2][3][3]=new MonsterType(2,2,3,1,bestiary[2][2][4][4]);
		bestiary[2][2][3][4]=new MonsterType(2,2,3,2,bestiary[2][2][4][5]);
		bestiary[2][2][3][5]=new MonsterType(2,2,3,2,bestiary[2][2][4][6]);
		bestiary[2][2][2][0]=new MonsterType(2,2,2,0,bestiary[2][2][3][0]);
		bestiary[2][2][2][1]=new MonsterType(2,2,2,1,bestiary[2][2][3][1]);
		bestiary[2][2][2][2]=new MonsterType(2,2,2,2,bestiary[2][2][3][2]);
		bestiary[2][2][2][3]=new MonsterType(2,2,2,3,bestiary[2][2][3][3],bestiary[2][2][3][4]);
		bestiary[2][2][2][4]=new MonsterType(2,2,2,5,bestiary[2][2][3][5]);
		bestiary[2][2][1][0]=new MonsterType(2,2,1,0,bestiary[2][2][2][0]);
		bestiary[2][2][1][1]=new MonsterType(2,2,1,1,bestiary[2][2][2][1],bestiary[2][2][2][2],bestiary[2][2][2][4]);
		bestiary[2][2][1][2]=new MonsterType(2,2,1,2,bestiary[2][2][2][3],bestiary[2][2][2][4]);		
		bestiary[2][2][0][0]=new MonsterType(2,2,0,0,bestiary[2][2][1][0],bestiary[2][2][1][1],bestiary[2][2][1][2]);
		bestiary[2][2][4][0].setEvolvesFrom(bestiary[2][2][3][0]);
		bestiary[2][2][4][1].setEvolvesFrom(bestiary[2][2][3][1]);
		bestiary[2][2][4][2].setEvolvesFrom(bestiary[2][2][3][1]);
		bestiary[2][2][4][3].setEvolvesFrom(bestiary[2][2][3][2]);
		bestiary[2][2][4][4].setEvolvesFrom(bestiary[2][2][3][3]);
		bestiary[2][2][4][5].setEvolvesFrom(bestiary[2][2][3][4]);
		bestiary[2][2][4][6].setEvolvesFrom(bestiary[2][2][3][5]);
		bestiary[2][2][3][0].setEvolvesFrom(bestiary[2][2][2][0]);
		bestiary[2][2][3][1].setEvolvesFrom(bestiary[2][2][2][1]);
		bestiary[2][2][3][2].setEvolvesFrom(bestiary[2][2][2][2]);
		bestiary[2][2][3][3].setEvolvesFrom(bestiary[2][2][2][3]);
		bestiary[2][2][3][4].setEvolvesFrom(bestiary[2][2][2][3]);
		bestiary[2][2][2][0].setEvolvesFrom(bestiary[2][2][1][0]);
		bestiary[2][2][2][1].setEvolvesFrom(bestiary[2][2][1][1]);
		bestiary[2][2][2][2].setEvolvesFrom(bestiary[2][2][1][1]);
		bestiary[2][2][2][3].setEvolvesFrom(bestiary[2][2][1][2]);
		bestiary[2][2][2][4].setEvolvesFrom(bestiary[2][2][1][1]);
		bestiary[2][2][2][4].setEvolvesFrom(bestiary[2][2][1][2]);
		bestiary[2][2][1][0].setEvolvesFrom(bestiary[2][2][0][0]);
		bestiary[2][2][1][1].setEvolvesFrom(bestiary[2][2][0][0]);
		bestiary[2][2][1][2].setEvolvesFrom(bestiary[2][2][0][0]);
		bestiary[2][3]=new MonsterType[5][];
		bestiary[2][3][0]=new MonsterType[1];
		bestiary[2][3][1]=new MonsterType[1];
		bestiary[2][3][2]=new MonsterType[2];
		bestiary[2][3][3]=new MonsterType[2];
		bestiary[2][3][4]=new MonsterType[2];
		bestiary[2][3][4][0]=new MonsterType(2,3,4,0);
		bestiary[2][3][4][1]=new MonsterType(2,3,4,1);
		bestiary[2][3][3][0]=new MonsterType(2,3,3,0,bestiary[2][3][4][0]);
		bestiary[2][3][3][1]=new MonsterType(2,3,3,1,bestiary[2][3][4][1]);
		bestiary[2][3][2][0]=new MonsterType(2,3,2,0,bestiary[2][3][3][0]);
		bestiary[2][3][2][1]=new MonsterType(2,3,2,1,bestiary[2][3][3][1]);
		bestiary[2][3][1][0]=new MonsterType(2,3,1,0,bestiary[2][3][2][0],bestiary[2][3][2][1]);
		bestiary[2][3][0][0]=new MonsterType(2,3,0,0,bestiary[2][3][1][0]);
		bestiary[2][3][4][0].setEvolvesFrom(bestiary[2][3][3][0]);
		bestiary[2][3][4][1].setEvolvesFrom(bestiary[2][3][3][1]);
		bestiary[2][3][3][0].setEvolvesFrom(bestiary[2][3][2][0]);
		bestiary[2][3][3][1].setEvolvesFrom(bestiary[2][3][2][1]);
		bestiary[2][3][2][0].setEvolvesFrom(bestiary[2][3][1][0]);
		bestiary[2][3][2][1].setEvolvesFrom(bestiary[2][3][1][0]);
		bestiary[2][3][1][0].setEvolvesFrom(bestiary[2][3][0][0]);
		bestiary[2][4]=new MonsterType[5][];
		bestiary[2][4][0]=new MonsterType[1];
		bestiary[2][4][1]=new MonsterType[1];
		bestiary[2][4][2]=new MonsterType[2];
		bestiary[2][4][3]=new MonsterType[2];
		bestiary[2][4][4]=new MonsterType[2];
		bestiary[2][4][4][0]=new MonsterType(2,4,4,0);
		bestiary[2][4][4][1]=new MonsterType(2,4,4,1);
		bestiary[2][4][3][0]=new MonsterType(2,4,3,0,bestiary[2][4][3][0]);
		bestiary[2][4][3][1]=new MonsterType(2,4,3,1,bestiary[2][4][3][1]);
		bestiary[2][4][2][0]=new MonsterType(2,4,2,0,bestiary[2][4][3][0]);
		bestiary[2][4][2][1]=new MonsterType(2,4,2,1,bestiary[2][4][3][1]);
		bestiary[2][4][1][0]=new MonsterType(2,4,1,0,bestiary[2][4][2][0],bestiary[2][4][2][1]);
		bestiary[2][4][0][0]=new MonsterType(2,4,0,0,bestiary[2][4][1][0]);
		bestiary[2][4][4][0].setEvolvesFrom(bestiary[2][4][3][0]);
		bestiary[2][4][4][1].setEvolvesFrom(bestiary[2][4][3][1]);
		bestiary[2][4][3][0].setEvolvesFrom(bestiary[2][4][2][0]);
		bestiary[2][4][3][1].setEvolvesFrom(bestiary[2][4][2][1]);
		bestiary[2][4][2][0].setEvolvesFrom(bestiary[2][4][1][0]);
		bestiary[2][4][2][1].setEvolvesFrom(bestiary[2][4][1][0]);
		bestiary[2][4][1][0].setEvolvesFrom(bestiary[2][4][0][0]);
		bestiary[2][5]=new MonsterType[5][];//TODO think about redoing this one
		bestiary[2][5][0]=new MonsterType[1];
		bestiary[2][5][1]=new MonsterType[1];
		bestiary[2][5][2]=new MonsterType[1];
		bestiary[2][5][3]=new MonsterType[1];
		bestiary[2][5][4]=new MonsterType[1];
		bestiary[2][5][4][0]=new MonsterType(2,5,4,0);
		bestiary[2][5][3][0]=new MonsterType(2,5,3,0,bestiary[2][5][4][0]);
		bestiary[2][5][2][0]=new MonsterType(2,5,2,0,bestiary[2][5][3][0]);
		bestiary[2][5][1][0]=new MonsterType(2,5,1,0,bestiary[2][5][2][0]);
		bestiary[2][5][0][0]=new MonsterType(2,5,0,0,bestiary[2][5][1][0]);
		bestiary[2][5][4][0].setEvolvesFrom(bestiary[2][5][3][0]);
		bestiary[2][5][3][0].setEvolvesFrom(bestiary[2][5][2][0]);
		bestiary[2][5][2][0].setEvolvesFrom(bestiary[2][5][1][0]);
		bestiary[2][5][1][0].setEvolvesFrom(bestiary[2][5][0][0]);
		bestiary[3][0]=new MonsterType[5][];
		bestiary[3][0][0]=new MonsterType[1];
		bestiary[3][0][1]=new MonsterType[1];
		bestiary[3][0][2]=new MonsterType[3];
		bestiary[3][0][3]=new MonsterType[3];
		bestiary[3][0][4]=new MonsterType[3];
		bestiary[3][0][4][0]=new MonsterType(3,0,4,0);
		bestiary[3][0][4][1]=new MonsterType(3,0,4,1);
		bestiary[3][0][4][2]=new MonsterType(3,0,4,2);
		bestiary[3][0][3][0]=new MonsterType(3,0,3,0,bestiary[3][0][4][0]);
		bestiary[3][0][3][1]=new MonsterType(3,0,3,1,bestiary[3][0][4][1]);
		bestiary[3][0][3][2]=new MonsterType(3,0,3,2,bestiary[3][0][4][2]);
		bestiary[3][0][2][0]=new MonsterType(3,0,2,0,bestiary[3][0][3][0]);
		bestiary[3][0][2][1]=new MonsterType(3,0,2,1,bestiary[3][0][3][1]);
		bestiary[3][0][2][2]=new MonsterType(3,0,2,2,bestiary[3][0][3][2]);
		bestiary[3][0][1][0]=new MonsterType(3,0,1,0,bestiary[3][0][2][0],bestiary[3][0][2][1],bestiary[3][0][2][2]);
		bestiary[3][0][0][0]=new MonsterType(3,0,0,0,bestiary[3][0][1][0]);
		bestiary[3][0][4][0].setEvolvesFrom(bestiary[3][0][3][0]);
		bestiary[3][0][4][1].setEvolvesFrom(bestiary[3][0][3][1]);
		bestiary[3][0][4][2].setEvolvesFrom(bestiary[3][0][3][2]);
		bestiary[3][0][3][0].setEvolvesFrom(bestiary[3][0][2][0]);
		bestiary[3][0][3][1].setEvolvesFrom(bestiary[3][0][2][1]);
		bestiary[3][0][3][2].setEvolvesFrom(bestiary[3][0][2][2]);
		bestiary[3][0][2][0].setEvolvesFrom(bestiary[3][0][1][0]);
		bestiary[3][0][2][1].setEvolvesFrom(bestiary[3][0][1][0]);
		bestiary[3][0][2][2].setEvolvesFrom(bestiary[3][0][1][0]);
		bestiary[3][0][1][0].setEvolvesFrom(bestiary[3][0][0][0]);
		bestiary[3][1]=new MonsterType[5][];
		bestiary[3][1][0]=new MonsterType[1];
		bestiary[3][1][1]=new MonsterType[1];
		bestiary[3][1][2]=new MonsterType[2];
		bestiary[3][1][3]=new MonsterType[2];
		bestiary[3][1][4]=new MonsterType[2];
		bestiary[3][1][4][0]=new MonsterType(3,1,4,0);
		bestiary[3][1][4][1]=new MonsterType(3,1,4,1);
		bestiary[3][1][3][0]=new MonsterType(3,1,3,0,bestiary[3][1][4][0]);
		bestiary[3][1][3][1]=new MonsterType(3,1,3,1,bestiary[3][1][4][1]);
		bestiary[3][1][2][0]=new MonsterType(3,1,2,0,bestiary[3][1][3][0]);
		bestiary[3][1][2][1]=new MonsterType(3,1,2,1,bestiary[3][1][3][1]);
		bestiary[3][1][1][0]=new MonsterType(3,1,1,0,bestiary[3][1][2][0],bestiary[3][1][2][1]);
		bestiary[3][1][0][0]=new MonsterType(3,1,0,0,bestiary[3][1][1][0]);
		bestiary[3][1][4][0].setEvolvesFrom(bestiary[3][1][3][0]);
		bestiary[3][1][4][1].setEvolvesFrom(bestiary[3][1][3][1]);
		bestiary[3][1][3][0].setEvolvesFrom(bestiary[3][1][2][0]);
		bestiary[3][1][3][1].setEvolvesFrom(bestiary[3][1][2][1]);
		bestiary[3][1][2][0].setEvolvesFrom(bestiary[3][1][1][0]);
		bestiary[3][1][2][0].setEvolvesFrom(bestiary[3][1][1][0]);
		bestiary[3][1][1][0].setEvolvesFrom(bestiary[3][1][0][0]);
		bestiary[3][2]=new MonsterType[5][];
		bestiary[3][2][0]=new MonsterType[1];
		bestiary[3][2][1]=new MonsterType[1];
		bestiary[3][2][2]=new MonsterType[2];
		bestiary[3][2][3]=new MonsterType[2];
		bestiary[3][2][4]=new MonsterType[2];
		bestiary[3][2][4][0]=new MonsterType(3,2,4,0);
		bestiary[3][2][4][1]=new MonsterType(3,2,4,1);
		bestiary[3][2][3][0]=new MonsterType(3,2,3,0,bestiary[3][2][4][0]);
		bestiary[3][2][3][1]=new MonsterType(3,2,3,1,bestiary[3][2][4][1]);
		bestiary[3][2][2][0]=new MonsterType(3,2,2,0,bestiary[3][2][3][0]);
		bestiary[3][2][2][1]=new MonsterType(3,2,2,1,bestiary[3][2][3][1]);
		bestiary[3][2][1][0]=new MonsterType(3,2,1,0,bestiary[3][2][2][0],bestiary[3][2][2][1]);
		bestiary[3][2][0][0]=new MonsterType(3,2,0,0,bestiary[3][2][1][0]);
		bestiary[3][2][4][0].setEvolvesFrom(bestiary[3][2][3][0]);
		bestiary[3][2][4][1].setEvolvesFrom(bestiary[3][2][3][1]);
		bestiary[3][2][3][0].setEvolvesFrom(bestiary[3][2][2][0]);
		bestiary[3][2][3][1].setEvolvesFrom(bestiary[3][2][2][1]);
		bestiary[3][2][2][0].setEvolvesFrom(bestiary[3][2][1][0]);
		bestiary[3][2][2][1].setEvolvesFrom(bestiary[3][2][1][0]);
		bestiary[3][2][1][0].setEvolvesFrom(bestiary[3][2][0][0]);
		bestiary[3][3]=new MonsterType[5][];
		bestiary[3][3][0]=new MonsterType[1];
		bestiary[3][3][1]=new MonsterType[1];
		bestiary[3][3][2]=new MonsterType[3];
		bestiary[3][3][3]=new MonsterType[3];
		bestiary[3][3][4]=new MonsterType[2];
		bestiary[3][3][4][0]=new MonsterType(3,3,4,0);
		bestiary[3][3][4][1]=new MonsterType(3,3,4,1);
		bestiary[3][3][3][0]=new MonsterType(3,3,3,0,bestiary[3][3][4][0]);
		bestiary[3][3][3][1]=new MonsterType(3,3,3,1,bestiary[3][3][4][0]);
		bestiary[3][3][3][2]=new MonsterType(3,3,3,2,bestiary[3][3][4][1]);
		bestiary[3][3][2][0]=new MonsterType(3,3,2,0,bestiary[3][3][3][0]);
		bestiary[3][3][2][1]=new MonsterType(3,3,2,1,bestiary[3][3][3][1]);
		bestiary[3][3][2][2]=new MonsterType(3,3,2,3,bestiary[3][3][3][2]);
		bestiary[3][3][1][0]=new MonsterType(3,3,1,0,bestiary[3][3][2][0],bestiary[3][3][2][1],bestiary[3][3][2][2]);
		bestiary[3][3][0][0]=new MonsterType(3,3,0,0,bestiary[3][3][1][0]);
		bestiary[3][3][4][0].setEvolvesFrom(bestiary[3][3][3][0]);
		bestiary[3][3][4][0].setEvolvesFrom(bestiary[3][3][3][1]);
		bestiary[3][3][4][1].setEvolvesFrom(bestiary[3][3][3][2]);
		bestiary[3][3][3][0].setEvolvesFrom(bestiary[3][3][2][0]);
		bestiary[3][3][3][1].setEvolvesFrom(bestiary[3][3][2][1]);
		bestiary[3][3][3][2].setEvolvesFrom(bestiary[3][3][2][2]);
		bestiary[3][3][2][0].setEvolvesFrom(bestiary[3][3][1][0]);
		bestiary[3][3][2][1].setEvolvesFrom(bestiary[3][3][1][0]);
		bestiary[3][3][2][2].setEvolvesFrom(bestiary[3][3][1][0]);
		bestiary[3][3][1][0].setEvolvesFrom(bestiary[3][3][0][0]);
		bestiary[3][4]=new MonsterType[5][];
		bestiary[3][4][0]=new MonsterType[1];
		bestiary[3][4][1]=new MonsterType[1];
		bestiary[3][4][2]=new MonsterType[3];
		bestiary[3][4][3]=new MonsterType[3];
		bestiary[3][4][4]=new MonsterType[1];
		bestiary[3][4][4][0]=new MonsterType(3,4,4,0);
		bestiary[3][4][3][0]=new MonsterType(3,4,3,0,bestiary[3][4][4][0]);
		bestiary[3][4][3][1]=new MonsterType(3,4,3,1,bestiary[3][4][4][0]);
		bestiary[3][4][3][2]=new MonsterType(3,4,3,2,bestiary[3][4][4][0]);
		bestiary[3][4][2][0]=new MonsterType(3,4,2,0,bestiary[3][4][3][0]);
		bestiary[3][4][2][1]=new MonsterType(3,4,2,1,bestiary[3][4][3][1]);
		bestiary[3][4][2][2]=new MonsterType(3,4,2,2,bestiary[3][4][3][2]);
		bestiary[3][4][1][0]=new MonsterType(3,4,1,0,bestiary[3][4][2][0],bestiary[3][4][2][1],bestiary[3][4][2][2]);
		bestiary[3][4][0][0]=new MonsterType(3,4,0,0,bestiary[3][4][1][0]);
		bestiary[3][4][4][0].setEvolvesFrom1(bestiary[3][4][3][0]);
		bestiary[3][4][4][0].setEvolvesFrom2(bestiary[3][4][3][1]);
		bestiary[3][4][4][0].setEvolvesFrom3(bestiary[3][4][3][2]);
		bestiary[3][4][3][0].setEvolvesFrom(bestiary[3][4][2][0]);
		bestiary[3][4][3][1].setEvolvesFrom(bestiary[3][4][2][1]);
		bestiary[3][4][3][2].setEvolvesFrom(bestiary[3][4][2][2]);
		bestiary[3][4][2][0].setEvolvesFrom(bestiary[3][4][1][0]);
		bestiary[3][4][2][1].setEvolvesFrom(bestiary[3][4][1][0]);
		bestiary[3][4][2][2].setEvolvesFrom(bestiary[3][4][1][0]);
		bestiary[3][4][1][0].setEvolvesFrom(bestiary[3][4][0][0]);
		bestiary[3][5]=new MonsterType[5][];
		bestiary[3][5][0]=new MonsterType[1];
		bestiary[3][5][1]=new MonsterType[1];
		bestiary[3][5][2]=new MonsterType[3];
		bestiary[3][5][3]=new MonsterType[3];
		bestiary[3][5][4]=new MonsterType[3];
		bestiary[3][5][4][0]=new MonsterType(3,5,4,0);
		bestiary[3][5][4][1]=new MonsterType(3,5,4,1);
		bestiary[3][5][4][2]=new MonsterType(3,5,4,1);
		bestiary[3][5][3][0]=new MonsterType(3,5,3,0,bestiary[3][5][4][0]);
		bestiary[3][5][3][1]=new MonsterType(3,5,3,1,bestiary[3][5][4][1]);
		bestiary[3][5][3][2]=new MonsterType(3,5,3,2,bestiary[3][5][4][2]);
		bestiary[3][5][2][0]=new MonsterType(3,5,2,0,bestiary[3][5][3][0]);
		bestiary[3][5][2][1]=new MonsterType(3,5,2,1,bestiary[3][5][3][1]);
		bestiary[3][5][2][2]=new MonsterType(3,5,2,1,bestiary[3][5][3][2]);
		bestiary[3][5][1][0]=new MonsterType(3,5,1,0,bestiary[3][5][2][0],bestiary[3][5][2][1],bestiary[3][5][2][2]);
		bestiary[3][5][0][0]=new MonsterType(3,5,0,0,bestiary[3][5][1][0]);
		bestiary[3][5][4][0].setEvolvesFrom(bestiary[3][5][3][0]);
		bestiary[3][5][4][1].setEvolvesFrom(bestiary[3][5][3][1]);
		bestiary[3][5][4][2].setEvolvesFrom(bestiary[3][5][3][2]);
		bestiary[3][5][3][0].setEvolvesFrom(bestiary[3][5][2][0]);
		bestiary[3][5][3][1].setEvolvesFrom(bestiary[3][5][2][1]);
		bestiary[3][5][3][2].setEvolvesFrom(bestiary[3][5][2][2]);
		bestiary[3][5][2][0].setEvolvesFrom(bestiary[3][5][1][0]);
		bestiary[3][5][2][1].setEvolvesFrom(bestiary[3][5][1][0]);
		bestiary[3][5][2][2].setEvolvesFrom(bestiary[3][5][1][0]);
		bestiary[3][5][1][0].setEvolvesFrom(bestiary[3][5][0][0]);
		bestiary[4][0]=new MonsterType[5][];
		bestiary[4][0][0]=new MonsterType[1];
		bestiary[4][0][1]=new MonsterType[1];
		bestiary[4][0][2]=new MonsterType[3];
		bestiary[4][0][3]=new MonsterType[3];
		bestiary[4][0][4]=new MonsterType[3];
		bestiary[4][0][4][0]=new MonsterType(4,0,4,0);
		bestiary[4][0][4][1]=new MonsterType(4,0,4,1);
		bestiary[4][0][4][2]=new MonsterType(4,0,4,2);
		bestiary[4][0][3][0]=new MonsterType(4,0,3,0,bestiary[4][0][4][0]);
		bestiary[4][0][3][1]=new MonsterType(4,0,3,1,bestiary[4][0][4][1]);
		bestiary[4][0][3][2]=new MonsterType(4,0,3,2,bestiary[4][0][4][2]);
		bestiary[4][0][2][0]=new MonsterType(4,0,2,0,bestiary[4][0][3][0]);
		bestiary[4][0][2][1]=new MonsterType(4,0,2,1,bestiary[4][0][3][1]);
		bestiary[4][0][2][2]=new MonsterType(4,0,2,2,bestiary[4][0][3][2]);
		bestiary[4][0][1][0]=new MonsterType(4,0,1,0,bestiary[4][0][2][0],bestiary[4][0][2][1],bestiary[4][0][2][2]);
		bestiary[4][0][0][0]=new MonsterType(4,0,0,0,bestiary[4][0][1][0]);
		bestiary[4][0][4][0].setEvolvesFrom(bestiary[4][0][3][0]);
		bestiary[4][0][4][1].setEvolvesFrom(bestiary[4][0][4][1]);
		bestiary[4][0][4][2].setEvolvesFrom(bestiary[4][0][3][2]);
		bestiary[4][0][3][0].setEvolvesFrom(bestiary[4][0][2][0]);
		bestiary[4][0][3][1].setEvolvesFrom(bestiary[4][0][2][1]);
		bestiary[4][0][3][2].setEvolvesFrom(bestiary[4][0][2][2]);
		bestiary[4][0][2][0].setEvolvesFrom(bestiary[4][0][1][0]);
		bestiary[4][0][2][1].setEvolvesFrom(bestiary[4][0][1][0]);
		bestiary[4][0][2][2].setEvolvesFrom(bestiary[4][0][1][0]);
		bestiary[4][0][1][0].setEvolvesFrom(bestiary[4][0][0][0]);
		bestiary[4][1]=new MonsterType[5][];
		bestiary[4][1][0]=new MonsterType[1];
		bestiary[4][1][1]=new MonsterType[1];
		bestiary[4][1][2]=new MonsterType[2];
		bestiary[4][1][3]=new MonsterType[2];
		bestiary[4][1][4]=new MonsterType[2];
		bestiary[4][1][4][0]=new MonsterType(4,1,4,0);
		bestiary[4][1][4][1]=new MonsterType(4,1,4,1);
		bestiary[4][1][3][0]=new MonsterType(4,1,3,0,bestiary[4][1][4][0]);
		bestiary[4][1][3][1]=new MonsterType(4,1,3,1,bestiary[4][1][4][1]);
		bestiary[4][1][2][0]=new MonsterType(4,1,2,0,bestiary[4][1][3][0]);
		bestiary[4][1][2][1]=new MonsterType(4,1,2,1,bestiary[4][1][3][1]);
		bestiary[4][1][1][0]=new MonsterType(4,1,1,0,bestiary[4][1][2][0],bestiary[4][1][2][1]);
		bestiary[4][1][0][0]=new MonsterType(4,1,0,0,bestiary[4][1][1][0]);
		bestiary[4][1][4][0].setEvolvesFrom(bestiary[4][1][3][0]);
		bestiary[4][1][4][1].setEvolvesFrom(bestiary[4][1][3][1]);
		bestiary[4][1][3][0].setEvolvesFrom(bestiary[4][1][2][0]);
		bestiary[4][1][3][1].setEvolvesFrom(bestiary[4][1][2][1]);
		bestiary[4][1][2][0].setEvolvesFrom(bestiary[4][1][1][0]);
		bestiary[4][1][2][1].setEvolvesFrom(bestiary[4][1][1][0]);
		bestiary[4][1][1][0].setEvolvesFrom(bestiary[4][1][0][0]);
		bestiary[4][2]=new MonsterType[5][];
		bestiary[4][2][0]=new MonsterType[1];
		bestiary[4][2][1]=new MonsterType[1];
		bestiary[4][2][2]=new MonsterType[2];
		bestiary[4][2][3]=new MonsterType[2];
		bestiary[4][2][4]=new MonsterType[2];
		bestiary[4][2][4][0]=new MonsterType(4,2,4,0);
		bestiary[4][2][4][1]=new MonsterType(4,2,4,1);
		bestiary[4][2][3][0]=new MonsterType(4,2,3,0,bestiary[4][2][4][0]);
		bestiary[4][2][3][1]=new MonsterType(4,2,3,1,bestiary[4][2][4][1]);
		bestiary[4][2][2][0]=new MonsterType(4,2,2,0,bestiary[4][2][3][0]);
		bestiary[4][2][2][1]=new MonsterType(4,2,2,1,bestiary[4][2][3][1]);
		bestiary[4][2][1][0]=new MonsterType(4,2,1,0,bestiary[4][2][2][0],bestiary[4][2][2][1]);
		bestiary[4][2][0][0]=new MonsterType(4,2,0,0,bestiary[4][2][1][0]);
		bestiary[4][2][4][0].setEvolvesFrom(bestiary[4][2][3][0]);
		bestiary[4][2][4][1].setEvolvesFrom(bestiary[4][2][3][1]);
		bestiary[4][2][3][0].setEvolvesFrom(bestiary[4][2][2][0]);
		bestiary[4][2][3][1].setEvolvesFrom(bestiary[4][2][2][1]);
		bestiary[4][2][2][0].setEvolvesFrom(bestiary[4][2][1][0]);
		bestiary[4][2][2][1].setEvolvesFrom(bestiary[4][2][1][0]);
		bestiary[4][2][1][0].setEvolvesFrom(bestiary[4][2][0][0]);
		bestiary[4][3]=new MonsterType[5][];
		bestiary[4][3][0]=new MonsterType[1];
		bestiary[4][3][1]=new MonsterType[1];
		bestiary[4][3][2]=new MonsterType[2];
		bestiary[4][3][3]=new MonsterType[2];
		bestiary[4][3][4]=new MonsterType[2];
		bestiary[4][3][4][0]=new MonsterType(4,3,4,0);
		bestiary[4][3][4][1]=new MonsterType(4,3,4,1);
		bestiary[4][3][3][0]=new MonsterType(4,3,3,0,bestiary[4][3][4][0]);
		bestiary[4][3][3][1]=new MonsterType(4,3,3,1,bestiary[4][3][4][1]);		
		bestiary[4][3][2][0]=new MonsterType(4,3,2,0,bestiary[4][3][3][0]);
		bestiary[4][3][2][1]=new MonsterType(4,3,2,1,bestiary[4][3][3][1]);
		bestiary[4][3][1][0]=new MonsterType(4,3,1,0,bestiary[4][3][2][0],bestiary[4][3][2][1]);
		bestiary[4][3][0][0]=new MonsterType(4,3,0,0,bestiary[4][3][1][0]);
		bestiary[4][3][4][0].setEvolvesFrom(bestiary[4][3][3][0]);
		bestiary[4][3][4][1].setEvolvesFrom(bestiary[4][3][3][1]);
		bestiary[4][3][3][0].setEvolvesFrom(bestiary[4][3][2][0]);
		bestiary[4][3][3][1].setEvolvesFrom(bestiary[4][3][2][1]);
		bestiary[4][3][2][0].setEvolvesFrom(bestiary[4][3][1][0]);
		bestiary[4][3][2][1].setEvolvesFrom(bestiary[4][3][0][0]);
		bestiary[4][4]=new MonsterType[5][];
		bestiary[4][4][0]=new MonsterType[1];
		bestiary[4][4][1]=new MonsterType[1];
		bestiary[4][4][2]=new MonsterType[3];
		bestiary[4][4][3]=new MonsterType[3];
		bestiary[4][4][4]=new MonsterType[3];
		bestiary[4][4][4][0]=new MonsterType(4,4,4,0);
		bestiary[4][4][4][1]=new MonsterType(4,4,4,1);
		bestiary[4][4][4][2]=new MonsterType(4,4,4,2);
		bestiary[4][4][3][0]=new MonsterType(4,4,3,0,bestiary[4][4][4][0]);
		bestiary[4][4][3][1]=new MonsterType(4,4,3,1,bestiary[4][4][4][1]);	
		bestiary[4][4][3][2]=new MonsterType(4,4,3,2,bestiary[4][4][4][2]);
		bestiary[4][4][2][0]=new MonsterType(4,4,2,0,bestiary[4][4][3][0]);
		bestiary[4][4][2][1]=new MonsterType(4,4,2,1,bestiary[4][4][3][1]);
		bestiary[4][4][2][2]=new MonsterType(4,4,2,2,bestiary[4][4][3][2]);
		bestiary[4][4][1][0]=new MonsterType(4,4,1,0,bestiary[4][4][2][0],bestiary[4][4][2][1],bestiary[4][4][2][2]);
		bestiary[4][4][0][0]=new MonsterType(4,4,0,0,bestiary[4][4][1][0]);
		bestiary[4][5]=new MonsterType[5][];
		bestiary[4][5][0]=new MonsterType[1];
		bestiary[4][5][1]=new MonsterType[1];
		bestiary[4][5][2]=new MonsterType[3];
		bestiary[4][5][3]=new MonsterType[3];
		bestiary[4][5][4]=new MonsterType[3];
		bestiary[4][5][4][0]=new MonsterType(4,5,4,0);
		bestiary[4][5][4][1]=new MonsterType(4,5,4,1);
		bestiary[4][5][4][2]=new MonsterType(4,5,4,2);
		bestiary[4][5][3][0]=new MonsterType(4,5,3,0,bestiary[4][5][4][0]);
		bestiary[4][5][3][1]=new MonsterType(4,5,3,1,bestiary[4][5][4][1]);
		bestiary[4][5][3][2]=new MonsterType(4,5,3,2,bestiary[4][5][4][2]);
		bestiary[4][5][2][0]=new MonsterType(4,5,2,0,bestiary[4][5][3][0]);
		bestiary[4][5][2][1]=new MonsterType(4,5,2,1,bestiary[4][5][3][1]);
		bestiary[4][5][2][2]=new MonsterType(4,5,2,2,bestiary[4][5][3][2]);
		bestiary[4][5][1][0]=new MonsterType(4,5,1,0,bestiary[4][5][2][0],bestiary[4][5][2][1],bestiary[4][5][2][2]);
		bestiary[4][5][0][0]=new MonsterType(4,5,0,0,bestiary[4][5][1][0]);
		bestiary[4][5][4][0].setEvolvesFrom(bestiary[4][5][3][0]);
		bestiary[4][5][4][1].setEvolvesFrom(bestiary[4][5][3][1]);
		bestiary[4][5][4][2].setEvolvesFrom(bestiary[4][5][3][2]);
		bestiary[4][5][3][0].setEvolvesFrom(bestiary[4][5][2][0]);
		bestiary[4][5][3][1].setEvolvesFrom(bestiary[4][5][2][1]);
		bestiary[4][5][3][2].setEvolvesFrom(bestiary[4][5][2][2]);
		bestiary[4][5][2][0].setEvolvesFrom(bestiary[4][5][1][0]);
		bestiary[4][5][2][1].setEvolvesFrom(bestiary[4][5][1][0]);
		bestiary[4][5][2][2].setEvolvesFrom(bestiary[4][5][1][0]);
		bestiary[4][5][1][0].setEvolvesFrom(bestiary[4][5][0][0]);
		bestiary[5][0]=new MonsterType[5][];
		bestiary[5][0][0]=new MonsterType[1];
		bestiary[5][0][1]=new MonsterType[1];
		bestiary[5][0][2]=new MonsterType[3];
		bestiary[5][0][3]=new MonsterType[3];
		bestiary[5][0][4]=new MonsterType[3];
		bestiary[5][0][4][0]=new MonsterType(5,0,4,0);
		bestiary[5][0][4][1]=new MonsterType(5,0,4,1);
		bestiary[5][0][4][2]=new MonsterType(5,0,4,2);
		bestiary[5][0][3][0]=new MonsterType(5,0,3,0,bestiary[5][0][4][0]);
		bestiary[5][0][3][1]=new MonsterType(5,0,3,1,bestiary[5][0][4][1]);
		bestiary[5][0][3][2]=new MonsterType(5,0,3,2,bestiary[5][0][4][2]);
		bestiary[5][0][2][0]=new MonsterType(5,0,2,0,bestiary[5][0][3][0]);
		bestiary[5][0][2][1]=new MonsterType(5,0,2,1,bestiary[5][0][3][1]);
		bestiary[5][0][2][2]=new MonsterType(5,0,2,2,bestiary[5][0][3][2]);
		bestiary[5][0][1][0]=new MonsterType(5,0,1,0,bestiary[5][0][2][0],bestiary[5][0][2][1],bestiary[5][0][2][2]);
		bestiary[5][0][0][0]=new MonsterType(5,0,0,0,bestiary[5][0][1][0]);
		bestiary[5][0][4][0].setEvolvesFrom(bestiary[5][0][3][0]);
		bestiary[5][0][4][1].setEvolvesFrom(bestiary[5][0][3][1]);
		bestiary[5][0][4][2].setEvolvesFrom(bestiary[5][0][3][2]);
		bestiary[5][0][3][0].setEvolvesFrom(bestiary[5][0][2][0]);
		bestiary[5][0][3][1].setEvolvesFrom(bestiary[5][0][2][1]);
		bestiary[5][0][3][2].setEvolvesFrom(bestiary[5][0][2][2]);
		bestiary[5][0][2][0].setEvolvesFrom(bestiary[5][0][1][0]);
		bestiary[5][0][2][1].setEvolvesFrom(bestiary[5][0][1][0]);
		bestiary[5][0][2][2].setEvolvesFrom(bestiary[5][0][1][0]);
		bestiary[5][0][1][0].setEvolvesFrom(bestiary[5][0][0][0]);
		bestiary[5][1]=new MonsterType[5][];
		bestiary[5][1][0]=new MonsterType[1];
		bestiary[5][1][1]=new MonsterType[1];
		bestiary[5][1][2]=new MonsterType[3];
		bestiary[5][1][3]=new MonsterType[3];
		bestiary[5][1][4]=new MonsterType[4];
		bestiary[5][1][4][0]=new MonsterType(5,1,3,0);
		bestiary[5][1][4][1]=new MonsterType(5,1,3,1);
		bestiary[5][1][4][2]=new MonsterType(5,1,3,2);
		bestiary[5][1][4][3]=new MonsterType(5,1,3,3);
		bestiary[5][1][3][0]=new MonsterType(5,1,3,0,bestiary[5][1][4][0]);
		bestiary[5][1][3][1]=new MonsterType(5,1,3,1,bestiary[5][1][4][1]);
		bestiary[5][1][3][2]=new MonsterType(5,1,3,2,bestiary[5][1][4][2],bestiary[5][1][4][3]);
		bestiary[5][1][2][0]=new MonsterType(5,1,2,0,bestiary[5][1][3][0]);
		bestiary[5][1][2][1]=new MonsterType(5,1,2,1,bestiary[5][1][3][1]);
		bestiary[5][1][2][2]=new MonsterType(5,1,2,2,bestiary[5][1][3][2]);
		bestiary[5][1][1][0]=new MonsterType(5,1,1,0,bestiary[5][1][2][0],bestiary[5][1][2][1],bestiary[5][1][2][2]);
		bestiary[5][1][0][0]=new MonsterType(5,1,0,0,bestiary[5][1][1][0]);
		bestiary[5][1][4][0].setEvolvesFrom(bestiary[5][1][3][0]);
		bestiary[5][1][4][1].setEvolvesFrom(bestiary[5][1][3][1]);
		bestiary[5][1][4][2].setEvolvesFrom(bestiary[5][1][3][2]);
		bestiary[5][1][4][3].setEvolvesFrom(bestiary[5][1][3][2]);
		bestiary[5][1][3][0].setEvolvesFrom(bestiary[5][1][2][0]);
		bestiary[5][1][3][1].setEvolvesFrom(bestiary[5][1][2][1]);
		bestiary[5][1][3][2].setEvolvesFrom(bestiary[5][1][2][2]);
		bestiary[5][1][2][0].setEvolvesFrom(bestiary[5][1][1][0]);
		bestiary[5][1][2][1].setEvolvesFrom(bestiary[5][1][1][0]);
		bestiary[5][1][2][2].setEvolvesFrom(bestiary[5][1][1][0]);
		bestiary[5][1][1][0].setEvolvesFrom(bestiary[5][1][0][0]);
		bestiary[5][2]=new MonsterType[5][];//TODO redo this one
		bestiary[5][2][0]=new MonsterType[1];
		bestiary[5][2][1]=new MonsterType[1];
		bestiary[5][2][2]=new MonsterType[2];
		bestiary[5][2][3]=new MonsterType[2];
		bestiary[5][2][4]=new MonsterType[2];
		bestiary[5][2][4][0]=new MonsterType(5,2,4,0);
		bestiary[5][2][4][1]=new MonsterType(5,2,4,1);
		bestiary[5][2][3][0]=new MonsterType(5,2,3,0,bestiary[5][2][4][0]);
		bestiary[5][2][3][1]=new MonsterType(5,2,3,1,bestiary[5][2][4][1]);
		bestiary[5][2][2][0]=new MonsterType(5,2,2,0,bestiary[5][2][3][0]);
		bestiary[5][2][2][1]=new MonsterType(5,2,2,1,bestiary[5][2][3][1]);
		bestiary[5][2][1][0]=new MonsterType(5,2,1,0,bestiary[5][2][2][0],bestiary[5][2][2][1]);
		bestiary[5][2][0][0]=new MonsterType(5,2,0,0,bestiary[5][2][1][0]);
		bestiary[5][2][4][0].setEvolvesFrom(bestiary[5][2][3][0]);
		bestiary[5][2][4][1].setEvolvesFrom(bestiary[5][2][3][1]);
		bestiary[5][2][3][0].setEvolvesFrom(bestiary[5][2][2][0]);
		bestiary[5][2][3][1].setEvolvesFrom(bestiary[5][2][2][1]);
		bestiary[5][2][2][0].setEvolvesFrom(bestiary[5][2][1][0]);
		bestiary[5][2][2][1].setEvolvesFrom(bestiary[5][2][1][0]);
		bestiary[5][2][1][0].setEvolvesFrom(bestiary[5][2][0][0]);
		bestiary[5][3]=new MonsterType[5][];
		bestiary[5][3][0]=new MonsterType[1];
		bestiary[5][3][1]=new MonsterType[1];
		bestiary[5][3][2]=new MonsterType[1];
		bestiary[5][3][3]=new MonsterType[1];
		bestiary[5][3][4]=new MonsterType[1];
		bestiary[5][3][4][0]=new MonsterType(5,3,4,0);
		bestiary[5][3][3][0]=new MonsterType(5,3,3,0,bestiary[5][3][4][0]);
		bestiary[5][3][2][0]=new MonsterType(5,3,2,0,bestiary[5][3][3][0]);
		bestiary[5][3][1][0]=new MonsterType(5,3,1,0,bestiary[5][3][2][0]);
		bestiary[5][3][0][0]=new MonsterType(5,3,0,0,bestiary[5][3][1][0]);
		bestiary[5][3][4][0].setEvolvesFrom(bestiary[5][3][3][0]);
		bestiary[5][3][3][0].setEvolvesFrom(bestiary[5][3][2][0]);
		bestiary[5][3][2][0].setEvolvesFrom(bestiary[5][3][1][0]);
		bestiary[5][3][1][0].setEvolvesFrom(bestiary[5][3][0][0]);
		bestiary[5][4]=new MonsterType[5][];//TODO: maybe flesh this one out a bit more
		bestiary[5][4][0]=new MonsterType[1];
		bestiary[5][4][1]=new MonsterType[1];
		bestiary[5][4][2]=new MonsterType[2];
		bestiary[5][4][3]=new MonsterType[1];
		bestiary[5][4][4]=new MonsterType[1];
		bestiary[5][4][4][0]=new MonsterType(5,4,4,0);
		bestiary[5][4][3][0]=new MonsterType(5,4,3,0,bestiary[5][4][4][0]);
		bestiary[5][4][2][0]=new MonsterType(5,4,2,0,bestiary[5][4][3][0]);
		bestiary[5][4][2][1]=new MonsterType(5,4,2,1,bestiary[5][4][3][0]);
		bestiary[5][4][1][0]=new MonsterType(5,4,1,0,bestiary[5][4][2][0],bestiary[5][4][2][1]);
		bestiary[5][4][0][0]=new MonsterType(5,4,0,0,bestiary[5][4][1][0]);
		bestiary[5][4][4][0].setEvolvesFrom(bestiary[5][4][3][0]);
		bestiary[5][4][3][0].setEvolvesFrom(bestiary[5][4][2][0]);
		bestiary[5][4][3][0].setEvolvesFrom2(bestiary[5][4][2][1]);
		bestiary[5][4][2][0].setEvolvesFrom(bestiary[5][4][1][0]);
		bestiary[5][4][1][0].setEvolvesFrom(bestiary[5][4][0][0]);
		bestiary[5][5]=new MonsterType[5][];
		bestiary[5][5][0]=new MonsterType[1];
		bestiary[5][5][1]=new MonsterType[1];
		bestiary[5][5][2]=new MonsterType[3];
		bestiary[5][5][3]=new MonsterType[3];
		bestiary[5][5][4]=new MonsterType[3];
		bestiary[5][5][4][0]=new MonsterType(5,5,4,0);
		bestiary[5][5][4][1]=new MonsterType(5,5,4,1);
		bestiary[5][5][4][2]=new MonsterType(5,5,4,2);
		bestiary[5][5][3][0]=new MonsterType(5,5,3,0,bestiary[5][5][4][0]);
		bestiary[5][5][3][1]=new MonsterType(5,5,3,1,bestiary[5][5][4][1]);
		bestiary[5][5][3][2]=new MonsterType(5,5,3,2,bestiary[5][5][4][2]);
		bestiary[5][5][2][0]=new MonsterType(5,5,2,0,bestiary[5][5][3][0]);
		bestiary[5][5][2][1]=new MonsterType(5,5,2,1,bestiary[5][5][3][0]);
		bestiary[5][5][2][2]=new MonsterType(5,5,2,2,bestiary[5][5][3][1]);
		bestiary[5][5][1][0]=new MonsterType(5,5,1,0,bestiary[5][5][2][0],bestiary[5][5][2][1],bestiary[5][5][2][2]);
		bestiary[5][5][0][0]=new MonsterType(5,5,0,0,bestiary[5][5][1][0]);
		bestiary[5][5][4][0].setEvolvesFrom(bestiary[5][5][3][0]);
		bestiary[5][5][4][1].setEvolvesFrom(bestiary[5][5][3][1]);
		bestiary[5][5][4][2].setEvolvesFrom(bestiary[5][5][3][2]);
		bestiary[5][5][3][0].setEvolvesFrom(bestiary[5][5][2][0]);
		bestiary[5][5][3][1].setEvolvesFrom(bestiary[5][5][2][1]);
		bestiary[5][5][3][2].setEvolvesFrom(bestiary[5][5][2][2]);
		bestiary[5][5][2][0].setEvolvesFrom(bestiary[5][5][1][0]);
		bestiary[5][5][2][1].setEvolvesFrom(bestiary[5][5][1][0]);
		bestiary[5][5][2][2].setEvolvesFrom(bestiary[5][5][1][0]);
		bestiary[5][5][1][0].setEvolvesFrom(bestiary[5][5][0][0]);
		//TODO here

		return bestiary;
	}
	public static MonsterType[] convertTo1d()
	{
		MonsterType[] bestiary1d=new MonsterType[358];
		int index=0;
		for(int i=0; i<bestiary.length;i++)
		{
			for(int j=0; j<bestiary[i].length; j++)
			{
				for(int k=0; k<bestiary[i][j].length; k++)
				{
					for(int m=0; m<bestiary[i][j][k].length; m++)
					{
						bestiary1d[index]=bestiary[i][j][k][m];
						index++;
					}
				}
			}
		}
		
		//This block reads the names from file and assigns them
		String[] names = ListReader.getNames();
		if(bestiary1d.length!=names.length)
		{
			System.out.println("bestiary: " + bestiary1d.length);
			System.out.println("names: " + names.length);
		}
		for(int i=0;i<bestiary1d.length;i++)
		{
			bestiary1d[i].setTypeName(names[i]);
		}
		
		
		//This block reads the descriptions from file and assigns them
		String[] descriptions = ListReader.getDescriptions();
		if(bestiary1d.length!=descriptions.length)//test code
		{
			System.out.println("bestiary: " + bestiary1d.length);
			System.out.println("Descriptions: " + descriptions.length);
		}
		for(int i=0;i<bestiary1d.length;i++)
		{
			bestiary1d[i].setDescription(descriptions[i]);
		}
		return bestiary1d;
	}
	public static int[][] generateMonsterIndexes()
	{
		MonsterType[] myArray=convertTo1d();
		int[][] myFourples=new int[myArray.length][4];
//		for(int i=0; i<myFourples.length;i++)
//		{
//			myFourples[i]=new Fourple();
//		}
		int index=0;
		for(int i=0; i<bestiary.length;i++)
		{
			for(int j=0; j<bestiary[i].length;j++)
			{
				for(int k=0; k<bestiary[i][j].length;k++)
				{
					for(int m=0;m<bestiary[i][j][k].length;m++)
					{
						myFourples[index][0]=i;
						myFourples[index][1]=j;
						myFourples[index][2]=k;
						myFourples[index][3]=m;
						index++;
					}
				}
			}
		}
		return myFourples;
	}
	public static String[][] defineTypes()
	{
		String[][] typeNames = new String[6][6];
		
		typeNames[0][0]="Pyro";//fire primary, Fire Secondary
		typeNames[0][1]="Lava";//fire primary, water secondary				WORK
		typeNames[0][2]="Dinosaur";//fire primary, earth secondary
		typeNames[0][3]="Phoenix";//fire primary, air secondary
		typeNames[0][4]="Justice";//fire primary, light secondary
		typeNames[0][5]="Vengence";//fire primary, dark secondary
		typeNames[1][0]="Steam";//Water primary, Fire Secondary		BAD
		typeNames[1][1]="Aqua";//Water Primary, Water Secondary
		typeNames[1][2]="Amphibious";//Water Primary, Earth Secondary		WORK
		typeNames[1][3]="Weather";//Water Primary, Air secondary
		typeNames[1][4]="Ice";//Water Primary, Light Secondary
		typeNames[1][5]="Deep";//Water Primary, Dark Secondary
		typeNames[2][0]="Fairy";//Earth Primary, Fire Secondary
		typeNames[2][1]="Swamp";//Earth Primary, Water Secondary
		typeNames[2][2]="Tera";//Earth Primary, Earth Secondary
		typeNames[2][3]="Pegasus";//Earth Primary, Wind Secondary			WORK
		typeNames[2][4]="Compassion";//Earth Primary, Light Secondary, focus healing
		typeNames[2][5]="Rotten";//Earth Primary, Dark Secondary
		typeNames[3][0]="Sands";//Wind Primary, Fire secondary, focus egypt, desert
		typeNames[3][1]="SeaBreeze";//Wind Primary, Water secondary focus 
		typeNames[3][2]="Birds";//Wind Primary, earth secondary
		typeNames[3][3]="Aero";//Wind Primary/secondary
		typeNames[3][4]="Cocka";//Wind Primary Light Secondary
		typeNames[3][5]="Nightwing";//Wind Primary Dark Secondary
		typeNames[4][0]="Solar";//Light Primary, Fire Secondary
		typeNames[4][1]="Lunar";//Light Primary, Water Secondary
		typeNames[4][2]="Guardian";//Light Primary, Earth Secondary-taunts enemies, support
		typeNames[4][3]="Holy";//Light Primary,  Air secondary
		typeNames[4][4]="Luxor";//Light Primary/secondary
		typeNames[4][5]="Redemption";//Light Primary, dark secondary
		typeNames[5][0]="Demonic";//Dark Primary, Fire Secondary
		typeNames[5][1]="Poison";//Dark Primary, Water Secondary
		typeNames[5][2]="Undead";//Dark Primary, Earth Secondary
		typeNames[5][3]="Storm";//Dark Primary, Air Secondary, dark version of weather
		typeNames[5][4]="Betrayer";//Dark Primary, light secondary, fallen angels etc
		typeNames[5][5]="Umbral";//Shadowed creatures
		
		return typeNames;
	}
	public static void travel()
	{
		exit=false;
		int[] myFourple= new int[4];
		int lookup;
		while(!exit)
		{	
			System.out.println("What would you like to do?\n1) Find monsters by element\n2) Look at random Monster\n3) Look up Monster by Index\n4) Look up Monster by Array position");
			choice=Main.verify(4);
			if(choice==1)
			{
				travelPrimary();
			}
			else if(choice==2)
			{
				int primaryElement=Main.randomNumber(0,bestiary.length-1);
				int secondaryElement=Main.randomNumber(0, bestiary[primaryElement].length-1);
				int evolutionStage=Main.randomNumber(0, bestiary[primaryElement][secondaryElement].length-1);
				int monsterSelect=Main.randomNumber(0, bestiary[primaryElement][secondaryElement][evolutionStage].length-1);
				travelMonster(primaryElement,secondaryElement,evolutionStage,monsterSelect);
			}
			else if(choice==3)
			{
				System.out.println("What position in the 1d array would you like to lookup?");
				MonsterType[] bestiary1d=convertTo1d();
				int[][] IndexLookup=generateMonsterIndexes();
				lookup=Main.verify(bestiary1d.length);
				myFourple=IndexLookup[lookup];
				travelMonster(myFourple[0],myFourple[1],myFourple[2],myFourple[3]);
				
			}
		}
	}
	public static void travelPrimary()
	{
		exit=false;
		while(!exit)
		{
			System.out.println("What is the primary element of the monster you would like to look for?");
			System.out.println("1) Fire\n2) Water\n3) Earth\n4) Air\n5) Light\n6) Dark\n7)Exit Bestiary");
			choice=Main.verify(7);
			if(choice>0&&choice<7)
			{
				travelSecondary(choice-1);
			}
			else if(choice==7)
			{
				return;
			}
		}
	}
	public static void travelSecondary(int primary)
	{
		exit=false;
		while(!exit)
		{
			System.out.println("What is the secondary element of the monster you would like to look for?");
			for(int i=1; i<bestiary[primary].length+1;i++)
			{
				System.out.print(i + ") ");
				System.out.println(typeNames[primary][i-1]);
			}
			System.out.println("7) Go Back\n8) Exit");
			choice=Main.verify(bestiary[primary].length+2);
			if(choice>0&&choice<7)
			{
				travelEvolution(primary,choice-1);
			}
			else if(choice==7)
			{
				return;
			}
			else if(choice==8)
			{
				exit=true;//this sets the static value to true, which will kick the user out of all while loops in bestiary
				return;
			}
		}
		
	}
	public static void travelEvolution(int primary,int secondary)
	{
		int[] next=new int[4];
		next[0]=0;
		exit=false;
		while(!exit)
		{
			System.out.println("Which monster sub-group for the " + typeNames[primary][secondary] + " monster group would you like to look at?");
			System.out.println("1) Show All\n2) Show Eggs\n3) Show Infants\n4) Show Adolescents\n5) Show Adults\n6) Show Elders\n7) Go Back\n8) Exit");
			choice=Main.verify(8);
			while(choice==1)
			{
				travelShowAllInGroup(primary,secondary);
			}
			if(choice>1&&choice<7)
			{
				travelSelect(primary,secondary,choice-2);
			}
			else if(choice==7)
			{
				return;
			}
			else if(choice==8)
			{
				exit=true;
				return;
			}
			
		}
	}
	public static void travelSelect(int primary,int secondary, int evolution)
	{
		int length;
		int[] next = new int[4];
		next[0]=0;
		exit=false;
		while(!exit)
		{
			length = bestiary[primary][secondary][evolution].length;
			System.out.println("Which monster type would you like to look at?");
			for(int i=1; i<bestiary[primary][secondary][evolution].length+1;i++)
			{
				System.out.println(i + ") " + bestiary[primary][secondary][evolution][i-1].getTypeName());
			}
			System.out.println((length+1) + ") Go Back\n" +(length+2)+ ") Exit");
			choice=Main.verify(length+2);
			next[0]=primary;
			next[1]=secondary;
			next[2]=evolution;
			next[3]=choice-1;
			if(choice>0 && choice<length)
			{
				travelMonster(next[0],next[1],next[2],next[3]);
			}
			else if(choice==length+1)
			{
				return;
			}
			else if(choice==length+2)
			{
				exit=true;
				return;
			}
		}
	}
	public static void travelShowAllInGroup(int primary, int secondary)
	{
		exit=false;
		//Fourple returner = new Fourple();
		int choice=0;
		int size=0;//the size of the array of tuples
		//This for loop determines the length of the tuple
		for(int i=0; i<bestiary[primary][secondary].length;i++)
		{
			for(int j=0;j<bestiary[primary][secondary][i].length;j++)
			{
				size++;
			}
		}
		
		Tuple[] choices = new Tuple[size]; 
		for(int i=0;i<size;i++)
		{
			choices[i]=new Tuple();
		}
		while(exit==false)//just mixing up the looping condition for some style points
		{
			System.out.println("Which Monster in the group would you like to look at?");
			for(int i=0; i<bestiary[primary][secondary].length;i++)
			{
				for(int j=0; j<bestiary[primary][secondary][i].length;j++)
				{
					System.out.println((choice+1) + ") " + bestiary[primary][secondary][i][j].getTypeName());
					choices[choice].m_a=i;
					choices[choice].m_b=j;
					choice++;
				}
			}
			choice++;
			System.out.println(choice + ") go Back");
			choice++;
			System.out.println(choice + ") Exit");
			tempi=Main.verify(choice+1);
			if(tempi>0&&tempi<choice-1)
			{
				travelMonster(primary,secondary,choices[tempi-1].m_a,choices[tempi-1].m_b);
			}
			else if(tempi==choice-1)
			{
				return;
			}
			else if(tempi==choice)
			{
				exit=true;
				return;
			}
			choice=0;
		}//unnecessary-added to get rid of warnings
		return;
	}
	public static void travelMonster(int primary, int secondary, int evolution, int which)
	{
		if(primary==7)
		{
			System.out.println("Error- primary element outside of accepted parameters");
		}
		MonsterType selected= bestiary[primary][secondary][evolution][which];//timesaver;
		System.out.println("Name:              " + selected.getTypeName());
		System.out.println("Primary Element:   " + getElementName(selected.getPrimaryElement()));
		System.out.println("Secondary Element: " + getElementName(selected.getSecondaryElement()));
		System.out.println("Derived Element:   " + typeNames[selected.getPrimaryElement()][selected.getSecondaryElement()]);
		System.out.println("Evolution Stage:   " + getStageName(selected.getEvolutionStage()));
		System.out.println("Index:             " + selected.indexLookup());
		Main.SmartPrint("Description:\n" + selected.getDescription());
		
		System.out.println("num of evolutions is " +selected.getNumOfEvolutions());//debugging
		if(selected.getNumOfEvolutions()==0)
		{
			System.out.println("Evolves Into:        Does not Evolve into anything");
		}
		else if(selected.getNumOfEvolutions()==1)
		{
			System.out.println("Evolves Into:        " + selected.getEvolvesInto1().getTypeName());
		}
		else if(selected.getNumOfEvolutions()==2)
		{
			System.out.println("Physical Evolution:  " + selected.getEvolvesInto1().getTypeName());
			System.out.println("Magical  Evolution:  " + selected.getEvolvesInto2().getTypeName());
		}
		else if(selected.getNumOfEvolutions()==3)
		{
			System.out.println("Physical Evolution:  " + selected.getEvolvesInto1().getTypeName());
			System.out.println("Balanced Evolution:  " + selected.getEvolvesInto2().getTypeName());
			System.out.println("Magical  Evolution:  " + selected.getEvolvesInto3().getTypeName());
		}
		else
		{
			System.out.println("Incorrect value for get NUM of Evolutions");
		}
		
		if(selected.getNumEvolvesFrom()==0)
		{
			System.out.println("Does Not Evolve From anything");
		}
		else if(selected.getNumEvolvesFrom()==1)
		{
			System.out.println("EvolvesFrom: " + selected.getEvolvesFrom1().getTypeName());
		}
		else if(selected.getNumEvolvesFrom()==2)
		{
			System.out.println("Evolves From: " + selected.getEvolvesFrom1().getTypeName());
			System.out.println("and:          " + selected.getEvolvesFrom2().getTypeName());
		}
		else if(selected.getNumEvolvesFrom()==3)
		{
			System.out.println("Evolves From: " + selected.getEvolvesFrom1().getTypeName());
			System.out.println("and:          " + selected.getEvolvesFrom2().getTypeName());
			System.out.println("and           " + selected.getEvolvesFrom3().getTypeName());
		}
		
		exit=false;
		int size=selected.getNumEvolvesFrom()+selected.getNumOfEvolutions();
		Tuple[] indexer = new Tuple[size];
		for(int i=0;i<size;i++)
		{
			indexer[i]=new Tuple();
		}
		while(exit==false)
		{
			choice=0;
			System.out.println("What would you like to look at next?");
			if(selected.getNumEvolvesFrom()>0)			
			{
				System.out.println(choice+1 + ") " +selected.getEvolvesFrom1().getTypeName());
				indexer[choice].m_a=selected.getEvolvesFrom1().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesFrom1().getEvolutionType();
				choice++;
			}
			if(selected.getNumEvolvesFrom()>1)
			{
				System.out.println(choice+1 + ") " +selected.getEvolvesFrom2().getTypeName());
				indexer[choice].m_a=selected.getEvolvesFrom2().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesFrom2().getEvolutionType();
				choice++;
			}
			if(selected.getNumEvolvesFrom()>2)
			{
				System.out.println(choice+1 + ") " + selected.getEvolvesFrom3().getTypeName());
				indexer[choice].m_a=selected.getEvolvesFrom2().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesFrom2().getEvolutionType();
				choice++;
			}
			if(selected.getNumOfEvolutions()>0)
			{
				System.out.println(choice+1 + ") " +selected.getEvolvesInto1().getTypeName());
				indexer[choice].m_a=selected.getEvolvesInto1().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesInto1().getEvolutionType();
				choice++;
			}
			if(selected.getNumOfEvolutions()>1)
			{	
				System.out.println(choice+1 + ") " + selected.getEvolvesInto2().getTypeName());
				indexer[choice].m_a=selected.getEvolvesInto2().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesInto2().getEvolutionType();
				choice++;
			}
			if(selected.getNumOfEvolutions()>2)
			{
				System.out.println(choice+1 + ") " +selected.getEvolvesInto3().getTypeName());
				indexer[choice].m_a=selected.getEvolvesInto3().getEvolutionStage();
				indexer[choice].m_b=selected.getEvolvesInto3().getEvolutionType();
				choice++;
			}
			System.out.println(choice+1 + ") Go Back");
			choice++;
			System.out.println(choice+1 + ") Exit");
			int decision = Main.verify(size+2);
			int[] myFourple = new int[4];
			myFourple[0] = primary;
			myFourple[1] = secondary;
			myFourple[2]=7;
			myFourple[3]=7;
			if(decision>0&decision<size+1)
			{
				travelMonster(primary,secondary,indexer[decision-1].m_a,indexer[decision-1].m_b);
				return;
			}
			else if(decision==choice)
			{
				return;				
			}
			else if(decision==choice+1)
			{
				exit=false;
				return;
			}
		}
		return;
	}
	public static String getElementName(int element)
	{
		if(element==0)
		{
			return("Fire");
		}
		else if(element==1)
		{
			return("Water");
		}
		else if(element==2)
		{
			return("Earth");
		}
		else if(element==3)
		{
			return("Air");
		}
		else if(element==4)
		{
			return("Light");
		}
		else if(element==5)
		{
			return("Dark");
		}
		else 
		{
			return("Error: Invalid Argument");
		}
	}
	public static String getStageName(int stage)
	{
		if(stage==0)
		{
			return("Egg");
		}
		else if(stage==1)
		{
			return("Infant");
		}
		else if(stage==2)
		{
			return("Adolescent");
		}
		else if(stage==3)
		{
			return("Adult");
		}
		else if(stage==4)
		{
			return("Elder");
		}
		else
		{
			return("Error: invalid Argument");
		}
	}
	public static void run()
	{
		travel();
	}
}
