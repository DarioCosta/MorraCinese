package org.dario.morracinese.games.classic;

import org.dario.morracinese.platform.Game;
import org.dario.morracinese.platform.GameStrategy;
import org.dario.morracinese.platform.IllegalPlayerException;
import org.dario.morracinese.platform.Player;
import org.dario.morracinese.platform.RandomPlayerStrategy;
import org.dario.morracinese.view.CLIUserAdapter;

public class MorraCineseCLI {

	public static void main(String[] args) {
		Player p1=new Player(new CLIUserAdapter());
		Player p2=new Player(new RandomPlayerStrategy());
		
		Game game=new Game(new RPSStrategy(5));
		try {
			game.play(p1, p2);
		} catch (IllegalPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
