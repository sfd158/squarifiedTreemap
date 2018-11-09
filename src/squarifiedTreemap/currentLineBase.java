package squarifiedTreemap;

import java.util.ArrayList;
import base.*;
import base.controlAlpha.alphaBase;
import base.controlAlpha.alphaCalc;
import base.mode.alphaMode;
import base.mode.insertMode;

public class currentLineBase extends alphaBase implements insertMode
{
	//public static final int fixInNotSure = 0;
	//public static final int fixInX = 1; //x固定, 也就是沿着y来插入.
	//public static final int fixInY = 2;
	protected int fixEdge;
	protected double fixEdgeLength;
	protected nodeHandler nodes;
	protected double[] nodes_area;
	protected ArrayList<answerNode> answerList;

	protected double getAlpha(final int first, final int last, final int mode)
	{
		return alphaCalc.getAlpha(nodes_area, nodes.getSumArea(first,last), first, last, fixEdgeLength, mode);
	}
	public currentLineBase(nodeHandler _nodes, ArrayList<answerNode> _answerList)
	{
		super(alphaMode.calcAlphaMaxMode);
		nodes = _nodes;
		nodes_area= nodes.getArea();
		answerList = _answerList;
	}
	public currentLineBase(nodeHandler _nodes, ArrayList<answerNode> _answerList, final int _alphaMode)
	{
		this(_nodes, _answerList);
		setAlphaMode(_alphaMode);
	}

	protected void set(final int _fixEdge, final double _fixEdgeLength)
	{
		fixEdge = _fixEdge;
		fixEdgeLength = _fixEdgeLength;
	}
	public int getInsertOrder()
	{
		return fixEdge;
	}
	public double getFixEdgeLength()
	{
		return fixEdgeLength;
	}
	public boolean isInsertAlongX()
	{
		return fixEdge == currentLineBase.insertAlongX;
	}
	public boolean isInsertAlongY()
	{
		return fixEdge == currentLineBase.insertAlongY;
	}
}

