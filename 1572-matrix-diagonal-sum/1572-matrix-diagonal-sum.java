class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for(int i=0;i<n;i++){

            sum += mat[i][i]; // top left to bottom right
            sum += mat[i][n-i-1]; // from top right to bottom left

        }

        if(n % 2 != 0){// if matrix is odd subtract mid element as it comes 2 time
            sum -= mat[n/2][n/2];
        }

        return sum;
    }
}