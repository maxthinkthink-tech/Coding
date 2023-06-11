package algorithm.array;

public class Angle {
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] r = new int[m * n];
        int c = 0;
        for (int k = 0; k < m + n - 1; k++) {
            int i = 0;
            int j = 0;
            if (k % 2 == 0) {
                i = k >= m ? m - 1 : k;
                j = 0;
                for (; i >= 0; i--, j++) {
                    r[c] = mat[i][j];
                    c++;
                }
            } else {
                i = 0;
                j = (k >= n ? n - 1 : k);
                for (; j >= 0; i++, j--) {
                    r[c] = mat[i][j];
                    c++;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
//        int[][] d = {{1,2},{4,5}};
        int[][] d = {{1,2,3},{4,5,6},{7,8,9}};
        int[] r = findDiagonalOrder(d);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }
}

