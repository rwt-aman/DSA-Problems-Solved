class Solution { // no extra space
    public int kthSmallest(int[][] matrix, int k) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                
                pq.add(matrix[i][j]);

                if(pq.size() > k){
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }
}



// extra space

// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         int[] arr = new int[matrix.length * matrix[0].length];
//         // putting value of matrix in arr
//         int idx = 0;
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[0].length;j++){
//                 arr[idx++] = matrix[i][j];
//             }
//         }
//         // max heap
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

//         for(int num : arr){
//             pq.add(num);

//             if(pq.size() > k){
//                 pq.remove();
//             }
//         }
//         return pq.peek();
//     }
// }