public class Nqueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board=new boolean[n][n];
        queens(board,0);
    }

    static void queens(boolean[][] board,int row)
    {
        if(row==board.length)
        {
            display(board);
            System.out.println();
            return ;
        }

        for(int col=0;col<board[0].length;col++)
        {
            if(IsSafe(board,row,col))
            {
                board[row][col]=true;
                queens(board,row+1);
                board[row][col]=false;
            }
        }

        return;

    }

    static boolean IsSafe(boolean[][] board,int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i][col])
            {
                return false;
            }

        }

        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++)
        {
            if(board[row-i][col-i])
            {
                return false;
            }
        }

        int maxRight=Math.min(row,board.length-col-1);
        for(int i=1;i<=maxRight;i++)
        {
            if(board[row-i][col+i])
            {
                return false;
            }
        }

        return true;
            
    }

    static void display(boolean[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j])
                {
                    System.out.print("Q");
                }
                else
                System.out.print("X");
            }
            System.out.println();
        }
    }
}
