package algorithm.basic;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lr = 0, rr = matrix.length, r = (lr + rr) / 2;
        int lc = 0, rc = matrix[0].length, c = (lc + rc) / 2;
        while (lr <= rr && lc <= rc) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {


                rr = r;
                rc = c;
            } else {
                lr = r;
                lc = c;
            }
            r = (lr + rr) / 2;
            c = (lc + rc) / 2;
        }
        return false;
    }
}
