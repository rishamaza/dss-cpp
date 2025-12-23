/* 
2 1 5 1 3 2 to find max of max size k=3 
[2,1,5] --> sum = 8
[1,5,1] --> sum = 7
[5,1,3] --> sum = 9 is max
[1,3,2] --> sum = 6 
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
    int windowSum=0;
    for(int i=0;i<k;i++){
        windowSum+=arr[i];
    }
    int maxSum=windowSum;
    for(int i=k;i<n;i++){
        windowSum=windowSum+arr[i]-arr[i-k];
        maxSum=max(maxSum,windowSum);
    }
    cout<<maxSum<<endl;
    return 0;
}