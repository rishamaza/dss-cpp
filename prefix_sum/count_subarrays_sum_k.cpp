/*
yhn slide windows technique not working because it only works
for positive numbers therefore prefix sum technique is used.
technique bilkul simple h agr prefixSum-k minus krke 0 aye 33 aye to 
add kro count aur pata chal jayega kinta subarrays h 
*/
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n,k;
    cin>>n>>k;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    unordered_map<int,int> freq;
    int prefixSum=0;
    int count=0;
    // ye isliye ki agar starting se hi sum k ban jaye
    freq[0]=1;
    for(int i=0;i<n;i++){
        //ab tak ka total;
        prefixSum += arr[i];
        //check kro kya pahle (prefixSum - K) aaya hai
        if(freq.find(prefixSum-k)!=freq.end()){
            count = count + freq[prefixSum-k];
        }
        freq[prefixSum]++;
    }
    cout<<count;
    return 0;
}