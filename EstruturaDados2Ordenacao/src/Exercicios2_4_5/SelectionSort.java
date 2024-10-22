package Exercicios2_4_5;

public class SelectionSort {
    public int[] selectionSort(int[] vetor) {
        for (int i = 0; i < vetor.length -1; i ++){
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++){
                if (vetor[j] < vetor[menor]){
                    menor = j;
                }
            }
            if (i != menor){
                vetor[i] = vetor[i] + vetor[menor];
                vetor[menor] = vetor[i] - vetor[menor];
                vetor[i] = vetor[i] - vetor[menor];
            }
        }

        return vetor;
    }
}
