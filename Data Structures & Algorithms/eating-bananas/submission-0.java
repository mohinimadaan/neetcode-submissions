class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int minSpeed = 1;
        int maxSpeed = Arrays.stream(piles).max().getAsInt();
        int ans = maxSpeed;

        while(minSpeed <= maxSpeed){
             int midSpeed = (minSpeed + maxSpeed)/2;

             if(canEatInMidSpeed(piles, h, midSpeed)){
                ans = midSpeed;
                maxSpeed = midSpeed-1;
             }else{
                minSpeed = midSpeed +1;
             }

        }

        return ans;
        
    }

    private boolean canEatInMidSpeed(int[] piles, int h, int midSpeed){
        int totalTime = 0;

        for(int p : piles){
            totalTime += Math.ceil((double) p/midSpeed);
        }

        return totalTime <= h;
    }
}
