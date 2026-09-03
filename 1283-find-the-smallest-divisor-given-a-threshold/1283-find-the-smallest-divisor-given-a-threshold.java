class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0;
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            high = Math.max(nums[i],high);
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(helper(nums,n,threshold,mid)){ // mid<threshold
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean helper(int[] nums,int n, int threshold, int divisor) {
        int ans = 0;

        for(int i=0;i<n;i++){
            ans = ans + (int) Math.ceil((float)nums[i]/divisor);
            if(ans > threshold) return false;
        }
        return true;
    }
}