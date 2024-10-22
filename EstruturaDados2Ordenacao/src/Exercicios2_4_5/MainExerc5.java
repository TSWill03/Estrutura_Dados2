package Exercicios2_4_5;

import java.util.Arrays;
import java.util.Random;

public class MainExerc5 {
    public static void main(String[] args) {
        final int tamanhoArray = 100000;
        final int ValorMaximo = 100000;
        final int numExecucoes = 10;

        Random random = new Random();

        DualPivotQuickSort dualPivotQuickSort = new DualPivotQuickSort();
        QuickSort quickSort = new QuickSort();

        long[][] times = new long[numExecucoes][2];

        for (int i = 0; i < numExecucoes; i++) {

            int[] ArrayOriginal = new int[tamanhoArray];
            for (int j = 0; j < tamanhoArray; j++) {
                ArrayOriginal[j] = random.nextInt(ValorMaximo);
            }

            int[] DualpivotArray = Arrays.copyOf(ArrayOriginal, tamanhoArray);
            int[] quickArray = Arrays.copyOf(ArrayOriginal, tamanhoArray);

            // Medindo o tempo do DualPivotQuickSort
            long start = System.currentTimeMillis();
            dualPivotQuickSort.dualPivotQuickSort(DualpivotArray, 0, DualpivotArray.length - 1);
            times[i][0] = System.currentTimeMillis() - start;
            System.out.println("Rodou QuickSortDualPivot");

            // Medindo o tempo do QuickSort tradicional
            start = System.currentTimeMillis();
            quickSort.quickSort(quickArray, 0, quickArray.length - 1);
            times[i][1] = System.currentTimeMillis() - start;
            System.out.println("Rodou QuickSort");

            System.out.println("Execução " + (i + 1) + " finalizada\n");
        }

        // Exibindo os tempos de execução para ambos os algoritmos
        System.out.println("Tempo de execução (em milissegundos) para cada algoritmo e execução:");
        System.out.println("Execução  | QuickSortDual | QuickSort");
        for (int i = 0; i < numExecucoes; i++) {
            System.out.printf("%9d | %13d | %10d \n",
                    i + 1, times[i][0], times[i][1]);
        }
    }
}
