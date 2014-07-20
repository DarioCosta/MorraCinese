package org.dario.morracinese.games.spocklizard;

import org.dario.morracinese.platform.Game;
import org.dario.morracinese.platform.IllegalPlayerException;
import org.dario.morracinese.platform.Player;
import org.dario.morracinese.players.auto.RandomPlayerStrategy;
import org.dario.morracinese.players.useragent.CLIUserAdapter;


public class MorraCineseSpockLizardCLI {

	public static void main(String[] args) {
		Player p1=new Player(new CLIUserAdapter());
		Player p2=new Player(new RandomPlayerStrategy());
		
		Game game=new Game(new SpockLizardStrategy(5));
		try {
			game.play(p1, p2);
		} catch (IllegalPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
