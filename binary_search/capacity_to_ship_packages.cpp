#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, D;
    cin >> n >> D;

    vector<int> w(n);
    for (int i = 0; i < n; i++) {
        cin >> w[i];
    }

    // Step 1: Search space
    int low = *max_element(w.begin(), w.end());   // minimum capacity
    int high = accumulate(w.begin(), w.end(), 0); // maximum capacity
    int ans = high;

    // Step 2: Binary Search
    while (low <= high) {
        int mid = low + (high - low) / 2; // current capacity guess

        // ---- CHECK PART (INLINE) ----
        int days = 1;   // start with day 1
        int curr = 0;   // current day's load

        for (int i = 0; i < n; i++) {
            if (curr + w[i] <= mid) {
                curr += w[i];   // same day
            } else {
                days++;         // new day
                curr = w[i];
            }
        }
        // ---- CHECK PART END ----

        if (days <= D) {
            ans = mid;        // capacity works
            high = mid - 1;   // try smaller
        } else {
            low = mid + 1;    // need bigger capacity
        }
    }

    cout << ans << endl;
    return 0;
}
