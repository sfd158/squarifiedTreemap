package squarifiedTreemap;

import base.*;
public class squarifiedTreemap extends treemapBase
{
	public squarifiedTreemap()
	{
		super();
	}
	
	public squarifiedTreemap(nodeHandler _nodes,
			final double _width, final double _height, final boolean normalize)
	{
		super(_nodes, _width, _height, normalize);
	}
	
	@Override
	public void calcTreemap()
	{
		rectType blankAndNowLine = new rectType(dx, dy, 0, 0);
		currentLine nowLine = new currentLine(nodes, answerList, blankAndNowLine);
		while(nowLine.nextToken())
		{
			if (nowLine.shouldCreateNew())
			{
				nowLine.outputNodeCoor();
				nowLine.createNew();
			}
			else
			{
				nowLine.append();
			}
		}
	}
}
