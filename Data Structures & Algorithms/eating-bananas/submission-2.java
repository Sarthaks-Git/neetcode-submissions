class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maximum = 0;

        for (int x : piles) maximum = Math.max(maximum, x);

        int l = 1;
        int high = maximum;

        while (l <= high) {
            int mid = l + (high - l) / 2;

            long hours = 0;
            for (int x : piles) hours += (x + mid - 1) / mid;

            if (hours <= h)
                high = mid - 1;
            else
                l = mid + 1;
        }

        return l;
    }
}
