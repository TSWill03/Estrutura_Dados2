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

        long[][] timesNano = new long[numExecucoes][6];

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

            long start = System.nanoTime();
            bubbleSort.bubbleSort(bubbleSorted);
            long end = System.nanoTime();
            timesNano[i][0] = end - start;
            System.out.println("Rodou BubbleSort");

            start = System.nanoTime();
            insertionSort.insertionSort(insertionSorted);
            end = System.nanoTime();
            timesNano[i][1] = end - start;
            System.out.println("Rodou InsertionSort");

            start = System.nanoTime();
            selectionSort.selectionSort(selectionSorted);
            end = System.nanoTime();
            timesNano[i][2] = end - start;
            System.out.println("Rodou SelectionSort");

            start = System.nanoTime();
            shellSort.shellSort(shellSorted);
            end = System.nanoTime();
            timesNano[i][3] = end - start;
            System.out.println("Rodou ShellSort");

            start = System.nanoTime();
            mergeSort.mergeSort(mergeSorted);
            end = System.nanoTime();
            timesNano[i][4] = end - start;
            System.out.println("Rodou MergeSort");

            start = System.nanoTime();
            quickSort.quickSort(quickSorted, 0, quickSorted.length - 1);
            end = System.nanoTime();
            timesNano[i][5] = end - start;
            System.out.println("Rodou QuickSort");

            System.out.println("Execução " + (i + 1) + " finalizada\n");
        }
        System.out.println("Tempo de execução (em nanosegundos, microssegundos e milissegundos) para cada algoritmo e execução:");
        System.out.println("Execução  | BubbleSort | InsertionSort | SelectionSort | ShellSort | MergeSort | QuickSort");

        for (int i = 0; i < numExecucoes; i++) {

            System.out.printf("Execução %d (Nanoseg):   | %13d | %13d | %13d | %9d | %9d | %9d\n",
                    i + 1, timesNano[i][0], timesNano[i][1], timesNano[i][2], timesNano[i][3], timesNano[i][4], timesNano[i][5]);

            System.out.printf("Execução %d (Microseg):  | %13d | %13d | %13d | %9d | %9d | %9d\n",
                    i + 1, timesNano[i][0] / 1000, timesNano[i][1] / 1000, timesNano[i][2] / 1000, timesNano[i][3] / 1000, timesNano[i][4] / 1000, timesNano[i][5] / 1000);

            System.out.printf("Execução %d (Miliseg):   | %13d | %13d | %13d | %9d | %9d | %9d\n",
                    i + 1, timesNano[i][0] / 1000000, timesNano[i][1] / 1000000, timesNano[i][2] / 1000000, timesNano[i][3] / 1000000, timesNano[i][4] / 1000000, timesNano[i][5] / 1000000);

            System.out.println();
        }
    }
}
