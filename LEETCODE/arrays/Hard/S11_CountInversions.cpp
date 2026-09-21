#include<bits/stdc++.h>
using namespace std;


int inversionCount(vector<int> &nums) {
    // code here
    int count = 0;
    int n = nums.size();
    for(int i = 0; i < n; i++){
        for(int j = i; j < n; j++){
            if(nums[i] > nums[j]){
                count++;
            }
        }
    }
    return count;
}

#include <bits/stdc++.h>
using namespace std;

int mergeArray(vector<int>& nums, int start, int mid, int end) {
    int count = 0;
    int i = start;
    int j = mid + 1;
    vector<int> temp;
    while (i <= mid && j <= end) {
        if (nums[i] <= nums[j]) {
            temp.push_back(nums[i]);
            i++;
        }
        else {
            // nums[i], nums[i+1], ..., nums[mid]
            // are all greater than nums[j]
            count += mid - i + 1;
            temp.push_back(nums[j]);
            j++;
        }
    }
    // Remaining elements in left half
    while (i <= mid) {
        temp.push_back(nums[i]);
        i++;
    }
    // Remaining elements in right half
    while (j <= end) {
        temp.push_back(nums[j]);
        j++;
    }
    // Copy sorted elements back
    for (int i = start; i <= end; i++) {
        nums[i] = temp[i - start];
    }
    return count;
}
int mergesort(vector<int>& nums, int start, int end) {
    if (start >= end)
        return 0;
    int mid = start + (end - start) / 2;
    int count = 0;
    count += mergesort(nums, start, mid);
    count += mergesort(nums, mid + 1, end);
    count += mergeArray(nums, start, mid, end);
    return count;
}

int optimal(vector<int>& nums) {
    return mergesort(nums, 0, nums.size() - 1);
}

int main() {
    int n;
    cin >> n;

    vector<int> nums(n);

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    cout << optimal(nums) << endl;

    return 0;
}
