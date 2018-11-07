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
		buffer.append("{dx: ");
		buffer.append(dx);
		buffer.append(',');
		
		buffer.append("dy: ");
		buffer.append(dy);
		buffer.append(',');
		
		buffer.append("x: ");
		buffer.append(leftTopX);
		buffer.append(',');
		
		buffer.append("y: ");
		buffer.append(leftTopY);
		buffer.append("}");
		return buffer.toString();
	}
}
