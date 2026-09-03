class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] temp = new int[nums.length];
        int evenidx = 0;
        int oddidx = 1;

        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 == 0){ // even
                temp[evenidx] = nums[i];
                evenidx += 2;
            }
            else{ // odd
                temp[oddidx] = nums[i];
                oddidx += 2;
            }
        }
        
        return temp;
    }
}