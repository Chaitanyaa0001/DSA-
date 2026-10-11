#include<bits/stdc++.h>
using namespace std;


int solve(int index1, int index2, string s1, string s2){

    if(index1 < 0 || index2 < 0){
        return 0;
    }
    if(index1 == index2){
        return solve(index1 - 1, index2 - 1, s1, s2);
    }
    return max(solve(index1 - 1, index2, s1, s2), solve(index1, index2 - 1, s1, s2));
}
int longestseq(string s1, string s2){
    int n = s1.size();
    int m = s2.size();
    vector<vector<int>> dp(n,vector<int>(m,-1));


}

int main(){

    string s1;
    string s2;
    cin >> s1 >> s2;

    int res = longestseq(s1,s2);
    cout << res << endl;

    return 0;
}