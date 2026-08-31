/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int srt = 1;
        int end = n;

        while(srt <= end){
            int mid = srt + (end-srt)/2;

            int pick = guess(mid);

            if(pick == 0){
                return mid;
            }
            else if(pick == -1){ // -1 -> mid > pick
                end = mid - 1;
            }
            else{ // 1 -> mid < pick
                srt = mid + 1;
            }
        }

        return -1;
    }
}