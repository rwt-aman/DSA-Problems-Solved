class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            int charindex = 'z' - ch + 1; // from this we will get character exact value eg:- a-26
        
            int value = i + 1; // character index eg:- a = 0+1=1, b = 1+1=2 ...so on

            sum += (charindex * value);
        }

        return sum;
    }
}