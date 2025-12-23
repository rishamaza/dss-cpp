/*
Binary Search on Answer 
We are NOT searching in the array
We are searching for the minimum possible speed
possible(speed) checks if work can be done with speed
If possible(mid) is true -> try smaller answer
If false -> increase speed 
ceil divison formula:
ceil(a/b)=(a+b-1)/b
right = maximum possivle anser (max pile)
left = minimum possible answer (1)
*/
#include<bits/stdc++.h>
using namespace std;
//Ye function check karta hai;
//given speed pe kya h hours me kaam ho jayega?
bool possible(vector<int>/* & is for preventing
    to be copied*/ &piles,int h, int speed){
        int hours=0;
        for(int i=0;i<piles.size();i++){
            //ceil(piles[i]/speed)
            hours+=(piles[i]+speed-1)/speed;
        }
        if (hours <= h){
            return true;
        }else
            return false;
    }
int main() {
    vector<int> piles = {3,6,7,11};
    int h=8;
    int left=1;
    int right=*max_element(piles.begin(),piles.end());
    int ans=-1;
    while(left<=right){
        int mid = left + (right-left)/2;// mid speed
        if(possible(piles,h,mid)){
            ans=mid; // ye speed valid hai
            right=mid-1; // aur chhoti speed try karo
        }else {
            left=mid+1; //speed kam hai to, badhao
        }
    }cout<<ans;
    return 0;
}