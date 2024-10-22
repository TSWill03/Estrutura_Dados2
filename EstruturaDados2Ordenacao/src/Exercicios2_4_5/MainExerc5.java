package Exercicios2_4_5;

import java.util.Arrays;
import java.util.Random;

public class MainExerc5 {
    public static void main(String[] args) {
        final int ValorMaximo = 100_000_000;
        final int numExecucoes = 10;

        Random random = new Random();

        DualPivotQuickSort dualPivotQuickSort = new DualPivotQuickSort();
        QuickSort quickSort = new QuickSort();

        long[][] timesNano = new long[numExecucoes][2];

        for (int i = 0; i < numExecucoes; i++) {

            int[] ArrayOriginal = new int[ValorMaximo];
            for (int j = 0; j < ValorMaximo; j++) {
                ArrayOriginal[j] = random.nextInt(ValorMaximo);
            }

            int[] DualpivotArray = Arrays.copyOf(ArrayOriginal, ValorMaximo);
            int[] quickArray = Arrays.copyOf(ArrayOriginal, ValorMaximo);


            long start = System.nanoTime();
            dualPivotQuickSort.dualPivotQuickSort(DualpivotArray, 0, DualpivotArray.length - 1);
            timesNano[i][0] = System.nanoTime() - start;
            System.out.println("Rodou QuickSortDualPivot");


            start = System.nanoTime();
            quickSort.quickSort(quickArray, 0, quickArray.length - 1);
            timesNano[i][1] = System.nanoTime() - start;
            System.out.println("Rodou QuickSort");

            System.out.println("Execução " + (i + 1) + " finalizada\n");
        }


        System.out.println("Tempo de execução para cada algoritmo e execução:");
        System.out.println("Execução                   | QuickSortDual |    QuickSort");
        for (int i = 0; i < numExecucoes; i++) {

            System.out.printf("Execução %2d  (Nanoseg):    | %13d | %13d\n",
                    i + 1, timesNano[i][0], timesNano[i][1]);
            
            System.out.printf("Execução %2d  (Microseg):   | %13d | %13d\n",
                    i + 1, timesNano[i][0] / 1000, timesNano[i][1] / 1000);

            System.out.printf("Execução %2d  (Miliseg):    | %13d | %13d\n",
                    i + 1, timesNano[i][0] / 1000000, timesNano[i][1] / 1000000);
            
            System.out.printf("Execução %2d  (Seg):        | %13d | %13d\n",
                    i + 1, timesNano[i][0] / 1000000000, timesNano[i][1] / 1000000000);
            
            System.out.println();
        }
    }
}
