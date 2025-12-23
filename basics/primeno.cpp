#include <iostream>
using namespace std;
void check(int x){
    if (x <= 1) {
        cout << "Not Prime no." << endl;
    }
    int flag=0;
    for(int i=2;i*i<=x;i++){
        if(x%i==0) flag = 1;
        break;
    }if(flag) cout<<"Not Prime no."<<endl;
    else cout<<"Prime No."<<endl;
}
int main() {
    int x;
    cin>>x;
    check(x);
    return 0;
}