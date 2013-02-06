package com.lemoncog.engine.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets
{
	// I created this game with an expected resolution of 800x480, this is the
	// diag length of that.
	public static final double expectedDiag = 932.9523031752481;
	public static float DIMENSIONS_SCALE_MOD = 1;
	public static float CAMERA_SCALE_MOD = 1;

	public static Texture splash_logo;

	private static AssetManager manager = new AssetManager();

	public static void resize(int width, int height)
	{
		double diagLength = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		Gdx.app.log("diagLength", "" + diagLength);

		// Camera scaling works from 0-INFINITY so for smaller screens this
		// should be larger.
		CAMERA_SCALE_MOD = (float) (expectedDiag / diagLength);

		// Font/Padding etc should go be reduced if the screen is smaller.
		DIMENSIONS_SCALE_MOD = (float) (diagLength / expectedDiag);

		// If this ever goes below 0, clamp it higher.
		if (DIMENSIONS_SCALE_MOD <= 0)
			DIMENSIONS_SCALE_MOD = 0.1f;
	}

	private static final String SPRITE_ATLAS = "data/basics.atlas";
	private static final String SPRITE_ATLAS_PLAYERS = "data/players.atlas";
	private static final String SPRITE_ATLAST_OBJECTS = "data/playObjects.atlas";
	private static final String PLAYER = "pixel";

	public static String[] bodyNames =
	{ "bodyLady" };
	public static String[] clothNames =
	{ "clothingShirtShort" };

	public static int frames = 2;
	public static String[] hairNames =
	{ "hairAffro" };

	public static TextureRegion Pixel()
	{
		return manager.get(SPRITE_ATLAS, TextureAtlas.class).findRegion(PLAYER);
	}

	public static TextureRegion chalkLine()
	{
		return getObjectAtlas().findRegion("chalkLine");
	}

	public static TextureAtlas getObjectAtlas()
	{
		return manager.get(SPRITE_ATLAST_OBJECTS, TextureAtlas.class);
	}

	public static Color toRGB(int r, int g, int b)
	{
		return toRGB(r, g, b, 1);
	}

	public static Color toRGB(int r, int g, int b, float alpha)
	{
		float RED = r / 255.0f;
		float GREEN = g / 255.0f;
		float BLUE = b / 255.0f;
		return new Color(RED, GREEN, BLUE, alpha);
	}

	public static TextureAtlas getPlayerAtlas()
	{
		return manager.get(SPRITE_ATLAS_PLAYERS, TextureAtlas.class);
	}

	public static TextureRegion loadingSpinner()
	{
		return manager.get(SPRITE_ATLAS, TextureAtlas.class).findRegion("RotateArrow");
	}

	public static BitmapFont defaultFont;
	public static BitmapFont defaultFontLarge;
	public static BitmapFont defaultFontMedium;

	public static BitmapFont getDefaultFont()
	{
		// Dosen't work!?!
		return defaultFont;
	}

	public static BitmapFont getDefaultFontMedium()
	{
		return defaultFontMedium;
	}

	public static BitmapFont getDefaultFontLarge()
	{
		// Dosen't work!?!
		return defaultFontLarge;
	}

	public static boolean updateManager()
	{
		return manager.update();
	}

	public static void load()
	{
		// atlas = new
		// TextureAtlas(Gdx.files.internal("data/shipAndOrbs.atlas"),
		// Gdx.files.internal("data/"));

		manager = new AssetManager();
		// manager.load(SPRITE_ATLAS, TextureAtlas.class);
		// manager.load(SPRITE_ATLAS_PLAYERS, TextureAtlas.class);
		// manager.load(SPRITE_ATLAST_OBJECTS, TextureAtlas.class);
		Texture.setAssetManager(manager);

		defaultFont = new BitmapFont(Gdx.files.internal("data/fonts/font1.fnt"), Gdx.files.internal("data/fonts/font1.png"), false);
		defaultFontLarge = new BitmapFont(Gdx.files.internal("data/fonts/font1.fnt"), Gdx.files.internal("data/fonts/font1.png"), false);
		defaultFontMedium = new BitmapFont(Gdx.files.internal("data/fonts/font1.fnt"), Gdx.files.internal("data/fonts/font1.png"), false);

		splash_logo = new Texture(Gdx.files.internal("data/splash_logo.png"));
	}
}
