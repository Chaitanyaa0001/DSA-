#include<bits/stdc++.h>
using namespace std;


vector<int> rearrangeArray(vector<int>& nums) {
    vector<int> pos;
    vector<int> neg;
    int n = nums.size();
    for(int i = 0; i < n; i++){
        if(nums[i] < 0){
            neg.push_back(nums[i]);
        }else{
            pos.push_back(nums[i]);
        }
    }
    vector<int> ans(n);
    for(int i = 0; i< n / 2 ; i++){
        ans[2*i] = pos[i];
        ans[2*i+1] = neg[i]; 
    }
    return ans;
}
vector<int> optimal(vector<int> nums){
    int n = nums.size();
    vector<int> ans(n);
    int pos = 0;
    int neg = 1;

    for(int i = 0; i < n; i++){
        if(nums[i] < 0){
            ans[neg] = nums[i];
            neg +=2;
        }else{
            ans[pos] = nums[i];
            pos += 2;
        }
    }
    return ans;
}
int main(){
    return 0;
}