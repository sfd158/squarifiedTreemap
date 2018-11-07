package base;
import java.util.ArrayList;

public abstract class treemapBase extends rectXY
{
	protected nodeHandler nodes; 
	protected ArrayList<answerNode> answerList = new ArrayList<>();
	protected static final double eps = 1e-6;
	public treemapBase()
	{
		
	}
	
	public treemapBase(nodeHandler _nodes,
			final double _width, final double _height, final boolean normalize)
	{
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
		this.set(_width, _height);
		nodes.make();
		if(normalize)
		{
			_nodes.normalize(_width, _height);
		}
		else
		{
			if(Math.abs(nodes.getTotalArea()-_width*_height)>eps)
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
