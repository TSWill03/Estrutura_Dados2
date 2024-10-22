package Exercicios2_4_5;

public class InsertionSort {
    public int[] insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int key = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > key) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = key;
        }
        return vetor;
    }
}
