package com.neet.texture;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;

public class MyContactListener implements ContactListener {

	@Override
	public void beginContact(Contact c1) {
		Fixture  f1  =  c1.getFixtureA();
		Fixture  f2  =  c1.getFixtureB();
		
		
		
		
		
		
		
	}

	@Override
	public void endContact(Contact c2) {
		
		
	}

	@Override
	public void postSolve(Contact arg0, ContactImpulse arg1) {
		
		
	}

	@Override
	public void preSolve(Contact arg0, Manifold arg1) {
		
		
	}

}
