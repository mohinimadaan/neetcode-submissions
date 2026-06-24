class Solution {
    public int longestConsecutive(int[] nums) {

        //brute force
        //int longestLen = 0;
        //Set<Integer> numSet = new HashSet<>();
        //for(int num : nums){
            //numSet.add(num); //adding in set for O(1) lookup
        //}

        //for(int num : nums){
            //int currLen = 0; int curr = num;
            //while(numSet.contains(curr)){
                //currLen++;
                //curr++;
            //}
            //longestLen = Math.max(currLen,longestLen);
        //}
        //return longestLen;

        //hashset, check if each num is starting of seq or not
        //int longestLen = 0;
        //Set<Integer> numSet = new HashSet<>();
        //for(int num : nums){
            //numSet.add(num); //adding in set for O(1) lookup
        //}

        //for(int num : nums){
            //if(!numSet.contains(num-1)){//if left not available, means it is starting of seq
                //int currLen = 1; int curr = num;
                //while(numSet.contains(curr + 1)){
                    //curr++;
                    //currLen++;
                //}
                //longestLen = Math.max(longestLen,currLen);
            //}
        //}
        //return longestLen;


        //sorting
        if(nums== null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);

        int longestLen = 0;
        int currentLen = 1;

        for(int i = 1; i< nums.length; i++){
            
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    currentLen++;
                }else{
                    longestLen = Math.max(longestLen, currentLen);
                    currentLen = 1;
                }

            }

        }
        return Math.max(longestLen, currentLen);
    }
}
