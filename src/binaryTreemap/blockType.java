package binaryTreemap;

import java.util.ArrayList;

public class blockType 
{
	public static final int divideNotSure = 3;
	public static final int divideLeftRight = 4;
	public static final int divideUpDown = 5;
	
	protected int divideOrder = divideNotSure;
	
	protected ArrayList<Integer> nodes = null;
	//nodes保存nodeArea中的标号. 保存标号是必要的, 因为可能要加入其它元素, 比如名字什么的...
	//再考虑一下, 到底是编号合适, 还是全复制合适...
	//因为java里都是引用, 所以还是全复制合适
	protected blockType[] child = null;
	protected binaryTreemap tree;
	public blockType(binaryTreemap _tree)
	{
		tree = _tree;
	}
	
	protected void initChild()
	{
		if (child == null)
		{
			
		}
	}
	
	protected void initNodes()
	{
		nodes = new ArrayList<Integer>();
	}
	
	public void divideLeftAndRight()
	{
		divideOrder = divideLeftRight;
	}
	

	
}
