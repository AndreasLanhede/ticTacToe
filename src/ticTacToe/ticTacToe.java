package ticTacToe;

import java.util.Scanner;

public class ticTacToe {	
	static String player = "";
	static String symbol = "";
	static char sym = 'X';
	static int turn = 1;
	static boolean newGame = true;
	static boolean GameOn = true;
	static boolean invalidInput = true;
	static String gameBoard = "";
	static String startBoard = new String("_____________" + "\n" +
			   		      "|   |   |   |" + "\n" +
			   		      "| 1 | 2 | 3 |" + "\n" +
			   		      "|___|___|___|" + "\n" +
			   		      "|   |   |   |" + "\n" +
			   		      "| 4 | 5 | 6 |" + "\n" +
			   		      "|___|___|___|" + "\n" +
			   		      "|   |   |   |" + "\n" +
			   		      "| 7 | 8 | 9 |" + "\n" +
			   		      "|___|___|___|" + "\n");

	public static void main(String[] args) {
	Scanner playerInput = new Scanner(System.in);

	while (newGame) {

		// Reset Game
		resetGame();
		// Turns
		while (GameOn) {
			playerTurn();
			invalidInput = true;
			String placeNumber = "";
			while (invalidInput) {
				System.out.println(player + " choose a square");
				placeNumber = playerInput.nextLine();
				invalidInput = false;
				if (!validInput(gameBoard, placeNumber))
					invalidInput = true;
			}
			gameBoard = gameBoard.replace(placeNumber, symbol);
			System.out.println(gameBoard);
			if (winlogic(gameBoard, sym))
				break;
			if (drawlogic(gameBoard))
				break;
		}

		// Turn off game?
		invalidInput = true;
		while (invalidInput) {
			System.out.println("You want to play again (Y/N)");
			String nG = playerInput.nextLine();
			turnOffGame(nG);
		}
	}
	playerInput.close();
}

public static boolean winlogic(String stringname, char ch) {
	char ch1 = stringname.charAt(30);
	char ch2 = stringname.charAt(34);
	char ch3 = stringname.charAt(38);
	char ch4 = stringname.charAt(72);
	char ch5 = stringname.charAt(76);
	char ch6 = stringname.charAt(80);
	char ch7 = stringname.charAt(114);
	char ch8 = stringname.charAt(118);
	char ch9 = stringname.charAt(122);

	if (((ch1 == ch) && (ch2 == ch) && (ch3 == ch)) || 
		((ch4 == ch) && (ch5 == ch) && (ch6 == ch)) || 
		((ch7 == ch) && (ch8 == ch) && (ch9 == ch)) || 
		((ch1 == ch) && (ch4 == ch) && (ch7 == ch))	|| 
		((ch2 == ch) && (ch5 == ch) && (ch8 == ch)) || 
		((ch3 == ch) && (ch6 == ch) && (ch9 == ch)) || 
		((ch1 == ch) && (ch5 == ch) && (ch9 == ch)) || 
		((ch3 == ch) && (ch5 == ch) && (ch7 == ch))) {
		System.out.println(player + " won!");
		GameOn = false;
		return true;
	}else
		return false;

}

public static boolean drawlogic(String stringname) {
	if (stringname.contains("1") || stringname.contains("2") || stringname.contains("3") || 
		stringname.contains("4") || stringname.contains("5") || stringname.contains("6") || 
		stringname.contains("7") || stringname.contains("8") || stringname.contains("9"))
		return false;
	else {
		System.out.println("It's a draw!");
		GameOn = false;
		return true;
	}
}

public static boolean validInput(String stringname, String placename) {
	if (stringname.contains(placename))
		try {
			Integer.parseInt(placename);
			return true;
		} catch (NumberFormatException e) {
			System.out.println(" Please don't try to break the game");
			return false;
		}
	else {
		System.out.println("You need to insert an unoccupied number!");
		return false;
	}

}

public static void playerTurn() {
	if (turn % 2 == 0) {
		player = "Player X";
		symbol = "X";
		sym = 'X';
	} else {
		player = "Player O";
		symbol = "O";
		sym = 'O';
	}
	turn += 1;
}

public static void turnOffGame(String newG) {
	if (newG.toLowerCase().equals("y")) {
		newGame = true;
		invalidInput = false;
		System.out.println("New Game");
	} else if (newG.toLowerCase().equals("n")) {
		newGame = false;
		invalidInput = false;
		System.out.println("Good Bye!");
	} else
		System.out.println("You need to input Y or N");
}

public static void resetGame() {
	gameBoard = startBoard;
	System.out.println(gameBoard);
	if (Math.random() > 0.5)
		turn += 1;
	GameOn = true;
	invalidInput = true;
}
}
