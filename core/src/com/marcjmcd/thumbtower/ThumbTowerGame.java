package com.marcjmcd.thumbtower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class ThumbTowerGame implements Screen {

	private ThumbTower game;
	
	private Stage gameStage;
	
	public ThumbTowerGame(ThumbTower game) {
		
		this.game = game;
		
		FitViewport viewPort = new FitViewport(ThumbTower.SCREEN_WIDTH, ThumbTower.SCREEN_HEIGHT);
		
		gameStage = new Stage(viewPort);
	}
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStage.act(delta);
		gameStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
		gameStage.getViewport().update(width, height, true);
	}

	@Override
	public void show() {

		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {

		// TODO Auto-generated method stub
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
