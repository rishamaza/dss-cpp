//1 1 2 2 3 remove duplicates to get 1 2 3 *NOTE Must be sorted array*
#include <iostream>
using namespace std;
int removeDuplicate(int arr[], int n){
    if(n==0) return 0;
    int i=0;
    for (int j=1;j<n;j++){
        if(arr[i]!=arr[j]){
            i++;
            arr[i]=arr[j];
        }
    }return i+1;
}
int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int newlen=removeDuplicate(arr,n);
    for(int i=0;i<newlen;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}