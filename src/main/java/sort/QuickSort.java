package sort;

public class QuickSort implements SortTemplate {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        exch(arr, hi, lo + (int)(Math.random()*(hi - lo + 1)));
        int[] p = partition(arr, lo, hi);
        sort(arr, lo, p[0] - 1);
        sort(arr, p[1] + 1, hi);
    }

    private int[] partition(int[] arr, int lo, int hi) {
        int less = lo - 1;
        int more = hi;
        while (lo < more){
            if(arr[lo] < arr[hi]){
                exch(arr,++less,lo++);
            }else if (arr[lo] > arr[hi]){
                exch(arr,--more,lo);
            }else {
                lo++;
            }
        }
        exch(arr,more,hi);
        return new int[]{less+1,more};
    }
}
