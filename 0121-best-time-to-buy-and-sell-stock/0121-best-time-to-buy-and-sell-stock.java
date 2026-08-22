class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int buyprice = prices[0];
        int current = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] < buyprice){
                buyprice = prices[i];
            }
            else{ // selling
                current = prices[i] - buyprice;
            }

            maxprofit = Math.max(maxprofit,current);
        }

        return maxprofit;
    }
}