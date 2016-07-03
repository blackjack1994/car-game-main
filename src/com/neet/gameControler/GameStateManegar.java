package com.neet.gameControler;

import java.util.Stack;


import com.neet.state.level1;



public class GameStateManegar {
	    private Stack<GameState> level;
		private static final int GUE = 1;
		private static final int LEV = 2;
		
		public GameStateManegar(com.neet.gameControler.Game  game){
				this.game = game;
				level =  new Stack<>();
				pushStak(0);
				
		}
		
		public void update(float deltaTime){
		level.peek().update(deltaTime);
		
		}
		public void render(){
		level.peek().render();
		}
		
		public com.neet.gameControler.Game getGame() {
		return game;
		}
		public void setGame(com.neet.gameControler.Game game) {
		this.game = game;
		}
		private void pushStak(int k){
			popStack();
			if(k == 1){
				level.push(new level1(this));
				}
			if(k== 0){
				level.push(new level1(this));
			}
		}
		public void setState(int k){
		  pushStak(k);
		}
		private void popStack(){
			
			if(!level.isEmpty()){
				level.pop();
			}
		}
		private com.neet.gameControler.Game game ;
	
}
