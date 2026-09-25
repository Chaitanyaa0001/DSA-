#include <bits/stdc++.h>
using namespace std;


bool ischeck(int row, int col, char c, vector<vector<char>>& board) {

    // Check row and column
    for (int i = 0; i < 9; i++) {
        // Check row
        if (board[row][i] == c) {
            return false;
        }
        // Check column
        if (board[i][col] == c) {
            return false;
        }
        // Check 3 x 3 box
        int boxRow = 3 * (row / 3) + i / 3;
        int boxCol = 3 * (col / 3) + i % 3;
        if (board[boxRow][boxCol] == c) {
            return false;
        }
    }
    return true;
}
bool sudoku(vector<vector<char>>& board) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            // Find empty cell
            if (board[i][j] == '.') {
                // Try digits 1 to 9
                for (char k = '1'; k <= '9'; k++) {
                    if (ischeck(i, j, k, board)) {
                        // Place digit
                        board[i][j] = k;
                        // Recursively solve
                        if (sudoku(board)) {
                            return true;
                        }
                        // Backtrack
                        board[i][j] = '.';
                    }
                }
                // No digit worked
                return false;
            }
        }
    }
    // No empty cells left
    return true;
}
int main() {
    vector<vector<char>> board(9, vector<char>(9));
    // Take Sudoku input
    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            cin >> board[row][col];
        }
    }
    sudoku(board);
    // Print solved Sudoku
    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            cout << board[row][col] << " ";
        }
        cout << endl;
    }
    return 0;
}