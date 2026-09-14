class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        char p = 0;
        char q = 0;

        while(p < word1.length() && q < word2.length()){
            ans.append(word1.charAt(p));
            ans.append(word2.charAt(q));
            p++;
            q++;
        }

        while(p < word1.length()){
            ans.append(word1.charAt(p));
            p++;
        }
        
        while(q < word2.length()){
            ans.append(word2.charAt(q));
            q++;
        }

        return ans.toString();        
    }
}