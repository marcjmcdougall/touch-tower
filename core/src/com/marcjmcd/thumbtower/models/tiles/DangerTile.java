package com.marcjmcd.thumbtower.models.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.marcjmcd.thumbtower.ThumbTower;

public class DangerTile extends BasicTile {

	public DangerTile(){
		
		super(new Texture("blue_tile.png"));
		
		this.addListener(new InputListener() {
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				Gdx.app.log(ThumbTower.TAG, this.getClass() + " is a DANGER tile.");
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
}
