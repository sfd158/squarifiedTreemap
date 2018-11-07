package base;
public class answerNode extends rectType
{
	//for output the answer.
	public answerNode(final double _dx,final double _dy,
			final double _leftTopX, final double _leftTopY)
	{
		super(_dx,_dy,_leftTopX,_leftTopY);
	}

	public String toJson()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("{\ndx: ");
		buffer.append(dx);
		buffer.append(",\n");
		
		buffer.append("dy: ");
		buffer.append(dy);
		buffer.append(",\n");
		
		buffer.append("x: ");
		buffer.append(leftTopX);
		buffer.append(",\n");
		
		buffer.append("y: ");
		buffer.append(leftTopY);
		buffer.append("\n}");
		return buffer.toString();
	}
}
