package org.dario.morracinese.platform;

public interface MorraCineseStrategy {
	public int fight(Element x, Element y) throws IllegalElementException;
	public Element[] getElements();
}
