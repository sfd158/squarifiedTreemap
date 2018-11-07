package squarifiedTreemap;

import java.util.ArrayList;
import base.*;
public class currentLine extends currentLineBase
{
	protected int firstNode = -1, lastNode = -1; ////of ArrayList nodeArea
	protected double alpha0, alpha1;
	protected rectType blankAndNowLine;
	protected double nowLineArea = 0;
	
	//���Ŷ̱�����
	protected void createNew()
	{
		//���¿հ�+CurrentLine���ϽǶ���, ����
		rectXY nlr = new rectXY(); //nowLineRec
		switch (fixEdge)
		{
		case currentLine.fixInX:
			nlr.setDX(blankAndNowLine.getDX(), nowLineArea);
			blankAndNowLine.setDY(blankAndNowLine.getDY() - nlr.getDY());
			blankAndNowLine.setLeftTop(blankAndNowLine.getLeftTopX(), 
					blankAndNowLine.getLeftTopY() + nlr.getDY());
			break;
		case currentLine.fixInY:
			nlr.setDY(blankAndNowLine.getDY(), nowLineArea);
			blankAndNowLine.setDX(blankAndNowLine.getDX() - nlr.getDX());
			blankAndNowLine.setLeftTop(blankAndNowLine.getLeftTopX() + nlr.getDX(), 
					blankAndNowLine.getLeftTopY());
			break;
		case currentLine.fixInNotSure:
			break;
		default:
			System.err.println("currentLine.fixEdge wrong.");
			break;
		}
		
		//����һ��
		this.firstNode = ++this.lastNode;
		nowLineArea = nodes_area[this.firstNode];
		rectXY rect = new rectXY();
		if(blankAndNowLine.getDX() < blankAndNowLine.getDY())
		{
			this.set(currentLine.fixInX, blankAndNowLine.getDX());
			rect.setDX(blankAndNowLine.getDX(), nowLineArea);
		}
		else
		{
			this.set(currentLine.fixInY, blankAndNowLine.getDY());
			rect.setDY(blankAndNowLine.getDY(), nowLineArea);
		}
		this.alpha0 = rect.getAlpha();
		this.alpha1 = this.alpha0;
	}
	protected void append()
	{
		alpha0 = alpha1;
		nowLineArea += nodes_area[++lastNode];
	}
	protected boolean nextToken()
	{
		if (lastNode + 1 < nodes_area.length)
			return true;
		else
		{
			outputNodeCoor();
			return false;
		}
	}
	
	protected void outputNodeCoor()
	{
		double nltx = blankAndNowLine.getLeftTopX();
		double nlty = blankAndNowLine.getLeftTopY();
		//new left top X, new left top Y
		
		double ndx = blankAndNowLine.getDX(), ndy = blankAndNowLine.getDY(); //new dx, new dy
		if(this.fixEdge == currentLine.fixInX)//x�̶�, ����y��. dx�ǲ����
		{
			for(int i=this.firstNode; i<=this.lastNode; i++)
			{
				ndy = nodes_area[i] / ndx;
				answerList.add(new answerNode(ndx, ndy, nltx, nlty));
				nlty += ndy;
			}
		}
		else
		{
			for(int i=this.firstNode; i<=this.lastNode; i++)
			{
				ndx = nodes_area[i] / ndy;
				answerList.add(new answerNode(ndx, ndy, nltx, nlty));
				nltx += ndx;
			}
		}
		//System.out.println(answerList.get(answerList.size()-1).toJson());
	}
	protected boolean shouldCreateNew()
	{
		alpha1 = calcMaxAlpha(firstNode, lastNode+1);
		return alpha1 > alpha0;
		//return false means should insert into current line.
	}
	public currentLine(nodeHandler _nodes, ArrayList<answerNode> _answerList,
			rectType _blankAndNowLine)
	{
		super(_nodes, _answerList);
		blankAndNowLine = _blankAndNowLine;
		createNew();
	}
	
	public int getFirstNode()
	{
		return firstNode;
	}
	public int getLastNode()
	{
		return lastNode;
	}
}

