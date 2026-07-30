class Pair{
    int value;
    int x;
    int y;

    Pair(int value,int x,int y){
        this.value = value;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.value - a.value);

        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];

            int dist = x*x + y*y;

            pq.add(new Pair(dist,x,y));

            if(pq.size() > k){
                pq.remove();
            }
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();

            ans[idx][0] = p.x;
            ans[idx][1] = p.y;
            
            idx++;
        }

        return ans;
    }
}