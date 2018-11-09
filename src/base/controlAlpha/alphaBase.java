package base.controlAlpha;

import base.mode.alphaMode;
public class alphaBase implements alphaMode
{
	protected int calcAlphaMode;
	public alphaBase()
	{
		calcAlphaMode = alphaMode.calcAlphaMaxMode;
	}
	public alphaBase(final int _calcAlphaMode)
	{
		setAlphaMode(_calcAlphaMode);
	}
	//想办法把getAlphaMode封装到某个基类或是接口中
	public int getAlphaMode()
	{
		return calcAlphaMode;
	}
	public void setAlphaMode(final int _alphaMode)
	{
		switch(_alphaMode)
		{
		case alphaMode.calcAlphaMaxMode:
		case alphaMode.calcAlphaMeanMode:
		case alphaMode.calcAlphaWeightedMeanMode:
			calcAlphaMode = _alphaMode;
			break;
		default:
			System.err.println("Wrong Alpha Mode. Choose calcAlphaMaxMode instead.");
			calcAlphaMode = alphaMode.calcAlphaMaxMode;
		}
	}
}
