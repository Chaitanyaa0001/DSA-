#include<bits/stdc++.h>
using namespace std;



void transpose(vector<vector<int>> grid){
    int m  = grid.size();
    int n = grid.size();
    vector<vector<int>> ans(m,vector<int>(n));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            ans[j][i] = grid[i][j];
        }
    }
}
int main(){
    int n; 
    cin >> n;
    
    return 0;
}