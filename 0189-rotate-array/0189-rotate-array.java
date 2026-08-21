class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k = k % n; // this is for if k greater then the array size 

        // reverse  whole array
        reverse(nums,0,n-1); 
        // reverse starting k-1 elements
        reverse(nums,0,k-1);
        // reverse rest element from k to n-1
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums,int srt,int end){
        while(srt <= end){
            int temp = nums[srt];
            nums[srt] = nums[end];
            nums[end] = temp;
            srt++;
            end--;
        }
    }
}