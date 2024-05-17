package codeactivity.example.tttgame;

import java.util.Scanner;

public class TTTBoard
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		char [][] board = new char [3][3];
		
		// Fill our 3 x 3 board with dashes
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				board[row][col] = '-';
			}
		}
		
		char player = 'X';
		int rowNum = -1;
		int colNum = -1;
		do
		{
			System.out.println("Printing the board info....");
			for(int row = 0; row < board.length; row++)
			{
				for(int col = 0; col < board[row].length; col++)
				{
					System.out.print(board[row][col] + " ");
				}
				System.out.println();
			}
			
			System.out.print("Player " + player + " please select a row number (0-2): ");
			rowNum = input.nextInt();
			System.out.print("Player " + player + " please select a column number (0-2): ");
			colNum = input.nextInt();
			
			// INPUT VALIDATION: within the array
			while(rowNum > 2 || rowNum < 0 || colNum > 2 || colNum < 0)
			{
				System.out.println("Space not on board! (row = " + rowNum + " , column = " + colNum + ")");
				System.out.println("Please try again!");
							
				System.out.print("Player " + player + " please select a row number (0-2): ");
				rowNum = input.nextInt();
				System.out.print("Player " + player + " please select a column number (0-2): ");
				colNum = input.nextInt();
			}
			
			
			// INPUT VALIDATION: space not played in yet
			if(board[rowNum][colNum] == '-')
			{
				board[rowNum][colNum] = player;
			
				// check to see if player lined three spaces in a row
				
				// diagonals
				if(board[1][1] == player)
				{
					if((board[0][0] == player) && (board[2][2] == player)) break;
					if((board[2][0] == player) && (board[0][2] == player)) break;
				}
				
				// horizontals
				if((board[0][0] == player) && (board[0][1] == player) && (board[0][2] == player)) break;
				if((board[1][0] == player) && (board[1][1] == player) && (board[1][2] == player)) break;
				if((board[2][0] == player) && (board[2][1] == player) && (board[2][2] == player)) break;
				
				// verticals
				if((board[0][0] == player) && (board[1][0] == player) && (board[2][0] == player)) break;
				if((board[0][1] == player) && (board[1][1] == player) && (board[2][1] == player)) break;
				if((board[0][2] == player) && (board[1][2] == player) && (board[2][2] == player)) break;
					
					
				// Switch players
				if(player == 'X') player = 'O';
				else player = 'X';
				
			}
			
			else
			{
				System.out.println("Space taken! (row = " + rowNum + " , column = " + colNum + ")");
				System.out.println("Please try again!");
			}
			
			
		} while(true);
		
		System.out.println("Congratulations! Player " + player + " has won the game!");
	}
}