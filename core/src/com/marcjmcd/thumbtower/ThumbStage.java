package com.marcjmcd.thumbtower;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.marcjmcd.thumbtower.listeners.GameMapEventListener;
import com.marcjmcd.thumbtower.models.tiles.BasicTile;


public class ThumbStage extends Stage{

	// Velocity of the board in units per second.  The width of the ViewPort is 1080,
	// therefore a velocity of 1080 would clear the screen in one second.
//	private static final float DEFAULT_VELOCITY = 108.0f;
	private static final float DEFAULT_VELOCITY = 360.0f;
	
	private float velocityX;
	private float effectiveDelta;
	
	private GameMapEventListener eventListener;
	
	public ThumbStage(GameMapEventListener eventListener){
		
		init(eventListener);
	}

	public ThumbStage(Viewport port, GameMapEventListener eventListener){
		
		super(port);
		init(eventListener);
	}
	
	@Override
	public void act(float delta) {
		
		this.getCamera().translate(delta * getVelocityX(), 0, 0);
		
		this.effectiveDelta += delta * getVelocityX();
		
		if(effectiveDelta >= BasicTile.TILE_DIMENSION){
			
			notifyTileOffScreen();
			
			effectiveDelta = 0.0f;
		}
		
		super.act(delta);
	}

	public float getVelocityX() {
		
		return velocityX;
	}

	public void setVelocityX(float velocityX) {
		
		this.velocityX = velocityX;
	}
	
	private void init(GameMapEventListener eventListener) {
		
		this.eventListener = eventListener;
		
		this.setVelocityX(DEFAULT_VELOCITY);
		this.effectiveDelta = 0.0f;
	}
	
	private void notifyTileOffScreen(){
		
		eventListener.onColumnShift();
	}
}
