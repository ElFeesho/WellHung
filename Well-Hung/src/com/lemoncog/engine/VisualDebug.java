package com.lemoncog.engine;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class VisualDebug
{
	public static boolean DEBUG_VISUALS = true;
	public static boolean DEBUG_TAPS = true;
	public static boolean DEBUG_LOGIC = true;

	public static final ShapeRenderer shapeRenderer = new ShapeRenderer();

	public static void setDebug(boolean debug)
	{
		if (debug)
		{
			DEBUG_VISUALS = true;
			DEBUG_TAPS = true;
			DEBUG_LOGIC = true;
			Gdx.app.setLogLevel(Application.LOG_DEBUG);
		} else
		{
			DEBUG_VISUALS = false;
			DEBUG_TAPS = false;
			DEBUG_LOGIC = false;
			Gdx.app.setLogLevel(Application.LOG_ERROR);
		}
	}

	public static boolean isVisualDebugging()
	{
		return DEBUG_VISUALS;
	}

	public static boolean isDebugging()
	{
		return DEBUG_VISUALS || DEBUG_TAPS || DEBUG_LOGIC;
	}
}
