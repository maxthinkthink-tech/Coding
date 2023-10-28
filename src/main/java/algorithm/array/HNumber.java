package algorithm.array;

import java.util.Arrays;
import java.util.Comparator;

public class HNumber {
    public static void main(String[] args) {
        int r = hIndex(new int[]{3,0,6,1,5});
        System.out.println(r);
    }
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int c = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= c) {
                return  c;
            }
            c--;
        }
        return c;
    }
}
