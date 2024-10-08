import java.util.ArrayList;
import java.util.Arrays;

public class Q2BuscaBinariaMultipla {

    public static ArrayList<Integer> buscaBinariaMultipla(int[] vetor, int chave) {
        ArrayList<Integer> posicoes = new ArrayList<>();
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == chave) {
                posicoes.add(meio);

                int esquerda = meio - 1;
                while (esquerda >= 0 && vetor[esquerda] == chave) {
                    posicoes.add(esquerda);
                    esquerda--;
                }

                int direita = meio + 1;
                while (direita < vetor.length && vetor[direita] == chave) {
                    posicoes.add(direita);
                    direita++;
                }
                break;
            } else if (vetor[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return posicoes;
    }

    public static void main(String[] args) {
        int[] vetor = {1, 3, 3, 3, 5, 7, 8, 9, 9};

        int chave = 3;

        ArrayList<Integer> resultado = buscaBinariaMultipla(vetor, chave);

        if (!resultado.isEmpty()) {
            System.out.println("Chave encontrada nas posições: " + resultado);
        } else {
            System.out.println("Chave não encontrada.");
        }
    }
}
