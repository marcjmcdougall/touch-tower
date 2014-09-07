package com.marcjmcd.thumbtower.listeners;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.marcjmcd.thumbtower.ThumbTower;

public class ScreenSwitchListener extends InputListener {

	private ThumbTower game;
	
	private Screen toScreen;
	
	public ScreenSwitchListener(ThumbTower game, Screen toScreen) {
	
		this.game = game;
		this.toScreen = toScreen;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		
		return true;
	}
	
	@Override
	public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
		
		super.touchUp(event, x, y, pointer, button);
		
		game.setScreen(toScreen);
		
		Gdx.app.log(ThumbTower.TAG, "Switching screens now!");
	}
}
