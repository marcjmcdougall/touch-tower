package com.marcjmcd.thumbtower.views.screens;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.marcjmcd.thumbtower.ThumbStage;
import com.marcjmcd.thumbtower.ThumbTower;
import com.marcjmcd.thumbtower.listeners.GameMapEventListener;
import com.marcjmcd.thumbtower.models.GameMap;
import com.marcjmcd.thumbtower.models.tiles.BasicTile;

public class ThumbTowerGame implements Screen, GameMapEventListener{

	private ThumbStage gameStage;
	
	private GameMap map;
	
	public ThumbTowerGame(ThumbTower game) {
		
		FitViewport viewPort = new FitViewport(ThumbTower.VIEWPORT_WIDTH, ThumbTower.VIEWPORT_HEIGHT);
		
		gameStage = new ThumbStage(viewPort, this);
		map = new GameMap();
		
		initializeGameMapActors();
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStage.act(delta);
		
		addTileColumns(1);
		
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
		
		gameStage.dispose();
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
	
	public void addTileColumns(int columnCount){
		
		map.pushNewTileGroups(columnCount);
		
		initializeGameMapActors();
	}
	
	@Override
	public void onColumnShift() {
		
		System.out.println("**Shifting Columns Now**");
		
		Array<BasicTile> removedActors =  map.getPrimaryTiles().removeIndex(0);
		
		Iterator<BasicTile> removedActorIterator = removedActors.iterator();
		
		while(removedActorIterator.hasNext()){
			
			removedActorIterator.next().remove();
		}
		
		addTileColumns(1);
	}
}