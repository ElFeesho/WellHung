package com.lemoncog.engine.resource;

import java.util.Random;

public class Globals
{
	public static Random rand = new Random();

	public static long CURRENTID;

	public static long getNext()
	{
		return ++CURRENTID;
	}
}
