package Exercicios2_4_5;

public class DualPivotQuickSort {

    public void dualPivotQuickSort(int[] array, int low, int high) {
        if (low < high) {

            int[] pivots = partition(array, low, high);
            int p1 = pivots[0], p2 = pivots[1];

            dualPivotQuickSort(array, low, p1 - 1);
            dualPivotQuickSort(array, p1 + 1, p2 - 1);
            dualPivotQuickSort(array, p2 + 1, high);
        }
    }

    private int[] partition(int[] array, int low, int high) {

        int mid = low + (high - low) / 2;
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }
        if (array[low] > array[high]) {
            swap(array, low, high);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }

        int pivot1 = array[low];
        int pivot2 = array[high];

        int i = low + 1;
        int less = low + 1;
        int great = high - 1;

        while (i <= great) {
            if (array[i] < pivot1) {
                swap(array, i, less);
                less++;
            } else if (array[i] > pivot2) {
                swap(array, i, great);
                great--;
                i--;
            }
            i++;
        }

        less--;
        great++;
        swap(array, low, less);
        swap(array, high, great);

        return new int[]{less, great};
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
