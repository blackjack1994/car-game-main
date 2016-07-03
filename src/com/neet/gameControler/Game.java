package com.neet.gameControler;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.neet.input.InputK;
import com.neet.main.Constant;

public class Game implements  ApplicationListener , Disposable{
	public static final String TITLE = "CAR_GAME";
	 private OrthographicCamera  mainCam ;
	 private OrthographicCamera hudCam ;
	 private SpriteBatch sb ;
	 private GameStateManegar gsm ;
	 
	 
	 private boolean check = false;
	 private static float STEP = 1/60f;
	 private float accum ;
	
	

	@Override
	public void create() {
		
	Texture.setEnforcePotImages(false);
	sb =  new SpriteBatch();
	mainCam = new OrthographicCamera(Constant.V_WIDTH ,  Constant.V_HEIGHT);
	gsm = new GameStateManegar(this);
	}

	@Override
	public void dispose() {
		
		sb.dispose();
	}

	@Override
	public void pause() {
		check =  true;
	}

	@Override
	public void render() {
		accum += Gdx.graphics.getDeltaTime();
		while(accum >=STEP ){
		gsm.update(STEP);	
		gsm.render();	
		accum -= STEP ;
		InputK.update();
		}
		
	}

	@Override
	public void resize(int arg0, int arg1) {
	
		
	}
	@Override
	public void resume() {
		
		check = false;
	}
	
	 public OrthographicCamera getMainCam() {
			return mainCam;
		}

		public void setMainCam(OrthographicCamera mainCam) {
			this.mainCam = mainCam;
		}

		public OrthographicCamera getHudCam() {
			return hudCam;
		}

		public void setHudCam(OrthographicCamera hudCam) {
			this.hudCam = hudCam;
		}

		public SpriteBatch getSb() {
			return sb;
		}

		public void setSb(SpriteBatch sb) {
			this.sb = sb;
		}
				
	
	
	
}