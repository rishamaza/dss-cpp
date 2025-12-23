#include <iostream>
using namespace std;
void maxcheck(int arr[],int n){
    int max=arr[0];
    for(int i=1;i<n;i++){
        if(arr[i]>max){
            max= arr[i];
        }
    }cout<<"Max element is "<<max<<endl;
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