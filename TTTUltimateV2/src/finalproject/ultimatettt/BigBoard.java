package finalproject.ultimatettt;

public class BigBoard {
	private Board[][] bigBoard;
	private int BBRowSize;
	private int BBColSize;
	
	BigBoard(int BBRowSize, int BBColSize) {
		this.setSize(BBRowSize, BBColSize);
	}
	
	private void setSize(int row, int col) {
		if(row < 3 || col < 3) {
			System.out.println("min board size is 3*3");
		} else {
			this.BBColSize = col;
			this.BBRowSize = row;
			init(this.BBColSize, this.BBRowSize);
		}
	}
	
	// Fill bigBoard with our empty boards
	private void init(int rowSize, int colSize) {
		int i = 0;
		bigBoard = new Board[rowSize][colSize];
		for(int row = 0; row < this.bigBoard.length; row++)
		{
			for(int col = 0; col < bigBoard[row].length; col++)
			{
				this.bigBoard[row][col] = new Board(rowSize, colSize, "Board"+i);
				i++;
			}
		}
	}
	
	// Print our entire bigBoard
	// (!) PRINTS IN WRONG FORMAT
	void print()
	{
		for(int row = 0; row < bigBoard.length; row++)
		{
			for(int col = 0; col < bigBoard[row].length; col++)
			{
				(bigBoard[row][col]).print();
			}
			System.out.println();
		}
	}
	
	// Print in the correct format
	void printRight()
	{
		for(int j = 0; j < bigBoard.length; j++)
		{
			for(int i = 0; i < bigBoard.length; i++)
			{
				bigBoard[j][i].printRow(0);
			}
			
			System.out.println();
			
			for(int i = 0; i < bigBoard.length; i++)
			{
				bigBoard[j][i].printRow(1);
			}
			
			System.out.println();
			
			for(int i = 0; i < bigBoard.length; i++)
			{
				bigBoard[j][i].printRow(2);
			}
			
			System.out.println();
			
			System.out.println("--------------------------------------------------------------------------------");
		}
	}
	
	// Don't look down here please
	public Board boardSelector(int num)
	{
		if(num == 0) return bigBoard[0][0];
		if(num == 1) return bigBoard[0][1];
		if(num == 2) return bigBoard[0][2];
		if(num == 3) return bigBoard[1][0];
		if(num == 4) return bigBoard[1][1];
		if(num == 5) return bigBoard[1][2];
		if(num == 6) return bigBoard[2][0];
		if(num == 7) return bigBoard[2][1];
		if(num == 8) return bigBoard[2][2];
		
		else return null;
	}
	
	
	public boolean gameOver(String player)
	{
		// diagonals
		if(bigBoard[1][1].getWinner() == player)
		{
			if((this.bigBoard[0][0].getWinner() == player) && (this.bigBoard[2][2].getWinner() == player)) return true;
			if((this.bigBoard[2][0].getWinner() == player) && (this.bigBoard[0][2].getWinner() == player)) return true;
		}
				
		// horizontals
		if((this.bigBoard[0][0].getWinner() == player) && (this.bigBoard[0][1].getWinner() == player) && (this.bigBoard[0][2].getWinner() == player)) return true;
		if((this.bigBoard[1][0].getWinner() == player) && (this.bigBoard[1][1].getWinner() == player) && (this.bigBoard[1][2].getWinner() == player)) return true;
		if((this.bigBoard[2][0].getWinner() == player) && (this.bigBoard[2][1].getWinner() == player) && (this.bigBoard[2][2].getWinner() == player)) return true;
				
		// verticals
		if((this.bigBoard[0][0].getWinner() == player) && (this.bigBoard[1][0].getWinner() == player) && (this.bigBoard[2][0].getWinner() == player)) return true;
		if((this.bigBoard[0][1].getWinner() == player) && (this.bigBoard[1][1].getWinner() == player) && (this.bigBoard[2][1].getWinner() == player)) return true;
		if((this.bigBoard[0][2].getWinner() == player) && (this.bigBoard[1][2].getWinner() == player) && (this.bigBoard[2][2].getWinner() == player)) return true;
				
		else
			return false;
	}

	public int getNumber(int lastRow, int lastCol) {
		if(bigBoard[lastRow][lastCol] == bigBoard [0][0]) return 0;
		if(bigBoard[lastRow][lastCol] == bigBoard [0][1]) return 1;
		if(bigBoard[lastRow][lastCol] == bigBoard [0][2]) return 2;
		if(bigBoard[lastRow][lastCol] == bigBoard [1][0]) return 3;
		if(bigBoard[lastRow][lastCol] == bigBoard [1][1]) return 4;
		if(bigBoard[lastRow][lastCol] == bigBoard [1][2]) return 5;
		if(bigBoard[lastRow][lastCol] == bigBoard [2][0]) return 6;
		if(bigBoard[lastRow][lastCol] == bigBoard [2][1]) return 7;
		if(bigBoard[lastRow][lastCol] == bigBoard [2][2]) return 8;
		return 0;
	}
}
