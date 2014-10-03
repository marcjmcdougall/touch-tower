package com.marcjmcd.thumbtower.models;

import java.util.Iterator;
import java.util.Random;

import com.badlogic.gdx.utils.Array;
import com.marcjmcd.thumbtower.models.tiles.BasicTile;
import com.marcjmcd.thumbtower.models.tiles.DangerTile;
import com.marcjmcd.thumbtower.models.tiles.SafeTile;

public class GameMap{

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
	
	public Array<Array<BasicTile>> pushNewTileGroups(int numberOfGroups){
		
		Array<Array<BasicTile>> newTiles = new Array<Array<BasicTile>>(); 
		
		for(int i = 0; i < numberOfGroups; i++){
			
			newTiles.add(generateColumn());
			tiles.add(newTiles.get(i));
		}
		
		return newTiles;
	}

	private void initializePrimaryTiles() {
		
		this.tiles = new Array<Array<BasicTile>>();
		
		Array<BasicTile> firstColumn = new Array<BasicTile>();
		
		for(int i = 0; i < MAX_VISIBLE_ROWS; i++){
			
			firstColumn.add(new SafeTile(0, i * BasicTile.TILE_DIMENSION));
		}
		
		tiles.add(firstColumn);
		
		for(int i = 0; i < MAX_VISIBLE_COLS - 1; i++){
			
			tiles.add(generateColumn());
		}
	}
	
	private Array<BasicTile> generateColumn(){

		Array<BasicTile> newColumn = new Array<BasicTile>(MAX_VISIBLE_ROWS);
		
		for(int i = 0; i < MAX_VISIBLE_ROWS; i++){
			
			newColumn.add(generateNewTile(i));
		}
		
		return newColumn;
	}
	
	private BasicTile generateNewTile(int row){
		
		Array<BasicTile> lastColumn = tiles.peek();
		BasicTile lastTile = lastColumn.get(row);
		
		if(rand.nextInt(2) == 0){
			
			return new SafeTile(lastTile.getX() + BasicTile.TILE_DIMENSION, lastTile.getY());
		}
		else{
			
			return new DangerTile(lastTile.getX() + BasicTile.TILE_DIMENSION, lastTile.getY());
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
