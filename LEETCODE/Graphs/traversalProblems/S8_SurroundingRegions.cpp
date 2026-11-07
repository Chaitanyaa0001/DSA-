#include<bits/stdc++.h>
using namespace std;
// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board. Such regions are completely enclosed by 'X' cells.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
// Example 1:
// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
// Explanation:
// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
// Example 2:
// Input: board = [["X"]]
// Output: [["X"]]
// Constraints:
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.


void bfs(vector<vector<char>>& board, int row, int col,vector<vector<int>>& isSafe){
    queue<pair<int,int>> q;
    q.push({row,col});
    isSafe[row][col] = true;

    int m = board.size();
    int n = board[0].size();
    while (!q.empty()){
        auto curr = q.front();
        q.pop();

        int r = curr.first;
        int c = curr.second;

        int dr[] = {-1,0,+1,0};
        int dc[] = {0,+1,0,-1};
        for(int i = 0 ; i < 4; i++){

            int nr = r + dr[i];
            int nc = c + dc[i];

            if(0 <= nr &&  nr < m && 0 <= nc && nc < n && board[nr][nc] == 'O' && !isSafe[nr][nc]){
                q.push({nr,nc});
                isSafe[nr][nc] = true;
            }
        }
    }
}

void surrounding_regions(vector<vector<char>>& board){
    int m = board.size();
    int n = board[0].size();

    vector<vector<int>> isSafe(m,vector<int>(n,0));

    for(int i = 0; i < n; i++){
        if(board[0][i] == 'O'){
            bfs(board,0,i,isSafe);
        }
        if( board[m-1][i] == 'O'){
            bfs(board,m-1,i,isSafe);
        }
    }
    for(int i = 1; i < m-1; i++){
        if(board[i][0] == 'O'){
            bfs(board, i, 0, isSafe);
        }
        if(board[i][n-1] == 'O'){
            bfs(board,i,n-1,isSafe);
        }
    }

    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){

            if(board[i][j] == 'O' && isSafe[i][j]){
                board[i][j] = 'X';
            }
        }
    }
}
int main(){

    return 0;
}