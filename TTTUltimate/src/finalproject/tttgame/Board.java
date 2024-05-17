package finalproject.tttgame;

import java.util.Scanner;

public class Board {
	
	private Box[] boxes;
	private String name;
	private int boardRowSize;
	private int boardColSize;
	
	Board() {
		this(3, 3, "Board1");
	}
	
	Board(int rowSize, int colSize, String name) {
		this.setName(name);
		this.setSize(rowSize, colSize);
	}
	
	private void setSize(int row, int col) {
		if(row < 3 || col < 3) {
			System.out.println("min board size is 3*3");
		} else {
			this.boardColSize = col;
			this.boardRowSize = row;
			init();
		}
	}
	
	private void init() {
		boxes = new Box[boardColSize * boardRowSize];
		for(int i = 0; i < boxes.length; i++) {
			Box b = new Box(i/boardRowSize, i%boardColSize);
			boxes[i] = b;
		}
		print();
	}
	
	void print() {
		System.out.println("printing the " + this.name + "-" +
				this.boardRowSize + "*" + this.boardColSize + " board info.....");
		
		for(int i = 0; i < boxes.length; i++) {
			if(i != 0 && i % boardColSize==0) System.out.println();
			boxes[i].print();
		}
		
		System.out.println("");
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	// Player input
	public boolean makeMove(String mark)
	{
		Scanner input = new Scanner(System.in);
		int rowNum, colNum;
		boolean valid = false;
		
		// Get player input and check validity
		while(valid == true)
		{
			System.out.print("Player " + mark + " please select a row number (0-2): ");
			rowNum = input.nextInt();
			System.out.print("Player " + mark + " please select a column number (0-2): ");
			colNum = input.nextInt();
			
			valid = canMove(rowNum, colNum);
		}
		
		this.boxes[rowNum * this.boardRowSize + colNum] = mark;
		
		return true;
	}
	
	// AI input
	public boolean makeMove(String mark, int randomNumber, int randomNumber2) {
		// TODO

		
		return false;
	}
	
	public boolean canMove(int row, int col)
	{
		if(this.box)
		return false;
	}
	
	public boolean isFull() {
		for(Box b : boxes)
			if(b.isAvailable()) return false;
		return true;
	}
	
	public String getMark(int row, int col) {
		return boxes[row * this.boardRowSize + col].getPlaceHolder();
	}
	
	public static void main(String [] args) {
		Board b = new Board();
	}
}
