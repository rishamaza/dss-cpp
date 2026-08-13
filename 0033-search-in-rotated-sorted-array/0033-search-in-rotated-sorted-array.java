class Solution {
    public int search(int[] nums, int target) {
        /*
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int old = low;
        low = 0;
        high = nums.length - 1;
        if (target >= nums[old] && target <= nums[high]) {
            low = old;
        } else {
            high = old - 1;
        }

        while (low <= high) {
            int m = low + (high - low) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return -1;
        */
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                    return mid;
            }
            
            // right half
            if (nums[mid] <= nums[high]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // left half
            else {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
