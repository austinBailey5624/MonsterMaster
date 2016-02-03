package ver0;

public class Item 
{
	//static variables
	static final int numOfItems=0;
	
	
	//member variables
	int m_value;
	String m_name;
	String m_description;
	
	//constructors
	public Item()//super constructor used in derived class constructors
	{
		
	}
	
	//methods
	public static int getNum()
	{
		return numOfItems;
	}
	
	public Item[] get()
	{
		Equippable e = new Equippable();
		Useable u = new Useable();
		Equippable[] earray=e.get();//gets an array of all the equippable items
		Useable[] uarray = u.get();//gets an array of all Useable items
		Item[] array = new Item[Equippable.getNum()+Useable.getNum()];//gets the size of both Equippable and Useable derived classes
		for(int i=0; i<Equippable.getNum(); i++)
		{
			array[i]=earray[i];
		}
		for(int i=Equippable.getNum(); i<(Equippable.getNum()+Useable.getNum());i++)
		{
			array[i]=uarray[i-Equippable.getNum()];
		}
		return array;
	}
	
	//getters/setters
	
	//tests
}
