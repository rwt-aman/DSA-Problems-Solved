class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);

        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1;i>=0;i--){ // 2*n because of circular loop and [i%n] help to match the index

            // Remove smaller elements
            while(!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }

            // If something greater exists
            if(!st.isEmpty()){
                ans[i%n] = st.peek();
            }

             // Push current element
            st.push(nums[i%n]);
        }

        return ans;
    }
}