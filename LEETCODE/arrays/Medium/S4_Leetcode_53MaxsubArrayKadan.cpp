#include<bits/stdc++.h>
using namespace std;

int kadans(vector<int> nums){
    int n = nums.size();
    int cs = 0;
    int maxsum = INT_MIN;
    for(int i = 0; i < n; i++){
        cs += nums[i];
        maxsum = max(cs,maxsum);
        if(cs < 0){
            cs = 0;
        }
    }
    return maxsum;
}

int main(){
    int n;
    cin >> n;
    vector<int> v(n);
    for(auto i : v){
        cin >> i;
    }
}