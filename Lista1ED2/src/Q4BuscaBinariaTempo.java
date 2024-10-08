import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q4BuscaBinariaTempo {

    public static void preencherVetor(int[] vetor) {
        Random rand = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(10001);
        }
    }

    public static int buscaBinaria(int[] vetor, int chave) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == chave) {
                return meio;
            } else if (vetor[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[100000];

        preencherVetor(vetor);

        System.out.print("Digite o valor que deseja buscar (entre 0 e 10.000): ");
        int chave = scanner.nextInt();

        long tempoInicialSemOrdenacao = System.nanoTime();
        int resultadoSemOrdenacao = buscaBinaria(vetor, chave);
        long tempoFinalSemOrdenacao = System.nanoTime();

        System.out.println("Busca sem ordenação:");
        if (resultadoSemOrdenacao != -1) {
            System.out.println("Elemento encontrado na posição: " + resultadoSemOrdenacao);
        } else {
            System.out.println("Elemento não encontrado (como esperado, sem ordenação).");
        }
        double tempoGastoSemOrdenacao = (tempoFinalSemOrdenacao - tempoInicialSemOrdenacao) / 1e6;
        System.out.printf("Tempo gasto na busca sem ordenação: %.6f ms\n", tempoGastoSemOrdenacao);

        long tempoInicialOrdenacao = System.nanoTime();
        Arrays.sort(vetor);
        long tempoFinalOrdenacao = System.nanoTime();

        long tempoInicialComOrdenacao = System.nanoTime();
        int resultadoComOrdenacao = buscaBinaria(vetor, chave);
        long tempoFinalComOrdenacao = System.nanoTime();

        System.out.println("\nBusca com ordenação:");
        if (resultadoComOrdenacao != -1) {
            System.out.println("Elemento encontrado na posição: " + resultadoComOrdenacao);
        } else {
            System.out.println("Elemento não encontrado.");
        }

        double tempoGastoOrdenacao = (tempoFinalOrdenacao - tempoInicialOrdenacao) / 1e6;
        double tempoGastoComOrdenacao = (tempoFinalComOrdenacao - tempoInicialComOrdenacao) / 1e6;

        System.out.printf("Tempo gasto na ordenação: %.6f ms\n", tempoGastoOrdenacao);
        System.out.printf("Tempo gasto na busca com ordenação: %.6f ms\n", tempoGastoComOrdenacao);

        scanner.close();
    }
}
