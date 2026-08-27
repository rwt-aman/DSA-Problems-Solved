class Solution { // solving using queue 
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++){ // adding in queue
            q.add(i);
        }
        // removing n-k element and adding in queue 
        while(q.size() != 1){
            for(int i=0;i<k-1;i++){ // moving k-1 element to back (q again)
                q.add(q.remove());
            }

            q.remove(); // exact element to remove 
        }

        return q.peek();
    }
}