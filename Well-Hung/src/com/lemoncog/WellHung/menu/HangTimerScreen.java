package com.lemoncog.WellHung.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.lemoncog.engine.factory.UIFactory;
import com.lemoncog.engine.menu.BaseScreen;

public class HangTimerScreen extends BaseScreen {
	
	public HangTimerScreen() 
	{
		super();
		
		Table holder = new Table();
		holder.setFillParent(true);
		holder.debug();
		addActor(holder);
		
		
		Button addButton = UIFactory.buildDefaultTextButton("Add");
		//addButton.setWidth(getWidth());
		holder.add(addButton).fillX().expandX();
	}
	
	@Override
	public void draw() {
		Table.drawDebug(this);
		
		super.draw();
	}

}
