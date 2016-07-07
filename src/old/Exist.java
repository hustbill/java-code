package old;
/*
  https://leetcode.com/problems/word-search/
*/
public class Exist {
    public static void main(String[] args) {
        char[][] board = { {'A', 'B', 'C', 'E'}, 
         {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        
        String[] words = { "ABCCED", "SEE", "ABCB"};
        
        for (String word:  words) {
            System.out.printf(" %s exist : %b\n", word, exist(board, word));
        }
    }
    
    public static boolean exist(char[][] board, String word) {
        for(int i=0; i< board.length; i++) {
            for (int j=0; j < board[i].length; j++) {
                if (exist(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    private static boolean exist(char[][] board, int x, int y, String word, int start) {
        if (start >= word.length()) return true;
        if (x < 0 || x >= board.length || y<0 || y >= board[0].length) return false;
        
        if (board[x][y] == word.charAt(start++)) {
            char c = board[x][y];
            board[x][y] = '#';
            boolean res = exist(board, x +1, y , word, start) 
                || exist(board, x-1, y, word, start)
                || exist(board, x, y+1, word, start)
                || exist(board, x, y-1, word, start);
            board[x][y] = c;
            return res;
        }
        return false;
        
    }
}