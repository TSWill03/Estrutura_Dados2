package Exercicios1;

import java.util.Arrays;

public class BubbleSortExerc1 {
    public int[] bubbleSort(int[] vetor) {
        for(int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    vetor[j] = vetor[j] + vetor[j + 1];
                    vetor[j + 1] = vetor[j] - vetor[j + 1];
                    vetor[j] = vetor[j] - vetor[j + 1];
                    System.out.println(Arrays.toString(vetor));
                }
            }
        }
        return vetor;
    }
}