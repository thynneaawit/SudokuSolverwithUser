package One;
import java.util.Scanner;
public class Sudoku {
	  private static final int SIZE = 9;
	  
	  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter nine rows for Sudoku: ");
	    int rows = sc.nextInt();
	    System.out.println("Enter nine columns for Sudoku: ");
	    int columns = sc.nextInt();
	    int [][] sudoku = new int[rows][columns];
	    if(rows== 9 && columns==9) {
		System.out.println("Enter elements in Sudoku: ");
	    for(int i = 0; i < rows; i++) {
	    	for(int j = 0; j < columns; j++) {
	    		sudoku[i][j]= sc.nextInt();
	    	}
	    }
	    }
	    else {
	    	System.out.println("You didn't enter nine for rows and columns");
	    	System.exit(0);
	    }
	   	    
	    showSudoku(sudoku);
	    
	    if (Solve(sudoku)==true) {
	      System.out.println("Sudoku solved");
	    }
	    else {
	      System.out.println("Sudoku couldn't be solved");
	    }
	    
	    showSudoku(sudoku);
	    
	  }
	  
	  
	  private static void showSudoku(int[][] sudoku) {
	    for (int row = 0; row < SIZE; row++) {
	      if (row % 3 == 0 && row != 0) {
	        System.out.println("-----------");
	      }
	      for (int column = 0; column < SIZE; column++) {
	        if (column % 3 == 0 && column != 0) {
	          System.out.print("|");
	        }
	        System.out.print(sudoku[row][column]);
	      }
	      System.out.println();
	    }
	  }


	  private static boolean checkRows(int[][] sudoku, int num, int row) {
	    for (int i = 0; i < SIZE; i++) {
	      if (sudoku[row][i] == num) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  private static boolean checkColumns(int[][] sudoku, int num, int column) {
	    for (int i = 0; i < SIZE; i++) {
	      if (sudoku[i][column] == num) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  private static boolean checkSudoku(int[][] sudoku, int num, int row, int column) {
	    int bRow = row - row % 3;
	    int bColumn = column - column % 3;
	    
	    for (int i = bRow; i < bRow + 3; i++) {
	      for (int j = bColumn; j < bColumn + 3; j++) {
	        if (sudoku[i][j] == num) {
	          return true;
	        }
	      }
	    }
	    return false;
	  }
	  
	  private static boolean workingSudoku(int[][] sudoku, int num, int row, int column) {
	    return !checkRows(sudoku, num, row) && !checkColumns(sudoku, num, column) && !checkSudoku(sudoku, num, row, column);
	  }
	  
	  private static boolean Solve(int[][] sudoku) {
	    for (int row = 0; row < SIZE; row++) {
	      for (int column = 0; column < SIZE; column++) {
	        if (sudoku[row][column] == 0) {
	          for (int x = 1; x <= SIZE; x++) {
	            if (workingSudoku(sudoku, x, row, column)) {
	              sudoku[row][column] = x;
	              
	              if (Solve(sudoku)) {
	                return true;
	              }
	              else {
	                sudoku[row][column] = 0;
	              }
	            }
	          }
	          return false;
	        }
	      }
	    }
	    return true;
	  }
	  
	  
	  
	}


