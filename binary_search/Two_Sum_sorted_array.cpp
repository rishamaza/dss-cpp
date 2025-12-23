// 1 2 4 7 11 to check whether 9 is present YES!! 7+2 *__* 
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n,target;
    cin>>n>>target;
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int left=0;
    int right=n-1;
    bool found=false; 
    while(left<=right){
        int sum=arr[left]+arr[right];
        if(sum==target){
            found=true;
            break;
        }else if(sum<target){
            left++;
        }else {
            right--;
        }
    }
    if(found){
        cout<<"FOUND"<<endl;
    }else cout<<"NOT FOUND"<<endl;
    return 0;
}