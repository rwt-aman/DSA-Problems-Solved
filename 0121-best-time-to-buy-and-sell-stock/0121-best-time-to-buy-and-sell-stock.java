class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int buy = prices[0];

        for(int i=1;i<prices.length;i++){
            int currentprofit = prices[i] - buy;

            if(currentprofit < 0){
                buy = prices[i];
            }

            maxprofit = Math.max(maxprofit,currentprofit);
        }
        return maxprofit;
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         int profit = 0;
//         int buyprice = prices[0];

//         for(int i=1;i<prices.length;i++){
//             if(buyprice > prices[i]){
//                 buyprice = prices[i];
//             }
//             else{
//                 int current_profit = prices[i] - buyprice;
//                 profit = Math.max(profit,current_profit);
//             }
//         }
//         return profit;
//     }
// }