package com.lemoncog.WellHung;

import java.util.Stack;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.lemoncog.engine.SettingsHolder;
import com.lemoncog.engine.VisualDebug;
import com.lemoncog.engine.crossPlatform.GeneralInterface;
import com.lemoncog.engine.factory.ColorFactory;
import com.lemoncog.engine.menu.BaseScreen;
import com.lemoncog.engine.menu.LoadingScreen;
import com.lemoncog.engine.menu.SplashScreen;
import com.lemoncog.engine.resource.Assets;

public class LemoncogGame extends Game implements ApplicationListener {
	// Interfaces
	private GeneralInterface mGeneralCallback;

	public static final String FIRST_RUN = "FIRST_RUN";

	public static int VIEW_WIDTH = 800;
	public static int VIEW_HEIGHT = 480;

	private static LemoncogGame game;
	private InputMultiplexer mMultiplexer;

	private LoadingScreen mLoadingScreen;

	public void addInputListener(InputProcessor[] processor) {
		if (processor != null) {
			for (int i = 0; i < processor.length; i++) {
				addInputListener(processor[i]);
			}
		}
	}

	public void removeInputListener(InputProcessor[] processor) {
		if (processor != null) {
			for (int i = 0; i < processor.length; i++) {
				removeInputListener(processor[i]);
			}
		}
	}

	public void addInputListener(InputProcessor proccessor) {
		if (mMultiplexer != null) {
			mMultiplexer.addProcessor(proccessor);
		} else {
			Gdx.input.setInputProcessor(proccessor);
		}
	}

	public void removeInputListener(InputProcessor processor) {
		if (mMultiplexer != null) {
			mMultiplexer.removeProcessor(processor);
		}
	}

	public static LemoncogGame getGame() {
		return game;
	}

	private Stack<BaseScreen> mScreenStack = new Stack<BaseScreen>();

	public synchronized void popScreen(BaseScreen popScreen) {
		if (mScreenStack.size() > 1) {
			mScreenStack.remove(popScreen);

		} else {
			// Should close
			Gdx.app.exit();
		}
	}

	public synchronized void popScreen() {
		if (mScreenStack.size() > 1) {
			mScreenStack.pop().dispose();
			setScreen(mScreenStack.lastElement());
		} else {
			// Should close
			Gdx.app.exit();
		}
	}

	public synchronized void pushScreen(BaseScreen screen) {
		mScreenStack.push(screen);
		setScreen(screen);
	}

	public synchronized BaseScreen getActiveMenu() {
		if (mScreenStack.size() > 0)
			return mScreenStack.lastElement();

		return null;
	}

	public LemoncogGame(GeneralInterface aGeneralCallback) {
		super();
		mGeneralCallback = aGeneralCallback;
	}

	@Override
	public void create() {
		game = this;

		VisualDebug.setDebug(true);
		// Use for remote control via Android device.
		// RemoteInput reciever = new RemoteInput();
		// Gdx.input = reciever;

		mMultiplexer = new InputMultiplexer();
		Gdx.input.setInputProcessor(mMultiplexer);

		Gdx.input.setCatchBackKey(true);

		Assets.load();

		mLoadingScreen = new LoadingScreen();
		// Change this to main menu when its been created.
		getGame().pushScreen(new SplashScreen());
	}

	@Override
	public void dispose() {
		// Ensure the boolean for First_Run is false.
		firstRunComplete();

		super.dispose();
	}

	private float[] mBackground = ColorFactory.getBackgroundColor();

	public void setBackground(float r, float g, float b, float a) {
		mBackground[0] = r;
		mBackground[1] = g;
		mBackground[2] = b;
		mBackground[3] = a;
	}

	@Override
	public void render() {
		if (Gdx.input.isTouched()) {
			// handleTouch();
		}

		// DJ.getInstance().updateSounds(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(mBackground[0], mBackground[1], mBackground[2],
				mBackground[3]);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		super.render();
	}

	@Override
	public void resize(int width, int height) {
		LemoncogGame.VIEW_WIDTH = width;
		LemoncogGame.VIEW_HEIGHT = height;

		Assets.resize(width, height);

		super.resize(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
		// Show our loading screen.
		LemoncogGame.getGame().pushScreen(mLoadingScreen);
	}

	public boolean needsBack() {
		if (mGeneralCallback != null)
			return mGeneralCallback.needsBack();

		return true;
	}

	public void firstRunComplete() {
		SettingsHolder.getSettings().storeBoolean(FIRST_RUN, false);
	}

	public boolean isFirstRun() {
		return SettingsHolder.getSettings().getBoolean(FIRST_RUN, true);
	}
}
