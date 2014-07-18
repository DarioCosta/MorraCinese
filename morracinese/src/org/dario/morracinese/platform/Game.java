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
			try {
				strategy.play();
			} catch (IllegalPlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
