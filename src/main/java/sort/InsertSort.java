package sort;

public class InsertSort implements SortTemplate{
    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[i]) {
                    exch(arr, i, j);
                }
            }
        }
    }
}
