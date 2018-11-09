import java.util.ArrayList;
import test.countProjectTotLine;

import base.*;
import binaryTreemap.*;
import squarifiedTreemap.squarifiedTreemap;
public class Main
{
	/*
	protected static ArrayList<Double> nodeArea = new ArrayList<Double>();
	protected static void initList()
	{
		nodeArea.add(500.0);
		nodeArea.add(433.0);
		nodeArea.add(78.0);
		nodeArea.add(25.0);
		nodeArea.add(25.0);
		nodeArea.add(7.0);
	}*/
	protected static nodeHandler nodes = new nodeHandler();
	protected static void initList()
	{
		nodes.append(new simpleNodeType(0,500));
		nodes.append(new simpleNodeType(1,433));
		nodes.append(new simpleNodeType(2,78));
		nodes.append(new simpleNodeType(3,25));
		nodes.append(new simpleNodeType(4,25));
		nodes.append(new simpleNodeType(5,7));
		//nodes.append(new simpleNodeType(6,1000));
		/*
		nodes.sortByArea();
		nodes.normalize(700, 433);
		nodes.make();
		System.out.println(nodes.toJson());*/
	}
	
	protected static void testSquarifiedTreemap()
	{
		initList();
		squarifiedTreemap tree = new squarifiedTreemap(nodes, 700, 433, true);
		tree.calcTreemap();
		System.out.println(tree.toJson());
	}
	
	protected static void testBinaryTreemap()
	{
		initList();
		binaryTreemap tree = new binaryTreemap();
		//blockType block = new blockType();
		//block.initChild();
	}
	
	public static void main(String[] args)
	{
		testSquarifiedTreemap();
		//testBinaryTreemap();
		//simpleNodeType node = new simpleNodeType(0, 233, "fuck");
		//System.out.println(node.toJson());
		//initList();
		//countProjectTotLine.read("D:/programming/eclipse-workspace/java/TreeMap/src/");
	}
}
