package ver0;

public class Party 
{
	int[] m_inventory;
	Actor[] m_content;
	int m_money;
	Party()
	{
		m_inventory = new int[Item.getNum()];
		m_content=new Actor[4];
		m_content[0]=new Actor();
	}
}
