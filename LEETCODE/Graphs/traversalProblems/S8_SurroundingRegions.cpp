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


void bfs(vector<vector<int>> board){
    int m = board.size();
    int n = board[0].size();
    queue<pair<int,int>> q;
    while (!q.empty()){
        int row = q.front().first;
        int col = q.front().first;
        
        int dr[] = {-1,0,+1,0};
        int dc[] = {0,+1,0,-1};
        
        for(int i = 0; i < 4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(0 <= nr && nr < m && 0 <= nc && nc < n && vis[nr][nc] == 0 && board[nr][nc] == 'O'){
                
            }
        }
    }
}
void solve(vector<vector<char>>& board) {

    int m = board.size();
    int n = board[0].size();    
    vector<vector<int,int>> vis( m, vector<int>(n,0));

    int low  = 0, high =  n - 1;
    int top = 0, bottom = m - 1;

    while (low <= high){

        for(int i = low ; i < high; i++){
            if(board[i][j] == 'O'){
                bfs(i,j)
            }
        }
    }
    
}
int main(){

    return 0;
}