package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, -1, -99, -342, -4, 324, 3, 526, 32, 6};
//        SortAlgorithm sortTemplate = new SelectSort();
//        SortAlgorithm sortTemplate = new InsertSort();
//        SortAlgorithm sortTemplate = new BubbleSort();
//        SortAlgorithm sortTemplate = new CountSort();
//        SortAlgorithm sortTemplate = new HeapSort();
//        SortAlgorithm sortTemplate = new MergeSort();
//        SortAlgorithm sortTemplate = new QuickSort();
//        sortTemplate.sort(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        exch(arr, hi, lo + (int)(Math.random()*(hi - lo + 1)));
        int[] p = partition(arr, lo, hi);
        quickSort(arr, lo, p[0] - 1);
        quickSort(arr, p[1] + 1, hi);
    }

    private static int[] partition(int[] arr, int lo, int hi) {
        int less = lo - 1;
        int more = hi;
        while (lo < more) {
            if (arr[lo] < arr[hi]) {
                exch(arr, ++less, lo++);
            } else if (arr[lo] > arr[hi]) {
                exch(arr, --more, lo);
            } else {
                lo++;
            }
        }
        exch(arr, more, hi);
        return new int[]{less + 1, more};
    }

    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
