#include<bits/stdc++.h>
using namespace std;

int main(){

    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i =0; i < n; i++){
        cin >> nums[i];
    }

    vector<int> ans ;
    int maxi = 0;
    for(int i = n-1; i >= 0; i--){
        if(nums[i] > maxi){
            ans.push_back(nums[i]);
            maxi = nums[i];
        }
    }
    reverse(ans.begin(), ans.end());
    
    return  0;
}