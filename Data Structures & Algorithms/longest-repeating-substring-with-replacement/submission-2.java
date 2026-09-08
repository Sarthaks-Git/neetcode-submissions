class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];   // frequency of characters A-Z
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // include current character
            freq[s.charAt(right) - 'A']++;

            // track max frequency in current window
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            // if replacements needed > k, shrink window
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // update answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}