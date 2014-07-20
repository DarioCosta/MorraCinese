package org.dario.morracinese.players.auto;

import java.util.Collection;
import java.util.Random;

import org.dario.morracinese.platform.Element;
import org.dario.morracinese.platform.GameStrategy;
import org.dario.morracinese.platform.IllegalElementException;
import org.dario.morracinese.platform.PlayerStrategy;

public class AIPlayerStrategy implements PlayerStrategy {
	private Random randomno = new Random();
	private Collection<Element> elements;
	private GameStrategy gameStrategy;
	private int[] history;
	private int loggedFights;

	public AIPlayerStrategy(GameStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
	}

	@Override
	public void setElements(Collection<Element> elements)
			throws IllegalElementException {
		if (elements == null) {
			throw new IllegalElementException();
		} else {
			this.elements = elements;
			history = new int[elements.size()];
		}
	}

	@Override
	public Element getNextElement() {
		Element guess = guessOpponentMove();
		return findWinningElementAgainst(guess);
	}

	/*
	 * A very raw algorithm to assign higher probability to the elements that
	 * opponent used less in previous fights. Note: This is supposed to show how
	 * the platform supports different strategies for players. This algorithm is
	 * just a very basic example and it might fail to provide optimal results.
	 * This may be not applicable to any possible game as it assumes opponent
	 * has exactly the same elements as local player... it seems to make sense,
	 * as a basic example, for morra-cinese classic, spock-lizard and other
	 * games of the same kind like pari-dispari but it would fail for other
	 * kinds of games.
	 * 
	 * @return the Element I guess opponent will play
	 */
	private Element guessOpponentMove() {
		int resultInt = 0;
		if (history != null) {
			int[] prob = new int[history.length];
			int totalProbs = 0;
			for (int i = 0; i < history.length; i++) {
				prob[i] = loggedFights - history[i];
				totalProbs += prob[i];
			}
			if (totalProbs == 0) {
				return getRandomElement();
			}
			int selected = randomno.nextInt(totalProbs);
			int index = 0;
			while (selected >= 0) {
				selected -= prob[index];
				index++;
			}
			resultInt = index - 1;
		} else {
			resultInt = randomno.nextInt(elements.size());
		}
		return elements.toArray(new Element[0])[resultInt];
	}

	private Element findWinningElementAgainst(Element other) {
		if (gameStrategy != null) {
			for (Element candidate : elements) {
				try {
					if (gameStrategy.fight(candidate, other) < 0) {
						return candidate;
					}
				} catch (IllegalElementException e) {
					// something went wrong... just skip element and move
					// over...
					e.printStackTrace();
				}
			}
			// no way to win :-( let's go for random
			return getRandomElement();
		} else {
			// I don't know game rules... just guess...
			return getRandomElement();
		}
	}

	private Element getRandomElement() {
		int resultInt = randomno.nextInt(elements.size());
		return elements.toArray(new Element[0])[resultInt];
	}

	@Override
	public void notifyOpponentElement(Element element) {
		if ((elements != null) && (history != null)) {
			Element[] tmp = elements.toArray(new Element[0]);
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i] == element) {
					history[i]++;
					loggedFights++;
				}
			}
		}
	}

	@Override
	public Collection<Element> getElements() {
		return elements;
	}

	@Override
	public void notifyOpponentScore(int score) {
		// just drop it

	}

	@Override
	public void showScore(int score) {
		// just drop it

	}

	@Override
	public void notifyGameOver() {
		// just drop it

	}

}
