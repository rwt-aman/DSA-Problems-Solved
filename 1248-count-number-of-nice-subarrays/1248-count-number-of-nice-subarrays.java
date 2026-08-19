class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        // Step 1: odd -> 1, even -> 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }

        // Step 2: sliding window
        int count = 0;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                int temp = left;

                // Count additional starting positions caused by zeros
                while (temp <= right && nums[temp] == 0) {
                    count++;
                    temp++;
                }

                count++;
            }
        }

        return count;
    }
}