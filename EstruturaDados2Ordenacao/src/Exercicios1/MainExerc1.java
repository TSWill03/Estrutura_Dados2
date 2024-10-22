package Exercicios1;


import java.util.Arrays;

public class MainExerc1 {
    public static void main(String[] args) {
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
        show.show(bubbleSort.bubbleSort(bubbleSorted));

        System.out.println("InsertionSort");
        show.show(insertionSort.insertionSort(insertionSorted));

        System.out.println("SelectionSort");
        show.show(selectionSort.selectionSort(selectionSorted));

        System.out.println("ShellSort");
        show.show(shellSort.shellSort(shellSorted));

        System.out.println("MergeSort");
        show.show(mergeSort.mergeSort(mergeSorted));

        System.out.println("QuickSort");
        show.show(quickSort.quickSort(quickSorted, 0, quickSorted.length - 1));
    }
}
