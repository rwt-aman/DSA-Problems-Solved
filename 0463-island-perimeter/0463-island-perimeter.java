class Solution { // simplest without using BFS and DFS
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 0) continue; // water so skip it

                // grid[i][j] == 1 so

                if(i-1 < 0 || grid[i-1][j] != 1){ // checking top
                    count++;
                }

                if(j-1 < 0 || grid[i][j-1] != 1){ // checking left
                    count++;
                }

                if(i+1 >= row || grid[i+1][j] != 1){ // checking bottom
                    count++;
                }

                if(j+1 >= col || grid[i][j+1] != 1){ // checking right
                    count++;
                }
            }
        }

        return count;
    }
}



// class Solution { // DFS approach we can also use BFS approach to solve it 
//     public int islandPerimeter(int[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;

//         for(int i=0;i<row;i++){
//             for(int j=0;j<col;j++){
//                 if(grid[i][j] == 1){
//                     return dfs(grid,i,j,row,col);
//                 }
//             }
//         }
//         return 0;
//     }

//     public int dfs(int[][] grid,int i,int j, int row,int col){
//         // Outside grid or water = one boundary
//         if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0){
//             return 1;
//         }

//         if(grid[i][j] == -1){ // already marked
//             return 0; 
//         }

//         grid[i][j] = -1; // mark visited

//         int count = 0;

//         // now calling dfs for left | right | bottom | top

//         count += dfs(grid,i+1,j,row,col); // bottom
//         count += dfs(grid,i-1,j,row,col); // top
//         count += dfs(grid,i,j+1,row,col); // right
//         count += dfs(grid,i,j-1,row,col); // left

//         return count;
//     }
// }