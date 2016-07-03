package com.neet.gameControler;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public abstract  class GameState implements Disposable {
protected OrthographicCamera cam;

protected OrthographicCamera hudCam;
protected SpriteBatch sb ;
protected GameStateManegar gsm;
protected com.neet.gameControler.Game game;
	public GameState(GameStateManegar gsm) {
	this.gsm = gsm;
	game = gsm.getGame();
	cam = game.getMainCam();
	hudCam = game.getHudCam();
	sb = game.getSb();
	}

	@Override
	public abstract void dispose() ;
	public  abstract void init();
	public   abstract  void update(float deltaTime);
	public   abstract void render();
	public  abstract void getStage();
	public  abstract void setStage();

}
