package base.controlAlpha;

import base.mode.alphaMode;

public class alphaCalc implements alphaMode
{	
	/*
	 * ��ʵ�ǿ����޸ĵ�...���������sumArray����ȥ, �����ӿ��ٶȡ�����
	 *ò�Ʋ�̫��ʵ�� ����û˵������
	 */
	public static double maxAlpha(
			final double[] area, final double totArea,
			final int first, final int last, final double fixEdgeLength)
	{
		double ans = 1, b;
		//double tpNowLineArea = nodes.getSumArea(first,last);
		final double a = totArea/fixEdgeLength;
		for(int i=first; i<=last; i++)
		{
			b = area[i]/totArea*fixEdgeLength;
			if(a > b) ans = Double.max(ans, a/b);
			else ans = Double.max(ans, b/a);
		}
		return ans;
	}
	
	public static double meanAlpha(
			final double[] area, final double totArea,
			final int first, final int last, final double fixEdgeLength)
	{
		return totAlpha(area,totArea,first,last,fixEdgeLength)/(last-first+1);
	}
	
	public static double totAlpha(
			final double[] area, final double totArea,
			final int first, final int last, final double fixEdgeLength)
	{
		double ans = 0.0, b;
		final double a = totArea/fixEdgeLength;
		for(int i=first; i<=last; i++)
		{
			b = area[i]/totArea*fixEdgeLength;
			if(a > b) ans += a/b;
			else ans += b/a;
		}
		return ans;
	}
	
	public static double totWeightedAlpha(
			final double[] area, final double totArea,
			final int first, final int last, final double fixEdgeLength)
	{
		double ans = 1.0, b;
		final double a = totArea/fixEdgeLength;
		for(int i=first; i<=last; i++)
		{
			b = area[i]/totArea*fixEdgeLength;
			if(a > b) ans += a/b*area[i];
			else ans += b/a*area[i];
		}
		return ans;
	}
	
	public static double weightedMeanAlpha(
			final double[] area, final double totArea,
			final int first, final int last, final double fixEdgeLength)
	{
		return totWeightedAlpha(area,totArea,first,last,fixEdgeLength)/totArea;
	}
	
	public static double getAlpha(
			final double[] area, final double totArea,
			final int first, final int last, final double fixEdgeLength, final int mode)
	{
		switch (mode)
		{
		case calcAlphaMaxMode:
			return maxAlpha(area, totArea, first, last, fixEdgeLength);
		case calcAlphaMeanMode:
			return maxAlpha(area, totArea, first, last, fixEdgeLength);
		case calcAlphaWeightedMeanMode:
			return maxAlpha(area, totArea, first, last, fixEdgeLength);
		default:
			System.err.println("In alphaClac, alpha mode is wrong.");
			return Double.NaN;
		}
		//��װ���������, ���������Ϳ��Ե�����, �����ظĴ���
	}
	
	public static final double[] getAlphaList(final double[] area, final double totArea,
			final int first, final int last, final double fixEdgeLength)
	{
		double[] ans = new double[last-first+1];
		double b;
		final double a = totArea/fixEdgeLength;
		for(int i=first; i<=last; i++)
		{
			b = area[i]/totArea*fixEdgeLength;
			if(a > b) ans[i-first] = a/b;
			else ans[i-first] = b/a;
		}
		return ans;
	}
}
