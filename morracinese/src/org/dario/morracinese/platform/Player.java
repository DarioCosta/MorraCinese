package org.dario.morracinese.platform;

import java.util.Collection;

public class Player {
	private int score;
	private PlayerStrategy strategy;
	
	public Player(PlayerStrategy strategy){
		if(strategy==null){
			strategy=new RandomPlayerStrategy();
		}
		this.strategy=strategy;
	}
	
	public void setElements(Collection<Element> elements) throws IllegalElementException{
		strategy.setElements(elements);
	}
	public Collection<Element> getElements(){
		return strategy.getElements();
	}
	
	public void incrScore(int incr){
		score+=incr;
	}
	public int getScore(){
		return score;
	}
	
	public Element getNextElement(){
		return strategy.getNextElement();
	}
	
	public void notifyOpponentElement(Element element){
		strategy.notifyOpponentElement(element);
	}
	
	public void notifyOpponentScore(int score){
		strategy.notifyOpponentScore(score);
	}
	
	public void showScore(int score){
		strategy.showScore(score);
	}
	
	public void notifyGameOver(){
		strategy.notifyGameOver();
	}
}
