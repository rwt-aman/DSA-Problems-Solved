class Solution { // Optimized using stack   
    public int[] previoussmaller(int[] arr){ // saving index
        int[] ps = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<arr.length;i++){ // putting -1(index) for leftsmaller if not found

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ps[i] = -1;
            }
            else{
                ps[i] = st.peek();
            }

            st.push(i); // index pushing
        }

        return ps;
    }

    public int[] nextsmaller(int[] arr){ // saving index
        int[] ns = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ns[i] = arr.length;
            }
            else{
                ns[i] = st.peek();
            }

            st.push(i); // index pushing
        }

        return ns;
    }
    
    public int largestRectangleArea(int[] heights) {
        int[] ps = previoussmaller(heights);
        int[] ns = nextsmaller(heights);

        int maxarea = Integer.MIN_VALUE;

        for(int i=0;i<heights.length;i++){
            int currmax = (ns[i] - ps[i] - 1) * heights[i];

            maxarea = Math.max(maxarea,currmax);
        } 

        return maxarea;
    }
}



// class Solution { // Brute force :- TC:-O(n^2)
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int maxarea = Integer.MIN_VALUE;

//         for(int i=0;i<n;i++){
//             int left = i;
//             int right = i;

//             while(left >= 0 && heights[left] >= heights[i]){
//                 left--;
//             }
//             while(right < n && heights[right] >= heights[i]){
//                 right++;
//             }
//             int area = (right-left-1) * heights[i];

//             maxarea = Math.max(maxarea,area);
//         }

//         return maxarea;
//     }
// }