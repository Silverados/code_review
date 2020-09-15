package sort;

public interface SortTemplate {
    void sort(int[] arr);

    default void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
