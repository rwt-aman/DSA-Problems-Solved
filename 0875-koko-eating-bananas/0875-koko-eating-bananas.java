class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int srt = 1; // minspeed to eat banana
        int end = Arrays.stream(piles).max().getAsInt(); // get maximum element in piles[] | max speed to eat banana
        int ans = end;

        while(srt <= end){
            int mid = srt + (end-srt) /2;
            long hours = 0;

            for(int pile : piles){
                hours += (pile + mid -1) / mid; // ceil value 
            }

            if(hours <= h){ // search left
                ans = mid;
                end = mid-1;
            }
            else{ // search right
                srt = mid+1;
            }
        }
        return ans;
    }
}