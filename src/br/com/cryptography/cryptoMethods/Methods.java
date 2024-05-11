package br.com.cryptography.cryptoMethods;

import br.com.cryptography.cryptoMethods.cryptography.CaesarCipher;
import br.com.cryptography.cryptoMethods.cryptography.MorseCode;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {
    public void decryptMessage(Scanner scanner) {
        System.out.println("""
                -------------------------
                Você deseja Decriptar em:
                Cifra de César, Digite: 1
                Código Morse, Digite: 2""");

        int userResponse;

        try {
            userResponse = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, digite um número válido");
            System.out.println(e.getMessage());
            scanner.nextLine();
            return;
        }

        switch (userResponse) {
            case 1 -> {
                System.out.println("Digite a frase que deseja Decriptar: ");
                String message = scanner.nextLine();
                System.out.println("Digite a chave da cifra de César: ");
                try {
                    int key = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do scanner
                    CaesarCipher cipher = new CaesarCipher(key);
                    String messageDecrypt = cipher.decryptMessage(message);
                    System.out.println("Mensagem descriptografada: " + messageDecrypt);
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, digite um número válido como chave");
                    System.out.println("Valor retorna: " + e.getMessage());
                    scanner.nextLine();
                }
            }
            case 2 -> {
                System.out.println("Digite a frase que deseja Decriptar: ");
                String message = scanner.nextLine();
                String decryptedMessage = MorseCode.decrypt(message);
                System.out.println("Mensagem descriptografada: " + decryptedMessage);
            }
            default -> System.out.println("Por favor, digite um número válido");
        }
    }

    public void encryptMessage(Scanner scanner) {
        System.out.println("""
                -------------------------
                Você deseja Encriptar em:
                Cifra de César, Digite: 1
                Código Morse, Digite: 2""");

        int userResponse;
        try {
            userResponse = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, digite um número válido");
            scanner.nextLine();
            return;
        }

        switch (userResponse) {
            case 1 -> {
                System.out.println("Digite a frase que deseja Encriptar: ");
                String message = scanner.nextLine();
                System.out.println("Digite a chave da cifra de César: ");
                try {
                    int key = scanner.nextInt();
                    scanner.nextLine();
                    CaesarCipher cipher = new CaesarCipher(key);
                    String messageEncrypt = cipher.encryptMessage(message);
                    System.out.println("Mensagem criptografada: " + messageEncrypt);
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, digite um número válido como chave");
                    System.out.println("Valor retorna: " + e.getMessage());
                    scanner.nextLine();
                }
            }
            case 2 -> {
                System.out.println("Digite a frase que deseja Encriptar: ");
                String message = scanner.nextLine();
                String encryptedMessage = MorseCode.encrypt(message);
                System.out.println("Mensagem criptografada: " + encryptedMessage);
            }
            default -> System.out.println("Por favor, digite um número válido");
        }
    }
}
