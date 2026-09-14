class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = 0;

        for(int num : nums){
            ans = ans | num;
        }

        return ans * (1 << (nums.length - 1));
    }
}