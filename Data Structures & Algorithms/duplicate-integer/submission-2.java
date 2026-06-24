class Solution {
    public boolean hasDuplicate(int[] nums) {
        //brute force
        //for(int i = 0; i< nums.length; i++){
            //for(int j = i+1; j< nums.length; j++){
                //if(nums[i] == nums[j]){
                    //return true;
                //}
            //}
        //}
        //return false;

        //Sorting
        Arrays.sort(nums);
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;

        //HashSet length
        //return Arrays.stream(nums).distinct().count() < nums.length;
        
    }
}