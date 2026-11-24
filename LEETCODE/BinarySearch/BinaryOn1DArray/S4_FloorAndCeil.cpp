
#include <bits/stdc++.h>
using namespace std;

pair<int, int> floor_ceil(int n, int key, vector<int>& nums) {

    int low = 0;
    int high = n - 1;

    int floor = -1;
    int ceil = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == key) {
            return {key, key};
        }
        else if (nums[mid] < key) {
            floor = nums[mid];
            low = mid + 1;
        }
        else {
            ceil = nums[mid];
            high = mid - 1;
        }
    }

    return {floor, ceil};
}

int main() {

    int n, key;
    cin >> n >> key;

    vector<int> nums(n);

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    auto ans = floor_ceil(n, key, nums);

    cout << "Floor: " << ans.first << endl;
    cout << "Ceil: " << ans.second << endl;

    return 0;
}
