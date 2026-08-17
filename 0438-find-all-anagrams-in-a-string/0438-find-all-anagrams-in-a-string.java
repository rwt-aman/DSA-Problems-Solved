class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()){
            return list;
        }

        HashMap<Character,Integer> map = new HashMap<>(); // storing p -> ch,freq

        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> map2 = new HashMap<>();

        int left = 0;

        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);

            map2.put(ch,map2.getOrDefault(ch,0)+1);

            // keep the window size eqal to p.length()
            if(right-left+1 > p.length()){
                char rem = s.charAt(left);

                map2.put(rem,map2.get(rem)-1);

                if(map2.get(rem) == 0){
                    map2.remove(rem);
                }

                left++;
            }

            // Check if current window is an anagram
            if(right-left+1 == p.length()){
                if(map2.equals(map)){
                    list.add(left);
                }
            }
        }
        return list;
    }
}