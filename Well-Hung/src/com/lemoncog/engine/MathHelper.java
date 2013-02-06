package com.lemoncog.engine;

public class MathHelper
{
	public static double getLongSide(float sideA, float sideB)
	{
		return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
	}
}
