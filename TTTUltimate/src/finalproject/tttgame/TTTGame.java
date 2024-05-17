package finalproject.tttgame;

import java.util.Scanner;

public class TTTGame {
	private ComputerPlayer[] players = new ComputerPlayer[2];
	private Board board;
	
	private String[] marks = {"X", "0"};
	private String name = "ULTIMATE TICK-TAC-TOE";
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	
	private int currentPlayerIndex = -1;
	
	public TTTGame() {
		setPlayers();
		setBoard();
		goFirst();
	}
	
	private void setBoard() {
		this.board = new Board(gameRowSize, gameColSize, "TTTGame");
	}
	
	private void setPlayers() {
		for(int i = 0; i < players.length; i++){
			ComputerPlayer p = new ComputerPlayer("player" + i+1 , marks[i]);
			players[i] = p;
		}
	}
	
	private void goFirst() {
		System.out.println("Which player will go first?");
		System.out.println("Press 0 for " + marks[0]);
		System.out.println("Press 1 for " + marks[1]);
		Scanner input = new Scanner(System.in);
		
		this.currentPlayerIndex = input.nextInt();
	}
	
	public void start() {
		Scanner input = new Scanner(System.in);
		System.out.println("|| GAME STARTED || WELCOME TO " + this.name + " GAME ||");
		System.out.println("-----------------------------------------------------------");
		do {
			// Player move
			board.makeMove(players[this.currentPlayerIndex].getMark());
			
			switchPlayer();
			
			// AI Random Move
			while(!board.makeMove(players[this.currentPlayerIndex].getMark(),
					players[this.currentPlayerIndex].randomNumber(gameRowSize),
					players[this.currentPlayerIndex].randomNumber(gameColSize)));
			
			board.print();
			
		}while(!gameOver());
	}
		
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
			
			// Player index not 1 or 0
			System.out.println("Error occured when switching player");
		}
		
		private boolean gameOver() {
			// TODO
			
			return false;
		}
		
		private boolean isWinner() {
			
			return false;
		}
}
