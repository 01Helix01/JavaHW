import java.util.*;
import java.lang.*;
import java.io.*;

class DriverMain{
     public static void main(String[] args){
        ProblemSolution problemSolution = new ProblemSolution();
        int[][] A = problemSolution.getMatrix();
         int N = A.length;
    if(N > 0){
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j]);
                if (j < (N - 1)) {
                    System.out.print(" ");
                }
            }
            if(i < N-1)
                System.out.println();
        }
   		System.out.println();
        System.out.println(problemSolution.findFirstRow(A, N));
   		System.out.print(problemSolution.findFirstCol(A, N));
             
    }else
            System.out.println("-1"); 
            
    }   
}
