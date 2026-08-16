class Solution {
    public int maxScore(int[] nums, int k) {
        int sum = 0;

        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        int max = sum;
        int right = nums.length-1; // right pointer
        
        for(int i=k-1;i>=0;i--){ // i can be left pointer 
            sum = sum - nums[i] + nums[right];
            right--;
            
            max = Math.max(max,sum);
        }

        return max;
    }
}