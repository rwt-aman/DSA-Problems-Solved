class Solution {
    public int maximumGap(int[] nums) {

        if (nums.length < 2) return 0;

        int n = nums.length;

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // All numbers are same
        if (min == max) return 0;

        int bucketSize = Math.max(1, (max - min) / (n - 1));

        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        boolean[] used = new boolean[bucketCount];

        // Put numbers into buckets
        for (int num : nums) {

            int index = (num - min) / bucketSize;

            if (!used[index]) {
                bucketMin[index] = num;
                bucketMax[index] = num;
                used[index] = true;
            } else {
                bucketMin[index] = Math.min(bucketMin[index], num);
                bucketMax[index] = Math.max(bucketMax[index], num);
            }
        }

        // Find maximum gap between buckets
        int maxdiff = 0;
        int previousMax = min;

        for (int i = 0; i < bucketCount; i++) {

            if (!used[i]) continue;

            maxdiff = Math.max(maxdiff, bucketMin[i] - previousMax);

            previousMax = bucketMax[i];
        }

        return maxdiff;
    }
}


// class Solution { // brute force
//     public int maximumGap(int[] nums) {
//         if(nums.length < 2) return 0;

//         int maxdiff = 0;
//         Arrays.sort(nums);

//         for(int i=1;i<nums.length;i++){
//             maxdiff = Math.max(maxdiff,(nums[i] - nums[i-1]));
//         }

//         return maxdiff;
//     }
// }