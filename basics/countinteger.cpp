#include <iostream>
using namespace std;
void count(int x){
    int count=0;
    while(x!=0){
        count++;
        x=x/10;
    }cout<<count<<endl;
}
int main() {
    int x;
    cin>>x;
    count(x);
    return 0;
}