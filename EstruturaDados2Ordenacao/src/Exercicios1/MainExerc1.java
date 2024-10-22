package Exercicios1;

import java.util.Arrays;

public class MainExerc1 {
    public static void main(String[] args) {
        long[] timesNano = new long[6];
        int[] vetorMain = {3, 4, 9, 2, 5, 8, 1};
        Exiba show = new Exiba();

        BubbleSortExerc1 bubbleSort = new BubbleSortExerc1();
        MergeSortExerc1 mergeSort = new MergeSortExerc1();
        SelectionSortExerc1 selectionSort = new SelectionSortExerc1();
        ShellSortExerc1 shellSort = new ShellSortExerc1();
        InsertionSortExerc1 insertionSort = new InsertionSortExerc1();
        QuickSortExerc1 quickSort = new QuickSortExerc1();

        int[] bubbleSorted = Arrays.copyOf(vetorMain, vetorMain.length);
        int[] insertionSorted = Arrays.copyOf(vetorMain, vetorMain.length);
        int[] selectionSorted = Arrays.copyOf(vetorMain, vetorMain.length);
        int[] shellSorted = Arrays.copyOf(vetorMain, vetorMain.length);
        int[] mergeSorted = Arrays.copyOf(vetorMain, vetorMain.length);
        int[] quickSorted = Arrays.copyOf(vetorMain, vetorMain.length);


        System.out.println("BubbleSort");
        long startTime = System.nanoTime();
        show.show(bubbleSort.bubbleSort(bubbleSorted));
        long endTime = System.nanoTime();
        timesNano[0] = endTime - startTime;

        System.out.println("InsertionSort");
        startTime = System.nanoTime();
        show.show(insertionSort.insertionSort(insertionSorted));
        endTime = System.nanoTime();
        timesNano[1] = endTime - startTime;

        System.out.println("SelectionSort");
        startTime = System.nanoTime();
        show.show(selectionSort.selectionSort(selectionSorted));
        endTime = System.nanoTime();
        timesNano[2] = endTime - startTime;

        System.out.println("ShellSort");
        startTime = System.nanoTime();
        show.show(shellSort.shellSort(shellSorted));
        endTime = System.nanoTime();
        timesNano[3] = endTime - startTime;

        System.out.println("MergeSort");
        startTime = System.nanoTime();
        show.show(mergeSort.mergeSort(mergeSorted));
        endTime = System.nanoTime();
        timesNano[4] = endTime - startTime;


        System.out.println("QuickSort");
        startTime = System.nanoTime();
        show.show(quickSort.quickSort(quickSorted, 0, quickSorted.length - 1));
        endTime = System.nanoTime();
        timesNano[5] = endTime - startTime;



        System.out.println("Tempo de execução (em nanosegundos, microssegundos e milissegundos) para cada algoritmo:");
        System.out.println("Execução  | BubbleSort | InsertionSort | SelectionSort | ShellSort | MergeSort | QuickSort");

        System.out.printf("Nanoseg   | %10d | %13d | %13d | %9d | %9d | %9d\n",
                timesNano[0], timesNano[1], timesNano[2], timesNano[3], timesNano[4], timesNano[5]);

        System.out.printf("Microseg  | %10d | %13d | %13d | %9d | %9d | %9d\n",
                timesNano[0]/1000, timesNano[1]/1000, timesNano[2]/1000, timesNano[3]/1000, timesNano[4]/1000, timesNano[5]/1000);

        System.out.printf("Miliseg   | %10d | %13d | %13d | %9d | %9d | %9d\n",
                timesNano[0]/1000000, timesNano[1]/1000000, timesNano[2]/1000000, timesNano[3]/1000000, timesNano[4]/1000000, timesNano[5]/1000000);
    }
}
