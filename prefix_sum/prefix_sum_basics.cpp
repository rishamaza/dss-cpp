/*
arr=[2,4,1,3]
pref[i]=arr[0]+...arr[i];
pref[0]=2
pref[1]=2+4=6
pref[2]=6+1=7
pref[3]=7+3=10
pref=[2,6,7,10]
if asked sum from index 1 to 3 then 
=> pref[3]-pref[0]
=> 10-2
=> 8 (4+1+3=8)   *__*
*/
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    vector <int> arr(n), pref(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    pref[0]=arr[0];
    for(int i=1;i<n;i++){
        pref[i]=pref[i-1]+arr[i];
    }
    int l,r;
    cin>>l>>r;
    if(l==0) 
        cout<<pref[r];
    else 
        cout <<pref[r]-pref[l-1];
    return 0;
}