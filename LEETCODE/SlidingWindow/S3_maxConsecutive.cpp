
#include<bits/stdc++.h>
using namespace std;

int bruteforce(vector<int> a, int k){
    int n = a.size();
    int maxlen = 0;
    for(int i = 0; i < n; i++){
        int count = 0;
        for(int j = i; j < n; j++){
            if(a[j] == 0){
                count++;
            }
            if(count > k){
                break;
            }
            if(count <= k){
                int len = j - i + 1;
                maxlen = max(maxlen,len);
            }
        }
    }
        return maxlen;
}
int betterApproch(vector<int>a, int k){
        int n = a.size();
        int count = 0;
        int l = 0,r = 0;
        int len = 0;
        int maxlen = 0;
        while (r < n) {
            if(a[r] == 0){
                count++;
            }
            while (count > k) {
                if(a[l] == 0){
                    count--;
                }
                l++;
            }
                len = r - l + 1;
                maxlen = max(len,maxlen);
        }
        return maxlen;
    }
int optimal(vector<int> a, int k){
        int n = a.size();
        int r = 0 , l = 0;
        int len = 0; int maxlen = 0;
        int count = 0;
        while (r < n) {
            if(a[r] == 0){
                count++;
            }
            if(count > k){
                if(a[l] == 0){
                    count--;
                }
                l++;
            }
            len = r-l+1;
            maxlen = max(maxlen, len);
            r++;
        }
        return maxlen;
    }

    int main(){
        int n;
        int k;
        cin >> n >> k;
        vector<int> nums(n);
        for(int i = 0; i < n; i++){
            cin >> nums[i];
        };
        bruteforce(nums,k);
        betterApproch(nums,k);
        optimal(nums,k);
    }