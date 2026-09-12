#include<bits/stdc++.h>
using namespace std;

    int fibonache(int n, vector<int>& dp){
        // time- > 
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = fibonache(n-1,dp) + fibonache(n-2, dp);
    }
    int main(){
        int n ;
        cin >> n;
        vector<int> dp(n+1, -1);
        cout << fibonache(5, dp);

        // tabulation 
        dp[0] = 0, dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        // now space optimize 
        int p2 = 0;
        int p1 = 1;
        int curr = 0;
        for(int i = 2; i <= n; i++){
            curr += p1 + p2;
            p2 = p1;
            p1 = curr;
        }
        cout << p1;
        return 0;
    }
