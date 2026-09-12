#include<bits/stdc++.h>
using namespace std;

void rotate(vector<vector<int>>& matrix) {
    int n = matrix.size();
    vector<vector<int>> ans(n,vector<int>(n));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n;a j++){
            ans[j][n-i-1] = matrix[i][j];
        }
    }
}

void rotate(vector<vector<int>>& matrix) {
   
}

int main(){

    return 0;
}
