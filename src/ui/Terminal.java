package ui;

import java.util.Scanner;
import game.Game;

public class Terminal {

	private Game game;
	private static Scanner input = new Scanner(System.in);
	public void run() {
		game = new Game();
		renderBoard(game);
		game.start();
		while(!game.isEnd()){
			System.out.println(game.getCurrentPlayerName() + "'s turn");
			System.out.print("Row : ");
			int row = input.nextInt();
			System.out.print("Column : ");
			int col = input.nextInt();
			game.currentPlayerTakesAction(row, col);
		}
		System.out.println("The winner is "+game.getWinnerName());
	}

	private void renderBoard(Game game) {
		int size = game.getBoardSize();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				String s = game.getSymbolOnBoard(row, col);
				if(s == null) {
					s = "_";
				}
				System.out.print(s);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Terminal ui = new Terminal();
		ui.run();
	}

}
