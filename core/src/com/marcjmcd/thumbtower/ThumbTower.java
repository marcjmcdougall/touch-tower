package com.marcjmcd.thumbtower;

import com.badlogic.gdx.Game;
import com.marcjmcd.thumbtower.views.screens.ThumbTowerMenu;

public class ThumbTower extends Game {
	
	public static final String TAG = "Touch Tower";
	
	public static final float VIEWPORT_WIDTH = 1080.0f;
	public static final float VIEWPORT_HEIGHT = 720.0f;
	
	@Override
	public void create() {
		
		this.setScreen(new ThumbTowerMenu(this));
	}

	@Override
	public void render() {
		
		super.render();
	}
}
