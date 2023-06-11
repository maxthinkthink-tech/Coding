package datastructure.string;

public class KMPattern {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 2, 1, 2, 2, 1, 2};
        containsPattern(arr, 1, 3);
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i < arr.length - m; i++) {
            // times
            int cnt = 0;
            for (; cnt < k; cnt++) {
                boolean isMatch = isMatch(arr, m, i + cnt * m);
                if (!isMatch) {
                    break;
                }
                if (isMatch && cnt == 0) {
                    cnt = 1;
                }
            }
            if (cnt == k) {
                return true;
            }
        }
        return false;
    }

    // match
    static boolean isMatch(int[] arr, int m, int j) {
        for (int p = 0; p < m; p++) {
            if (j + p + m >= arr.length) {
                return false;
            }

            if (arr[j + p] != arr[j + p + m]) {
                return false;
            }
        }

        return true;
    }

}
