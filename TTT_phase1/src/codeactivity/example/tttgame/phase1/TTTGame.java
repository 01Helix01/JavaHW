package codeactivity.example.tttgame.phase1;

public class TTTGame {
	private ComputerPlayer[] players = new ComputerPlayer[2];
	private Board board;
	
	private String[] marks = {"X", "0"};
	private String name = "TickTacToe";
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gamScoreToWin = 3;
	
	private int currentPlayerIndex = -1;
	
	public TTTGame() {
		setPlayers();
		setBoard();
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
	
	public void start() {
		System.out.println("game started...");
		do {
			switchPlayer();
			while(!board.makeMove(players[this.currentPlayerIndex].getMark(),
					players[this.currentPlayerIndex].randomNumber(gameRowSize),
					players[this.currentPlayerIndex].randomNumber(gameColSize)));
			board.print();
			
		}while(!gameOver());
	}
		
		private void switchPlayer() {
			// TODO
		}
		
		private boolean gameOver() {
			// TODO
			
			return false;
		}
		
		private boolean isWinner() {
			
			return false;
		}
}
