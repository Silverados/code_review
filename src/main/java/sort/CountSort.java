package sort;

public class CountSort implements SortAlgorithm {
    @Override
    public void sort(int[] arr, int low, int high) {
        int max = arr[low];
        int min = arr[low];
        for (int i = low + 1; i < high; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        int[] helper = new int[max - min + 1];
        for (int num : arr) {
            helper[num - min]++;
        }

        int index = low;
        for (int i = 0; i < helper.length; i++) {
            while (helper[i] > 0) {
                arr[index++] = i + min;
                helper[i]--;
            }
        }
    }
}
