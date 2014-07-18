package org.dario.morracinese.platform;

import org.dario.morracinese.games.classic.RPSStrategy;

public class Game {
	private GameStrategy strategy;

	public Game(GameStrategy strategy) {
		if (strategy != null) {
			this.strategy = strategy;
		} else {
			this.strategy = new RPSStrategy();
		}
	}

	public Game() {
		this(null);
	}

	public void play(Player p1, Player p2) throws IllegalPlayerException {
		strategy.setup(p1, p2);
		while (!strategy.isGameOver()) {
			Element x = p1.getNextElement();
			Element y = p2.getNextElement();
			p1.notifyOpponentElement(y);
			p2.notifyOpponentElement(x);
			try {
				strategy.play(x, y);
			} catch (IllegalElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
