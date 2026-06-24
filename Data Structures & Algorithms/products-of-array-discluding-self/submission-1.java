class Solution {
    public int[] productExceptSelf(int[] nums) {

        //bruteforce
        //int n = nums.length;
        //int[] prodArr = new int[n];

        //for(int i = 0;i<nums.length;i++){
            //int prod = 1;
            //for(int j = 0;j<nums.length;j++){
                //if(i!=j){
                    //prod = prod*nums[j];

                //}
                
            //}
            //prodArr[i] = prod;
        //}
        //return prodArr;

        //Prefix , postfix
        int n = nums.length;
        int[] prodArr = new int[n];
        int[] preArr = new int[n];
        int[] postArr = new int[n];

        preArr[0]=1;
        postArr[n-1]=1;
        for(int i = 1; i<n; i++){
            preArr[i] = preArr[i-1]*nums[i-1];
        }

        for(int i = n-2; i>=0; i--){
            postArr[i] = postArr[i+1]*nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            prodArr[i] = preArr[i] * postArr[i];
        }

        return prodArr;
    }
}  
