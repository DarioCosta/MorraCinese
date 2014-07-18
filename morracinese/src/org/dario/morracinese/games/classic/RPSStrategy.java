package org.dario.morracinese.games.classic;

import java.util.ArrayList;
import java.util.List;

import org.dario.morracinese.platform.Element;
import org.dario.morracinese.platform.GameStrategy;
import org.dario.morracinese.platform.IllegalElementException;
import org.dario.morracinese.platform.IllegalPlayerException;
import org.dario.morracinese.platform.Player;

public class RPSStrategy implements GameStrategy {

	private List<Element> elements = new ArrayList<Element>();
	private int rounds;
	private Player p1, p2;

	public RPSStrategy(int rounds) {
		elements.add(Element.CARTA);
		elements.add(Element.FORBICI);
		elements.add(Element.PIETRA);
		this.rounds = rounds;
	}

	public RPSStrategy() {
		this(5);
	}

	public void setup(Player p1, Player p2) throws IllegalPlayerException {
		if ((p1 == null) || (p2 == null)) {
			throw new IllegalPlayerException();
		}
		this.p1 = p1;
		this.p2 = p2;
		try {
			this.p1.setElements(elements);
			this.p2.setElements(elements);
		} catch (IllegalElementException e) {
			e.printStackTrace();
		}
	}

	public boolean isGameOver() {
		return ((p1.getScore() == rounds) || (p2.getScore() == rounds));
	}

	@Override
	public void play(Element x, Element y) throws IllegalElementException {
		if ((x == null) || (y == null)) {
			throw new IllegalElementException();
		}

		int posX = elements.indexOf(x);
		int posY = elements.indexOf(y);
		if ((posX < 0) || (posY < 0)) {
			throw new IllegalElementException();
		}
		if (posY == (posX + 1) % elements.size()) {
			p2.incrScore(1);
		} else {
			p1.incrScore(1);
		}

	}

}
