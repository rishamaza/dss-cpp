#include <iostream>
#include <algorithm>
using namespace std;
void maxcheck(int arr[],int n){
    int first=0;
    int last=n-1;
    while(first<last){
        swap(arr[first],arr[last]);
        first++;
        last--;
    }for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
}
int main() {
    int n;
    cout<<"Enter no. of element: ";
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    maxcheck(arr,n);
    return 0;
}