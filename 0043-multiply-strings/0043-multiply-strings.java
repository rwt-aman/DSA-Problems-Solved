class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] ans = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';

                int product = a * b;

                int position = i + j + 1;

                ans[position] += product;

                ans[position - 1] += ans[position] / 10;
                ans[position] %= 10;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int num : ans) {
            if (result.length() == 0 && num == 0) {
                continue;
            }

            result.append(num);
        }

        return result.toString();
    }
}

// class Solution { // we can not use this approach here
//     public String multiply(String num1, String num2) {
//         int a = helper(num1);
//         int b = helper(num2);

//         int c = a * b;

//         String ans = String.valueOf(c);

//         return ans;
//     }

//     private int helper(String s){
//         int p = 0;

//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);

//             if(ch == '0' && i == 0){
//                 continue;
//             }

//             p = p * 10 + (ch - '0');
//         }

//         return p;
//     }
// }