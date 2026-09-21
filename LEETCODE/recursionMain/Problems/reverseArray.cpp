#include<bits/stdc++.h>
using namespace std;




void solve(int i, int j, vector<int> nums){
    if(j > i){
        return;
    }
    swap(nums[i],nums[j]);
    solve(i++,j--,nums);
}
void othersolve(int i, vector<int> nums, int n){
    if(i > n/2){
        return;
    }
    swap(nums[i],nums[n - i- 1]);
    othersolve(i+1, nums,n);
}

int main(){
    int n ;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    

    return 0;
}