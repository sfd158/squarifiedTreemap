package base;

public abstract class judgeEqu 
{
	protected static double eps = 1e-5;
	public static double getEps()
	{
		return eps;
	}
	public static void setEps(final double _eps)
	{
		if(_eps <= 0) return;
		eps = _eps;
	}
	public static boolean isEqual(final double x, final double y)
	{
		return Math.abs(x-y) < eps;
	}
	public static boolean notEqual(final double x, final double y)
	{
		return !isEqual(x,y);
	}
}
