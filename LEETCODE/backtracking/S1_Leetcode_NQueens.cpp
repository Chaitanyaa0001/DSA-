#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    bool isSafe(int row, int col, vector<string>& board, int n) {

        // 1. Check upper-left diagonal
        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q')
                return false;

            r--;
            c--;
        }
        // 2. Check left side
        r = row;
        c = col;
        while (c >= 0) {
            if (board[r][c] == 'Q')
                return false;

            c--;
        }
        // 3. Check lower-left diagonal
        r = row;
        c = col;
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r++;
            c--;
        }
        return true;
    }

    void solve(vector<string>& board, vector<vector<string>>& ans, int col, int n) {
        // Base case:
        // We successfully placed queens in all columns
        if (col == n) {
            ans.push_back(board);
            return;
        }
        // Try every row in current column
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                // Place queen
                board[row][col] = 'Q';
                // Move to next column
                solve(board, ans, col + 1, n);
                // BACKTRACK
                board[row][col] = '.';
            }
        }
    }
    void solve2Optimal(int n, int col, vector<string>& board, vector<vector<string>>& ans, vector<int>& lowerD, vector<int>& upperD, vector<int>& currentRow){

        if(col == n){
            ans.push_back(board);
            return ;
        }
        // for upper the formula is n - 1 + row - col 
        // for lower the formula is row + col 
        for(int row = 0; row < board.size(); row++){
            if(lowerD[row+col] == 0 && upperD[n-1 + row - col] == 0 && currentRow[row] == 0){
                board[row][col] = 'Q';
                upperD[n - 1 + row - col] = 1;
                lowerD[ row + col] = 1;
                currentRow[row] = 1;
                solve2Optimal(n,col + 1, board, ans,lowerD,upperD,currentRow);
                board[row][col] = '.';
                upperD[n - 1 + row - col] = 0;
                lowerD[ row + col] = 0;
                currentRow[row] = 0;
            }
        }
    }

    vector<vector<string>> solveNQueens(int n) {

        vector<vector<string>> ans;

        // Create n x n board filled with '.'
        vector<string> board(n, string(n, '.'));

        solve(board, ans, 0, n);
        vector<int> currentRow(n, 0);

        // 2n - 1 diagonals
        vector<int> lowerD(2 * n - 1, 0);
        vector<int> upperD(2 * n - 1, 0);
        solve2Optimal(n,0,board,ans,lowerD,upperD,currentRow);

        return ans;
    }
};
int main() {

    int n;
    cin >> n;

    Solution obj;

    vector<vector<string>> ans = obj.solveNQueens(n);
    for (auto board : ans) {
        for (auto row : board) {
            cout << row << endl;
        }

        cout << endl;
    }

    return 0;
}