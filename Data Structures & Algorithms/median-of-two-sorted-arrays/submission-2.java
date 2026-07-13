class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //brute force = merge, sort, if odd - mid ele, if even avg of 2 mid

        // two pointers - no need to merge whole and no extra space needed

        //binary search / partition

        int[] smaller = nums1.length < nums2.length ? nums1 : nums2;
        int[] larger = nums1.length < nums2.length ? nums2 : nums1;
        int totLen = nums1.length + nums2.length;

        int low = 0;
        int high = smaller.length; // not smaller.length-1

        while(low <= high){
            int parX = (low + high)/2;
            int parY = (totLen + 1)/2 - parX;

            int l1 = parX == 0 ? Integer.MIN_VALUE : smaller[parX-1];
            int r1 = parX == smaller.length ? Integer.MAX_VALUE : smaller[parX];

            int l2 = parY == 0 ? Integer.MIN_VALUE : larger[parY-1];
            int r2 = parY == larger.length ? Integer.MAX_VALUE : larger[parY];

            if(l1<=r2 && l2<=r1){ //valid partition
                if(totLen % 2 == 0){
                    return (Math.max(l1,l2)+ Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }

            }

            if (l1>r2){
                high = parX -1;
            }else{
                low = parX + 1;
            }
        }

        return 0;
        
    }
}
