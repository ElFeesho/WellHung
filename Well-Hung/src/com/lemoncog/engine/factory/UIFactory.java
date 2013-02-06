package com.lemoncog.engine.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.lemoncog.engine.resource.Assets;

public class UIFactory
{
	public static final int BUTTON_DEFAULT_PADDING = 10;

	public static String humanTime(float secs)
	{
		long milliseconds = (long) (secs * 1000);

		int milli = (int) (milliseconds) % 1000;
		int seconds = (int) (milliseconds / 1000) % 60;
		int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
		int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);

		return formatWithZero(minutes) + ":" + formatWithZero(seconds) + "." + formatWithTwoZero(milli);
		// return String.format("%d:%d.%d",
		// TimeUnit.MILLISECONDS.toMinutes(millis),
		// TimeUnit.MILLISECONDS.toSeconds(millis),
		// TimeUnit.MILLISECONDS.toMillis(millis));
	}

	private static String formatWithTwoZero(int time)
	{
		return time < 100 ? time < 10 ? "00" + time : "0" + time : "" + time;
	}

	private static String formatWithZero(int time)
	{
		return time < 10 ? "0" + time : "" + time;
	}

	public static NinePatchDrawable buildPadNinePatch()
	{
		return new NinePatchDrawable(new NinePatch(new Texture(Gdx.files.internal("data/pad_9.png")), 7, 7, 7, 7));
	}

	public static Image buildSpinner(Image spinner)
	{
		RotateByAction rot = new RotateByAction();
		spinner.setOrigin(spinner.getHeight() / 2, spinner.getWidth() / 2);
		rot.setDuration(1);
		rot.setAmount(360);
		spinner.addAction(Actions.forever(rot));

		return spinner;
	}

	public static Image buildLoadingSpinner()
	{
		return buildSpinner(new Image(Assets.loadingSpinner()));
	}

	public static NinePatchDrawable buildDefaultNinePatch()
	{
		return new NinePatchDrawable(new NinePatch(new Texture(Gdx.files.internal("data/generic_9.png")), 6, 6, 6, 6));
	}

	public static NinePatchDrawable buildDarkNinePatch()
	{
		return new NinePatchDrawable(new NinePatch(new Texture(Gdx.files.internal("data/generic_dark_9.png")), 6, 6, 6, 6));
	}

	public static Button buildDefaultTextButton(String text)
	{
		NinePatchDrawable patch = buildDefaultNinePatch();
		final TextButtonStyle buttonStyle = new TextButtonStyle();
		buttonStyle.up = patch;
		buttonStyle.down = patch;
		buttonStyle.checked = patch;
		buttonStyle.font = Assets.getDefaultFont();
		buttonStyle.font.setScale(Assets.DIMENSIONS_SCALE_MOD);
		buttonStyle.fontColor = Color.WHITE;
		buttonStyle.pressedOffsetY = 1f;
		buttonStyle.downFontColor = new Color(0.8f, 0.8f, 0.8f, 1f);

		Button button = new TextButton(text, buttonStyle);
		button.pad(BUTTON_DEFAULT_PADDING);

		return button;
	}

	public static Label buildDefaultLabel(String text, Color color)
	{
		final LabelStyle style = new LabelStyle();
		style.font = Assets.getDefaultFont();
		style.font.setScale(Assets.DIMENSIONS_SCALE_MOD);
		style.fontColor = color;

		return new Label(text, style);
	}

	public static Label buildDefaultLabel(String text)
	{
		return buildDefaultLabel(text, Color.BLACK);
	}

	public static Label buildExcitingLabel(String text)
	{
		final LabelStyle style = new LabelStyle();
		style.font = Assets.getDefaultFontLarge();
		style.font.setScale(3 * Assets.DIMENSIONS_SCALE_MOD);
		style.fontColor = Color.BLACK;

		return new Label(text, style);
	}

	public static Table buildDefaultSkinnedTable()
	{
		NinePatchDrawable patch = buildDefaultNinePatch();
		Table table = new Table();
		table.setBackground(patch);

		return table;
	}

	public static Table buildDarkSkinnedTable()
	{
		NinePatchDrawable patch = buildDarkNinePatch();
		Table table = new Table();
		table.setBackground(patch);

		return table;
	}

	public static Label buildScoreTableLabel(String text)
	{
		return buildDefaultLabel(text);
	}
}