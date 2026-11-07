#include<bits/stdc++.h>
using namespace std;


int solve(int index1, int index2, string s1, string s2, vector<vector<int>>& dp){
    if(index1 < 0 || index2 < 0){
        return 0;
    }
    if(dp[index1][index2] != -1){
        return dp[index1][index2];
    }
    if(s1[index1] == s2[index2]){
        return 1 + solve(index1 - 1, index2 - 1, s1, s2, dp);
    }
    return dp[index1][index2] =  max(solve(index1 - 1, index2, s1, s2, dp), solve(index1, index2 - 1, s1, s2, dp));
}
int longestseq(string s1, string s2){
    int n = s1.size();
    int m = s2.size();
    vector<vector<int>> dp(n,vector<int>(m,-1));

    return solve(n-1, m-1, s1, s2, dp);
}

int tabulation(string s1, string s2){

    int n = s1.size();
    int m = s2.size();
    vector<vector<int>> dp(n+1, vector<int>(m+1,0));

    dp[0][0] = 0;
    for(int i = 1; i < n; i++){
        for(int j = 1; i < n; j++){
            if(s1[i] == s2[j]){
                return 1 + dp[i - 1][j - 1];
            }else{
                dp[i][j] =  max(dp[i - 1][j],dp[i][ j - 1]);    
            }
        }
    }
    
}

int spaceoptimize(string s1, string s2) {
    int n = s1.size();
    int m = s2.size();

    vector<int> prev(m + 1, 0);
    vector<int> curr(m + 1, 0);

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (s1[i - 1] == s2[j - 1]) {
                curr[j] = 1 + prev[j - 1];
            } else {
                curr[j] = max(prev[j], curr[j - 1]);
            }
        }
        prev = curr;
    }

    return prev[m];
}

int main(){

    string s1;
    string s2;
    cin >> s1 >> s2;

    int res = longestseq(s1,s2);
    cout << res << endl;

    return 0;
}