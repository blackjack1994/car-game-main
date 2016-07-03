package com.neet.main;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.neet.gameControler.Game;


public class ApplicationConfig {
	
public static void main(String arg[]){

	LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
	cfg.title = Game.TITLE;
	cfg.width = (int)Constant.V_HEIGHT;
	cfg.height = (int)Constant.V_WIDTH;
	cfg.resizable = false;
	new LwjglApplication( new Game() , cfg ); 
	

	}
}
