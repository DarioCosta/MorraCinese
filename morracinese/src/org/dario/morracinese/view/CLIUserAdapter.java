package org.dario.morracinese.view;

import java.util.Collection;
import java.util.Scanner;

import org.dario.morracinese.platform.Element;
import org.dario.morracinese.platform.IllegalElementException;
import org.dario.morracinese.platform.PlayerStrategy;

public class CLIUserAdapter implements PlayerStrategy {

	private Collection<Element> elements;
	private Scanner scanner = new Scanner(System.in);

	@Override
	public void setElements(Collection<Element> elements)
			throws IllegalElementException {
		this.elements = elements;

	}

	@Override
	public Element getNextElement() {
		int index = 0;
		do {
			System.out.println("Fai la tua mossa:");
			int count = 0;
			for (Element el : elements) {
				count++;
				System.out.println(count + " - " + el.toString());
			}
			index = scanner.nextInt();
		} while ((index <= 0) || (index > elements.size()));
		Element result = elements.toArray(new Element[0])[index - 1];
		System.out.println("Hai scelto: " + result);
		return result;
	}

	@Override
	public void notifyOpponentElement(Element element) {
		System.out.println("Il tuo avversario ha scelto: " + element);
	}

	@Override
	public Collection<Element> getElements() {
		return elements;
	}

	@Override
	public void notifyOpponentScore(int score) {
		System.out.println("Il tuo avversario ha " + score + " punti");
	}

	@Override
	public void showScore(int score) {
		System.out.println("Hai " + score + " punti");
	}

}
