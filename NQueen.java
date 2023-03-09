public class NQueen {
    static int count=0;
    public static boolean isSafe(char chess[][],int row,int col){
        //vertical up
        for (int i=row-1;i>=0;i--){
            if(chess[i][col]=='Q'){
                return false;
            }
        }
        //dial left
        for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(chess[i][j]=='Q'){
                return false;
            }
        }

        //diag right
        for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++){
            if (chess[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }
    public static void nQueens(char chess[][],int row){
        //base
        if(row== chess.length){
//            printBoards(chess);
            count++;
            return;
        }

        //logic
        for (int j=0;j< chess.length;j++){
            if (isSafe(chess,row,j)){
                chess[row][j]='Q';
                nQueens(chess,row+1);
                chess[row][j]='x';
            }

        }
    }

    public static boolean nQueens_1_solution(char chess[][],int row){
        //base
        if(row== chess.length){
            count++;
            return true;
        }

        //logic
        for (int j=0;j< chess.length;j++){
            if (isSafe(chess,row,j)){
                chess[row][j]='Q';
                if(nQueens_1_solution(chess,row+1)){
                    return true;
                }
                chess[row][j]='x';
            }
        }
        return false;
    }
    public static void printBoards(char chess[][]){
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int n=4;
        char board[][]=new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j=0;j<n;j++){
                board[i][j]='x';
            }
        }
        nQueens(board,0);
        System.out.println("Total ways are "+count);

        if(nQueens_1_solution(board,0)){
            System.out.println("Possible solution is :");
            printBoards(board);
        }else {
            System.out.println("No solution found");
        }
    }
}
