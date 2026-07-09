class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];

        //one half will be sorted , and other will be unsorted
        //min will be in unsorted

        while(left <= right){
            int mid = left +(right - left)/2;
            if(nums[mid] < min){
                min = nums[mid];
            }else if(nums[mid] > nums[right]){//right is unsorted
                left = mid+1;
            }else{//left is sorted
                right = mid-1;
            }

        }
        return min;
    }
}
