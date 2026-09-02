class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        int idx = 0;

        for(int i=0;i<m;i++){
            int oneinrow = 0;
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1){
                    oneinrow++;
                }
            }
            if(oneinrow > count){
                idx = i;
            }
            count = Math.max(count,oneinrow);
        }

        return new int[]{idx,count};
    }
}