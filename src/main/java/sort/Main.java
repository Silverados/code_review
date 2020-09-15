package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, -1, -99, -342, -4, 324, 3, 526, 32, 6};
//        SortTemplate sortTemplate = new SelectSort();
//        SortTemplate sortTemplate = new InsertSort();
//        SortTemplate sortTemplate = new BubbleSort();
//        SortTemplate sortTemplate = new CountSort();
//        SortTemplate sortTemplate = new HeapSort();
//        SortTemplate sortTemplate = new MergeSort();
        SortTemplate sortTemplate = new QuickSort();
        sortTemplate.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
