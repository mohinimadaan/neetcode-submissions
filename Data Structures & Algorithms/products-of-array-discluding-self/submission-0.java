class Solution {
    public int[] productExceptSelf(int[] nums) {

        //bruteforce
        int n = nums.length;
        int[] prodArr = new int[n];

        for(int i = 0;i<nums.length;i++){
            int prod = 1;
            for(int j = 0;j<nums.length;j++){
                if(i!=j){
                    prod = prod*nums[j];

                }
                
            }
            prodArr[i] = prod;
        }
        return prodArr;
    }
}  
