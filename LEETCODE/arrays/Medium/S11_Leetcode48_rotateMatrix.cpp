#include<bits/stdc++.h>
using namespace std;

void rotate(vector<vector<int>>& matrix) {
    int n = matrix.size();
    vector<vector<int>> ans(n,vector<int>(n));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; i++){
            ans[j][n-i-1] = matrix[i][j];
        }
    }
}

void rotateOptimal(vector<vector<int>>& matrix) {
    // without space 
    int m = matrix.size();
    int n = matrix[0].size();

    for(int i = 0; i <m; i++){
        for(int j = i + 1;  j < m; j++){
            swap(matrix[i][j], matrix[j][i]);
        }
    }
        for(auto &row : matrix){
            reverse(row.begin(), row.end());
        }

}

int main(){

    return 0;
}
