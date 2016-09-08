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
		bestiary[5][0][4][0]=new MonsterType("Astaroth",5,0,4,0,"Astaroth is a bright red demon with large black horns fifteen feet tall. He weilds a large corrupted axe that has a living eye where the blade meets the haft");
		bestiary[5][0][4][1]=new MonsterType("Asag",5,0,4,1,"Asag is also known as the fear. He appears as a giant demon with the body of a bear and the head of a stag.");
		bestiary[5][0][4][2]=new MonsterType("Shedu",5,0,4,2,"The Shedu is a phantom witch that speaks only curses, whose eyeless sockets see through the dark and not");
		bestiary[5][0][3][0]=new MonsterType("Incubus",5,0,3,0,"The Incubus can take many forms, sometimes appearing as a poet, or perhaps an athelete to sexually corrupt women, when they feel excited as their prey is near, often their eyes will revert to their true form, but only for an instant, giving the virtuous their only warning",bestiary[5][0][4][0]);
		bestiary[5][0][3][1]=new MonsterType("Succubus",5,0,3,1,"The succubus is a beautiful female demon meant to provoke lust in the hearts of men. They catch their prey more ofthen than the Incubus, as men have weaker hearts when it comes to resisting beauty",bestiary[5][0][4][1]);
		bestiary[5][0][3][2]=new MonsterType("Grimiore",5,0,3,2,"A sentient black book that has the demon crest embossed on the cover. The spells and hexes within are written in both the blood of the slain and the blood of the conqueror",bestiary[5][0][4][2]);
		bestiary[5][0][2][0]=new MonsterType("Scamp",5,0,2,0,"A scamp is a minor demon with claws and long ears, it screams at its enemies to initiate combat",bestiary[5][0][3][0]);
		bestiary[5][0][2][1]=new MonsterType("Imp",5,0,2,1,"An imp is a small red demon carrying a pitchfork. It is aggressive but is wise enough not to initiate combat against a stronger opponent",bestiary[5][0][3][1]);
		bestiary[5][0][2][2]=new MonsterType("Jinn",5,0,2,2,"A Jinn attacks its enemies with mystical enemies, preying on the weak of mind. It is ephemeral, which greatly reduces the efficacy of physical attacks",bestiary[5][0][3][2]);
		bestiary[5][0][1][0]=new MonsterType("Fiend",5,0,1,0,"The fiend is a minor demon, colored dark red with black horns",bestiary[5][0][2][0],bestiary[5][0][2][1],bestiary[5][0][2][2]);
		bestiary[5][0][0][0]=new MonsterType("Demonic Egg",5,0,0,0,"The demonic egg is is a rusty black with the demonic symbol embossed on its center, it is painful to touch",bestiary[5][0][1][0]);
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
		bestiary[5][1][4][0]=new MonsterType("Queen B",5,1,3,0,"Queen B is the younger sister of Queen A, however when they were in a beauty pagent, everyone chose Queen B, so she became the dominant Queen. She can summon Stingers to the empty allied positions");
		bestiary[5][1][4][1]=new MonsterType("King Rattle",5,1,3,1,"King Rattle has a large Rattle on the end of its tail. Not like a snakes, like a babies rattle, but really large. It also has a crown. Its scales are brown and it is very large");
		bestiary[5][1][4][2]=new MonsterType("Red Widow",5,1,3,2,"The Red Widow has gotten over her husbands death. The hourglass has turned black, and the rest of her has turned red. This color, and the scent given off from her hide, attracts insects to their doom. Her bright color does as well");
		bestiary[5][1][4][3]=new MonsterType("Cougar Spider",5,1,3,3,"The Cougar Spider is an older spider who still looks nice and knows how to treat men (spiders) right. She takes them to her web and then eats them.");
		bestiary[5][1][3][0]=new MonsterType("Wasplash",5,1,3,0,"The Wasplash is an oversized wasp with a stinger and it can latch onto a single enemy with the hooked blades on the end of its legs, stinging them multiple times",bestiary[5][1][4][0]);
		bestiary[5][1][3][1]=new MonsterType("Slyslyther",5,1,3,1,"The SlySlyther is a grown Slyther whose scales have turned black as night, it is very quiet and can sneak attack its enemies.",bestiary[5][1][4][1]);
		bestiary[5][1][3][2]=new MonsterType("Widow",5,1,3,2,"The Widow is a widowed spider that is really broken up about it, cries all the time. It looks like a black widow but larger and sad",bestiary[5][1][4][2],bestiary[5][1][4][3]);
		bestiary[5][1][2][0]=new MonsterType("Stinger",5,1,2,0,"The Stinger is an oversized wasp with a poisonous stinger",bestiary[5][1][3][0]);
		bestiary[5][1][2][1]=new MonsterType("Slyther",5,1,2,1,"The Slyther is a small snake that slides through the grass towards its prey. Its bite is venemous. Its green and has no rattle",bestiary[5][1][3][1]);
		bestiary[5][1][2][2]=new MonsterType("Creeper",5,1,2,2,"The creeper is a spider that can shoot webs at its enemies to slow them down.",bestiary[5][1][3][2]);
		bestiary[5][1][1][0]=new MonsterType("Fanger",5,1,1,0,"The fanger is a small scorpion that can lift its legs up and slither and has fangs",bestiary[5][1][2][0],bestiary[5][1][2][1],bestiary[5][1][2][2]);
		bestiary[5][1][0][0]=new MonsterType("Poison Egg",5,1,0,0,"The poison egg is black with a greenish hue. The symbol is embossed on its surface, and spikes extend from the shell, which defend itself. The spikes are of course dipped in poison",bestiary[5][1][1][0]);
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
		bestiary[5][2][4][0]=new MonsterType("Skulltyrant",5,2,4,0,"The Skulltyrant is a large undead T-rex. Very Scary");
		bestiary[5][2][4][1]=new MonsterType("Specter",5,2,4,1,"The Specter can possess an enemy for three turns after which it dies");
		bestiary[5][2][3][0]=new MonsterType("Skullclar",5,2,3,0,"The Skullclar is a larger Skullsaur with wings and horns",bestiary[5][2][4][0]);
		bestiary[5][2][3][1]=new MonsterType("Wraith",5,2,3,1,"The Phantom is still incorporeal and weilds a curved scepter",bestiary[5][2][4][1]);
		bestiary[5][2][2][0]=new MonsterType("Skullsaur",5,2,2,0,"The Skullsaur is a undead veloceraptor looking thing that has a badass attack called deathclaw",bestiary[5][2][3][0]);
		bestiary[5][2][2][1]=new MonsterType("Ghostet",5,2,2,1,"The Ghostet is a weak phantom that takes reduced physical damage",bestiary[5][2][3][1]);
		bestiary[5][2][1][0]=new MonsterType("Stull",5,2,1,0,"The stull is a floating skull with glowing green orbs in its eye sockets",bestiary[5][2][2][0],bestiary[5][2][2][1]);
		bestiary[5][2][0][0]=new MonsterType("Undead Egg",5,2,0,0,"Lifeless and cold, the egg is the color and consistency of bone, with the undead crest embossed on the center",bestiary[5][2][1][0]);
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
		bestiary[5][3][4][0]=new MonsterType("Thundragon",5,3,4,0,"The Thundragon is a fully formed dragon made of clouds. Its breath is a hurricane, its scream a thunderbolt");
		bestiary[5][3][3][0]=new MonsterType("Tempestor",5,3,3,0,"The Tempestor is a greater thunder wyvern with wings and rear claws. Its presence will darken the sky and call harsh gales",bestiary[5][3][4][0]);
		bestiary[5][3][2][0]=new MonsterType("Thundroar",5,3,2,0,"The Thundroar is a dragonlike snake in the clouds. Lightening storms occur when multiple Thundroars battle in the heavens. It is said that thunder is caused by their roaring",bestiary[5][3][3][0]);
		bestiary[5][3][1][0]=new MonsterType("Maltag",5,3,1,0,"Have you ever had a really bad day? So bad that even though there was a clear blue sky, it felt like a small dark cloud was following you around? This is that cloud",bestiary[5][3][2][0]);
		bestiary[5][3][0][0]=new MonsterType("Storm Egg",5,3,0,0,"The storm egg is solid black and appears to be made of obsidian, excepting, of course, the symbol embossed on its center",bestiary[5][3][1][0]);
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
		bestiary[5][4][4][0]=new MonsterType("Avengeant",5,4,4,0,"The Avengeant once served God, but gien will, disagreed with his descision. When he went to resolve the conflict, God couldn't stand being questioned and excommunicated the Avengent, who has hated God and those loyal to him ever since");
		bestiary[5][4][3][0]=new MonsterType("Black Knight",5,4,3,0,"The black knight is sheilded in dark plate, that has rituals etched into the steel",bestiary[5][4][4][0]);
		bestiary[5][4][2][0]=new MonsterType("Dark Phage",5,4,2,0,"The dark phage is a corrupted phage that turned from the service of its creator",bestiary[5][4][3][0]);
		bestiary[5][4][2][1]=new MonsterType("Fallen HemiAngel",5,4,2,1,"The Fallen HemiAngel has larger wings both turned black",bestiary[5][4][3][0]);
		bestiary[5][4][1][0]=new MonsterType("Fallen DemiAngel",5,4,1,0,"The fallen demiAngel is an angel that followed the light bringer when he fell from heaven. It was weak then, and has yet to grow",bestiary[5][4][2][0],bestiary[5][4][2][1]);
		bestiary[5][4][0][0]=new MonsterType("Betrayer Eggs",5,4,0,0,"The betrayer egg is half black and half white its center embossed with the betrayers symbol, a back being stabbed",bestiary[5][4][1][0]);
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
		bestiary[5][5][4][0]=new MonsterType("Eye Of Dis",5,5,4,0,"The Eye of Dis is one of the many eyes of the dark god Dis himself- it can see all aspects of you. Kill it before it speaks, as those that hear its voice turn mad");
		bestiary[5][5][4][1]=new MonsterType("Mang",5,5,4,1,"Mang appears as an old man with a walking stick. Attack it and see what happens");
		bestiary[5][5][4][2]=new MonsterType("Umbral Atronach",5,5,4,2,"The Umbral Atronach is a very large umbral symbol surrounded by Elementals representing every element. As such, it can cast greater darkness magics and regular magics of every other element");
		bestiary[5][5][3][0]=new MonsterType("Senistair",5,5,3,0,"The Senistair is a shadow in the form of a man whose eyeless sockets peer into your soul. It has an inhuman cheshire smile that can only elicit terror",bestiary[5][5][4][0]);
		bestiary[5][5][3][1]=new MonsterType("Caecus",5,5,3,1,"The caecus is a shadow warrior with a bandage wrapped around its eyes. It cannot see, but tracks its enemies by listening-often giving it a better picture of reality than sight",bestiary[5][5][4][1]);
		bestiary[5][5][3][2]=new MonsterType("Umbral Elemental",5,5,3,2,"The Umbral Elemental is a large umbral symbol surrounded by three lesser symbols of other elements. As such, it can cast lesser magics of those elements",bestiary[5][5][4][2]);
		bestiary[5][5][2][0]=new MonsterType("Shadeoss",5,5,2,0,"The Shadeoss is strongest in darkness. It appears to be the upper torso of a knight weilding a sword",bestiary[5][5][3][0]);
		bestiary[5][5][2][1]=new MonsterType("Screel",5,5,2,1,"The Screel is a black envy demon, desiring the desiring the form and life of a man. It is still young, so the result is obscene",bestiary[5][5][3][0]);
		bestiary[5][5][2][2]=new MonsterType("Umbral Symbol",5,5,2,2,"The Umbral Symbol is a floating symbol in the shape of the blinded eye that casts basic dark magic",bestiary[5][5][3][1]);
		bestiary[5][5][1][0]=new MonsterType("Umbress",5,5,1,0,"The umbress appears to bea small floating black flame, with two purple eyes",bestiary[5][5][2][0],bestiary[5][5][2][1],bestiary[5][5][2][2]);
		bestiary[5][5][0][0]=new MonsterType("Umbral Egg",5,5,0,0,"The umbral egg sucks light and appears to cast dark tendrils from its shell, but if you look again theyre gone. It seems weak and fragile when exposed to light, but during the dusk, when the light is weak, the blinded eye  can be seen embossed on its surface",bestiary[5][5][1][0]);
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
	public static Fourple[] generateMonsterIndexes()
	{
		MonsterType[] myArray=convertTo1d();
		Fourple[] myFourples=new Fourple[myArray.length];
		for(int i=0; i<myFourples.length;i++)
		{
			myFourples[i]=new Fourple();
		}
		int index=0;
		for(int i=0; i<bestiary.length;i++)
		{
			for(int j=0; j<bestiary[i].length;j++)
			{
				for(int k=0; k<bestiary[i][j].length;k++)
				{
					for(int m=0;m<bestiary[i][j][k].length;m++)
					{
						myFourples[index].m_a=i;
						myFourples[index].m_b=j;
						myFourples[index].m_c=k;
						myFourples[index].m_d=m;
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
		Fourple myFourple= new Fourple();
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
				Fourple[] IndexLookup=generateMonsterIndexes();
				lookup=Main.verify(bestiary1d.length);
				myFourple=IndexLookup[lookup];
				travelMonster(myFourple.m_a,myFourple.m_b,myFourple.m_c,myFourple.m_d);
				
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
		Fourple next=new Fourple();
		next.m_a=0;
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
		Fourple next = new Fourple();
		next.m_a=0;
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
			next.m_a=primary;
			next.m_b=secondary;
			next.m_c=evolution;
			next.m_d=choice-1;
			if(choice>0 && choice<length)
			{
				travelMonster(next.m_a,next.m_b,next.m_c,next.m_d);
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
			Fourple myFourple = new Fourple();
			myFourple.m_a = primary;
			myFourple.m_b = secondary;
			myFourple.m_c=7;
			myFourple.m_d=7;
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
