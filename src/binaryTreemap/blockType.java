package binaryTreemap;

import java.util.ArrayList;

public class blockType 
{
	public static final int divideNotSure = 3;
	public static final int divideLeftRight = 4;
	public static final int divideUpDown = 5;
	
	protected int divideOrder = divideNotSure;
	
	protected ArrayList<Integer> nodes = null;
	//nodes����nodeArea�еı��. �������Ǳ�Ҫ��, ��Ϊ����Ҫ��������Ԫ��, ��������ʲô��...
	//�ٿ���һ��, �����Ǳ�ź���, ����ȫ���ƺ���...
	//��Ϊjava�ﶼ������, ���Ի���ȫ���ƺ���
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
