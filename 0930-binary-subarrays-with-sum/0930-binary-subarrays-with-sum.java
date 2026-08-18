class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            // All subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}


// class Solution { // brute force
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int count = 0;

//         for(int i=0;i<nums.length;i++){
//             int sum = 0;

//             for(int j=i;j<nums.length;j++){
//                 sum += nums[j];

//                 if(sum == goal){
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }
