package juegocartas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            showMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        int option;
        do {
            System.out.println("Bienvenido a Poker!");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Mezclar deck");
            System.out.println("2. Sacar una carta");
            System.out.println("3. Carta al azar");
            System.out.println("4. Generar una mano de 5 cartas");
            System.out.println("0. Salir");

            System.out.print("Opción: ");
            option = scanner.nextInt();

            if (option < 0 || option > 4) {
                System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            } else {
                handleOption(option, deck);
            }
        } while (option != 0);

        scanner.close();
    }

    private static void handleOption(int option, Deck deck) throws Exception {
        switch (option) {
            case 1:
                deck.shuffle();
                break;
            case 2:
                deck.head();
                break;
            case 3:
                deck.pick();
                break;
            case 4:
                deck.hand(5);
                break;
            case 0:
                System.out.println("¡Hasta luego!");
                break;
        }
    }
}
