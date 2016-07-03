package com.neet.texture;

import static com.neet.main.Constant.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.neet.input.InputK;
import com.neet.input.InputProcesser;
import com.neet.main.Constant;

public class CarMan {


	Texture text ;
	private World  world;
	private Body body;
	private BodyDef  def;
	private float _vel = (float) (100*Math.random());

	float _y = 0 , _x ,i  ;
	float _dy = _x / 100;
	float _k  =  5 ;
	float _x_main = 0 , _y_main =  25 ;

	public CarMan( String  _path , int i , World  world ){
		Gdx.input.setInputProcessor(new InputProcesser());


			text = new Texture(Gdx.files.internal(_path));
			this.world = world;
			this.i = i ;
			_x =   100   +  i*138;
			if(i != Constant.FINAL_CAR){

				world.setGravity(new Vector2(0 , 0));
////////////////////////////////////////////
				def = new BodyDef();
				def.position.set(new Vector2(( _x  )/PPM  , (_y)/PPM ));
				def.type = BodyType.DynamicBody;
				FixtureDef fdef = new FixtureDef();
				PolygonShape shape = new PolygonShape();
				shape.setAsBox((float)30/PPM , (float)50/PPM);
				fdef.shape = shape;
				body = 	world.createBody(def);
				body.createFixture(fdef).setUserData(i);;
				body.setLinearVelocity(new Vector2(0 , (float) (100/PPM + _vel/PPM) ));
					}
	//////////////////////////// body for main car
			else{
				def = new BodyDef();
				def.position.set(new Vector2(( 100   +  getInt()*138  )/PPM  ,  600/PPM ));
				def.type = BodyType.DynamicBody;
				FixtureDef fdef = new FixtureDef();
				PolygonShape shape = new PolygonShape();
				shape.setAsBox((float)30/PPM , (float)50/PPM);
				fdef.shape = shape;
				body = 	world.createBody(def);
				body.createFixture(fdef).setUserData(i);;
				//body.setLinearVelocity(new Vector2(0 , (float) (100/PPM + _vel/PPM) ));


				}


	}
	public void update(float dt){
		if(body.getPosition().y*PPM  > Constant.V_HEIGHT ) {
				_vel = (float)(300*Math.random());
					//System.out.println("this is working");
					//def.position.set(new Vector2(  ));
				body.setTransform(new Vector2((_x)/PPM  , 0) , 0);


			}
		if(i == Constant.FINAL_CAR){
			body.setTransform(new Vector2( ( 100   +  getInt()*138  )/PPM ,  600/PPM ) , 0) ;
		}


		if(InputK.isPressed(Constant.A)){

			--x;

		}
		if(InputK.isPressed(Constant.D)){

			++x;
		}


	}
	public void render(SpriteBatch  sb  ){

			sb.draw(text ,body.getPosition().x*Constant.PPM - 25 , body.getPosition().y*PPM - 50);
	}


	public float get_y() {
		return _y;
	}
	public void set_y(int _y) {
		this._y = _y;
	}
	public float get_x() {
		return _x;
	}
	public Vector2 getPos(){
		return new Vector2(_x ,_y);
	}
	public void set_x(int _x) {
		this._x = _x;
	}
	public float  getValue(){
		return 0 ;
	}
	int x = 4 ;
	public int getInt(){
		if(x == 0) x = 5;
		if(x== 5 )  x = 0;



		return  x ;
	}
}
