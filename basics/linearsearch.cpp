#include <iostream>
using namespace std;
int linearsearch(int arr[], int n, int key){
    int count=0;
    for(int i=0;i<n;i++){
        if(arr[i]==key){
            count++;
        }
    }return count;
}
int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int key;
    cout<<"ENTER NO. TO SEARCH"<<endl;
    cin>>key;
    int count=linearsearch(arr,n,key);
    cout<<count<<" times"<< endl;
    return 0;
}