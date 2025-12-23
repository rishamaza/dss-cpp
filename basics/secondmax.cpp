#include <iostream>
#include <climits>
using namespace std;
void maxcheck(int arr[],int n){
    int max=INT_MIN;
    int secmax=INT_MIN;
    if(n<2) cout<<"Need more elements"<<endl;
    for(int i=0;i<n;i++){
        if(arr[i]>max){
            secmax=max;
            max= arr[i];
        }else if(arr[i]>secmax && arr[i]!=max){
                secmax=arr[i];
            }
    }
    cout<<"Max element is "<<max<<endl<<"Second max is "<<secmax<<endl;
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