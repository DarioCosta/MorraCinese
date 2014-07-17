package org.dario.morracinese;

import java.util.ArrayList;
import java.util.List;

public class RPSStrategy implements MorraCineseStrategy {

	private List<Element> elements = new ArrayList<Element>();

	public RPSStrategy() {
		elements.add(Element.CARTA);
		elements.add(Element.FORBICI);
		elements.add(Element.PIETRA);
	}

	@Override
	public int fight(Element x, Element y) throws IllegalElementException {
		if (x == y) {
			return 0;
		}
		int posX = elements.indexOf(x);
		int posY = elements.indexOf(y);
		if (posX < 0 || posY < 0) {
			throw new IllegalElementException();
		}
		if (posY == (posX + 1) % elements.size()) {
			return 1;
		} else {
			return -1;
		}

	}

	@Override
	public Element[] getElements() {
		return elements.toArray(new Element[0]);
	}

}
