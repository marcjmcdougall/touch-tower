package com.marcjmcd.thumbtower.models.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.marcjmcd.thumbtower.ThumbTower;

public abstract class BasicTile extends Actor{

	public static final float TILE_DIMENSION = 72.0f;
	
	protected Texture texture;
	
	public BasicTile(Texture texture, float x, float y){
		
		this.setWidth(TILE_DIMENSION);
		this.setHeight(TILE_DIMENSION);
		
		this.setX(x);
		this.setY(y);
		
		this.setTexture(texture);
		
		this.addListener(new InputListener() {
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				Gdx.app.log(ThumbTower.TAG, this.getClass() + " was touched (down).");
				
				return super.touchDown(event, x, y, pointer, button);
			}
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				Gdx.app.log(ThumbTower.TAG, this.getClass() + " was touched (up).");
				
				super.touchUp(event, x, y, pointer, button);
			}
		});
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		super.draw(batch, parentAlpha);
		
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
	}

	public Texture getTexture() {
		
		return texture;
	}

	public void setTexture(Texture texture) {
		
		this.texture = texture;
	}
}
