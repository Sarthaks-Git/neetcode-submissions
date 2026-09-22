class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int l = 0;
        int h = matrix.length - 1;

        // Find the possible row
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (matrix[mid][0] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        // h is now the row that could contain target
        if (h < 0) return false;

        return binarySearch(matrix[h], target);
    }

    private boolean binarySearch(int[] row, int target) {
        int l = 0;
        int h = row.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (row[mid] == target) {
                return true;
            } 
            else if (row[mid] > target) {
                h = mid - 1;
            } 
            else {
                l = mid + 1;
            }
        }

        return false;
    }
}