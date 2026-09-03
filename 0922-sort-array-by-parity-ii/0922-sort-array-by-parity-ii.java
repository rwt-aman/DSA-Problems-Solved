class Solution { // TC -> O(N) and SC -> O(1)
    public int[] sortArrayByParityII(int[] nums) {
        int evenidx = 0;
        int oddidx = 1;

        while(evenidx < nums.length && oddidx < nums.length){
            if(nums[evenidx] % 2 == 0){
                evenidx += 2;
            }
            else if(nums[oddidx] % 2 == 1){
                oddidx += 2;
            }
            else{
                int temp = nums[evenidx];
                nums[evenidx] = nums[oddidx];
                nums[oddidx] = temp;

                evenidx += 2;
                oddidx += 2;
            }
        }

        return nums;
    }
}



// class Solution { // TC -> O(N) and SC -> O(N)
//     public int[] sortArrayByParityII(int[] nums) {
//         int[] temp = new int[nums.length];
//         int evenidx = 0;
//         int oddidx = 1;

//         for(int i=0;i<nums.length;i++){
//             if(nums[i] % 2 == 0){ // even
//                 temp[evenidx] = nums[i];
//                 evenidx += 2;
//             }
//             else{ // odd
//                 temp[oddidx] = nums[i];
//                 oddidx += 2;
//             }
//         }
        
//         return temp;
//     }
// }