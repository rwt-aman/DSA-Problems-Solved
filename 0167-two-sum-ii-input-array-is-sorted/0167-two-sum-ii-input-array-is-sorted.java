class Solution { // optimize 
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            int rem = target - numbers[i];

            if(map.containsKey(rem)){
                return new int[]{map.get(rem)+1,i+1};
            }
            else{
                map.put(numbers[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}


// class Solution { // brute force TC:-O(n^2)
//     public int[] twoSum(int[] numbers, int target) {
//         int n = numbers.length;

//         for(int i=0;i<n-1;i++){
//             for(int j=i+1;j<n;j++){
//                 if(numbers[i] + numbers[j] == target){
//                     return new int[]{i+1,j+1};
//                 }
//             }
//         }
//         return new int[]{-1,-1};
//     }
// }