package Exercicios1;

import java.util.Arrays;

public class ShellSortExerc1 {
    public int[] shellSort(int[] vetor) {
        int n = vetor.length;
        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;
        }


        while (h >= 1) {
            boolean trocou = false;

            for (int i = h; i < n; i++) {
                int c = vetor[i];
                int j = i - h;
                boolean houveTrocaInterna = false;

                while (j >= 0 && vetor[j] > c) {
                    vetor[j + h] = vetor[j];
                    j -= h;
                    houveTrocaInterna = true;
                }

                vetor[j + h] = c;

                if (houveTrocaInterna) {
                    System.out.println(Arrays.toString(vetor));
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }


            h = h / 3;
        }

        return vetor;
    }
}
