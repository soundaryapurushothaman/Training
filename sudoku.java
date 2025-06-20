public class Sudoku {
    public static void main(String[] args)
    {
        int[][] board = new int[][]{
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };
        if(solve(board))
        {
            display(board);
        }
        else{
            System.out.println("cannot be solved");
        }
    }


    
    static void display(int[][] board)
    {
        for(int[] row:board)
        {
            for(int c:row)
            {
                System.out.print(c+" ");
            }
            System.out.println();
        }
        
    }

    

    static boolean solve(int[][] board)
    {
        int row=-1;
        int col=-1;
        boolean emptyleft=true;

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(board[i][j]==0)
                {
                    row=i;
                    col=j;
                    emptyleft=false;
                    break;
                }

            }
            if(!emptyleft)
            break;
        }
        if(emptyleft)
        return true;
for(int i=1;i<=9;i++)
{
    if(IsSafe(board,row,col,i))
    {
        board[row][col]=i;
        if(solve(board))
        {
          
            return true;
        }
        else{
            board[row][col]=0;
        }
    }
}
return false;
    }

    static boolean IsSafe(int[][] board,int row,int col,int number)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i][col]==number)
            {
                return false;
            }
        }

        for(int i=0;i<col;i++)
        {
            if(board[row][i]==number)
            {
                return false;
            }

        }

        int sqrt=(int)Math.sqrt(board.length);

        int rowStart=row-row%sqrt;
        int colStart=col-col%sqrt;

        for(int i=rowStart;i<rowStart+sqrt;i++)
        {
            for(int j=colStart;j<colStart+sqrt;j++)
            {
                if(board[i][j]==number)
                {
                    return false;
                }
            }
        }

        return true;

    }
}
