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
        //if(nums== null || nums.length == 0){
            //return 0;
        //}
        //Arrays.sort(nums);

        //int longestLen = 0;
        //int currentLen = 1;

        //for(int i = 1; i< nums.length; i++){
            
            //if(nums[i] != nums[i-1]){ //Skip duplicate numbers
                //if(nums[i] == nums[i-1]+1){
                    //currentLen++;
                //}else{
                    //longestLen = Math.max(longestLen, currentLen);
                    //currentLen = 1;
                //}

            //}

        //}
        //return Math.max(longestLen, currentLen);

        //using hashmap
        Map<Integer,Boolean> hmap = new HashMap<>();
        int longestLen = 0;
        for(int num : nums){
            hmap.put(num, Boolean.FALSE);
        }

        for(int num : nums){
            int currentLen = 1;

            //check for forward numbers
            int nextNum = num + 1;
            while(hmap.containsKey(nextNum) && hmap.get(nextNum)== false){
                currentLen++;
                hmap.put(nextNum, Boolean.TRUE);
                nextNum++;
            }

            //check for previous numbers
            int prevNum = num - 1;
            while(hmap.containsKey(prevNum) && hmap.get(prevNum)== false){
                currentLen++;
                hmap.put(prevNum, Boolean.TRUE);
                prevNum--;
            }

            longestLen = Math.max(longestLen,currentLen );
        }

        return longestLen;
    }
}
