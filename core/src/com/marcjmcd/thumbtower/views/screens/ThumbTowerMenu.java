package com.marcjmcd.thumbtower.views.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.marcjmcd.thumbtower.ThumbTower;
import com.marcjmcd.thumbtower.listeners.ScreenSwitchListener;
import com.marcjmcd.thumbtower.models.tiles.BasicButton;

public class ThumbTowerMenu implements Screen {

	private Stage menuStage;
	
	private BasicButton newGame;
	
	public ThumbTowerMenu(ThumbTower game){
		
		FitViewport viewPort = new FitViewport(ThumbTower.VIEWPORT_WIDTH, ThumbTower.VIEWPORT_HEIGHT);
		
		menuStage = new Stage(viewPort);
		newGame = new BasicButton(new Texture("button-new-game.png"), new Texture("button-new-game.png"), ThumbTower.VIEWPORT_WIDTH / 2.0f, ThumbTower.VIEWPORT_HEIGHT / 2.0f);
		
		newGame.addListener(new ScreenSwitchListener(game, new ThumbTowerGame(game)));
		
		menuStage.addActor(newGame);
		
		Gdx.input.setInputProcessor(menuStage);
	}
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		menuStage.act();
		menuStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
		menuStage.getViewport().update(width, height, true);
	}

	@Override
	public void show() {
		
		// TODO: Implementation.
	}

	@Override
	public void hide() {
		
		// TODO: Implementation.
	}

	@Override
	public void pause() {
		
		// TODO: Implementation.
	}

	@Override
	public void resume() {
		
		// TODO: Implementation.
	}

	@Override
	public void dispose() {
		
		menuStage.dispose();
	}
}
