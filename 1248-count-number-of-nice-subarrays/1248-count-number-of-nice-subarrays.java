class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        // odd -> 1, even -> 0
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}