class Solution {
    public void bfs(int srt,boolean[] vis,List<List<Integer>> rooms){
        Queue<Integer> q = new LinkedList<>();
        q.add(srt);

        while(!q.isEmpty()){
            int front = q.remove();

            for(int ele : rooms.get(front)){
                if(!vis[ele]){
                    vis[ele] = true;
                    q.add(ele);
                }
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;

        bfs(0,vis,rooms);

        for(boolean ele : vis){
            if(ele == false){
                return false;
            }
        }

        return true;
    }
}