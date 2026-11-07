#include<bits/stdc++.h>
using namespace std;



void selection_sort(int n, vector<int>& nums) {
    for (int i = 0; i < n; i++) {
        int minindex = i;

        for (int j = i + 1; j < n; j++) {
            if (nums[minindex] > nums[j]) {
                minindex = j;
            }
        }

        swap(nums[i], nums[minindex]);
    }
}

int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i< n; i++){
        cin >> nums[i];
    }
    selection_sort(n,nums);
    return 0;
}