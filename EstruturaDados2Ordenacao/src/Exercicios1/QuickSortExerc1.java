package Exercicios1;

import java.util.Arrays;

public class QuickSortExerc1 {
    public int[] quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);

            System.out.println("Depois da separação com pivô em posição " + posicaoPivo + ": " + Arrays.toString(vetor));

            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
        return vetor;
    }

    public int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;

                System.out.println("Depois de trocar elementos: " + Arrays.toString(vetor));
            }
        }

        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        System.out.println("Depois de reposicionar o pivô: " + Arrays.toString(vetor));

        return f;
    }
}
