// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.
// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 
// Constraints:
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
// Follow up:
// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
#include<bits/stdc++.h>
using namespace std;
void setrow(vector<vector<int>> grid,int  r){
    int col = grid[0].size();
    for(int i = 0; i < col; i++){
        grid[r][i] = -1;
    }
}
void setcol(vector<vector<int>> grid, int c){
    int row = grid.size();
    for(int i = 0; i < row; i++){
        grid[i][c] = -1;
    }
}
int bruteforce(vector<vector<int>> grid, int n, int m){
    for(int i = 0; i < n; i++){
        for(int j = 0;  j < n; j++){
            if(grid[i][j] == 0){
                setrow(grid,i);
                setcol(grid,j);
            }
        }
    }
    for(int i = 0; i < n; i++){
        for(int j = 0;j < m; j++){
            if(grid[i][j] == -1){
                grid[i][j] = 0;
            }
        }
    }
}
int better(vector<vector<int>> grid, int n, int m){
    vector<int> row(n,0);
    vector<int> col(m,0);

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(grid[i][j] == 0){
                row[i] = 1;
                col[j] = 1;
            }
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(row[i] == 1 || col[j] == 1){
                grid[i][j] = 1;
            }
        }
    }
}
vector<vector<int>> optimal(vector<vector<int>> grid){
    int m = grid.size();
    int n = grid[0].size();
    int col0 = 1;

    for(int i = 0 ; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 0){

                grid[i][0] = 0;
                if(j != 0){
                    grid[0][j] = 0;
                }else{
                    col0 = 0;
                }
            }
        }
    }
    for(int i = 1; i < m; i++){
        for(int j = 1; j < n; j++){
            if(grid[i][j] != 0){

                if(grid[0][j] == 0 || grid[i][0] == 0){
                    grid[i][j] = 0;
                }
            }
        }
    }
    // now edge case for first row and first col
    if(grid[0][0]){
        for(int i = 0; i < n; i++){
            grid[0][i] = 0;
        }
    }
    if(col0 == 0){
        for(int i = 0; i < m; i++){
            grid[i][0] = 0;
        }
    }
    return grid;
}
int main(){
    int n;
    cin >> n;
    vector<vector<int>> v(n,vector<int>(n));
    for(int i =0; i < n;i++){
        for(int j =0; j < n; j++){
            cin >> v[i][j];
        }
    }
    return 0;
}