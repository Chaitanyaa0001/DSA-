package A2Darrays;

public class spiralmatrix {
    public static int[] spiralOrder(int[][] matrix) {
        int result[] = new int[matrix.length * matrix[0].length];
        int j = 0;
        int startrow = 0, endrow = matrix.length - 1;
        int startcol = 0, endcol = matrix[0].length - 1;

        while (startrow <= endrow && startcol <= endcol) {
            // top row
            for (int i = startcol; i <= endcol; i++) {
                result[j++] = matrix[startrow][i];
            }
            // right column
            for (int i = startrow + 1; i <= endrow; i++) {
                result[j++] = matrix[i][endcol];
            }
            // bottom row (only if more than one row left)
            if (startrow < endrow) {
                for (int i = endcol - 1; i >= startcol; i--) {
                    result[j++] = matrix[endrow][i];
                }
            }
            // left column (only if more than one column left)
            if (startcol < endcol) {
                for (int i = endrow - 1; i > startrow; i--) {
                    result[j++] = matrix[i][startcol];
                }
            }

            startrow++;
            endrow--;
            startcol++;
            endcol--;
        }

        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int ans[] = spiralOrder(matrix);
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
