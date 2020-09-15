package sort;

public class HeapSort implements SortTemplate {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int size = arr.length;
        exch(arr, 0, --size);

        while (size > 0) {
            heapify(arr, 0, size);
            exch(arr, 0, --size);
        }
    }

    private void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[i] ? largest : i;
            if (largest == i) {
                return;
            }
            exch(arr, largest, i);
            i = largest;
            left = 2 * i + 1;
        }
    }

    private void heapInsert(int[] arr, int i) {
        while ((i - 1) / 2 >= 0 && arr[i] > arr[(i - 1) / 2]) {
            exch(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
}
