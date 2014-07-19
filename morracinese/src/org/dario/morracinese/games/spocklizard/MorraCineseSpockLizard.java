package org.dario.morracinese.games.spocklizard;

import javax.swing.JFrame;

import org.dario.morracinese.platform.Game;
import org.dario.morracinese.platform.IllegalPlayerException;
import org.dario.morracinese.platform.Player;
import org.dario.morracinese.platform.RandomPlayerStrategy;
import org.dario.morracinese.view.GUIUserAdapter;

public class MorraCineseSpockLizard {

	public static void main(String[] args) {
		JFrame gui=new JFrame("Morra cinese + Spock e Lizard");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUIUserAdapter userAdapter=new GUIUserAdapter();
		gui.setContentPane(userAdapter);
		Player p1=new Player(userAdapter);
		Player p2=new Player(new RandomPlayerStrategy());
		gui.setSize(800,320);
		gui.setVisible(true);
		Game game=new Game(new SpockLizardStrategy(5));
		try {
			game.play(p1, p2);
		} catch (IllegalPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
