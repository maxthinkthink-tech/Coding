package brain;

public class ASort {
    public static void main(String[] args) {

    }

    /*
     * Time:
     *  Best Case: O(n2)
     *  Average Case: O(n2)
     *  Worst Case: O(n2)
     * Stable: No
     */
    public static void selectionSort(int[] a) {
        // find the 0, 1, 2,  ... n-1 minimal element
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;

            // find minimum element in [i, a.length - 1]
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    index = j;
                }
            }

            // swap i and index element
            if (i != index) {
                int tmp = a[index];
                a[i] = tmp;
                a[index] = a[i];
            }
        }
    }

    /*
     * Time:
     *  Best Case: O(n)
     *  Average Case: O(n2)
     *  Worst Case: O(n2)
     * Stable: Yes
     */
    public static void bubbleSort(int[] a) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i+1]) {
                    flag = true;
                    swap(a[i], a[i+1]);
                }
            }
        }
    }

    /*
     * Time:
     *  Best Case: O(n)
     *  Average Case: O(n2)
     *  Worst Case: O(n2)
     * Stable: Yes
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i -1;
            while (j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}
