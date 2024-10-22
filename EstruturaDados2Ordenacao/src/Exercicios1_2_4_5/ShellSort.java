package Exercicios1_2_4_5;

public class ShellSort {
    public int[] shellSort(int[] vetor){
        int n = vetor.length;
        int h = 1;

        while (h < n) {
            h = 3 * h + 1;
        }
        while (h > 1) {
            h = h / 3;
            for (int i = h; i < n; i++) {
                int c = vetor[i];
                int j = i - h;
                while (j >= 0 && vetor[j] > c) {
                    vetor[j + h] = vetor[j];
                    j -= h;
                }
                vetor[j + h] = c;
            }
        }

        return vetor;
    }
}
