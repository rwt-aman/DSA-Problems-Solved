class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev1 = 0;
        int prev2 = 0;
        int result = prev2;

        for(int i=2;i<=n;i++){
            result = Math.min(prev2 + cost[i-1] , prev1 + cost[i-2]);

            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }
}


// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;

//         int[] dp = new int[n+1];

//         dp[0] = 0;
//         dp[1] = 0;

//         for(int i=2;i<=n;i++){
//             dp[i] = Math.min(dp[i-1] + cost[i-1] , dp[i-2] + cost[i-2]);
//         }

//         return dp[n];
//     }
// }