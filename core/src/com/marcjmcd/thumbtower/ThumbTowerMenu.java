package com.marcjmcd.thumbtower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.marcjmcd.thumbtower.listeners.ScreenSwitchListener;
import com.marcjmcd.thumbtower.models.BasicButton;

public class ThumbTowerMenu implements Screen {

	private ThumbTower game;
	
	private Stage menu;
	
	private BasicButton newGame;
	
	public ThumbTowerMenu(ThumbTower game){
		
		this.game = game;
		
		FitViewport viewPort = new FitViewport(ThumbTower.SCREEN_WIDTH, ThumbTower.SCREEN_HEIGHT);
		
		menu = new Stage(viewPort);
		newGame = new BasicButton(new Texture("button-new-game.png"), new Texture("button-new-game.png"), ThumbTower.SCREEN_WIDTH / 2.0f, ThumbTower.SCREEN_HEIGHT / 2.0f);
		
		newGame.addListener(new ScreenSwitchListener(game, new ThumbTowerGame(game)));
		
		menu.addActor(newGame);
		
		Gdx.input.setInputProcessor(menu);
	}
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		menu.act(Gdx.graphics.getDeltaTime());
		menu.draw();
	}

	@Override
	public void resize(int width, int height) {
		
		menu.getViewport().update(width, height, true);
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
		
		menu.dispose();
	}
}
