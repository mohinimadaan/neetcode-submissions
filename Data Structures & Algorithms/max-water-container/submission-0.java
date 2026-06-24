class Solution {
    public int maxArea(int[] heights) {

        //bruteforce
        int maxArea = 0;
        for(int i = 0; i< heights.length; i++){
            for(int j = i+1; j< heights.length; j++){
                int length = Math.min(heights[i],heights[j]);
                int breadth = j -i;
                maxArea = Math.max(maxArea,length*breadth);
            }
        }

        return maxArea;
        
    }
}
