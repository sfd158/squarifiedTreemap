package binaryTreemap;

public class nodeBlockType 
{
	public static final int insertNotSure = 0;
	public static final int insertAlongX = 1;
	public static final int insertAlongY = 2;
	protected int insertOrder = insertNotSure;
	public nodeBlockType()
	{
		
	}
	
	public boolean isInsertAlongX()
	{
		return insertOrder == insertAlongX;
	}
	
	public boolean isInsertAlongY()
	{
		return insertOrder == insertAlongY;
	}
	
	public int getInsertOrder()
	{
		return insertOrder;
	}
}
