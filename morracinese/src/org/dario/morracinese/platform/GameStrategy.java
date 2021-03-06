package org.dario.morracinese.platform;

public interface GameStrategy {
	public void setup(Player p1, Player p2) throws IllegalPlayerException;
	public void play() throws IllegalPlayerException;
	public boolean isGameOver();
	public int fight(Element x, Element y) throws IllegalElementException;
}
