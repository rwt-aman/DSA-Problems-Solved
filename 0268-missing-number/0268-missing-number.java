class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int actualsum = 0;
        for(int num : nums){
            actualsum += num;
        }
        int expectedsum = n * (n + 1) / 2;

        int missingno = expectedsum - actualsum;

        return missingno;
    }
}