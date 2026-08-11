class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            map.put(ch,map.get(ch)-1); //decreasing the value of current key(ch)

            if(st.contains(ch)) continue;
            
            while(!st.isEmpty() && st.peek() > ch && map.get(st.peek()) > 0){
                st.pop();
            }

            st.push(ch);
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}