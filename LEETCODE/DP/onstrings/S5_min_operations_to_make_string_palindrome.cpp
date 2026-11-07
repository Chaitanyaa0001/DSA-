#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    int longest_common_subsequence(string s1, string s2){
        int n = s1.size();
        vector<int> prev(n+1);
        vector<int> curr(n+1);

        for(int i = 1; i <= n; i++){
            for(int  j = 1; j <= n; j++){

                if(s1[i-1] == s2[j-1]){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[n];
    }
    int longestPalindromeSubseq(string s) {
        string s1 = s;
        reverse(s.begin(), s.end());
        int res  = longest_common_subsequence(s1,s);


        
        return res;
    }
    int minInsertions(string s) {
        int n = s.size();
        return n -  longestPalindromeSubseq(s);
    }
};