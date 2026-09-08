class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int one = 1;
        int two = 1;

        for (int i = 1; i < n; i++) {
            int curr = 0;
            char c = s.charAt(i);
            char p = s.charAt(i - 1);

            if (c != '0') {
                curr += two;
            }
            if (p == '1' || (p == '2' && c <= '6')) {
                curr += one;
            }
            one = two;
            two = curr;
        }
        return two;
    }
}
