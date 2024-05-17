package finalproject.tttgame;

public class BigBoard {
		private BigBox[] boxes;
		private int BBRowSize;
		private int BBColSize;
		
		BigBoard() {
			this(3, 3);
		}
		
		BigBoard(int rowSize, int colSize) {
			this.setSize(rowSize, colSize);
		}
		
		private void setSize(int row, int col) {
			if(row < 3 || col < 3) {
				System.out.println("min board size is 3*3");
			} else {
				this.BBColSize = col;
				this.BBRowSize = row;
				init();
			}
		}
		
		private void init() {
			boxes = new BigBox[BBColSize * BBRowSize];
			for(int i = 0; i < boxes.length; i++) {
				BigBox b = new BigBox(i/BBRowSize, i%BBColSize);
				boxes[i] = b;
			}
			print();
		}
		
		void print()
		{
			for(int i = 0; i < boxes.length; i++) {
				if(i != 0 && i % BBColSize==0) System.out.println();
				boxes[i].print();
			}
			
			System.out.println("");
		}
}
