package LEETCODE.Graphs.traversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class S8_SurroundingRegions {
    

    // Stores a cell's coordinates for BFS
    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // BFS to mark all 'O's connected to a boundary 'O' as SAFE
    private void bfs(int row, int col, char[][] board, boolean[][] isSafe, int m, int n) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        isSafe[row][col] = true; // Mark starting boundary cell as safe

        // 4-direction movement
        int[] dr = {-1, 0, +1, 0};
        int[] dc = {0, +1, 0, -1};

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            // Visit all 4 neighbours
            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                // If neighbour is inside board, is 'O', and not already marked safe
                if (0 <= nr && nr < m &&
                    0 <= nc && nc < n &&
                    board[nr][nc] == 'O' &&
                    !isSafe[nr][nc]) {

                    q.offer(new Pair(nr, nc));
                    isSafe[nr][nc] = true; // Mark reachable boundary region
                }
            }
        }
    }

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // isSafe[i][j] = true => 'O' is connected to boundary, so DON'T flip it
        boolean[][] isSafe = new boolean[m][n];

        // Pointers to traverse the boundary once
        int top = 0;
        int bottom = m - 1;
        int low = 0;
        int high = n - 1;

        // ---------------- Traverse Top Row ----------------
        for (int i = low; i <= high; i++) {
            if (board[0][i] == 'O') {
                bfs(0, i, board, isSafe, m, n);
            }
        }
        top++;

        // ---------------- Traverse Right Column ----------------
        for (int i = top; i <= bottom; i++) {
            if (board[i][n - 1] == 'O') {
                bfs(i, n - 1, board, isSafe, m, n);
            }
        }
        high--;

        // ---------------- Traverse Bottom Row ----------------
        for (int i = high; i >= low; i--) {
            if (board[m - 1][i] == 'O') {
                bfs(m - 1, i, board, isSafe, m, n);
            }
        }
        bottom--;

        // ---------------- Traverse Left Column ----------------
        for (int i = bottom; i >= top; i--) {
            if (board[i][0] == 'O') {
                bfs(i, 0, board, isSafe, m, n);
            }
        }

        // Flip only those 'O's which were NOT reached from boundary
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O' && !isSafe[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
