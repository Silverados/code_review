package sort;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] helper = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= high) {
            helper[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            helper[index++] = arr[i++];
        }

        while (j <= high) {
            helper[index++] = arr[j++];
        }

        System.arraycopy(helper, 0, arr, low, helper.length);
    }
}
