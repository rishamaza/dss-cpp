#include <iostream>
using namespace std;
void reverse(int x){
    int rev=0;
    while(x>0){
        rev=rev*10+x%10;
        x=x/10;
    }cout<<rev<<endl;
}
int main() {
    int x;
    cin>>x;
    reverse(x);
    return 0;
}