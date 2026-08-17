class Solution { // optimized
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int right=0;right<nums.length;right++){
            sum += nums[right];
            
            while(sum >= target){
                min = Math.min(min,right-left+1);

                sum -= nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}



// class Solution { // brute force
//     public int minSubArrayLen(int target, int[] nums) {
//         int min = 0;

//         for(int i=0;i<nums.length;i++){
//             int sum = 0;
//             for(int j=i;j<nums.length;j++){
//                 sum += nums[j];

//                 if(sum >= target){
//                     int len = j - i + 1;

//                     if(min == 0 || min > len){
//                         min = len;
//                     }
//                     break;
//                 }
//             }
//         }
//         return min;
//     }
// }