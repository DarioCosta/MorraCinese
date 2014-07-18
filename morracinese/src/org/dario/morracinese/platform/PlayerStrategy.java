package org.dario.morracinese.platform;

import java.util.Collection;

public interface PlayerStrategy {
	public void setElements(Collection<Element> elements)
			throws IllegalElementException;

	public Element getNextElement();

	public void notifyOpponentElement(Element element);

	public Collection<Element> getElements();

	public void notifyOpponentScore(int score);
	
	public void showScore(int score);

}
