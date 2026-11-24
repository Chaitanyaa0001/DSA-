#include<bits/stdc++.h>
using namespace std;



int binary_search(int n, int target, vector<int> nums){

    int low = 0; int high = n -1 ;
    int ans = -1;
    while ( low <= high){
        
        int mid = low + (high - low) / 2;
        if(nums[mid] == target){
            ans = mid;
            break;
        }else if(target < nums[mid]){
            high = mid - 1;
        }else{
            low = mid + 1;
        }
    }
    return ans;
}
int main(){
    int n;
    int target;
    cin >> n >> target;
    vector<int> nums(n);
    for(int i= 0; i < n; i++){
        cin >> nums[i];
    }

    auto  ans = binary_search(n,target,nums);
    cout << ans << endl;
}