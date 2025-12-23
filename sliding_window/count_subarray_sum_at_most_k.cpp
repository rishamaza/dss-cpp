/*
subarray=continuous only=slide window
array=[2,1,3]
k=4
[2] -> 2 YES
[2,1] -> 3 YES
[2,1,3] -> 6 NO
[1] -> 1 YES
[1,3] -> 4 YES
[3] -> 3 YES
total 5 subarrays so answer is 5 
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
    int left=0,sum=0;
    long long count=0;
    for(int right=0;right<n;right++){
        sum+=arr[right];
        while(sum>k){
            sum-=arr[left];
            left++;
        }count +=(right-left+1);
    }
    cout<<count<<endl;
    return 0;
}
    
