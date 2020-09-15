package sort;

public class CountSort implements SortTemplate{
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        int[] helper = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            helper[arr[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] > 0) {
                arr[index++] = i + min;
                helper[i]--;
            }
        }
    }
}
