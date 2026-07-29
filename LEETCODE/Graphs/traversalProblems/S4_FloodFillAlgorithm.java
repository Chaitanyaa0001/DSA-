package LEETCODE.Graphs.traversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class S4_FloodFillAlgorithm {

    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        // Original color from where flood fill starts
        int originalColor = image[sr][sc];

        // Start BFS
        q.add(new Pair(sr, sc));
        vis[sr][sc] = true;

        // Change starting pixel immediately
        image[sr][sc] = color;

        // 4 Directions -> Up, Right, Down, Left
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int row = curr.r;
            int col = curr.c;

            // Visit all 4 neighbours
            for (int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                // Valid cell + Same Original Color + Not Visited
                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    !vis[nr][nc] &&
                    image[nr][nc] == originalColor) {

                    vis[nr][nc] = true;
                    image[nr][nc] = color;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        /*
         * Time Complexity:
         * Every pixel is visited at most once.
         * Every visited pixel checks only 4 neighbours.
         *
         * Time  : O(m * n)
         * Space : O(m * n)
         *         - visited[][] = O(m*n)
         *         - Queue       = O(m*n) (Worst Case)
         */

        return image;
    }

    public static void main(String[] args) {

        // Example Input
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] ans = floodFill(image, 1, 1, 2);

        // Print Result
        for (int[] row : ans) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}