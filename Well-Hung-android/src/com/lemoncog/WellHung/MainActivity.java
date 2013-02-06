package com.lemoncog.WellHung;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.lemoncog.engine.crossPlatform.GeneralInterface;

public class MainActivity extends AndroidApplication implements GeneralInterface {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
        
        initialize(new LemoncogGame(this), cfg);
    }

	@Override
	public void contactMeClicked(String to, String subject, String message) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getDeviceInformation() 
	{
		return null;
	}

	@Override
	public boolean needsBack() {
		return false;
	}
}