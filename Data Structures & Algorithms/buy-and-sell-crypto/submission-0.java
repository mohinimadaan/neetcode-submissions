class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];
        for(int j = 1; j < prices.length; j++){
            int currP = prices[j]-minBuy;
            maxP = Math.max(maxP,currP);
            minBuy = Math.min(minBuy,prices[j]);
        }
        return maxP;

        
    }
}
