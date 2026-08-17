class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int size = 0;
        int left = 0;
        int maxfreq = 0;

        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Maximum frequency inside current window
            maxfreq = Math.max(maxfreq, map.get(ch));

            // Number of replacements needed
            int windowSize = right - left + 1;
            int replacements = windowSize - maxfreq;

            // Window is invalid
            while (replacements > k) {
                char remove = s.charAt(left);

                map.put(remove, map.get(remove) - 1);

                left++;

                windowSize = right - left + 1;
                replacements = windowSize - maxfreq;
            }

            // Valid window
            size = Math.max(size, right - left + 1);
        }

        return size;
    }
}