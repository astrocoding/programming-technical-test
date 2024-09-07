/**
 * Name: NQueenProblem.java
 * Author: Zaenal Alfian
 * Date: 08 Sept 2024
 * Description: This program contains solution for N-Queen Problem using backtracking algorithm.
 */
public class NQueenProblem {
  private static int N;

  public static void solveNQueens(int n) {
    N = n;
    int[][] board = new int[N][N];
    if (solveNQueensUtil(board, 0)) {
      printSolution(board);
    } else {
      System.out.println("Solusi tidak ditemukan.");
    }
  }

  private static boolean solveNQueensUtil(int[][] board, int col) {
    if (col >= N) return true;

    for (int i = 0; i < N; i++) {
      if (isSafe(board, i, col)) {
        board[i][col] = 1;
        if (solveNQueensUtil(board, col + 1)) return true;
        board[i][col] = 0;
      }
    }

    return false;
  }

  private static boolean isSafe(int[][] board, int row, int col) {
    for (int i = 0; i < col; i++) {
      if (board[row][i] == 1) return false;
    }

    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) return false;
    }

    for (int i = row, j = col; i < N && j >= 0; i++, j--) {
      if (board[i][j] == 1) return false;
    }

    return true;
  }

  private static void printSolution(int[][] board) {
    for (int[] row : board) {
      for (int cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = 5;
    solveNQueens(n);
  }
}
