package com.lemoncog.engine.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lemoncog.WellHung.LemoncogGame;
import com.lemoncog.WellHung.menu.HangTimerScreen;
import com.lemoncog.engine.factory.UIFactory;
import com.lemoncog.engine.resource.Assets;

public class MainScreen extends BaseScreen
{
	private static final String MODE_1 = "Hanging";
	public static final int MENU_PADDING = (int) (20 * Assets.DIMENSIONS_SCALE_MOD);

	public MainScreen()
	{
		super();

		Table menuTable = new Table();
		menuTable.setFillParent(true);

		Button testLevel = UIFactory.buildDefaultTextButton(MODE_1);
		testLevel.addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				LemoncogGame.getGame().pushScreen(new HangTimerScreen());
			}
		});

		// Use the larget width as the definer of the rest.
		final int buttonWidth = (int) testLevel.getWidth();

		addActor(menuTable);

		// mWorld = new ScreenSaverWorld(new
		// LevelData().createScreenSaveWorld());

		menuTable.row();
		menuTable.add(testLevel).width(buttonWidth);
	}

	public void draw()
	{
		// mWorld.renderWorld();

		super.draw();
	}

	public void update(float delta)
	{
		// mWorld.updateWorld(delta);
	}
}
