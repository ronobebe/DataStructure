package Algorithms.RoughDraft.Problems;

public class NQueensProblem {

  private int numberOfQueens;
  private final int placedQueens = 1;
  private int[][] nQueens;
  private int numberOfPlacedQueens = 0;

  public NQueensProblem(int numberOfQueens) {

    this.numberOfQueens = numberOfQueens;
    this.nQueens = new int[numberOfQueens][numberOfQueens];
  }

  private boolean placingConditions(int x, int y) {
    // check row index inBetween 0 and size-1;
    if (x < 0 || x > numberOfQueens - 1) return false;
    // check column index inBetween 0 and size-1;
    if (y < 0 || y > numberOfQueens - 1) return false;
    // check no other number is present in the column
    if (!checkColumn(x, y)) return false;
    // check no other number is present in the row
    if (!checkRow(x, y)) return false;

    if (!checkUpperDiagonal(x, y)) return false;

    if (!checkLowerDiagonal(x, y)) return false;


    return true;
  }

  private boolean checkRow(int x, int y) {
    for (int i = x; i < x - 1; i++) {
      if (nQueens[i][y] == placedQueens) return false;
    }
    return true;
  }
  private boolean checkUpperDiagonal(int x, int y) {
    for (int i = x, j = y; i >= 0 && j >= 0; i--, j--)
      if (nQueens[i][j] == placedQueens)
        return false;
    return true;

  }
  private boolean checkLowerDiagonal(int x, int y) {
    for (int i = x,  j = y; j >= 0 && i < numberOfQueens; i++, j--)
      if (nQueens[i][j] == placedQueens)
        return false;
    return true;
  }

  private boolean checkColumn(int x, int y) {
    for (int i = y; i < y - 1; i++) {
      if (nQueens[x][i] == placedQueens) return false;
    }
    return true;
  }

  boolean isSafe(int board[][], int row, int col)
  {
    int i, j;

    /* Check this row on left side */
    for (i = 0; i < col; i++)
      if (board[row][i] == 1)
        return false;

    /* Check upper diagonal on left side */
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
      if (board[i][j] == 1)
        return false;

    /* Check lower diagonal on left side */
    for (i = row, j = col; j >= 0 && i < numberOfQueens; i++, j--)
      if (board[i][j] == 1)
        return false;

    return true;
  }


  private boolean placeQueens(int col) {
    if (col >= numberOfQueens) return true;
    /* Consider this column and try placing
    this queen in all rows one by one */
    for (int i = 0; i < numberOfQueens; i++) {
      /* Check if the queen can be placed on
      board[i][col] */
      if (isSafe(nQueens,i, col)) {
        /* Place this queen in board[i][col] */
        nQueens[i][col] = placedQueens;

        /* recur to place rest of the queens */
        if (placeQueens(col + 1) == true) return true;

        /* If placing queen in board[i][col]
        doesn't lead to a solution then
        remove queen from board[i][col] */
        nQueens[i][col] = 0; // BACKTRACK
      }
    }
    return false;
  }

  void printSolution()
  {
    placeQueens(0);
    for (int i = 0; i < numberOfQueens; i++) {
      for (int j = 0; j < numberOfQueens; j++)
        System.out.print(" " + nQueens[i][j]
                + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    NQueensProblem nQueensProblem=new NQueensProblem(8);
    nQueensProblem.printSolution();
  }
}