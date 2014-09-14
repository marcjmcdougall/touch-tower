package com.marcjmcd.thumbtower.views.screens;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.marcjmcd.thumbtower.ThumbTower;
import com.marcjmcd.thumbtower.models.GameMap;
import com.marcjmcd.thumbtower.models.tiles.BasicTile;

public class ThumbTowerGame implements Screen {

	private Stage gameStage;
	
	private GameMap map;
	
	public ThumbTowerGame(ThumbTower game) {
		
		FitViewport viewPort = new FitViewport(ThumbTower.VIEWPORT_WIDTH, ThumbTower.VIEWPORT_HEIGHT);
		
		gameStage = new Stage(viewPort);
		map = new GameMap();
		
		initializeGameMapActors();
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStage.act(delta);
		
		gameStage.getCamera().translate(5, 0, 0);
		
		gameStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
		gameStage.getViewport().update(width, height, true);
	}

	@Override
	public void show() {

		Gdx.input.setInputProcessor(gameStage);
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
	
	private void initializeGameMapActors() {
		
		Iterator<Array<BasicTile>> columnIterator = map.getTileColumnIterator();
		Iterator<BasicTile> tileIterator = null;
		
		while(columnIterator.hasNext()){
			
			tileIterator = columnIterator.next().iterator();
			
			while(tileIterator.hasNext()){
				
				gameStage.addActor(tileIterator.next());
			}
		}
	}
}
