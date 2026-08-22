class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int mid = (n + 1) / 2;
        int left = mid - 1;
        int right = n - 1;

        // Fill nums in wiggle fashion: nums[0] < nums[1] > nums[2] < nums[3]...
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--];  // Smaller half (reversed)
            } 
            else {
                nums[i] = sorted[right--]; // Larger half (reversed)
            }
        }
    }   
}