public class Q1BuscaSequencial {
    public static int buscaSequencial(int[] vetor, int chave) {
        int i = 0;
        while (i < vetor.length) {
            if (vetor[i] == chave) {
                return i;  // Retorna a posição do elemento encontrado
            }
            i++;
        }
        return -1;  // Retorna -1 se o elemento não for encontrado
    }

    public static void main(String[] args) {
        int[] vetor = {10, 20, 30, 40, 50};
        int chave = 30;

        int resultado = buscaSequencial(vetor, chave);
        if (resultado != -1) {
            System.out.println("Elemento encontrado na posição: " + resultado);
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }
}
