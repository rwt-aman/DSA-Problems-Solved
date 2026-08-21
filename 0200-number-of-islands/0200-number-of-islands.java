class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(int x,int y,char[][] grid,boolean[][] vis){ // x -> row & y -> col
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        q.add(new Pair(x,y));
        vis[x][y] = true;

        while(!q.isEmpty()){
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;
            // Top -> row-1,col
            if(row > 0){
                if(vis[row-1][col] == false && grid[row-1][col] == '1'){
                    q.add(new Pair(row-1,col));
                    vis[row-1][col] = true;
                }
            }
            // Bottom -> row+1,col
            if((row+1) < m){
                if(vis[row+1][col] == false && grid[row+1][col] == '1'){
                    q.add(new Pair(row+1,col));
                    vis[row+1][col] = true;
                }
            }
            // Left -> row,col-1
            if(col > 0){
                if(vis[row][col-1] == false && grid[row][col-1] == '1'){
                    q.add(new Pair(row,col-1));
                    vis[row][col-1] = true;
                }
            }
            // Right -> row,col+1
            if((col+1) < n){
                if(vis[row][col+1] == false && grid[row][col+1] == '1'){
                    q.add(new Pair(row,col+1));
                    vis[row][col+1] = true;
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    bfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
}