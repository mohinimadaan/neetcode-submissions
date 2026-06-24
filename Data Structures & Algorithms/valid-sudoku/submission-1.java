class Solution {
    public boolean isValidSudoku(char[][] board) {

        //checking for each row
        //for(int r = 0; r<9; r++){
            //Set<Character> seen = new HashSet<>();
            //for(int c = 0; c<9; c++){
                //if(board[r][c]=='.')
                    //continue;
                //if(seen.contains(board[r][c])){
                    //return false;
                //}
                //seen.add(board[r][c]);
            //}
        //}

        //checking for each col
        //for(int c = 0; c<9; c++){
            //Set<Character> seen = new HashSet<>();
            //for(int r = 0; r<9; r++){
                //if(board[r][c]=='.')
                    //continue;
                //if(seen.contains(board[r][c])){
                    //return false;
                //}
                //seen.add(board[r][c]);
            //}
        //}

        //checking for each box
        //for(int sq = 0; sq<9; sq++){
            //Set<Character> seen = new HashSet<>();
            //for(int i = 0; i<3; i++){
                //for(int j = 0; j<3; j++){
                    //int row = (sq/3)*3 +i;
                    //int col = (sq%3)*3 +j;

                    //if(board[row][col]=='.')
                        //continue;

                    //if(seen.contains(board[row][col])){
                        //return false;
                    //}
                    //seen.add(board[row][col]);
                    
                //}

            //}
        //}
        //return true;



        //checking in one pass
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];

        for(int r = 0; r<9; r++){
            for(int c = 0; c<9; c++){
                if(board[r][c]=='.'){
                    continue;
                }

                int val = board[r][c]-'1';

                if(rows[r][val]==1){
                    return false;
                }
                rows[r][val] = 1;

                if(cols[c][val]==1){
                    return false;
                }
                cols[c][val] = 1;

                int boxId = (r/3)*3 + c/3;
                if(boxes[boxId][val]==1){
                    return false;
                }
                boxes[boxId][val] = 1;

            }
        }
        return true;
}
}










