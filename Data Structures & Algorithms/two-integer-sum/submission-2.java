class Solution {
    public int[] twoSum(int[] nums, int target) {
        //brute force
        //for(int i = 0; i< nums.length;i++){
            //for(int j = i+1; j< nums.length;j++){
                //if(nums[i]+nums[j] == target){
                    //return new int[]{i,j};
                //}
            //}        
        //}
        //return new int[0];

        // Sorting n two pointer will change the original index 
        //so we need to store values with index before sorting
        //int[][] valueWithIndex = new int[nums.length][2];
        //for(int i = 0; i< nums.length;i++){
            //valueWithIndex[i][0] = nums[i];
            //valueWithIndex[i][1] = i;
        //}

        //Arrays.sort(valueWithIndex, (a,b)-> Integer.compare(a[0],b[0]));

        //int start = 0;
        //int end = nums.length -1;
        //while(start<end){
            //int sum = valueWithIndex[start][0] + valueWithIndex[end][0];
            //if(sum == target){
                //int index1 = valueWithIndex[start][1];
                //int index2 = valueWithIndex[end][1];
                //return new int[]{Math.min(index1,index2),Math.max(index1,index2)};


            //}else if(sum > target ){
                //end--;
            //}else if(sum < target ){
                //start++;
            //}
        //}
        //return new int[0];



        //Using Hashmap which stores value and index
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i< nums.length;i++){
            int first = nums[i];
            int second = target - first;
            if(hmap.containsKey(second)){
                return new int[]{hmap.get(second),i};
            }else{
                hmap.put(first,i);
            }
        }
        return new int[0];
    }
}
