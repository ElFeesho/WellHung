package com.lemoncog.engine;

public class Timer
{
	private boolean mPaused = true;
	private float mStart = 0;
	private float mElapsedTime = 0;

	public void start()
	{
		mPaused = false;
		mStart = 0;
	}

	public void stop()
	{
		mPaused = true;
	}

	public float update(float dt)
	{
		if (!mPaused)
		{
			mElapsedTime += dt;
		}

		return mElapsedTime;
	}

	public float getElapsedTime()
	{
		return mElapsedTime;
	}
}
