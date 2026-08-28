class Solution {
    public boolean isPalindrome(String s) {

        boolean isPalin = true;
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char first = Character.toLowerCase(s.charAt(left));
            char last = Character.toLowerCase(s.charAt(right));

            if (first != last) {
                isPalin = false;
                break;
            }

            left++;
            right--;
        }

        return isPalin;
    }
}