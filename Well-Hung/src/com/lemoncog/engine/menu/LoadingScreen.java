package com.lemoncog.engine.menu;

import java.util.Date;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.lemoncog.engine.factory.UIFactory;
import com.lemoncog.engine.resource.Assets;
import com.lemoncog.WellHung.LemoncogGame;

public class LoadingScreen extends BaseScreen
{
	public static String TAG = "LoadingScreen";

	public LoadingScreen()
	{
		super();

		Date now = new Date();

		Image logo = UIFactory.buildSpinner(new Image(Assets.splash_logo));

		Table container = new Table();

		container.setWidth(LemoncogGame.VIEW_WIDTH);
		container.setHeight(LemoncogGame.VIEW_HEIGHT);
		container.add(logo).expand();
		container.row();

		addActor(container);

		timeStop(TAG, now);
	}

	@Override
	public void render(float delta)
	{
		super.render(delta);

		if (Assets.updateManager())
		{
			LemoncogGame.getGame().popScreen();
		}
	}

	public boolean onBack()
	{
		// CANNOT back out of this screen.
		return false;
	}

	@Override
	public void dispose()
	{
		// Dont dipose this, we will re-use it for the lifetime of the app.
	}
}
