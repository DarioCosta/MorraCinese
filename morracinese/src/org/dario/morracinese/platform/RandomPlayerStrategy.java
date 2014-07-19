package org.dario.morracinese.platform;

import java.util.Collection;
import java.util.Random;

public class RandomPlayerStrategy implements PlayerStrategy {
	private Random randomno = new Random();
	private Collection<Element> elements;

	@Override
	public Element getNextElement() {
		int resultInt = randomno.nextInt(elements.size());
		return elements.toArray(new Element[0])[resultInt];
	}

	@Override
	public void notifyOpponentElement(Element element) {
		// just drop it

	}

	@Override
	public void setElements(Collection<Element> elements)
			throws IllegalElementException {
		if ((elements == null) || (elements.size() == 0)) {
			throw new IllegalElementException();
		}
		this.elements = elements;
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
