package Exercicios1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] vetorMain = {3, 4, 9, 2, 5, 8, 1};
        Exiba show = new Exiba();

        MergeSortExerc1 shellSort = new MergeSortExerc1();

        int[] shellSorted = Arrays.copyOf(vetorMain, vetorMain.length);

        System.out.println("ShellSort");
        show.show(shellSort.mergeSort(shellSorted));
    }
}
