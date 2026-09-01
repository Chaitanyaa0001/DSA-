#include<bits/stdc++.h>
using namespace std;

int secondlargest(int n, vector<int> nums){

    int l = INT_MIN;
    int sl = INT_MIN;
    for(int i = 0; i < n; i++){
        if(nums[i] > l){
            sl = l;
            l = nums[i];
        }else if(nums[i] > sl && nums[i] != l){
            sl = nums[i];
        }
    }
    return sl;
}
int main(){
    int n;
    cin >> n;
    vector<int> nums(n);

    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    secondlargest(n, nums);
    return 0;
}