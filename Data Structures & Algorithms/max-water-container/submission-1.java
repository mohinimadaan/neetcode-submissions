class Solution {
    public int maxArea(int[] heights) {

        //bruteforce
        //int maxArea = 0;
        //for(int i = 0; i< heights.length; i++){
            //for(int j = i+1; j< heights.length; j++){
                //int length = Math.min(heights[i],heights[j]);
                //int breadth = j -i;
                //maxArea = Math.max(maxArea,length*breadth);
            //}
        //}

        //return maxArea;
        
        //2 pointers
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;

        while(left<right){
            int length = Math.min(heights[left], heights[right]);
            int breadth = right - left;
            maxArea = Math.max(maxArea, length * breadth);
            if(heights[left]<=heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;


    }
}
