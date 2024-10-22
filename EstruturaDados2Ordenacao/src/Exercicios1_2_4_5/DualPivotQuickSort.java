package Exercicios1_2_4_5;

public class DualPivotQuickSort {


    public int[] dualPivotQuickSort(int[] array, int low, int high)//tive que abusar do stackoverflow aqui, não entendi direito por exemplo porque raios o retorno e int?
    {
        if (low < high) {

            int[] pivots = partition(array, low, high);
            int p1 = pivots[0], p2 = pivots[1];

            dualPivotQuickSort(array, low, p1 - 1);
            dualPivotQuickSort(array, p1 + 1, p2 - 1);
            dualPivotQuickSort(array, p2 + 1, high);
        }
        return array;
    }

    private int[] partition(int[] array, int low, int high) {
        if (array[low] > array[high]) {
            swap(array, low, high); // Garante que array[low] <= array[high]
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

        // Coloca os pivôs em suas posições corretas
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
