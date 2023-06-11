package datastructure.array;

public class IntegerArraySquareSort {
    public static void main(String[] args) {

    }

    public int[] sort(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return null;
        }

        int[] result = new int[arrays.length];
        int resultIndex = arrays.length - 1;

        int beginIndex = 0;
        int endIndex = arrays.length - 1;

        while (beginIndex <= endIndex) {
            int leftNum = arrays[beginIndex] < 0 ? -arrays[beginIndex] : arrays[beginIndex];
            int rightNUm = arrays[endIndex];
            if (leftNum >= rightNUm) {
                result[resultIndex] = leftNum * leftNum;
                beginIndex++;
            } else {
                result[resultIndex] = rightNUm * rightNUm;
                endIndex--;
            }

            resultIndex--;
        }

        return result;
    }
}
