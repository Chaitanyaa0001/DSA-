#include<bits/stdc++.h>
using namespace std;

void nextPermutation(int n, vector<int> nums){

    int index = -1;
    for(int i = n-2; i >= 0; i--){
        if(nums[i] < nums[i+1]){
            index  = i;
            break;
        }
    }
    if(index == -1){
        sort(nums.begin(), nums.end());
        cout << " already sorted";
    }

    for(int i = n-2; i >= 0; i--){
        if(nums[i] > nums[i+1]){
            swap(nums[index], nums[i]);
            break;
        }
    }
    sort(nums.begin() + index + 1, nums.end());
}

int main(){
    int n;
    cin >> n;
    vector<int> nums(n);

    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
}