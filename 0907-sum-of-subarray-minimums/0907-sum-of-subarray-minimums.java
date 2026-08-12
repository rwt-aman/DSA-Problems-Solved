class Solution {
    public int[] previoussmaller(int[] arr){
        int[] ps = new int[arr.length]; //index pushing
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<arr.length;i++){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){ // exactly smaller (>)
                st.pop();
            }

            if(st.isEmpty()){
                ps[i] = -1; // if minimum not present in array putting -1 index 
            }
            else{
                ps[i] = st.peek(); // index stored in stack
            }

            st.push(i); // index pushing
        }

        return ps;
    }

    public int[] nextsmaller(int[] arr){
        int[] ns = new int[arr.length]; //index pushing
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){ // exaclty smaller and  equal (>=)
                st.pop();
            }

            if(st.isEmpty()){
                ns[i] = arr.length; // if minimum not present in array putting last index + 1 
            }
            else{
                ns[i] = st.peek(); // index stored in stack
            }

            st.push(i); // index pushing
        }

        return ns;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] ps = previoussmaller(arr); // ps is storing index of previous element
        int[] ns = nextsmaller(arr); // ns is storing index of next elements

        long mod = 1000000007;
        long total = 0;

        for(int i=0;i<arr.length;i++){
            int left = i - ps[i]; 
            int right = ns[i] - i;

            total = (total + ((long) left * right * arr[i])) % mod;
        }

        return (int) total;
    }
}



// class Solution { // Brute force 
//     public int sumSubarrayMins(int[] arr) {
//         long mod = 1000000007;

//         long sum = 0;

//         for(int i=0;i<arr.length;i++){
//             int min = arr[i];

//             sum = (sum + min) % mod; // for single element subarray eg:- [3]

//             for(int j=i+1;j<arr.length;j++){ // finding min and sum of subarrays 
//                 min = Math.min(min,arr[j]);

//                 sum = (sum + min) % mod;
//             }
//         }

//         return (int) sum;
//     }
// }