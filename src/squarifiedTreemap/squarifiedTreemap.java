package squarifiedTreemap;


import java.util.ArrayList;
import java.util.Collections;
import base.*;
public class squarifiedTreemap extends treemapBase
{
	public squarifiedTreemap()
	{
		super();
	}
	
	public squarifiedTreemap(final ArrayList<Double> _nodeArea,
			final double _width, final double _height, final boolean normalize)
	{
		super(_nodeArea, _width, _height, normalize);
	}
	
	@Override
	protected void afterSetNodeArea()
	{
		Collections.sort(nodeArea, Collections.reverseOrder());
	}
	
	@Override
	public void calcTreemap()
	{
		rectType blankAndNowLine = new rectType(dx, dy, 0, 0);
		currentLine nowLine = new currentLine(nodeArea, answerList, blankAndNowLine);
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
