package LEETCODE.Graphs.traversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class S5_NumberOfIslands {
    

    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private void bfs(char[][] grid, int row, int col, boolean[][] vis, int m, int n) {

        // Queue stores cells to process level by level
        Queue<Pair> q = new LinkedList<>();

        // Start BFS from current unvisited land
        q.add(new Pair(row, col));
        vis[row][col] = true;

        // 4 Directions -> Up, Right, Down, Left
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Every land cell enters queue only ONCE
        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            // Check all 4 neighbours (constant work)
            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                // Valid cell + Land + Not Visited
                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == '1' &&
                    !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        /*
         * BFS Complexity
         *
         * Every land cell is visited exactly once.
         * Every visited cell checks only 4 neighbours.
         *
         * Time  : O(m * n)
         * Space : O(m * n) (Queue in worst case)
         */
    }

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int col = grid[0].length;

        boolean[][] vis = new boolean[rows][col];
        int count = 0;

        // Visit every cell exactly once
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {

                // New island found
                if (grid[i][j] == '1' && !vis[i][j]) {

                    count++;

                    // Mark entire island visited
                    bfs(grid, i, j, vis, rows, col);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
    }
}
