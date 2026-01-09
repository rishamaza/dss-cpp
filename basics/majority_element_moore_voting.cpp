#include <bits/stdc++.h>
using namespace std;
int main(){
        vector<int> nums(7);
        nums={2,2,1,1,1,2,2};
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
            candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        cout<<candidate;
}