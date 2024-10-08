import java.util.Random;
import java.util.Scanner;

public class Q3BuscaSequencialTempo {

    public static void preencherVetor(int[] vetor) {
        Random rand = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(10001);
        }
    }

    public static int buscaSequencial(int[] vetor, int chave) {
        int i = 0;
        while (i < vetor.length) {
            if (vetor[i] == chave) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[100000];

        preencherVetor(vetor);

        System.out.print("Digite o valor que deseja buscar (entre 0 e 10.000): ");
        int chave = scanner.nextInt();

        long tempoInicial = System.nanoTime();
        int resultado = buscaSequencial(vetor, chave);
        long tempoFinal = System.nanoTime();

        System.out.println("Busca sequencial:");
        if (resultado != -1) {
            System.out.println("Elemento encontrado na posição: " + resultado);
        } else {
            System.out.println("Elemento não encontrado.");
        }

        double tempoGasto = (tempoFinal - tempoInicial) / 1e6;
        System.out.printf("Tempo gasto na busca: %.6f ms\n", tempoGasto);

        scanner.close();
    }
}
