class Solution {
    public void bfs(int srt,int[][] mat,boolean[] vis){
        Queue<Integer> q = new LinkedList<>();

        q.add(srt);
        vis[srt] = true;

        while(!q.isEmpty()){
            int front = q.remove();

            for(int i=0;i<mat.length;i++){
                if(mat[front][i] == 1 && vis[i] == false){
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] vis = new boolean[n+1];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,isConnected,vis);
                count++;
            }
        }

        return count;
    }
}