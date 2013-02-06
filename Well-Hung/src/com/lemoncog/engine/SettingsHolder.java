package com.lemoncog.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class SettingsHolder
{
	private static final String SETTINGS_USE_ACCELOMETER = "SETTINGS_USE_ACCELOMETER";
	private static final String SETTINGS_CAN_VIBRATE = "SETTINGS_CAN_VIBRATE";

	private static final String PREF_GENERAL = "GENERAL";

	private boolean useAccelometer;

	private static SettingsHolder settings;

	public static SettingsHolder getSettings()
	{
		if (settings == null)
			settings = new SettingsHolder();

		return settings;
	}

	public SettingsHolder()
	{
		super();
		// Load settings
		useAccelometer = getBoolean(SETTINGS_USE_ACCELOMETER, false);
	}

	public void save()
	{
		storeBoolean(SETTINGS_USE_ACCELOMETER, useAccelometer);
	}

	public boolean getBoolean(String key, boolean defValue)
	{
		return Gdx.app.getPreferences(PREF_GENERAL).getBoolean(key, defValue);
	}

	public void storeBoolean(String key, boolean value)
	{
		Preferences prefs = Gdx.app.getPreferences(PREF_GENERAL);
		prefs.putBoolean(key, value);
		prefs.flush();
	}

	public boolean useAccelometer()
	{
		return useAccelometer;
	}

	public void setUseAccelometer(boolean use)
	{
		useAccelometer = use;

	}

	public boolean canVibrate()
	{
		return getBoolean(SETTINGS_CAN_VIBRATE, true);
	}
}
