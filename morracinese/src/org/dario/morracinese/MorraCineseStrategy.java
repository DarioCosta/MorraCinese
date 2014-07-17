package org.dario.morracinese;

public interface MorraCineseStrategy {
	public int fight(Element x, Element y) throws IllegalElementException;
	public Element[] getElements();
}
