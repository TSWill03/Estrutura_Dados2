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

        long[][] timesNano = new long[numExecucoes][2];

        for (int i = 0; i < numExecucoes; i++) {

            int[] ArrayOriginal = new int[tamanhoArray];
            for (int j = 0; j < tamanhoArray; j++) {
                ArrayOriginal[j] = random.nextInt(ValorMaximo);
            }

            int[] bubbleSorted = Arrays.copyOf(ArrayOriginal, tamanhoArray);
            int[] bubbleSortedMelhorado = Arrays.copyOf(ArrayOriginal, tamanhoArray);

            long start = System.currentTimeMillis();
            bubbleSort.bubbleSort(bubbleSorted);
            timesNano[i][0] = System.currentTimeMillis() - start;
            System.out.println("Rodou BubbleSort");

            start = System.currentTimeMillis();
            bubbleSortMelhorado.bubbleSort(bubbleSortedMelhorado);
            timesNano[i][1] = System.currentTimeMillis() - start;
            System.out.println("Rodou BubbleSortMelhorado");

            System.out.println("Execução " + (i + 1) + " finalizada\n");
        }

        System.out.println("Tempo de execução (em milissegundos) para cada algoritmo e execução:");
        System.out.println("Execução  | BubbleSort   | BubbleSortMelhorado");
        for (int i = 0; i < numExecucoes; i++) {
            System.out.printf("Execução %d (Nanoseg):   | %13d | %13d\n",
                    i + 1, timesNano[i][0], timesNano[i][1]);

            System.out.printf("Execução %d (Microseg):  | %13d | %13d\n",
                    i + 1, timesNano[i][0] / 1000, timesNano[i][1] / 1000);

            System.out.printf("Execução %d (Miliseg):   | %13d | %13d\n",
                    i + 1, timesNano[i][0] / 1000000, timesNano[i][1] / 1000000);

            System.out.println();
        }
    }
}
