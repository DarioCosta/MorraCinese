package org.dario.morracinese;

import java.util.Random;

public class MorraCineseGame {
	private int rounds;
	private MorraCineseStrategy strategy;
	private int currentRound=0;
	private int score=0;
	private Random randomno = new Random();

	public MorraCineseGame(int rounds, MorraCineseStrategy strategy) {
		if (rounds > 0) {
			this.rounds = rounds;
		} else {
			this.rounds = 5;
		}
		if (strategy != null) {
			this.strategy = strategy;
		} else {
			this.strategy = new RPSStrategy();
		}
	}

	public MorraCineseGame(int rounds) {
		this(rounds, new RPSStrategy());
	}

	public MorraCineseGame() {
		this(5);
	}
	
	public boolean isGameOver(){
		return currentRound>=rounds;
	}
	
	public Element getNextRandomElement(){
		int resultInt=randomno.nextInt(strategy.getElements().length);
		return strategy.getElements()[resultInt];
	}
	
	public int fight(Element x, Element y) throws IllegalElementException{
		return strategy.fight(x, y);
	}
	
	public int play(Element x) throws GameOverException, IllegalElementException{
		if(!isGameOver()){
			Element y=getNextRandomElement();
			// morraCineseView.showFight(x, y);
			int result=fight(x, y);
			if(result!=0){
				currentRound++;
				if(result<0){
					score++;
				}
			}
			// morraCineseView.showWinner(result); ???
			return result;
		}else{
			throw new GameOverException();
		}
	}
	
	public int getScore(){
		return score;
	}
	
	public void reset(){
		score=0;
		currentRound=0;
	}
}
