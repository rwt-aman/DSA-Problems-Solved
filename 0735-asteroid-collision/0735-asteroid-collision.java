class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int num : asteroids){
            boolean alive = true;
            while(!st.isEmpty() && st.peek() > 0 && num < 0){ // negative sign is showing direction
                if(st.peek() < -num){
                    st.pop();
                }
                else if(st.peek() == -num){
                    st.pop();
                    alive = false;
                    break;
                }
                else{ // st.peek() >-num
                    alive = false;
                    break;
                }
            }

            if(alive){
                st.push(num);
            }
        }

        int[] ans = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}