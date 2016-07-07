package architect;

import java.util.Arrays;

class Test
{
    public static void main(String[] args)
    {
       //http://stackoverflow.com/questions/14575972/how-can-i-refer-to-my-two-dimensional-boolean-array-as-a-whole
    	boolean[][] board = {{}, {}, {}};
        // all values in board are set to false by default

        boolean[][] board2 = new boolean[0][3];
        boolean[][] board3 = {{true},{true},{true, false, false}};
        boolean[][] board4 = {{}, {true}, {true, true}, {}};

        printInfo(board, 1);
        printInfo(board2, 2);
        printInfo(board3, 3);
        printInfo(board4, 4);


    }

    public static boolean check(boolean[][] board)
    {
        if(board.length == 0) return false;

        int colLength = 0;
        int elementsInBoard = 0;    

        for (int i = 0; i < board.length; i++)
        {
            colLength = board[i].length;
            elementsInBoard += colLength;
            for(int j = 0; j < colLength; j++)
            {
                if (board[i][j] == false)
                {
                    return false;
                }
            }
        }

        if (elementsInBoard == 0)
        {
            return false;
        }else
        {
            return true;
        }
    }

    public static void printInfo(boolean[][] board, int id)
    {
        System.out.println("Board : " + id);
        System.out.println(Arrays.deepToString(board)); 
        System.out.println(check(board));       
    }
}