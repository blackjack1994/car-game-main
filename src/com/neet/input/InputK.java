package com.neet.input;

public class InputK {
	public static  boolean key[] ;
	public static  boolean pkey[] ;
	
	private static final int _k = 4;
	static {
		key = new boolean[_k];
		pkey =  new boolean[_k];
	}
	public static void  update(){
		for(int i =0 ;i < _k ;i++){
			pkey[i] = key[i];
		}
	}
	
	public static boolean isDown(int i ){

		return key[i];
		
	}
	public static boolean isPressed(int i){
		
		return key[i] && !pkey[i];
	}
	public static void  setKey(int i , boolean b){
		key[i] =  b ;
	}

}
