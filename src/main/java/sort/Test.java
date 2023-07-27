package sort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static final int MIN = -50;
    public static final int MAX = 50;
    public static final int COUNT = 200;

    public static void main(String[] args) {
        int[] arr = generateArray();
        SortAlgorithm sortAlgorithm = new BubbleSort();
        sortAlgorithm.sort(arr);
        if (!sortAlgorithm.isSorted(arr)) {
            throw new RuntimeException(
                    String.format("Check sort algorithm implement!!!\nUnsorted array: %s", Arrays.toString(arr)));
        }
    }

    public static int[] generateArray() {
        int[] arr = new int[COUNT];
        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            arr[i] = random.nextInt(MAX - MIN) + MIN;
        }
        return arr;
    }
}
