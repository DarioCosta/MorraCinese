package org.dario.morracinese.platform;

public class GameOverException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameOverException() {
		super("No more moves allowed.");
	}
}
