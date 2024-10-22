package Exercicios2_4_5;

import java.util.Arrays;
import java.util.Random;

public class MainExerc2 {
    public static void main(String[] args) {
        final int tamanhoArray = 100000;
        final int ValorMaximo = 100000;
        final int numExecucoes = 10;

        Random random = new Random();

        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort = new MergeSort();
        SelectionSort selectionSort = new SelectionSort();
        ShellSort shellSort = new ShellSort();
        InsertionSort insertionSort = new InsertionSort();
        QuickSort quickSort = new QuickSort();

        long[][] times = new long[numExecucoes][6];

        for (int i = 0; i < numExecucoes; i++) {

            int[] ArrayOriginal = new int[tamanhoArray];
            for (int j = 0; j < tamanhoArray; j++) {
                ArrayOriginal[j] = random.nextInt(ValorMaximo);
            }

            int[] bubbleSorted = Arrays.copyOf(ArrayOriginal, tamanhoArray);
            int[] insertionSorted = Arrays.copyOf(ArrayOriginal, tamanhoArray);
            int[] selectionSorted = Arrays.copyOf(ArrayOriginal, tamanhoArray);
            int[] shellSorted = Arrays.copyOf(ArrayOriginal, tamanhoArray);
            int[] mergeSorted = Arrays.copyOf(ArrayOriginal, tamanhoArray);
            int[] quickSorted = Arrays.copyOf(ArrayOriginal, tamanhoArray);


            long start = System.currentTimeMillis();
            bubbleSort.bubbleSort(bubbleSorted);
            times[i][0] = System.currentTimeMillis() - start;
            System.out.println("Rodou BubbleSort");

            start = System.currentTimeMillis();
            insertionSort.insertionSort(insertionSorted);
            times[i][1] = System.currentTimeMillis() - start;
            System.out.println("Rodou InsertionSort");

            start = System.currentTimeMillis();
            selectionSort.selectionSort(selectionSorted);
            times[i][2] = System.currentTimeMillis() - start;
            System.out.println("Rodou SelectionSort");

            start = System.currentTimeMillis();
            shellSort.shellSort(shellSorted);
            times[i][3] = System.currentTimeMillis() - start;
            System.out.println("Rodou ShellSort");

            start = System.currentTimeMillis();
            mergeSort.mergeSort(mergeSorted);
            times[i][4] = System.currentTimeMillis() - start;
            System.out.println("Rodou MergeSort");

            start = System.currentTimeMillis();
            quickSort.quickSort(quickSorted, 0, quickSorted.length - 1);
            times[i][5] = System.currentTimeMillis() - start;
            System.out.println("Rodou QuickSort");

            System.out.println("Execução " + (i + 1) + " finalizada\n");
        }


        System.out.println("Tempo de execução (em milissegundos) para cada algoritmo e execução:");
        System.out.println("Execução  | BubbleSort | InsertionSort | SelectionSort | ShellSort | MergeSort | QuickSort");
        for (int i = 0; i < numExecucoes; i++) {
            System.out.printf("%9d | %10d | %13d | %13d | %9d | %9d | %9d\n",
                    i + 1, times[i][0], times[i][1], times[i][2], times[i][3], times[i][4], times[i][5]);
        }
    }
}