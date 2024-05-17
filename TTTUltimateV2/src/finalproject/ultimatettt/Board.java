package finalproject.ultimatettt;

import java.util.Scanner;

public class Board {
	
	private String[][] board;
	private String boardName;
	private int boardRowSize;
	private int boardColSize;
	private String winner = "N";
	
	Board() {
		this(3, 3, "defaultBoard");
	}
	
	public Board(int rowSize, int colSize, String name) {
		this.setName(name);
		this.setSize(rowSize, colSize);
	}
	
	private void setSize(int row, int col) {
		if(row < 3 || col < 3) {
			System.out.println("min board size is 3*3");
		} else {
			this.boardColSize = col;
			this.boardRowSize = row;
			init(this.boardColSize, this.boardRowSize);
		}
	}
	
	private void setName(String name) {
		this.boardName = name;
	}
	
	public String getName() {
		return this.boardName;
	}
	
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	public String getWinner() {
		return this.winner;
	}
	
	// Fill board with our temp character
	private void init(int rowSize, int colSize) {
		board = new String[rowSize][colSize];
		for(int row = 0; row < this.board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				this.board[row][col] = "-";
			}
		}
	}
	
	// Print out the board
	void print() {
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				System.out.print(this.boardName);
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	void printRow(int row) {
		System.out.print(this.boardName);
		for(int col = 0; col < board.length; col++)
		{
			System.out.print(" | " + board[row][col] + " | ");
		}
	}
	
	// Have the player make their move
	public boolean makeMove(String mark)
	{
		Scanner input = new Scanner(System.in);
		int rowNum = -1;
		int colNum = -1;
		boolean valid = false;
			
		// Get player input and check validity
		while(valid == false)
		{
			System.out.print("Player " + mark + " please select a row number (0-2): ");
			rowNum = input.nextInt();
			System.out.print("Player " + mark + " please select a column number (0-2): ");
			colNum = input.nextInt();
				
			valid = canMove(rowNum, colNum);
		}
		
		TTTGame.lastRow = rowNum;
		TTTGame.lastCol = colNum;
			
		this.board[rowNum][colNum] = mark;
		
		return true;
	}
		
	// AI input
	public boolean AIMove(int range, String mark) {
		
		boolean valid = false;
		int rand1 = -1;
		int rand2 = -1;
			
		while(valid == false)
		{
			rand1 = (int) (Math.random() * range);
			rand2 = (int) (Math.random() * range);
			valid = canMove(rand1, rand2);
		}
		
		TTTGame.lastRow = rand1;
		TTTGame.lastCol = rand2;
		
		this.board[rand1][rand2] = mark;
		
		
		return true;
	}
	
	// Make sure player move was valid
	public boolean canMove(int rowNum, int colNum)
	{
		if(rowNum > 2 || rowNum < 0 || colNum > 2 || colNum < 0)
		{
			System.out.println("Space not on board! (row = " + rowNum + " , column = " + colNum + ")");
			System.out.println("Please try again!");
			return false;
		}
		
		else if((board[rowNum][colNum] != "-"))
		{
			System.out.println("Space has already been taken!");
			System.out.println("Please try again!");
			return false;
		}
		
		// Input was valid
		return true;
		
	}
	
	// Check if player that last played won the board
	public boolean isWon(String player) {
		// diagonals
		if(board[1][1] == player)
		{
			if((this.board[0][0] == player) && (this.board[2][2] == player)) return true;
			if((this.board[2][0] == player) && (this.board[0][2] == player)) return true;
		}
		
		// horizontals
		if((this.board[0][0] == player) && (this.board[0][1] == player) && (this.board[0][2] == player)) return true;
		if((this.board[1][0] == player) && (this.board[1][1] == player) && (this.board[1][2] == player)) return true;
		if((this.board[2][0] == player) && (this.board[2][1] == player) && (this.board[2][2] == player)) return true;
		
		// verticals
		if((this.board[0][0] == player) && (this.board[1][0] == player) && (this.board[2][0] == player)) return true;
		if((this.board[0][1] == player) && (this.board[1][1] == player) && (this.board[2][1] == player)) return true;
		if((this.board[0][2] == player) && (this.board[1][2] == player) && (this.board[2][2] == player)) return true;
		
		else
			return false;
	}
	
	public boolean isFull() {
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				// If a single dash is found, board not empty
				if(this.board[row][col] == "-")
					return false;
			}
		}
		
		// No dashes found - board empty
		return false;
	}
}
