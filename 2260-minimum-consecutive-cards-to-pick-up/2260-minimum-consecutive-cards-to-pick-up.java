class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i=0;i<cards.length;i++){
            
            if(map.containsKey(cards[i])){
                int len = i - map.get(cards[i]) + 1;
                min = Math.min(min,len);
            }
            
            map.put(cards[i],i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}