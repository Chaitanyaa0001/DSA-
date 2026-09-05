#include<bits/stdc++.h>
using namespace std;

int solve(int n,vector<int> nums, int k){
    int i = 0;
    int j = 0;
    int sum = 0;
    int maxlen = 0;
    deque<int> dq;

    while (j < n){
        sum += nums[i];
        while (dq.empty() || nums[dq.back()] <= nums[i]){
            dq.pop_back();
        }
        dq.push_back(j);
        int maxi = nums[dq.front()];
        while (dq.empty() && sum - maxi > k){
            // case 1 
            if(nums[dq.front()] == nums[i]){
                dq.pop_front();
            }
            sum -= nums[i];
            i++;
        }

        if(!dq.empty() && sum - maxi == k){
            int len = j - i + 1;
            maxlen = max(maxlen,len);
        }
    }
    return maxlen;   
}
int main(){
    int n; cin >> n;
    int k; cin >> k;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    int res = solve(n,nums,k);
    cout << res;
    return 0;
}