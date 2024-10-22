package Exercicios2_4_5;

public class MergeSort {
    public int[] mergeSort(int[] vetor){
        if (vetor.length > 1){
            int meio = vetor.length / 2;
            int[] esquerda = new int[meio];
            int[] direita = new int[vetor.length - meio];

            for (int i = 0; i < meio; i++){
                esquerda[i] = vetor[i];
            }
            for (int i = meio; i < vetor.length; i++){
                direita[i - meio] = vetor[i];
            }

            mergeSort(esquerda);
            mergeSort(direita);

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < esquerda.length && j < direita.length){
                if (esquerda[i] < direita[j]){
                    vetor[k] = esquerda[i];
                    i++;
                } else {
                    vetor[k] = direita[j];
                    j++;
                }
                k++;
            }

            while (i < esquerda.length){
                vetor[k] = esquerda[i];
                i++;
                k++;
            }

            while (j < direita.length){
                vetor[k] = direita[j];
                j++;
                k++;
            }
        }



        return vetor;
    }
}
