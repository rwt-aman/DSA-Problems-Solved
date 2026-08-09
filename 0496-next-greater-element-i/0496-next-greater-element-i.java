class Solution { // optimal TC:-O(n) AND SC:-(n+m)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        // Find next greater element for every nums2 element
        for(int i=0;i<nums2.length;i++){  
            while(!st.isEmpty() && st.peek() < nums2[i]){
                map.put(st.pop(),nums2[i]); // put the value as key and pair as its greater element
            }

            st.push(nums2[i]);
        }
        
        // Remaining elements have no greater element
        while(!st.isEmpty()){ // or we can write for(int i :  stack){map.put(st.pop(),-1);}
            map.put(st.pop(),-1); 
        }

        for(int i=0;i<nums1.length;i++){ //fetching nums1 element greater element from map
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}


// class Solution { // Brute force but Optimized using hashmap still TC:- O(n^2) ans SC:- O(n)
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int[] ans = new int[nums1.length];
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i=0;i<nums2.length;i++){
//             map.put(nums2[i],i);
//         }

//         for(int i=0;i<nums1.length;i++){
//             for(int j=map.get(nums1[i])+1;j<nums2.length;j++){

//                 if(nums2[j] > nums1[i]){
//                     ans[i] = nums2[j];
//                     break;
//                 }
//             }
//         }
//         for(int i=0;i<ans.length;i++){
//             if(ans[i] == 0){
//                 ans[i] = -1;
//             }
//         }

//         return ans;
//     }
// }


// class Solution { // Brute force TC:-O(n^2)
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int[] ans = new int[nums1.length];
//         boolean found = false;

//         for(int i=0;i<nums1.length;i++){
//             found = false;
//             for(int j=0;j<nums2.length;j++){
//                 if(nums1[i] == nums2[j]){
//                     found = true;
//                 }

//                 if(found == true && nums2[j] > nums1[i]){
//                     ans[i] = nums2[j];
//                     break;
//                 }
//             }
//         }
//         for(int i=0;i<ans.length;i++){
//             if(ans[i] == 0){
//                 ans[i] = -1;
//             }
//         }

//         return ans;
//     }
// }