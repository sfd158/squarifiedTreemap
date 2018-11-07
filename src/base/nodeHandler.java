package base;

import java.util.ArrayList;
import java.util.Collections;

public class nodeHandler
{
	protected double[] areaSum = null;
	protected double[] area = null;
	protected ArrayList<simpleNodeType> nodes;
	protected boolean needMake = false;
	public nodeHandler()
	{
		nodes = new ArrayList<>();
	}
	
	public nodeHandler(ArrayList<simpleNodeType> _nodes)
	{
		setNodes(_nodes);
	}
	
	public final double[] getArea()
	{
		judgeMake();
		return area;
	}
	
	public void normalize(final double _width, final double _height)
	{
		if(needMake)
		{
			make();
		}
		final double tmp = (_width * _height) / getTotalArea();
		for(int i=0; i<nodes.size(); i++)
		{
			simpleNodeType t = nodes.get(i);
			nodes.set(i,new simpleNodeType(t.id, t.area*tmp, t.name));
		}
		needMake = true;
	}
	
	public void sortByArea()
	{
		Collections.sort(nodes);
		needMake = true;
	}
	
	@Override
	public String toString()
	{
		return toJson();
	}
	
	public String toJson()
	{
		if(nodes == null || nodes.size() == 0)
			return "{}";
		StringBuilder build = new StringBuilder();
		build.append("{\n");
		for(simpleNodeType i:nodes)
		{
			build.append(i.toJson());
			build.append(",\n");
		}
		build.append("}\n");
		return build.toString();
	}
	
	public void clear()
	{
		nodes.clear();
		areaSum = null;
		area = null;
		needMake = false;
	}
	
	public void setNodes(ArrayList<simpleNodeType> _nodes)
	{
		nodes = _nodes;
		needMake = true;
	}
	
	public void append(simpleNodeType _node)
	{
		if(_node != null)
			nodes.add(_node);
		needMake = true;
	}
	
	public void make()
	{
		if(!needMake || nodes == null || nodes.size() == 0)
			return;
		needMake = false;
		areaSum = new double[nodes.size()];
		area = new double[nodes.size()];
		areaSum[0] = area[0] = nodes.get(0).area;
		for(int i=1; i<area.length; i++)
		{
			area[i] = nodes.get(i).area;
			areaSum[i] = areaSum[i-1] + area[i];
		}
	}
	
	protected void judgeMake()
	{
		if(needMake)
		{
			make();
		}
	}
	
	public boolean isNeedMake()
	{
		return needMake;
	}
	
	public double getTotalArea()
	{
		judgeMake();
		return areaSum[areaSum.length-1];
	}
	
	public double getSumArea(final int first, final int last)
	{
		judgeMake();
		if(first > 0)return areaSum[last] - areaSum[first-1];
		else return areaSum[last];
	}
}
