package squarifiedTreemap;

import java.util.ArrayList;
import base.*;
public class currentLineBase 
{
	public static final int fixInNotSure = 0;
	public static final int fixInX = 1;
	public static final int fixInY = 2;
	protected int fixEdge;
	protected double fixEdgeLength;
	protected nodeHandler nodes;
	protected double[] nodes_area;
	protected ArrayList<answerNode> answerList;

	protected double calcMaxAlpha(final int first, final int last)
	{
		double ans = 1, b;
		double tpNowLineArea = nodes.getSumArea(first,last);
		final double a = tpNowLineArea/fixEdgeLength;
		for(int i=first; i<=last; i++)
		{
			b = nodes_area[i]/tpNowLineArea*fixEdgeLength;
			if(a > b) ans = Double.max(ans, a/b);
			else ans = Double.max(ans, b/a);
		}
		return ans;
	}
	protected double calcAverAlpha(final int first, final int last)
	{
		double ans = 1, b;
		double tpNowLineArea = nodes.getSumArea(first,last);
		final double a = tpNowLineArea/fixEdgeLength;
		for(int i=first; i<=last; i++)
		{
			b = nodes_area[i]/tpNowLineArea*fixEdgeLength;
			if(a > b) ans += a/b;
			else ans += b/a;
		}
		return ans/(last-first+1);
	}
	public currentLineBase(nodeHandler _nodes, ArrayList<answerNode> _answerList)
	{
		nodes = _nodes;
		nodes_area= nodes.getArea();
		answerList = _answerList;
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
	public boolean isFixInX()
	{
		return fixEdge == currentLineBase.fixInX;
	}
	public boolean isFixInY()
	{
		return fixEdge == currentLineBase.fixInY;
	}
}

