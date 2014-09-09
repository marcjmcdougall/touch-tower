package com.marcjmcd.thumbtower.models;

import com.badlogic.gdx.utils.Array;
import com.marcjmcd.thumbtower.models.tiles.BasicTile;

public class GameMap {

	private Array<Array<BasicTile>> primaryTiles;
	private Array<BasicTile> tileColumnBuffer;
	
	public GameMap(){
		
		this.primaryTiles = new Array<Array<BasicTile>>();
		this.tileColumnBuffer = new Array<BasicTile>();
		
		populatePrimaryTiles();
		populateSecondaryTiles();
	}

	private void populateSecondaryTiles() {
		
		// TODO: Implementation.
	}

	private void populatePrimaryTiles() {
		
		// TODO: Implementation.
	}
	
	private void generateColumn(){
		
		// TODO: Implementation.
	}
	
	public void shiftTiles(){
		
		// TODO: Implementation.
	}

	public Array<Array<BasicTile>> getPrimaryTiles() {
		
		return primaryTiles;
	}

	public Array<BasicTile> getColumnBuffer() {
		
		return tileColumnBuffer;
	}
}
