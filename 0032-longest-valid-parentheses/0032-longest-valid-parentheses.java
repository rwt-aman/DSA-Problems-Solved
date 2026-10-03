class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        int start = 0;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') {
                st.push(i);
            }
            else {

                if(!st.isEmpty()) {
                    st.pop();

                    if(st.isEmpty()) {
                        count = Math.max(count, i - start + 1);
                    }
                    else {
                        count = Math.max(count, i - st.peek());
                    }
                }
                else {
                    start = i + 1;
                }
            }
        }

        return count;
    }
}