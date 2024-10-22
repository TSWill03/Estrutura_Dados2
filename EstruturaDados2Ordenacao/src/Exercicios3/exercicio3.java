package Exercicios3;

import java.util.ArrayList;
import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listaOrdenada = new ArrayList<>();

        System.out.println("Digite quantos valores você quer inserir:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite o valor " + (i + 1) + ":");
            int valor = scanner.nextInt();
            insert(listaOrdenada, valor);
            System.out.println("Lista atual: " + listaOrdenada);
        }

        scanner.close();
    }

    public static void insert(ArrayList<Integer> list, int value) {
        int i = list.size() - 1;
        list.add(value);
        while (i >= 0 && list.get(i) > value) {
            list.set(i + 1, list.get(i));
            i--;
        }
        list.set(i + 1, value);
    }
}
