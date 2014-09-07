package com.marcjmcd.thumbtower;

import com.badlogic.gdx.Game;

public class ThumbTower extends Game {
	
	public static final String TAG = "Touch Tower";
	
	public static final float SCREEN_WIDTH = 1080.0f;
	public static final float SCREEN_HEIGHT = 720.0f;
	
	@Override
	public void create() {
		
		this.setScreen(new ThumbTowerMenu(this));
	}

	@Override
	public void render() {
		
		super.render();
	}
}
