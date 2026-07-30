package LEETCODE.Graphs.traversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class S9_NumberOfEnclaves {
    // Stores coordinates of a cell for BFS
    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // BFS from a boundary land cell
    // Marks every land cell connected to the boundary as SAFE
    private void bfs(int row, int col, int[][] grid, boolean[][] isSafe, int m, int n) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        isSafe[row][col] = true;

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

                // Continue BFS only for unvisited land cells
                if (0 <= nr && nr < m &&
                    0 <= nc && nc < n &&
                    grid[nr][nc] == 1 &&
                    !isSafe[nr][nc]) {

                    q.offer(new Pair(nr, nc));
                    isSafe[nr][nc] = true;
                }
            }
        }
    }

    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Boundary pointers
        int top = 0;
        int bottom = m - 1;
        int low = 0;
        int high = n - 1;

        // isSafe[i][j] = true => land is connected to boundary
        boolean[][] isSafe = new boolean[m][n];

        // 0 -> Sea
        // 1 -> Land

        // ---------------- Top Row ----------------
        for (int i = low; i <= high; i++) {
            if (grid[0][i] == 1) {
                bfs(0, i, grid, isSafe, m, n);
            }
        }
        top++;

        // ---------------- Right Column ----------------
        for (int i = top; i <= bottom; i++) {
            if (grid[i][n - 1] == 1) {
                bfs(i, n - 1, grid, isSafe, m, n);
            }
        }
        high--;

        // ---------------- Bottom Row ----------------
        for (int i = high; i >= low; i--) {
            if (grid[m - 1][i] == 1) {
                bfs(m - 1, i, grid, isSafe, m, n);
            }
        }
        bottom--;

        // ---------------- Left Column ----------------
        for (int i = bottom; i >= top; i--) {
            if (grid[i][0] == 1) {
                bfs(i, 0, grid, isSafe, m, n);
            }
        }

        // Count land cells NOT connected to boundary
        // These are the enclaves
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 && !isSafe[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
    }   
}
