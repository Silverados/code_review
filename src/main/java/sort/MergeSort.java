package sort;

public class MergeSort implements SortTemplate {
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

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        int[] helper = new int[hi - lo + 1];
        int i = lo;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <= hi) {
            helper[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            helper[index++] = arr[i++];
        }

        while (j <= hi) {
            helper[index++] = arr[j++];
        }

        for (int k = 0; k < helper.length; k++) {
            arr[lo + k] = helper[k];
        }

    }


}
