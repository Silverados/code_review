package sort;

public class SelectSort implements SortTemplate{
    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    exch(arr, i, j);
                }
            }
        }
    }
}
