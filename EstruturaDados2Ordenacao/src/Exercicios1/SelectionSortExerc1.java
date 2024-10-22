package Exercicios1;

import java.util.Arrays;

public class SelectionSortExerc1 {
    public int[] selectionSort(int[] vetor) {
        boolean trocou;

        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            trocou = false;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }

            if (i != menor) {
                vetor[i] = vetor[i] + vetor[menor];
                vetor[menor] = vetor[i] - vetor[menor];
                vetor[i] = vetor[i] - vetor[menor];

                trocou = true;
                System.out.println(Arrays.toString(vetor));
            }

            if (!trocou) {
                break;
            }
        }

        return vetor;
    }
}
