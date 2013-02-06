package com.lemoncog.engine.menu;

import java.util.Date;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lemoncog.engine.factory.UIFactory;
import com.lemoncog.engine.resource.StringsResource;
import com.lemoncog.WellHung.LemoncogGame;

public class BaseScreen extends Stage implements Screen
{
	private final String TAG = "BaseScreen";
	private boolean mPaused = false;

	public BaseScreen()
	{
		super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);

		Date now = new Date();
		Gdx.app.log(TAG, "START");

		Button back = UIFactory.buildDefaultTextButton(StringsResource.BACK);
		back.addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				// Prompt user if they wish to really quit.
				LemoncogGame.getGame().popScreen();
			}
		});

		if (LemoncogGame.getGame().needsBack() && LemoncogGame.getGame().getActiveMenu() != null)
			addActor(back);

		timeStop(TAG, now);
	}

	public void timeStop(String tag, Date start)
	{
		long timePassed = new Date().getTime() - start.getTime();
		Gdx.app.log(tag, "END, took: " + timePassed);
	}

	@Override
	public void render(float delta)
	{
		act(delta);

		if (!mPaused)
			update(delta);

		draw();
	}

	public void update(float delta)
	{
		act(delta);
	}

	@Override
	public void resize(int width, int height)
	{
		setViewport(width, height, false);
	}

	@Override
	public boolean keyDown(int keycode)
	{
		if (keycode == Keys.BACK)
		{
			// Do your optional back button handling (show pause menu?)
			if (onBack())
			{
				LemoncogGame.getGame().popScreen();
				return true;
			}
		}
		return false;
	}

	public boolean onBack()
	{
		return true;
	}

	@Override
	public void show()
	{
		LemoncogGame.getGame().addInputListener(getInputType());
	}

	@Override
	public void hide()
	{
		LemoncogGame.getGame().removeInputListener(getInputType());
	}

	public InputAdapter[] getInputType()
	{
		return new InputAdapter[]
		{ this };
	}

	@Override
	public void pause()
	{
		mPaused = true;
	}

	@Override
	public void resume()
	{
		mPaused = false;
	}

	@Override
	public void dispose()
	{
		super.dispose();
	}
}
