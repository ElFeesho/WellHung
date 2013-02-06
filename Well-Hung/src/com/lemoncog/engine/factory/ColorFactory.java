package com.lemoncog.engine.factory;

import com.badlogic.gdx.graphics.Color;

public class ColorFactory
{
	public static final float[] MAIN_BLUE =
	{ 52, 124, 255, 255 };
	public static final float[] MAIN_YELLOW =
	{ 241, 255, 11, 255 };

	public static Color PRIMARY_COLOR;

	private static boolean initCalled = false;

	public static void init()
	{
		if (initCalled)
			return;
		initCalled = true;

		convertToFloating(MAIN_BLUE);
		PRIMARY_COLOR = toRGB(MAIN_YELLOW[0], MAIN_YELLOW[1], MAIN_YELLOW[2]);
	}

	public static float[] convertToFloating(float[] array)
	{
		array[0] = array[0] / 255f;
		array[1] = array[1] / 255f;
		array[2] = array[2] / 255f;
		array[3] = array[3] / 255f;

		return array;
	}

	public static Color toRGB(float r, float g, float b)
	{
		return toRGB(r, g, b, 1);
	}

	public static Color toRGB(float r, float g, float b, float alpha)
	{
		float RED = r / 255.0f;
		float GREEN = g / 255.0f;
		float BLUE = b / 255.0f;
		return new Color(RED, GREEN, BLUE, alpha);
	}

	public static float[] getBackgroundColor()
	{
		return new float[]
		{ 52f / 255f, 124f / 255f, 255f / 255f, 1 };
	}

	public static Color getPrimaryTextColor()
	{
		return PRIMARY_COLOR;
	}

}
