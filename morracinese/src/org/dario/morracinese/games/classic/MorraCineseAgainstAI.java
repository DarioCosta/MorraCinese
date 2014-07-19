package org.dario.morracinese.games.classic;

import javax.swing.JFrame;

import org.dario.morracinese.platform.AIPlayerStrategy;
import org.dario.morracinese.platform.Game;
import org.dario.morracinese.platform.GameStrategy;
import org.dario.morracinese.platform.IllegalPlayerException;
import org.dario.morracinese.platform.Player;
import org.dario.morracinese.view.GUIUserAdapter;

public class MorraCineseAgainstAI {

	public static void main(String[] args) {
		JFrame gui=new JFrame("Morra cinese");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUIUserAdapter userAdapter=new GUIUserAdapter();
		gui.setContentPane(userAdapter);
		Player p1=new Player(userAdapter);
		GameStrategy strategy=new RPSStrategy(5);
		Player p2=new Player(new AIPlayerStrategy(strategy));
		gui.setSize(500,300);
		gui.setVisible(true);
		Game game=new Game(strategy);
		try {
			game.play(p1, p2);
		} catch (IllegalPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
