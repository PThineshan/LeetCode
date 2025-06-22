class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
                return List.of();
        
        int[] pCharArray = new int[26];
        for (char ch: p.toCharArray()) {
            pCharArray[ch - 'a']++;
        }

        int[] windowCharArray = new int[26];
        int windowSize = p.length();
        for (int i = 0; i < windowSize; i++) {
            windowCharArray[s.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(pCharArray, windowCharArray))
            result.add(0);

        for (int right = windowSize; right < s.length(); right++) {
            int left = right - windowSize;
            windowCharArray[s.charAt(left) - 'a']--;
            windowCharArray[s.charAt(right) - 'a']++;

            if (Arrays.equals(pCharArray, windowCharArray))
                result.add(left + 1);
        }

        return result;
    }
}