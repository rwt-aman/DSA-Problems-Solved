class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long maxsum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k) {
            maxsum = sum;
        }

        for (int i = k; i < nums.length; i++) {
            // Remove outgoing element
            sum -= nums[i - k];

            map.put(nums[i - k], map.get(nums[i - k]) - 1);

            if (map.get(nums[i - k]) == 0) {
                map.remove(nums[i - k]);
            }

            // Add incoming element
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // All k elements are distinct
            if (map.size() == k) {
                maxsum = Math.max(maxsum, sum);
            }
        }

        return maxsum;
    }
}