class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int rightneeded = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '('){
                rightneeded += 2;

                if(rightneeded % 2 != 0){
                    count++;
                    rightneeded--;
                }    
            }
            else{
                rightneeded--;

                if(rightneeded < 0){
                    count++;
                    rightneeded = 1;
                }
            }
        }

        return count + rightneeded;
    }
}