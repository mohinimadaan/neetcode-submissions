class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N-k+1];
        int pos = 0;

        int start = 0;
        int end = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        while(end < N){

            while(!dq.isEmpty() && dq.peekLast() < nums[end]){
                dq.pollLast();
            }
            dq.addLast(nums[end]);

            if(end-start+1 < k){
                end++;
            }else if(end-start+1 == k){
                res[pos] = dq.peekFirst();
                pos++;

                //slide window
                if(!dq.isEmpty() && nums[start] == dq.peekFirst()){
                    dq.pollFirst();
                }
                start++;

                end++;
            }

        }


        return res;
        
    }
}
