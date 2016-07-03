package com.neet.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class InputProcesser implements InputProcessor {

	@Override
	public boolean keyDown(int k) {
		if(Keys.A == k){
			InputK.setKey( 0  , true);
	
		}
		if(Keys.D == k){
			InputK.setKey( 1 , true);
		}
		if(Keys.W == k){
			InputK.setKey( 2  , true);
		}
		if(Keys.S == k){
			InputK.setKey( 3  , true);
		}

		return true;
	}

	@Override
	public boolean keyTyped(char arg0) {

		return false;
	}

	@Override
	public boolean keyUp(int k) {
		if(Keys.A == k){
			InputK.setKey(0, false);
		}
		if(Keys.D == k){
			InputK.setKey(1, false);
		}
		if(Keys.W == k){
			InputK.setKey( 2 , false);
		}
		if(Keys.S == k){
			InputK.setKey( 3  , false);
		}
		
		return true;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
	
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
	
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
	
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {

		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		
		return false;
	}

}
