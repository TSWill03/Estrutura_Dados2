package Exercicios2_4_5;

import java.util.Random;
import java.util.Arrays;

public class MainExerc4 {
    public static void main(String[] args) {
        final int tamanhoArray = 100000;
        final int ValorMaximo = 100000;
        final int numExecucoes = 10;

        Random random = new Random();

        BubbleSort bubbleSort = new BubbleSort();
        BubbleSortMelhorado bubbleSortMelhorado = new BubbleSortMelhorado();

        long[][] times = new long[numExecucoes][2];

        for (int i = 0; i < numExecucoes; i++) {

            int[] ArrayOriginal = new int[tamanhoArray];
            for (int j = 0; j < tamanhoArray; j++) {
                ArrayOriginal[j] = random.nextInt(ValorMaximo);
            }

            int[] bubbleSorted = Arrays.copyOf(ArrayOriginal, tamanhoArray);
            int[] bubbleSortedMelhorado = Arrays.copyOf(ArrayOriginal, tamanhoArray);

            // Medindo o tempo do BubbleSort tradicional
            long start = System.currentTimeMillis();
            bubbleSort.bubbleSort(bubbleSorted);
            times[i][0] = System.currentTimeMillis() - start;
            System.out.println("Rodou BubbleSort");

            // Medindo o tempo do BubbleSort melhorado
            start = System.currentTimeMillis();
            bubbleSortMelhorado.bubbleSort(bubbleSortedMelhorado);
            times[i][1] = System.currentTimeMillis() - start;
            System.out.println("Rodou BubbleSortMelhorado");

            System.out.println("Execução " + (i + 1) + " finalizada\n");
        }

        // Exibindo os tempos de execução para ambos os algoritmos
        System.out.println("Tempo de execução (em milissegundos) para cada algoritmo e execução:");
        System.out.println("Execução  | BubbleSort   | BubbleSortMelhorado");
        for (int i = 0; i < numExecucoes; i++) {
            System.out.printf("%9d | %12d | %19d \n",
                    i + 1, times[i][0], times[i][1]);
        }
    }
}
