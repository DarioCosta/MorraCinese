package org.dario.morracinese.players.useragent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import org.dario.morracinese.platform.Element;
import org.dario.morracinese.platform.IllegalElementException;
import org.dario.morracinese.platform.PlayerStrategy;

public class GUIUserAdapter extends JPanel implements PlayerStrategy,
		ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Collection<Element> elements;

	private PlayerViewPanel local, opponent;
	private ButtonsPanel buttonsPanel;

	private Element selectedElement;

	private final ReentrantLock lock = new ReentrantLock(true);
	private Condition condition;

	public GUIUserAdapter() {
		setLayout(new BorderLayout());
		JPanel players = new JPanel(new GridLayout(1, 2));
		local = new PlayerViewPanel("Tu");
		opponent = new PlayerViewPanel("Avversario");
		players.add(local);
		players.add(opponent);
		add(players);
		buttonsPanel = new ButtonsPanel(this);
		add(buttonsPanel, BorderLayout.SOUTH);
		condition = lock.newCondition();
	}

	@Override
	public void setElements(Collection<Element> elements)
			throws IllegalElementException {
		this.elements = elements;
		buttonsPanel.reset(elements);

		revalidate();

	}

	@Override
	public Element getNextElement() {
		selectedElement = null;
		buttonsPanel.setEnabled(true);
		try {
			lock.lock();
			condition.awaitUninterruptibly();
		} finally {
			lock.unlock();
		}
		local.showElement(selectedElement);
		return selectedElement;
	}

	@Override
	public void notifyOpponentElement(Element element) {
		opponent.showElement(element);

	}

	@Override
	public Collection<Element> getElements() {
		return elements;
	}

	@Override
	public void notifyOpponentScore(int score) {
		opponent.showScore(score);

	}

	@Override
	public void showScore(int score) {
		local.showScore(score);

	}

	class PlayerViewPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JLabel score;
		private JLabel currentElement;
		private JLabel name;

		public PlayerViewPanel(String name) {
			setLayout(new BorderLayout());
			setBorder(new BevelBorder(BevelBorder.LOWERED));
			score = new JLabel("0");
			JPanel scorePanel = new JPanel();
			scorePanel.add(new JLabel("Punteggio: "));
			scorePanel.add(score);
			currentElement = new JLabel();
			this.name = new JLabel(name);
			JPanel namePanel = new JPanel();
			namePanel.add(new JLabel("Giocatore: "));
			namePanel.add(this.name);
			add(namePanel, BorderLayout.NORTH);
			add(scorePanel, BorderLayout.SOUTH);
			JPanel elementContainer = new JPanel();
			elementContainer.add(currentElement);
			add(elementContainer);
		}

		public void showScore(final int scoreValue) {
			if (SwingUtilities.isEventDispatchThread()) {
				score.setText(Integer.toString(scoreValue));
			} else {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						score.setText(Integer.toString(scoreValue));
					}
				});
			}
		}

		public void showElement(final Element element) {
			if (SwingUtilities.isEventDispatchThread()) {
				currentElement.setIcon(new ImageIcon(element.getIcon()));
			} else {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						currentElement.setIcon(new ImageIcon(element.getIcon()));
					}
				});
			}
		}
	}

	class ButtonsPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private ElementButton[] elementButtons;
		private ActionListener listener;

		public ButtonsPanel(ActionListener listener) {
			setLayout(new FlowLayout());
			this.listener = listener;
		}

		private void resetButtons(final Collection<Element> elements) {
			if (listener != null) {
				if (elementButtons != null) {
					for (int i = 0; i < elementButtons.length; i++) {
						elementButtons[i].removeActionListener(listener);
					}
				}
			}
			removeAll();

			elementButtons = new ElementButton[elements.size()];
			int i = 0;
			for (Element el : elements) {
				elementButtons[i] = new ElementButton(el);
				add(elementButtons[i]);
				elementButtons[i].addActionListener(listener);
				i++;
			}

		}

		public void reset(final Collection<Element> elements) {

			if (SwingUtilities.isEventDispatchThread()) {
				resetButtons(elements);
			} else {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						resetButtons(elements);
					}
				});
			}
		}

		public void setEnabled(boolean enabled) {
			super.setEnabled(enabled);
			if (elementButtons != null) {
				for (int i = 0; i < elementButtons.length; i++) {
					elementButtons[i].setEnabled(enabled);
				}
			}
		}

	}

	class ElementButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Element element;

		public ElementButton(Element element) {
			super(new ImageIcon(element.getIcon()));
			this.element = element;
		}

		public Element getElement() {
			return element;
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof ElementButton) {
			lock.lock();
			ElementButton button = (ElementButton) event.getSource();
			buttonsPanel.setEnabled(false);
			selectedElement = button.getElement();
			condition.signalAll();
			lock.unlock();

		}
	}

	@Override
	public void notifyGameOver() {
		JOptionPane.showMessageDialog(this, "Game Over");
		buttonsPanel.setEnabled(false);
	}
}
