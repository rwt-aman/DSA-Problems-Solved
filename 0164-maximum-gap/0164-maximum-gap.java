class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;

        int maxdiff = 0;
        Arrays.sort(nums);

        for(int i=1;i<nums.length;i++){
            maxdiff = Math.max(maxdiff,(nums[i] - nums[i-1]));
        }

        return maxdiff;
    }
}