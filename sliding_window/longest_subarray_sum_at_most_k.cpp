/*
max lenth wala sub array kojo jiska sum<=k ho 
NOTE: max sum must nhi h bas max length h condition
k=3 mtlb sum<=3
1 2 1 1 1
answer max len is 3 ---> [1,1,1]
*/
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n,k;
    cin>>n>>k;
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int left=0, sum=0, maxLen=0;
    for(int right=0;right<n;right++){
        sum += arr[right];
        while(sum>k){
            sum-=arr[left];
            left++;
        }
        maxLen=max(maxLen, right-left+1);
    }
    cout<<maxLen<<endl;
    return 0;
}