#include <iostream>
using namespace std;
void sum(int x){
    int sum=0;
    while(x>0){
        sum=x%10+sum;
        x=x/10;
    }cout<<sum<<endl;
}
int main() {
    int x;
    cin>>x;
    sum(x);
    return 0;
}