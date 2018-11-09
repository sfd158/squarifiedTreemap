package base;
import java.util.ArrayList;

import base.controlAlpha.alphaBase;

public abstract class treemapBase extends alphaBase
{
	protected nodeHandler nodes;
	protected ArrayList<answerNode> answerList = new ArrayList<>();
	protected rectXY screen = new rectXY();
	//protected static final double eps = 1e-6;
	public treemapBase()
	{
		
	}
	
	public treemapBase(nodeHandler _nodes,
			final double _width, final double _height, final boolean normalize)
	{
		setNodeArea(_nodes,_width,_height,normalize);
	}
	
	public treemapBase(nodeHandler _nodes,
			final double _width, final double _height, final boolean normalize, final int _calcAlphaMode)
	{
		this.setAlphaMode(_calcAlphaMode);
		setNodeArea(_nodes,_width,_height,normalize);
	}
	
	public nodeHandler getNodes()
	{
		return nodes;
	}
	
	public final ArrayList<answerNode> getAnswerList()
	{
		return answerList;
	}
	
	public void setNodeArea(nodeHandler _nodes,
			final double _width, final double _height, final boolean normalize)
	{
		nodes = _nodes;
		screen.set(_width, _height);
		nodes.make();
		if(normalize)
		{
			_nodes.normalize(_width, _height);
		}
		else
		{
			if(judgeEqu.notEqual(nodes.getTotalArea(), _width*_height))
			{
				System.err.println("nodes doesn't match screen with _width * _height");
				return;
			}
		}
	}
	
	public abstract void calcTreemap();
	
	public String toJson()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("{\n");
		for(int i=0;i<answerList.size()-1;i++)
		{
			buffer.append(answerList.get(i).toJson());
			buffer.append(",\n");
		}
		buffer.append(answerList.get(answerList.size()-1).toJson());
		buffer.append("\n}\n");
		return buffer.toString();
	}
}
