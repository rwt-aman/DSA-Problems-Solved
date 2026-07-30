class Pair{
    int ele;
    int freq;

    Pair(int ele,int freq){
        this.ele = ele;
        this.freq = freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // hashmap to store frequency of elements
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.freq - b.freq);

        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));

            if(pq.size() > k){  // keep the size equal to k store only k element
                pq.remove();
            }
        }
        // giving k size ans by copying from priority queue
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.remove().ele;
        }

        return ans;
    }
}