package base;
public class rectType extends rectXY implements Cloneable
{
	protected double leftTopX, leftTopY;
	public rectType()
	{
		
	}
	public rectType(final double _dx, final double _dy,
			final double _leftTopX, final double _leftTopY)
	{
		super(_dx,_dy);
		leftTopX = _leftTopX; leftTopY = _leftTopY;
		area = dx*dy;
	}
	
	public rectType(final double _dx, final double _dy, final double _area,
			final double _leftTopX, final double _leftTopY)
	{
		super(_dx,_dy, _area);
		leftTopX = _leftTopX; leftTopY = _leftTopY;
	}
	public double getLeftTopX()
	{
		return leftTopX;
	}
	public void setLeftTopX(double _leftTopX)
	{
		leftTopX = _leftTopX;
	}
	public double getLeftTopY()
	{
		return leftTopY;
	}
	public void setLeftTopY(double _leftTopY)
	{
		leftTopY = _leftTopY;
	}
	public void setLeftTop(double _leftTopX, double _leftTopY)
	{
		leftTopX = _leftTopX;
		leftTopY = _leftTopY;
	}
	public void setValue(final rectType rec)
	{
		dx = rec.dx;
		dy = rec.dy;
		leftTopX = rec.leftTopX;
		leftTopY = rec.leftTopY;
		area = rec.area;
	}
	@Override
	public rectType clone()
	{
		return new rectType(dx,dy,leftTopX,leftTopY);
	}
}
