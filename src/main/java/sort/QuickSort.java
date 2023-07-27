package sort;

public class QuickSort implements SortAlgorithm {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length - 1);
    }

    @Override
    public void sort(int[] arr, int low, int high) {
        if(high <= low) {
            return;
        }
        swap(arr, high, low + (int)(Math.random()*(high - low + 1)));
        int[] p = partition(arr, low, high);
        sort(arr, low, p[0] - 1);
        sort(arr, p[1] + 1, high);
    }

    private int[] partition(int[] arr, int lo, int hi) {
        int less = lo - 1;
        int more = hi;
        while (lo < more){
            if(arr[lo] < arr[hi]){
                swap(arr, ++less, lo++);
            }else if (arr[lo] > arr[hi]){
                swap(arr, --more, lo);
            }else {
                lo++;
            }
        }
        swap(arr, more, hi);
        return new int[]{less+1,more};
    }
}
