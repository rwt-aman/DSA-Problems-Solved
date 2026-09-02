class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = m - 1, j = 0;

        int res = 0;

        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                res += n - j;
                i--;
            } else
                j++;
        }

        return res;
    }
}


// class Solution {
//     public int countNegatives(int[][] grid) {
//         int count = 0;

//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[i].length;j++){
//                 if(grid[i][j] < 0){
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }