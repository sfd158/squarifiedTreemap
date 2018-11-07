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
	protected ArrayList<Double> nodeArea;
	protected ArrayList<answerNode> answerList;
	protected double[] areaSum;
	protected double getSumArea(final int first, final int last)
	{
		if(first > 0)return areaSum[last] - areaSum[first-1];
		else return areaSum[last];
	}
	protected void buildSumArea()
	{
		areaSum = new double[nodeArea.size()];
		areaSum[0] = nodeArea.get(0);
		for(int i=1;i<areaSum.length;i++)
		{
			areaSum[i] = areaSum[i-1] + nodeArea.get(i);
		}
	}
	protected double calcMaxAlpha(final int first, final int last)
	{
		double ans = 1, b;
		double tpNowLineArea = getSumArea(first,last);
		final double a = tpNowLineArea/fixEdgeLength;
		for(int i=first; i<=last; i++)
		{
			b = nodeArea.get(i)/tpNowLineArea*fixEdgeLength;
			if(a > b) ans = Double.max(ans, a/b);
			else ans = Double.max(ans, b/a);
		}
		return ans;
	}
	protected double calcAverAlpha(final int first, final int last)
	{
		double ans = 1, b;
		double tpNowLineArea = getSumArea(first,last);
		final double a = tpNowLineArea/fixEdgeLength;
		for(int i=first; i<=last; i++)
		{
			b = nodeArea.get(i)/tpNowLineArea*fixEdgeLength;
			if(a > b) ans += a/b;
			else ans += b/a;
		}
		return ans/(last-first+1);
	}
	public currentLineBase(ArrayList<Double> _nodeArea, ArrayList<answerNode> _answerList)
	{
		nodeArea = _nodeArea;
		answerList = _answerList;
		buildSumArea();
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

