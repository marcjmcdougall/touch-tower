package com.marcjmcd.thumbtower.models;

import java.util.Iterator;

import sun.rmi.runtime.NewThreadAction;

import com.badlogic.gdx.utils.Array;
import com.marcjmcd.thumbtower.models.tiles.BasicTile;

public class GameMap {

	public static final int MAX_ROWS = 10;
	public static final int MAX_COLS = 15;
	
	private Array<Array<BasicTile>> primaryTiles;
	private Array<BasicTile> tileColumnBuffer;
	
	// Iterator that moves through the rows of Arrays of basic tiles.  Moves vertically.
	private Iterator<Array<BasicTile>> tileRowIterator;	
	
	// Iterator that will iterate through each row of basic tiles.  Moves horizontally.
	private Iterator<BasicTile> tileColumnIterator;
	
	// Iterator that will iterate through the buffer overflow array.  Moves vertically.
	private Iterator<BasicTile> tileColumnBufferIterator;
	
	public GameMap(){
		
		this.tileColumnBuffer = new Array<BasicTile>();
		
		initializePrimaryTiles();
		initializeBufferTiles();
		
		this.tileColumnBufferIterator = tileColumnBuffer.iterator();
	}

	private void initializePrimaryTiles() {
		
		this.primaryTiles = new Array<Array<BasicTile>>(MAX_ROWS);
		
		for(int i = 0; i < MAX_ROWS; i++){
			
			Array<BasicTile> newTiles = new Array<BasicTile>(MAX_COLS);
			
			for(int j = 0; j < MAX_COLS; j++){
				
				newTiles.add(new BasicTile());
			}
			
			primaryTiles.add(newTiles);
		}
		
		// Once the data structure is completely initialized, extract the iterator.
		this.tileRowIterator = primaryTiles.iterator();
		
		// Initialized to null now - it will be reinitialized with each new row extracted from the main array.
		this.tileColumnIterator = null;
	}
	
	private void initializeBufferTiles() {
		
		this.tileColumnBuffer = new Array<BasicTile>(MAX_ROWS);
		
		generateColumn();
	}

	private void generateColumn(){

		for(int i = 0; i < MAX_ROWS; i++){
			
			tileColumnBuffer.add(new BasicTile());
		}
		
		// Once the data structure is completely initialized, extract the iterator.
		this.tileColumnBufferIterator = tileColumnBuffer.iterator();
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
