/*
toys=[1,12,5,111,200]after sorting[1,5,12,111,200]
k=10;
1->remaining 9 ->count=1;
5->remaining 4 ->count=2;
12-> X
SO 2 toys
*/
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n,k;
    cin>>n>>k;
    vector<int> price(n);
    for(int i=0;i<n;i++){
        cin>>price[i];
    }
    //sorting
    sort(price.begin(),price.end());
    int count=0;
    int sum=0;
    for(int i=0;i<n;i++){
        if(sum+price[i]<=k){
            sum+=price[i];
            count++;
        }else break;
    }cout<<count<<endl;
    return 0;
}