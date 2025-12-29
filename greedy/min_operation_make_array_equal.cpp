/*
Problem: Minimum operations to make all arrays elements equal
Pattern: Greedt + Sorting
Key Idea: Bring all elements to the median
*/
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    vector<int> a(n);
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    //sorting
    sort(a.begin(),a.end());
    int median=a[n/2];
    long long operations=0;
    for(int i=0;i<n;i++){
        operations+=abs(a[i]-median);
    }
    cout<<operations<<endl;
    return 0;
}