class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowTotal = matrix.length, colTotal = matrix[0].length;
        int low = 0, high = rowTotal * colTotal - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / colTotal, col = mid % colTotal;
            if (matrix[row][col] < target) {
                low = mid + 1;
            } else if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
