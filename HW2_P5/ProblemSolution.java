import java.util.*;
import java.lang.*;
import java.io.*;
/** Your Analysis

*/
/**Your Design

*/
class ProblemSolution{

// You can add more/extra methods, if it is needed! 
// Please do not change the signature of the provided methods
    
        //N is the size of the Matrix N by N
         public int[][] getMatrix(){
        	 
        	// get the matrix
             Scanner s = new Scanner(System.in);
             int L = s.nextInt();
             
             int [][] A = new int [L][L];
             
             for (int i = 0; i < L; i++)
             {
            	 for (int j = 0; j < L; j++)
            		 A[i][j] = s.nextInt();
             }
             
             return A;
        }
         
            
        public int findFirstRow(int[][] matrix, int N){
            
            // this function will find the first row with the most 1's in it
            int tempCount = 0;
            int mostCount = 0;
            int tempRow = 0;
            int mostRow = 0;
            
            for (int i = 0; i < N; i++)
            {
            	for (int j = 0; j < N; j++)
           	 	{
           		 	if(matrix[i][j] == 1)
           		 	{
           			 	tempCount++;
           		 	}
           		 	
           		 	tempRow = i;
           	 	}
            	
            	if (tempCount > mostCount)
            	{
            		mostCount = tempCount;
            		mostRow = tempRow;
            	}
            	
            	tempCount = 0;
            }
            
            return mostRow;
        }
    
        public int findFirstCol(int[][] matrix, int N){
            
        	// this function will find the first column with the most 1's in it
        	int tempCount = 0;
            int mostCount = 0;
            int tempCol = 0;
            int mostCol = 0;
            
            for (int i = 0; i < N; i++)
            {
            	for (int j = 0; j < N; j++)
           	 	{
           		 	if(matrix[j][i] == 1)
           		 	{
           			 	tempCount++;
           		 	}
           		 	
           		 	tempCol = i;
           	 	}
            	
            	if (tempCount > mostCount)
            	{
            		mostCount = tempCount;
            		mostCol = tempCol;
            	}
            	
            	tempCount = 0;
            }
            
            return mostCol;
        }
}
