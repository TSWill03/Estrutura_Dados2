import java.util.ArrayList;

public class Q2BuscaSequencialMultipla {
    public static ArrayList<Integer> buscaSequencial(int[] vetor, int chave) {
        ArrayList<Integer> posicoes = new ArrayList<>();
        int i = 0;
        while (i < vetor.length) {
            if (vetor[i] == chave) {
                posicoes.add(i);
            }
            i++;
        }
        return posicoes;
    }

    public static void main(String[] args) {
        int[] vetor = {5, 3, 8, 1, 9, 3, 2, 7, 6};

        int chave = 3;

        ArrayList<Integer> resultado = buscaSequencial(vetor, chave);

        if (!resultado.isEmpty()) {
            System.out.println("Chave encontrada nas posições: " + resultado);
        } else {
            System.out.println("Chave não encontrada.");
        }
    }
}
