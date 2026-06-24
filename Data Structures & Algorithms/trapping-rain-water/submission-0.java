class Solution {
    public int trap(int[] height) {
        
        //brute force
        //int sum = 0;
        //int n = height.length;
        //for(int i = 0 ; i < n; i++){
           //int leftMax = height[i];
           //int rightMax = height[i];

            //for(int j = 0 ; j<i; j++){
                //leftMax = Math.max(leftMax,height[j]);
            //}

            //for(int k = i+1 ; k<n; k++){
                //rightMax = Math.max(rightMax,height[k]);
            //} 

            //sum = sum + Math.min(leftMax, rightMax) - height[i];

        //}

        //return sum;
        
        //prefix array to keep left max and suffix array to keep max right == not implementing

        //2pointer
        int start = 0;
        int end = height.length-1;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(start < end){
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);
            if(leftMax < rightMax){
                sum = sum+(leftMax-height[start]);
                start++;
            }else{
                sum = sum + (rightMax - height[end]);
                end--;

            }

        }
        return sum;
    }
}
