package base;

public class simpleNodeType implements Comparable<simpleNodeType>
{
	public final int id;
	public final double area;
	public final String name;
	
	public simpleNodeType(final int _id, final double _area)
	{
		id = _id;
		area = _area;
		name = null;
	}
	
	public simpleNodeType(final int _id, final double _area, final String _name)
	{
		id = _id;
		area = _area;
		name = _name;
	}
	
	public String toJson()
	{
		return '{' + toString() + '}';
	}
	
	@Override
	public String toString()
	{
		StringBuilder build = new StringBuilder();
		build.append("id: ");
		build.append(id);
		build.append(", area: ");
		build.append(area);
		if(name != null)
		{
			build.append(", name: \"");
			build.append(name);
			build.append('\"');
		}
		return build.toString();
	}

	@Override
	public int compareTo(simpleNodeType o) 
	{
		//按照面积从大到小排序
		if(this.area < o.area) return 1;
		else if(this.area > o.area) return -1;
		else return 0;
	}
}
