class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest = 0;

        for(int num : set){

            if(!set.contains(num-1)){
                int current = num;
                int length = 1;

                while(set.contains(current+1)){ // it take O(1)
                    current++; //it help to check next element 
                    length++;
                }

                longest = Math.max(longest,length);
            }
        }
        
        return longest;
    }
}