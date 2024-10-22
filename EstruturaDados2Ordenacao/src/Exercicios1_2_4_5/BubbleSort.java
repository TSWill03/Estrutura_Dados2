package Exercicios1_2_4_5;

public class BubbleSort {
    public int[] bubbleSort(int[] vetor) {
        for(int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    vetor[j] = vetor[j] + vetor[j + 1];
                    vetor[j + 1] = vetor[j] - vetor[j + 1];
                    vetor[j] = vetor[j] - vetor[j + 1];
                }
            }
        }
        return vetor;
    }
}