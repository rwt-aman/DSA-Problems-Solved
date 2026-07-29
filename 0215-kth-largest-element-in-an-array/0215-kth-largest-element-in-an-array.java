class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int arr : nums){
            pq.add(arr);
        }

        for(int i=0;i<k-1;i++){
            pq.remove();
        }

        return pq.peek();
    }
}