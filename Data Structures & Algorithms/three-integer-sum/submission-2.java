class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Brute force after sorting = O(n3)
        //Arrays.sort(nums);
        //Set<List<Integer>> threeSum = new HashSet<>();

        //for(int i = 0; i< nums.length; i++){
            //if(nums[i] > 0){
                //break; // as other 2 numbes will be pos too after sorting and sum cant be 0
            //}

            //int start = i+1;
            //int end = nums.length - 1;

            //while(start < end){
                //int sum = nums[i] + nums[start] + nums[end];
                //if (sum == 0){
                    //threeSum.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    //start++;
                    //end--;
                //}else if (sum > 0){
                    //end--;
                //}else if (sum < 0){
                    //start++;
                //}
             //}

        //}

        //return new ArrayList<>(threeSum);

        //without using set to avoid duplicates
        Arrays.sort(nums);
        List<List<Integer>> threeSum = new ArrayList<>();

        for(int i = 0; i< nums.length; i++){
            if(nums[i] > 0){
                break; // as other 2 numbes will be pos too after sorting and sum cant be 0
            }

            if(i>0 && nums[i] == nums[i-1]){
                continue; //skip as this triplet has already been added in result
            }

            int start = i+1;
            int end = nums.length - 1;

            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0){
                    threeSum.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    
                    while(start < end && nums[start]==nums[start+1]){
                        start++;//skip if second element is same
                    }
                    
                    while(start < end && nums[end]==nums[end-1]){
                        end--;//skip if third element is same
                    }
                    start++;
                    end--;
                    
                }else if (sum > 0){
                    end--;
                }else if (sum < 0){
                    start++;
                }
             }

        }

        return threeSum;
        
    }
}
