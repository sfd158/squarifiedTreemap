package base;
import java.util.ArrayList;

public abstract class treemapBase extends rectXY
{
	protected ArrayList<Double> nodeArea;
	protected ArrayList<answerNode> answerList;
	protected static final double eps = 1e-6;
	public treemapBase()
	
	{
		answerList = new ArrayList<answerNode>();
	}
	
	public treemapBase(final ArrayList<Double> _nodeArea,
			final double _width, final double _height, final boolean normalize)
	{
		this();
		setNodeArea(_nodeArea,_width,_height,normalize);
	}
	
	public final ArrayList<answerNode> getAnswerList()
	{
		return answerList;
	}
	
	public boolean setNodeArea(final ArrayList<Double> _nodeArea,
			final double _width, final double _height, final boolean normalize)
	{
		double sum = 0;
		for(double i:_nodeArea)
			sum += i;
		nodeArea = new ArrayList<Double>(_nodeArea);
		if(!normalize)
		{
			if (Math.abs(_width*_height-sum)>eps)return false;
		}
		else
		{
			final double tmp = (_width * _height) / sum;
			for(int i=0; i<nodeArea.size(); i++)
			{
				nodeArea.set(i, nodeArea.get(i)*tmp);
			}
		}
		this.set(_width, _height);
		afterSetNodeArea();
		return true;
	}
	
	protected void afterSetNodeArea()
	{
		
	}
	
	public abstract void calcTreemap();
	
	public String outputTreemap()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		for(int i=0;i<answerList.size()-1;i++)
		{
			buffer.append(answerList.get(i).toJson());
			buffer.append(",\n");
		}
		buffer.append(answerList.get(answerList.size()-1).toJson());
		buffer.append("}\n");
		return buffer.toString();
	}
}
