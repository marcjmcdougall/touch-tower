package com.marcjmcd.thumbtower.models;

import java.util.Iterator;
import java.util.Random;

import com.badlogic.gdx.utils.Array;
import com.marcjmcd.thumbtower.models.tiles.BasicTile;
import com.marcjmcd.thumbtower.models.tiles.DangerTile;
import com.marcjmcd.thumbtower.models.tiles.SafeTile;

public class GameMap {

	public static final int MAX_VISIBLE_ROWS = 10;
	public static final int MAX_VISIBLE_COLS = 15;
	
	private Array<Array<BasicTile>> tiles;
	private Random rand = new Random();
	
	private int startIndex;
	
	public GameMap(){
		
		this.startIndex = 0;
		
		initializePrimaryTiles();
	}
	
	/**
	 * Removes the 5 oldest tile columns.  This should only be called when the game controller knows
	 * that the tiles will no longer be on screen.
	 * 
	 * This method is here to help with memory management.
	 */
	public void popOldestTileGroups(){
		
		// Removes the 5 oldest tile columns.
		tiles.removeRange(startIndex, startIndex + 4);
		
		// Updates the start index to point to the new starting point of the Array. 
		startIndex += 5;
	}
	
	public void pushNewTileGroups(int numberOfGroups){
		
		for(int i = 0; i < numberOfGroups; i++){
			
			tiles.add(generateColumn(MAX_VISIBLE_COLS + i));
		}
	}

	private void initializePrimaryTiles() {
		
		this.tiles = new Array<Array<BasicTile>>();
		
		for(int i = 0; i < MAX_VISIBLE_COLS; i++){
			
			tiles.add(generateColumn(i));
		}
	}
	
	private Array<BasicTile> generateColumn(int columnReference){

		Array<BasicTile> newColumn = new Array<BasicTile>(MAX_VISIBLE_ROWS);
		
		for(int i = 0; i < MAX_VISIBLE_ROWS; i++){
			
			newColumn.add(generateTile(columnReference, i));
		}
		
		return newColumn;
	}
	
	private BasicTile generateTile(int column, int row){
		
		if(rand.nextInt(2) == 0){
			
			return new SafeTile(column * BasicTile.TILE_DIMENSION, row * BasicTile.TILE_DIMENSION);
		}
		else{
			
			return new DangerTile(column * BasicTile.TILE_DIMENSION, row * BasicTile.TILE_DIMENSION);
		}
	}
	
	public Array<Array<BasicTile>> getPrimaryTiles() {
		
		return tiles;
	}

	public Iterator<Array<BasicTile>> getTileColumnIterator() {
		
		return tiles.iterator();
	}

	public Iterator<BasicTile> getTileIterator(int index) {
		
		return tiles.get(index).iterator();
	}
}
