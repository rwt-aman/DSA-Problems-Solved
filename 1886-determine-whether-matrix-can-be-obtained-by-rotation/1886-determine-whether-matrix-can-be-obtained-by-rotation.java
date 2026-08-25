class Solution {

    public boolean findRotation(int[][] mat, int[][] target) {

        for (int rotation = 0; rotation < 4; rotation++) {

            // Check if current matrix matches target
            if (isEqual(mat, target)) {
                return true;
            }

            // Rotate mat by 90 degrees clockwise
            rotate(mat);
        }

        return false;
    }

    public void rotate(int[][] mat) {
        int n = mat.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse every row
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;

            while (start < end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;

                start++;
                end--;
            }
        }
    }

    public boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}