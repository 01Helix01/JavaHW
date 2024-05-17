package finalproject.ultimatettt;

import java.util.Scanner;

// ULTIMATE TIC-TAC-TOE
// Carson Branham
// Course Project for CS 2336.0W2

/* Analysis:
 * For the Ultimate TTT game, there are several new rules that need to be followed
 * We will have a 6 x 6 grid of Tic-Tac-Toe games and three games need to be won -
 * in a row - to win the game as a whole
 * When a player makes a move, the place on the small game is the board that they
 * must play on for their next turn
 * If it is the start of the game or the board is full, they player may play whererever
 * they may like
 * Won board's outcomes cannot be influenced but you can be sent to them
 */

/* Design:
 * Use a 2D array for both our small boards, as well as the big board
 * The small board being an array of type string and big board being of type board
 * With this, we are able to repurpose some of the framework from our previous
 * In Class Assignments where we made the original TTT game - with the aformentioned  
 * changed stated above in the analysis.
 * In my mind, I first thought of this "Ultimate" version of the game like normal TTT
 * but with seperate game placed in each empty space so that influenced many of my design decisions
 */


public class TTTGame {
	
	private ComputerPlayer[] players = new ComputerPlayer[2];
	
	private BigBoard bb;
	private Board board;
	
	private String[] marks = {"X", "0"};
	private String name = "ULTIMATE TICK-TAC-TOE";
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	boolean win = false;
	
	int numPlayers = -1;
	private int currentPlayerIndex = -1;
	
	// Used for finding valid board to play on
	public static int lastCol = -1;
	public static int lastRow = -1;
	
	public TTTGame() {
		setPlayers();
		setBoard();
		settings();
	}
	
	// Defines players
	private void setPlayers() {
		for(int i = 0; i < players.length; i++){
			ComputerPlayer p = new ComputerPlayer("player" + i+1 , marks[i]);
			players[i] = p;
		}
	}
	
	private void setBoard()
	{
		this.bb = new BigBoard(gameRowSize, gameColSize);
	}
	
	// Pick which mark will go first
	private void settings() {
		System.out.println("Which player will go first?");
		System.out.println("Press 0 for " + marks[0]);
		System.out.println("Press 1 for " + marks[1]);
		
		Scanner input = new Scanner(System.in);
		
		this.currentPlayerIndex = input.nextInt();
		while(this.currentPlayerIndex != 0 && this.currentPlayerIndex != 1)
		{
			System.out.println("Invalid input: Input has to be 1 or 0");
			this.currentPlayerIndex = input.nextInt();
		}
		
		System.out.println("Would you like to play 1 player or 2 player?");
		numPlayers = input.nextInt();
		while(numPlayers != 1 && numPlayers != 2)
		{
			System.out.println("Invalid input: There can only be 1 or 2 players");
			numPlayers = input.nextInt();
		}
	}
	
	// Starts game
	public void start() {
		System.out.println("|| GAME STARTED || WELCOME TO " + this.name + " GAME ||");
		System.out.println("-----------------------------------------------------------");
		
		bb.printRight();
		
		do {
			selectBoard();
			
			// Player move
			board.makeMove(players[this.currentPlayerIndex].getMark());
			
			// Check if board was won for 1P
			if(this.isWinner())
			{
				System.out.println("Board has been won! You may continue to play on it if it isn't full");
				win = bb.gameOver(players[this.currentPlayerIndex].getMark());
			}
			
			if(this.gameOver())
			{
				System.out.println("-----------------------------");
				System.out.println("|| Game has been won by " + players[this.currentPlayerIndex].getMark() + "! ||");
				System.out.println("-----------------------------");
				System.exit(0);
			}
			
			bb.printRight();
			switchPlayer();
			selectBoard();
			
			// Depending on number of players, either AI takes move, or player 2
			if(numPlayers == 1)
			{
				// AI Random Move
				board.AIMove(gameRowSize, players[this.currentPlayerIndex].getMark());
			}
			else
			{
				// Player move
				board.makeMove(players[this.currentPlayerIndex].getMark());
			}
			
			// Check is Board was won for 2P
			if(this.isWinner())
			{
				System.out.println("Board has been won! You may continue to play on it if it isn't full");
				board.setWinner(players[this.currentPlayerIndex].getMark());
			}
			
			if(this.gameOver())
			{
				System.out.println("-----------------------------");
				System.out.println("|| Game has been won by " + players[this.currentPlayerIndex].getMark() + "! ||");
				System.out.println("-----------------------------");
				System.exit(0);
			}
			
			switchPlayer();
			
			bb.printRight();
			
		}while(!gameOver());
	}
	
	// Swaps current player
	private void switchPlayer() {
		// If player is X, make player O
		if(this.currentPlayerIndex == 0)
		{
			this.currentPlayerIndex = 1;
			System.out.println("Current Player is : " + marks[this.currentPlayerIndex]);
			return;
		}
		// If player is 0 make player 1
		else if(this.currentPlayerIndex == 1)
		{
			this.currentPlayerIndex = 0;
			System.out.println("Current Player is : " + marks[this.currentPlayerIndex]);
			return;
		}
	}
	
	private void selectBoard() {
		Scanner input = new Scanner(System.in);
		int num;
		
		
		// If first round or board is full, play anywhere
		if((lastCol == -1 && lastRow == -1) || board.isFull())
		{
			System.out.println("Select a valid Board to play on");
			
			num = input.nextInt();
				
			while(num < 0 || num > 8)
			{
				System.out.println("You must play on a board. Try again");
				num = input.nextInt();
			}
		}
		
		
		// Else, must play on the board corresponding to the last play
		else
		{
			int playOn = bb.getNumber(lastRow, lastCol);
			System.out.println("You must play in Board " + playOn);
			num = playOn;
		}

		this.board = bb.boardSelector(num);
	}
	
	// Determines if the whole game is over
	private boolean gameOver() {
		return bb.gameOver(players[this.currentPlayerIndex].getMark());
	}
	
	// Determines if a board has been won
	private boolean isWinner() {
		if(board.isWon(players[this.currentPlayerIndex].getMark()) && board.getWinner() == "N")
		{
			board.setWinner(players[this.currentPlayerIndex].getMark());
			return true;
		}
		
		else
			return false;
	}
}
