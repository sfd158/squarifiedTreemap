package squarifiedTreemap;


//TODO: squarifiedTreemap输出的时候, 一并把name和id也输出了。。
import java.util.ArrayList;
import base.*;
import base.mode.alphaMode;
import base.mode.divideMode;
public class currentLine extends currentLineBase
{
	protected int firstNode = -1, lastNode = -1; ////of ArrayList nodeArea
	protected double alpha0, alpha1;
	protected rectType blankAndNowLine;
	protected double nowLineArea = 0;
	
	//沿着短边来排
	protected void createNew()
	{
		//更新空白+CurrentLine左上角顶点, 长宽
		rectXY nlr = new rectXY(); //nowLineRec
		switch (fixEdge)
		{
		case currentLine.insertAlongY:
			nlr.setDX(blankAndNowLine.getDX(), nowLineArea);
			blankAndNowLine.setToRemain(nlr, divideMode.divideUpDown);
			//其实insertAlongY和divideUpDown或许可以合并...
			/*
			blankAndNowLine.setDY(blankAndNowLine.getDY() - nlr.getDY());
			blankAndNowLine.setLeftTop(blankAndNowLine.getLeftTopX(), 
					blankAndNowLine.getLeftTopY() + nlr.getDY());*/
			break;
		case currentLine.insertAlongX:
			nlr.setDY(blankAndNowLine.getDY(), nowLineArea);
			blankAndNowLine.setToRemain(nlr, divideMode.divideLeftRight);
			/*
			blankAndNowLine.setDX(blankAndNowLine.getDX() - nlr.getDX());
			blankAndNowLine.setLeftTop(blankAndNowLine.getLeftTopX() + nlr.getDX(), 
					blankAndNowLine.getLeftTopY());*/
			break;
		case currentLine.insertNotSure:
			break;
		default:
			System.err.println("currentLine.fixEdge wrong.");
			break;
		}
		
		//新起一行
		this.firstNode = ++this.lastNode;
		nowLineArea = nodes_area[this.firstNode];
		rectXY rect = new rectXY();
		if(blankAndNowLine.getDX() < blankAndNowLine.getDY())
		{
			this.set(currentLine.insertAlongY, blankAndNowLine.getDX());
			rect.setDX(blankAndNowLine.getDX(), nowLineArea);
		}
		else
		{
			this.set(currentLine.insertAlongX, blankAndNowLine.getDY());
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
		if(this.fixEdge == currentLine.insertAlongY)//x固定, 沿着y走. dx是不变的
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
		alpha1 = getAlpha(firstNode, lastNode+1, calcAlphaMode);
		return alpha1 > alpha0;
		//return false means should insert into current line.
	}
	public currentLine(nodeHandler _nodes, ArrayList<answerNode> _answerList, rectType _blankAndNowLine)
	{
		this(_nodes, _answerList, _blankAndNowLine, alphaMode.calcAlphaMaxMode);
	}
	
	public currentLine(nodeHandler _nodes, ArrayList<answerNode> _answerList, rectType _blankAndNowLine, final int _alphaMode)
	{
		super(_nodes, _answerList, _alphaMode);
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

