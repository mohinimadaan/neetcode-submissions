class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        //1. brute force o(m*n)
        //2. binary search over each row m*o(logn)

        //3. binary search , find potential row, then search over that row logn + logm = log(m*n)
        //search potential row
        int row = searchPotentialRow(matrix, target);
        if(row != -1){
            return searchInRow(row, matrix, target);
        }else{
            return false;
        }

        

        

        
    }

    private int searchPotentialRow(int[][] matrix, int target){

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0; int bot = m-1;
        while(top <= bot){
            int mid = top + (bot - top)/2;

            //if target within row first and last element
            if(matrix[mid][0] <= target && target <= matrix[mid][n-1]){
                return mid;
            }else if(matrix[mid][0] < target){
                top = mid+1;
            }else if(matrix[mid][0] > target){
                bot = mid-1;
            }
        }
        return -1;
    }

    private boolean searchInRow(int row, int[][] matrix, int target){

        int left = 0;
        int right = matrix[0].length -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
