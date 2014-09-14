package com.marcjmcd.thumbtower.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.marcjmcd.thumbtower.ThumbTower;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width = 1080;
		config.height = 720;
//		config.fullscreen = true;
		
		new LwjglApplication(new ThumbTower(), config);
	}
}
