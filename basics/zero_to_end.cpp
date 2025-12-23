//1 0 2 0 0 5 remove duplicates to get 1 2 5 0 0 0 *NOTE Must be sorted array*
#include <iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int i=0;
    for(int j=0;j<n;j++){
        if(arr[j]!=0){
            arr[i]=arr[j];
            i++;
        }
    }
    for(int j=i;j<n;j++){
        arr[j]=0;
    }
    for(int k=0;k<n;k++){
        cout<<arr[k]<<" ";
    }
    return 0;
}