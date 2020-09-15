package sort;

public class BubbleSort implements SortTemplate{
    @Override
    public void sort(int[] arr) {
        for(int i = arr.length - 1; i >= 0; i--) {
            for(int j = 1; j <= i; j++) {
                if(arr[j] < arr[j - 1]) {
                    exch(arr, j, j - 1);
                }
            }
        }
    }
}
