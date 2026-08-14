class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        // Rule 1: Always Binary Search on the SMALLER array
        if (A.length > B.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = A.length;
        int n = B.length;

        // Cut ranges from 0 to m (not m - 1)
        int l = 0, r = m;

        int totalLeft = (m + n + 1) / 2; // Total elements needed in Left Half

        while (l <= r) {
            int i = l + (r - l) / 2; // Cut in A
            int j = totalLeft - i;   // Cut in B

            // Boundary handling with Infinity
            int Al = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Ar = (i == m) ? Integer.MAX_VALUE : A[i];

            int Bl = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Br = (j == n) ? Integer.MAX_VALUE : B[j];

            // Valid Partition Condition
            if (Al <= Br && Bl <= Ar) {
                // Total elements Odd hain
                if ((m + n) % 2 == 1) {
                    return Math.max(Al, Bl);
                } 
                // Total elements Even hain
                else {
                    return (Math.max(Al, Bl) + Math.min(Ar, Br)) / 2.0;
                }
            } 
            // A me cut bohot aage lag gaya hai, peeche lao
            else if (Al > Br) {
                r = i - 1;
            } 
            // A me cut bohot peeche hai, aage badhao
            else {
                l = i + 1;
            }
        }

        return 0.0;
    }
}