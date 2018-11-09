package base;

import base.mode.divideMode;
public class rectType extends rectXY implements Cloneable, divideMode
{
	protected double leftTopX, leftTopY;
	public rectType()
	{
		
	}
	public rectType(final double _dx, final double _dy,
			final double _leftTopX, final double _leftTopY)
	{
		set(_dx,_dy,_leftTopX,_leftTopY);
	}
	
	public rectType(final double _dx, final double _dy, final double _area,
			final double _leftTopX, final double _leftTopY)
	{
		super(_dx,_dy, _area);
		leftTopX = _leftTopX; leftTopY = _leftTopY;
	}
	public rectType getRemain(final rectXY usedRec, final int divideType)
	{
		//È¥µôusedRecºó, Ê£ÏÂ
		rectType rec = null;
		switch(divideType)
		{
		case divideLeftRight:
			rec = new rectType(this.dx-usedRec.dx, this.dy, this.leftTopX+usedRec.dx, this.leftTopY);
			break;
		case divideUpDown:
			rec = new rectType(this.dx, this.dy-usedRec.dy, this.leftTopX, this.leftTopY+usedRec.dy);
			break;
		default:
			System.err.println("In rectType getRemain, divideType is wrong.");
		}
		return rec;
	}
	public void setToRemain(final rectXY usedRec, final int divideType)
	{
		switch(divideType)
		{
		case divideLeftRight:
			set(this.dx-usedRec.dx, this.dy, this.leftTopX+usedRec.dx, this.leftTopY);
			break;
		case divideUpDown:
			set(this.dx, this.dy-usedRec.dy, this.leftTopX, this.leftTopY+usedRec.dy);
			break;
		default:
			System.err.println("In rectType setToRemain, divideType is wrong.");
		}
	}
	public void set(final double _dx, final double _dy, final double _leftTopX, final double _leftTopY)
	{
		super.set(_dx, _dy);
		this.setLeftTop(_leftTopX, _leftTopY);
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
	public void setLeftTop(final rectType rec)
	{
		setLeftTop(rec.leftTopX, rec.leftTopY);
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
