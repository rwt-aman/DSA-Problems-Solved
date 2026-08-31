class Solution {
    public int findKthPositive(int[] arr, int k) {
        int srt = 0;
        int end  = arr.length-1;

        while(srt <= end){
            int mid = srt + (end-srt)/2;
            // missing count before arr[mid] = arr[mid] - (mid+1)
            if(arr[mid] - (mid+1) < k){
                srt = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        // srt = index where missing count first reaches k
        return srt+k;
    }
}