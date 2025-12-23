#include <iostream>
using namespace std;
int binarysearch(int arr[], int n, int key){
    int first=0;
    int last=n-1;
    while(first<=last){
        int mid = first+(last-first)/2;
        if(arr[mid]==key) return mid;
        else if(arr[mid]<key) first=mid+1;
        else last=mid-1;
    }
    return -1;
}
int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int key;
    cout<<"Enter the no. to search"<<endl;
    cin>>key;
    int check=binarysearch(arr,n,key);
    cout<<check<<endl;
    return 0;
}