/*
 * 		@file:		PlayerCharacter.java
 * 		@author:	Austin Bailey
 * 		@date:		12/8/2015
 */
package ver0;
import java.util.Scanner;
public class PlayerCharacter 
{
	static Scanner myScanner = new Scanner(System.in);
	//constructor
	PlayerCharacter()
	{
		int tempi;
		boolean lcv=false;
		System.out.print("Welcome to Monster Master. Please answer a few questions to determine your character.\nWhat is your name?");
		this.setName(myScanner.next());
		System.out.println("What is your gender\n1)male\n2)female\n**please answer questions by inputing a number and pressing enter,\n**other inputs may have unexpected results\n");
		tempi=myScanner.nextInt();
		if(tempi==1)
		{
			this.isMale=true;
		}
		else if(tempi==2)
		{
			this.isMale=false;
		}
		else
		{	
			lcv=true;
			while(lcv)
			{
				System.out.println("Please enter either a 1 for male or a 2 for female");
				tempi=myScanner.nextInt();
				if(tempi==1)
				{
					this.isMale=true;
					lcv=false;
				}		
				else if(tempi==2)
				{
					this.isMale=false;
					lcv=false;
				}
			}
		}
		System.out.println("Now its time for a quiz to determine your element\n\nQuestion #1\nYou see a large gold coin slip out of someones pocket. Do you:\n1)Yell at the Man, and give him his gold coin\n2)Take the gold coin for yourself, or\n3)Do nothing and leave it for someone else");
		tempi=myScanner.nextInt();
		if(tempi==1)
		{
			m_lightAptitude=7;
			m_darkAptitude=3;
		}
		else if(tempi==2)
		{
			m_lightAptitude=3;
			m_darkAptitude=7;
		}
		else if(tempi==3)
		{
			m_lightAptitude=5;
			m_darkAptitude=5;
		}
		else
		{
			lcv=true;
			while(lcv)
			{
				System.out.println("Please enter a 1 for give the man his gold coin 2 for keep it for yourself and 3 for neither\n");
				tempi=myScanner.nextInt();
				if(tempi==1)
				{
					m_lightAptitude=7;
					m_darkAptitude=3;
					lcv=false;
				}
				else if(tempi==2)
				{
					m_lightAptitude=3;
					m_darkAptitude=7;
					lcv=false;
				}
				else if(tempi==3)
				{
					m_lightAptitude=5;
					m_darkAptitude=5;
					lcv=false;
				}
				
			}
		}
		System.out.println("Question #2: \nWhat do you look for in a lover?\n1)Someone I can share my passion and zest for life with\n2)Someone I can talk to for hours with about beleifs, ideas, philosophy, and intellectual leanings\n3)Stability, someone that I can rely upon, that will be there for me\n4)Someone who never bores me but always excites me with their spontaneity\n");
		tempi=myScanner.nextInt();
		if(tempi==1)
		{
			m_fireAptitude=7;
			m_waterAptitude=3;
			m_earthAptitude=5;
			m_airAptitude=5;
		}
		else if(tempi==2)
		{
			m_fireAptitude=3;
			m_waterAptitude=7;
			m_earthAptitude=5;
			m_airAptitude=5;
		}
		else if(tempi==3)
		{
			m_fireAptitude=5;
			m_waterAptitude=5;
			m_earthAptitude=7;
			m_airAptitude=3;
		}
		else if(tempi==4)
		{
			m_fireAptitude=5;
			m_waterAptitude=5;
			m_airAptitude=3;
			m_earthAptitude=7;
		}
		else
		{
			lcv=true;
			while(lcv)
			{
				System.out.println("Please answer with a number 1,2,3 or 4. 1 for passion, 2 for intellectual stimulation, 3 for reliance or 4 for spontaneity");
				tempi=myScanner.nextInt();
				if(tempi==1)
				{
					m_fireAptitude=7;
					m_waterAptitude=3;
					m_earthAptitude=5;
					m_airAptitude=5;
					lcv=false;
				}
				else if(tempi==2)
				{
					m_fireAptitude=3;
					m_waterAptitude=7;
					m_earthAptitude=5;
					m_airAptitude=5;
					lcv=false;
				}
				else if(tempi==3)
				{
					m_fireAptitude=5;
					m_waterAptitude=5;
					m_earthAptitude=7;
					m_airAptitude=3;
					lcv=false;
				}
				else if(tempi==4)
				{
					m_fireAptitude=5;
					m_waterAptitude=5;
					m_earthAptitude=3;
					m_airAptitude=7;
					lcv=false;
				}
			}
		}
		System.out.println("Question #3\nYour nemesis, who once betrayed your trust, approaches you trying to reconcile. Do you\n1)Forgive him and accept him back into the fold\n2)Forgive him so that you can get back at him at his weakest moment\n3)Shove him, because you know he is just trying to hurt you again\n4)Walk away and avoid the confrontation");
		tempi=myScanner.nextInt();
		if(tempi==1)
		{
			m_lightAptitude++;
			m_lightAptitude++;
			m_darkAptitude--;
			m_waterAptitude++;
		}
		else if(tempi==2)
		{
			m_darkAptitude++;
			m_darkAptitude++;
			m_lightAptitude--;
			m_fireAptitude++;
		}
		else if(tempi==3)
		{
			m_fireAptitude++;
			m_fireAptitude++;
			m_waterAptitude--;
			m_darkAptitude++;
		}
		else if(tempi==4)
		{
			m_waterAptitude++;
			m_waterAptitude++;
			m_fireAptitude--;
			m_lightAptitude++;
		}
		else
		{
			lcv=true;
			while(lcv)
			{
				System.out.println("Please answer with a number 1) for reconciliation 2) for betrayal 3) for agression or 4)for walking away");
				tempi=myScanner.nextInt();
				if(tempi==1)
				{
					m_lightAptitude++;
					m_lightAptitude++;
					m_darkAptitude--;
					m_waterAptitude++;
					lcv=false;
				}
				else if(tempi==2)
				{
					m_darkAptitude++;
					m_darkAptitude++;
					m_lightAptitude--;
					m_fireAptitude++;
					lcv=false;
				}
				else if(tempi==3)
				{
					m_fireAptitude++;
					m_fireAptitude++;
					m_waterAptitude--;
					m_darkAptitude++;
					lcv=false;
				}
				else if(tempi==4)
				{
					m_waterAptitude++;
					m_waterAptitude++;
					m_fireAptitude--;
					m_lightAptitude++;
					lcv=false;
				}
			}
		}
		System.out.println("Question#4\nYour family is about to move to a new town. Do you:\n1)Go with a positive attitude because you'll be able to make all new friends and the adventure will be exciting!\n2)Go because you know its pointless to fight your parents, but make sure that they know they'll owe you for this\n3)Resolve to stay with a friend whose family is willing to adopt you\n4)Bitch and moan and scream until they take you from your old house kicking and scrreaming");
		tempi=myScanner.nextInt();
		if(tempi==1)
		{
			m_airAptitude++;
			m_airAptitude++;
			m_earthAptitude--;
			m_lightAptitude++;
		}
		else if(tempi==2)
		{
			m_airAptitude++;
			m_airAptitude++;
			m_earthAptitude--;
			m_darkAptitude++;
		}
		else if(tempi==3)
		{
			m_earthAptitude++;
			m_earthAptitude++;
			m_airAptitude--;
			m_lightAptitude++;
		}
		else if(tempi==4)
		{
			m_earthAptitude++;
			m_earthAptitude++;
			m_airAptitude--;
			m_lightAptitude++;
		}
		else
		{
			lcv=true;
			while(lcv)
			{
				System.out.println("Question#4\nYour family is about to move to a new town. Do you:\n1)Go with a positive attitude because you'll be able to make all new friends and the adventure will be exciting!\n2)Go because you know its pointless to fight your parents, but make sure that they know they'll owe you for this\n3)Resolve to stay with a friend whose family is willing to adopt you\n4)Bitch and moan and scream until they take you from your old house kicking and scrreaming");
				System.out.println("Please answer with a 1 2 3 or 4 and nothing else");
				if(tempi==1)
				{
					m_airAptitude++;
					m_airAptitude++;
					m_earthAptitude--;
					m_lightAptitude++;
					lcv=false;
				}
				else if(tempi==2)
				{
					m_airAptitude++;
					m_airAptitude++;
					m_earthAptitude--;
					m_darkAptitude++;
					lcv=false;
				}
				else if(tempi==3)
				{
					m_earthAptitude++;
					m_earthAptitude++;
					m_airAptitude--;
					m_lightAptitude++;
					lcv=false;
				}
				else if(tempi==4)
				{
					m_earthAptitude++;
					m_earthAptitude++;
					m_airAptitude--;
					m_darkAptitude++;
				}
			}
		}
		System.out.println("Final Question\nWhat is your favorite element?\n1)Fire\n2)Water\n3)Earth\n4)Air\n5)Light\n6)Dark");
		tempi=myScanner.nextInt();
		if(tempi==1)
		{
			m_fireAptitude++;
			m_waterAptitude--;
		}
		else if(tempi==2)
		{
			m_waterAptitude++;
			m_fireAptitude--;
		}
		else if(tempi==3)
		{
			m_earthAptitude++;
			m_airAptitude--;
		}
		else if(tempi==4)
		{
			m_airAptitude++;
			m_earthAptitude--;
		}
		else if(tempi==5)
		{
			m_lightAptitude++;
			m_darkAptitude--;
		}
		else if(tempi==6)
		{
			m_darkAptitude++;
			m_lightAptitude--;
		}
		else
		{
			lcv=true;
			while(lcv)
			{
				System.out.println("Final Question\nWhat is your favorite element?\n1)Fire\n2)Water\n3)Earth\n4)Air\n5)Light\n6)Dark");
				System.out.println("please use only the number when entering your response");
				tempi=myScanner.nextInt();
				if(tempi==1)
				{
					m_fireAptitude++;
					m_waterAptitude--;
					lcv=false;
				}
				else if(tempi==2)
				{
					m_waterAptitude++;
					m_fireAptitude--;
					lcv=false;
				}
				else if(tempi==3)
				{
					m_earthAptitude++;
					m_airAptitude--;
					lcv=false;
				}
				else if(tempi==4)
				{
					m_airAptitude+=3;
					m_earthAptitude--;
					lcv=false;
				}
				else if(tempi==5)
				{
					m_lightAptitude++;
					m_darkAptitude--;
					lcv=false;
				}
				else if(tempi==6)
				{
					m_darkAptitude++;
					m_lightAptitude--;
					lcv=false;
				}
			}
		}
		int[] arr={m_fireAptitude,m_waterAptitude,m_earthAptitude,m_airAptitude,m_lightAptitude,m_darkAptitude};
		int maxIndex=0;
		for(int i=0; i<5;i++)
		{
			if(arr[i]<arr[i+1])
			{
				maxIndex=i+1;
			}
		}
		m_element=maxIndex;
		m_maxHp=50+m_earthAptitude*5;
		m_curHp=m_maxHp;
		m_maxMp=m_waterAptitude*5;
		m_curMp=m_maxMp;
		m_level=0;
		m_experience=0;
		System.out.print("Based on our test, you are ");
		if(m_element==0)
		{
			System.out.print("fire");
		}
		else if(m_element==1)
		{
			System.out.print("water");
		}
		else if(m_element==2)
		{
			System.out.print("earth");
		}
		else if(m_element==3)
		{
			System.out.print("air");
		}
		else if(m_element==4)
		{
			System.out.print("light");
		}
		else if(m_element==5)
		{
			System.out.print("dark");
		}
		else
		{
			System.out.print("ERROR ELEMENT NOT ASSIGNED");
		}
		System.out.print(" elemental.\n");
	}
	public void printCharacterDetails()
	{
		System.out.print("Name: " + m_name + "\nGender: ");
		if(isMale)
		{
			System.out.print("male ");
		}
		else
		{
			System.out.print("female ");
		}
		System.out.print("MaxHp: " + m_maxHp + "\nCurrentHp: "+ m_curHp +"\nMaxMp: "+m_maxMp+"\nCurrentMp: " + m_curMp + "\nElement: ");
		printElement();
		System.out.println("\nFire Aptitude: "+ m_fireAptitude+"\nWater Aptitude: " + m_waterAptitude + "\nEarth Aptitude: " + m_earthAptitude+ "\nAir Aptitude: " + m_airAptitude + "\nLightAptitude: " + m_lightAptitude + "\nDarkAptitude: " + m_darkAptitude + "\n");
	}
	public void printElement()
	{
		if(m_element==0)
		{
			System.out.print("fire");
		}
		else if(m_element==1)
		{
			System.out.print("water");
		}
		else if(m_element==2)
		{
			System.out.print("earth");
		}
		else if(m_element==3)
		{
			System.out.print("air");
		}
		else if(m_element==4)
		{
			System.out.print("light");
		}
		else if(m_element==5)
		{
			System.out.print("dark");
		}
		else
		{
			System.out.print("ERROR m_element at improper value");
		}
	}
	//member variables
	boolean isMale;
	private int m_maxHp;
	private int m_curHp;
	private int m_maxMp;
	private int m_curMp;
	private int m_element;
	private String m_name;
	private int m_experience;
	private int m_level;
	private int m_fireAptitude;
	private int m_waterAptitude;
	private int m_earthAptitude;
	private int m_airAptitude;
	private int m_lightAptitude;
	private int m_darkAptitude;
	
	//setters and getters
	public int getMaxHp()
	{
		return m_maxHp;
	}
	public void setMaxHp(int updateHp)
	{
		m_maxHp=updateHp;
	}
	public int getCurHp()
	{
		return m_curHp;
	}
	public void setCurHp(int updateHp)
	{
		m_curHp=updateHp;
		return;
	}
	public int getMaxMp()
	{
		return m_maxMp;
	}
	public void setMaxMp(int updateMp)
	{
		m_maxMp=updateMp;
	}
	public int getCurMp()
	{
		return m_curMp;
	}
	public void setCurMp(int updateMp)
	{
		m_curMp=updateMp;
	}
	public int getElement()
	{
		return m_element;
	}
	public void setElement(int updateElement)
	{
		m_element=updateElement;
	}
	public String getName()
	{
		return m_name;
	}
	public void setName(String updateName)
	{
		m_name=updateName;
	}
	public int getExperience()
	{
		return m_experience;
	}
	public void setExperience(int updateExp)
	{
		m_experience=updateExp;
	}
	public int getLevel()
	{
		return m_level;
	}
	public void setLevel(int updateLevel)
	{
		m_level=updateLevel;
	}
	public int getFireAptitude()
	{
		return m_fireAptitude;
	}
	public void setFireAptitude(int updateFireAptitude)
	{
		m_fireAptitude=updateFireAptitude;
	}
	public int getWaterAptitude()
	{
		return m_waterAptitude;
	}
	public void setWaterAptitude(int updateWaterAptitude)
	{
		m_waterAptitude=updateWaterAptitude;
	}
	public int getEarthAptitude()
	{
		return m_earthAptitude;
	}
	public void setEarthAptitude(int updateEarthAptitude)
	{
		m_earthAptitude=updateEarthAptitude;
	}
	public int getAirAptitude()
	{
		return m_airAptitude;
	}
	public void setAirAptitude(int updateAirAptitude)
	{
		m_airAptitude=updateAirAptitude;
	}
	public int getLightAptitdue()
	{
		return m_lightAptitude;
	}
	public void setLightAptitude(int updateLightApitude)
	{
		m_lightAptitude=updateLightApitude;
	}
	public int getDarkAptitude()
	{
		return m_darkAptitude;
	}
	public void setDarkAptitude(int updateDarkAptitude)
	{
		m_darkAptitude=updateDarkAptitude;
	}
	
}
