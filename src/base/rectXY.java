package base;

public class rectXY 
{
	protected double dx, dy;
	protected double area;
	public rectXY()
	{
		
	}
	public rectXY(final double _dx, final double _dy)
	{
		set(_dx,_dy);
	}
	public rectXY(final double _dx, final double _dy, final double _area)
	{
		dx = _dx; dy = _dy; area = _area;
	}
	public double getLongerEdge()
	{
		return Double.max(dx, dy);
	}
	public double getShorterEdge()
	{
		return Double.min(dx, dy);
	}
	public void set(final double _dx, final double _dy)
	{
		dx = _dx;
		dy = _dy;
		area = dx * dy;
	}
	public void set(final double _dx, final double _dy, final double _area)
	{
		dx = _dx;
		dy = _dy;
		area = _area;
	}
	public void setDX(final double _dx)
	{
		dx = _dx;
		area = dx*dy;
	}
	public void setDX(final double _dx, final double _area)
	{
		dx = _dx;
		area = _area;
		dy = area/dx;
	}
	public double getDX()
	{
		return dx;
	}
	public void setDY(final double _dy)
	{
		dy = _dy;
		area = dx*dy;
	}
	public void setDY(final double _dy, final double _area)
	{
		dy = _dy;
		area = _area;
		dx = _area / dy;
	}
	public double getDY()
	{
		return dy;
	}
	public double getAlpha()
	{
		return (dx<dy)?(dy/dx):(dx/dy);
	}
}
