class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int r = 0; r<9; r++){
            Set<Character> seen = new HashSet<>();
            for(int c = 0; c<9; c++){
                if(board[r][c]=='.')
                    continue;
                if(seen.contains(board[r][c])){
                    return false;
                }
                seen.add(board[r][c]);
            }
        }

        for(int c = 0; c<9; c++){
            Set<Character> seen = new HashSet<>();
            for(int r = 0; r<9; r++){
                if(board[r][c]=='.')
                    continue;
                if(seen.contains(board[r][c])){
                    return false;
                }
                seen.add(board[r][c]);
            }
        }

        for(int sq = 0; sq<9; sq++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    int row = (sq/3)*3 +i;
                    int col = (sq%3)*3 +j;

                    if(board[row][col]=='.')
                        continue;

                    if(seen.contains(board[row][col])){
                        return false;
                    }
                    seen.add(board[row][col]);
                    
                }

            }
        }
        return true;
}
}










