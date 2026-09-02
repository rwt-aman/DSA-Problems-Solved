class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;

        int srt = 1;
        int end = num / 2;

        while(srt <= end){
            int mid = srt + (end-srt)/2;
            long square = (long) mid * mid;

            if(square == num){
                return true;
            }
            else if(square > num){
                end = mid-1;
            }
            else{
                srt = mid+1;
            }
        }

        return false;
    }
}