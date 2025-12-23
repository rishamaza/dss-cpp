/*
coins {1,2,5}
total for 11 rs
max x<=11 -> 5
11-5= 6 max x<=6 -> 5
6-5=1 max x>=1 -> 1
1-1=0
5rs+5rs+1rs coins could be used min coins to be taken
hence total 3 coins
*/
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n,x;
    cin>>n>>x;
    vector<int> coins(n);
    for(int i=0;i<n;i++){
        cin>>coins[i];
    }
    //sorting
    sort(coins.rbegin(),coins.rend());
    int count=0;
    for(int coin : coins){
        if(x>=coin){
            count+=x/coin;
            x=x%coin;
        }
    }cout<<count<<endl;
    return 0;
}