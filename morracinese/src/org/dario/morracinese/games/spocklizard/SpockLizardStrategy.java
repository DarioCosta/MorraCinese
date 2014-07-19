package org.dario.morracinese.games.spocklizard;

import javax.swing.ImageIcon;

import org.dario.morracinese.games.classic.RPSStrategy;
import org.dario.morracinese.platform.Element;
import org.dario.morracinese.platform.IllegalElementException;

public class SpockLizardStrategy extends RPSStrategy {
	
	public static final Element LUCERTOLA = new Element("LUCERTOLA", new ImageIcon("resources/lucertola.png").getImage());
	public static final Element SPOCK = new Element("SPOCK", new ImageIcon("resources/spock.png").getImage());
	
	public SpockLizardStrategy(int rounds) {
		super(rounds);
		elements.add(SPOCK);
		elements.add(LUCERTOLA);
	}

	public SpockLizardStrategy() {
		this(5);
	}
	
	public int fight(Element x, Element y) throws IllegalElementException {
		if((x==null)||(y==null)){
			throw new IllegalElementException();
		}
		int posX = elements.indexOf(x);
		int posY = elements.indexOf(y);
		if (posX == posY) {
			return 0;
		}
		if ((posY == (posX + 1) % elements.size())||(posY == (posX + 3) % elements.size())) {

			return 1;
		} else {

			return -1;
		}
	}
	
}
