/*
Date: 2016.1.19
*/
public class SolveSudoku {
    public static void main(String[] args) {
        String[] strs =                    {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
        
        char[][] board = new char[9][9];
        int i=0;
        for (String str : strs) {
            
            char[] ca= str.toCharArray();
            for(int j=0; j<9; j++) {
                board[i][j] = ca[j];
                System.out.printf("%c", board[i][j]);
                
            }
            System.out.println();
            i++;
        }

        System.out.println();        
        solveSudoku(board);
      
        
        
    }

    public static void solveSudoku(char[][] board) {
        char[][] output = new char[9][9];
           if(board == null || board.length == 0)
               return;
           solve(board);
       }

    public static boolean solve(char[][] board) {
        // Ref: https://leetcode.com/discuss/30482/straight-forward-java-solution-using-backtracking
        // Try 1 through 9 for each cell.  Using backtracking
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char c ='1'; c <='9'; c++) {
                    
                        if (isValid(board, i, j , c)) { // Trial. Try 1 through 9 for each cell
                            board[i][j] = c;   // Put c for the cell
                            if (solve(board)) {
                                return true; // If it's the solution return true
                            } else
                                board[i][j] = '.';  // Otherwise go back
                        } 
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isValid(char[][] board, int i, int j, char c) {
        // check column
        for(int row= 0; row < 9; row++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        
        // check row 
        for(int col=0; col < 9; col++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        
        // check 3 x 3 block
        for (int row = (i/3)*3; row <(i/3)*3 + 3; row++) {
            for(int col = (j/3)*3; col <(j/3)*3 +3 ; col++) {
                if (board[row][col] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}