#include <bits/stdc++.h>
using namespace std;

vector<int> leftrotate(int n, vector<int> &nums) {
    int f = nums[0];
    for(int i = 1; i < n; i++) {
        nums[i - 1] = nums[i];
    }
    nums[n - 1] = f;
    return nums;
}

int main() {
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++) {
        cin >> nums[i];
    }
    vector<int> result = leftrotate(n, nums);
    for(int x : result) {
        cout << x << " ";
    }
    return 0;
}