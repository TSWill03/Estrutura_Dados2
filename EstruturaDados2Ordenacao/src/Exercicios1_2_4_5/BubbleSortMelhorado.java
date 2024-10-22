package Exercicios1_2_4_5;

public class BubbleSortMelhorado {
    public int[] bubbleSort(int[] vetor) {
        boolean swapped;
        for (int i = 0; i < vetor.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {

                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return vetor;
    }
}
