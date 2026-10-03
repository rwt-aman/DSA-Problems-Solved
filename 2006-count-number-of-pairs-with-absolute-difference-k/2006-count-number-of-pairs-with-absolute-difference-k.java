class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for(int num : nums){
            count += map.getOrDefault(num-k,0);
            count += map.getOrDefault(num+k,0);

            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        return count;
    }
}



// class Solution {
//     public int countKDifference(int[] nums, int k) {
//         int count = 0;

//         for(int i=0;i<nums.length-1;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(Math.abs(nums[i] - nums[j]) == k){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }