package com.neet.state;

import static com.neet.main.Constant.PPM;

import java.util.logging.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.Disposable;
import com.neet.gameControler.GameState;
import com.neet.gameControler.GameStateManegar;
import com.neet.main.Constant;
import com.neet.texture.CarMan;

public class level1  extends GameState implements Disposable   {
	private Texture tx , car1  ;
	private float con =  Constant.V_HEIGHT/100;
	private float x1 , y1;
	//////////////////////////

	private World world ;
	private Body body  ;
	private Box2DDebugRenderer b2dr;
	private OrthographicCamera b2dCam ;
	private OrthographicCamera Cam ;
	
//////////////// for rendering car
	private CarMan[] _carMan ;
	private CarMan  mainCar;
	
	
	
	public level1(GameStateManegar gsm) {
		super(gsm);
		
		tx = new Texture(Gdx.files.internal("GameAssets/Road19.png"));
		car1 = new Texture(Gdx.files.internal("GameAssets/BlueCar.png"));
		////////////////////////
		
		
		world = new World( new Vector2(0 , 0) , true);	
		b2dCam = new OrthographicCamera();
		Cam = new OrthographicCamera();
		b2dCam.setToOrtho(true  , 6.9f  , 6.9f);
		Cam.setToOrtho(true ,  Constant.V_WIDTH , Constant.V_HEIGHT);
		///////////////////
		_carMan = new CarMan[5];
		_carMan[0] = new CarMan("GameAssets/RedCar.png", 1 , world);
		_carMan[1] = new CarMan("GameAssets/RedCar.png", 2 , world);
		_carMan[2] = new CarMan("GameAssets/RedCar.png", 3 , world);
		_carMan[3] = new CarMan("GameAssets/RedCar.png", 4 , world);
		_carMan[4] = new CarMan("GameAssets/RedCar.png", 0 , world);
		mainCar = new  CarMan("GameAssets/Car4.png", Constant.FINAL_CAR, world);
		
		b2dr = new Box2DDebugRenderer();
	
	
		

		
	}

	@Override
	public void dispose() {
	
		
	}

	@Override
	public void init() {

		
	}

	@Override
	public void update(float deltaTime) {
		world.step(deltaTime, 6, 2);
		for(int i =0 ;i < 5 ; i++){
		_carMan[i].update(deltaTime);
		}
		mainCar.update(deltaTime);
	
	}

	@Override
	public void render() {
		sb.begin();
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		sb.setProjectionMatrix(b2dCam.combined);
		
		b2dr.render(world , b2dCam.combined );
		
		sb.setProjectionMatrix(Cam.combined);
		
		
		
		sb.draw(tx , 0 , 0);
		for(int i =0 ;i <5 ; i++){
			_carMan[i].render(sb);
		}
		mainCar.render(sb);
		sb.end();
	}

	@Override
	public void getStage() {

		
	}

	@Override
	public void setStage() {
	
		
	}
	

}
