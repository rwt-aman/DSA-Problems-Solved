class Solution { // optimized
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int sum = 0;
        int maxsum = 0;
        
        for(int right=0;right<nums.length;right++){

            while(!set.isEmpty() && set.contains(nums[right])){
                set.remove(nums[left]); // remove element from set
                sum = sum - nums[left];
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];

            maxsum = Math.max(maxsum,sum);
        }

        return maxsum;
    }
}


// class Solution { // brute force
//     public int maximumUniqueSubarray(int[] nums) {
//         int maxSum = 0;

//         for (int i = 0; i < nums.length; i++) {
//             HashSet<Integer> set = new HashSet<>();
//             int sum = 0;

//             for (int j = i; j < nums.length; j++) {

//                 if (set.contains(nums[j])) {
//                     break;
//                 }

//                 set.add(nums[j]);
//                 sum += nums[j];

//                 maxSum = Math.max(maxSum, sum);
//             }
//         }

//         return maxSum;
//     }
// }