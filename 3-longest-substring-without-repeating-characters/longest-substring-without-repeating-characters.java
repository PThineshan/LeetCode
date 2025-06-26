class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int longest = 0;

        Map<Character, Integer> charMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right), 0) + 1);

            while (charMap.get(s.charAt(right)) > 1) {
                charMap.put(s.charAt(left), charMap.get(s.charAt(left)) - 1);
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }


        return longest;
        
    }
}