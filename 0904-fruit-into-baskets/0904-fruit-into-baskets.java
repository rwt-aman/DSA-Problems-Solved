class Solution { // optimize force
    public int totalFruit(int[] fruits) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        HashMap<Integer,Integer> map = new HashMap<>(); // num , freq

        for(int right=0;right<fruits.length;right++){
            int ele = fruits[right];

            map.put(ele,map.getOrDefault(ele,0)+1);

            while(map.size() > 2){

                int rem = fruits[left]; // remove or decrease the element  left side(remove or decrese)
                map.put(rem,map.get(rem)-1); // value decreasing

                if(map.get(rem) == 0){ // if value of current fruits[left] == 0 remove from map
                    map.remove(rem);
                }
                left++;
            }

            max = Math.max(max,right-left+1);
        }

        return max;
    }
}







// class Solution { // Brute Force
//     public int totalFruit(int[] fruits) {

//         int max = 0;

//         for (int i = 0; i < fruits.length; i++) {

//             HashSet<Integer> set = new HashSet<>();

//             for (int j = i; j < fruits.length; j++) {

//                 set.add(fruits[j]);

//                 // More than 2 types of fruits
//                 if (set.size() > 2) {
//                     break;
//                 }

//                 max = Math.max(max, j - i + 1);
//             }
//         }

//         return max;
//     }
// }