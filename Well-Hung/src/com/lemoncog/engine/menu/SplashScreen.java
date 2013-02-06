package com.lemoncog.engine.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.lemoncog.engine.VisualDebug;
import com.lemoncog.engine.factory.UIFactory;
import com.lemoncog.engine.resource.Assets;
import com.lemoncog.WellHung.LemoncogGame;

public class SplashScreen extends BaseScreen
{
	public float DELAY_FOR = 1.5f;
	public float mElapsedTime = 0;
	private boolean mFinished = false;

	public SplashScreen()
	{
		super();

		Image logo = new Image(Assets.splash_logo);

		Table container = new Table();
		Label text = UIFactory.buildDefaultLabel("Lemoncog");

		if (VisualDebug.isVisualDebugging())
		{
			container.debug();
		}

		container.setFillParent(true);
		container.add(logo).expand();
		container.row();
		container.add(text);

		addActor(container);
	}

	@Override
	public void render(float delta)
	{
		super.render(delta);

		Assets.updateManager();

		mElapsedTime += delta;

		if (mElapsedTime > DELAY_FOR)
		{
			progress();
		}

		Table.drawDebug(this);
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button)
	{
		// Skip straight to game screen.
		progress();

		return super.touchDown(x, y, pointer, button);
	}

	private void progress()
	{
		if (Assets.updateManager())
		{
			mFinished = true;
			LemoncogGame.getGame().pushScreen(new MainScreen());
			LemoncogGame.getGame().popScreen(this);
		}
	}
}
