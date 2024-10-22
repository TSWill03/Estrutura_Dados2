package Exercicios2_4_5;

import java.util.Random;
import java.util.Arrays;

public class MainExerc4 {
    public static void main(String[] args) {
        final int ValorMaximo = 100000; //tamanhoArray
        final int numExecucoes = 10;

        Random random = new Random();

        BubbleSort bubbleSort = new BubbleSort();
        BubbleSortMelhorado bubbleSortMelhorado = new BubbleSortMelhorado();

        long[][] timesNano = new long[numExecucoes][2];

        for (int i = 0; i < numExecucoes; i++) {

            int[] ArrayOriginal = new int[ValorMaximo];
            for (int j = 0; j < ValorMaximo; j++) {
                ArrayOriginal[j] = random.nextInt(ValorMaximo);
            }

            int[] bubbleSorted = Arrays.copyOf(ArrayOriginal, ValorMaximo);
            int[] bubbleSortedMelhorado = Arrays.copyOf(ArrayOriginal, ValorMaximo);

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

        System.out.println("Tempo de execução para cada algoritmo e execução:");
        System.out.println("Execução                   |   BubbleSort   |    BubbleSortMelhorado");
        for (int i = 0; i < numExecucoes; i++) {
            System.out.printf("Execução %2d  (Nanoseg):    | %14d | %13d\n",
                    i + 1, timesNano[i][0], timesNano[i][1]);

            System.out.printf("Execução %2d  (Microseg):   | %14d | %13d\n",
                    i + 1, timesNano[i][0] / 1000, timesNano[i][1] / 1000);

            System.out.printf("Execução %2d  (Miliseg):    | %14d | %13d\n",
                    i + 1, timesNano[i][0] / 1000000, timesNano[i][1] / 1000000);

            System.out.println();
        }
    }
}
