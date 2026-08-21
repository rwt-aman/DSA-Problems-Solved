class Solution {
    public void rotate(int[] nums, int k) { // Right rotate
        int n = nums.length;
        int i = 0;
        int j = n-1;

        k = k % n;

        // Revering first 0 to n-k-1 element(from the right)
        Reverse(nums,i,n-k-1);

        // Reversing n-k to n-1 elements
        Reverse(nums,n-k,n-1);

        // Reverse whole array
        Reverse(nums,i,j);
    }

    public static void Reverse(int[] nums,int srt,int end){
        while(srt < end){
            int temp = nums[srt];
            nums[srt] = nums[end];
            nums[end] = temp;
            srt++;
            end--;
        }
    }
}