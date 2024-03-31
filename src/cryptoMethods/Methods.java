package cryptoMethods;

import cryptoMethods.cryptography.CaesarCipher;
import cryptoMethods.cryptography.MorseCode;

import java.util.Scanner;
public class Methods {
    private static void decryptMessageInternal(Scanner scanner) {
        System.out.println("""
                -------------------------
                Você deseja Decriptar em:
                Cifra de César, Digite: 1
                Código Morse, Digite: 2""");

        int userResponse = scanner.nextInt();
        scanner.nextLine();

        switch (userResponse) {
            case 1 -> {
                System.out.println("Digite a frase que deseja Decriptar: ");
                String message = scanner.nextLine();
                System.out.println("Digite a chave da cifra de César: ");
                int key = Integer.parseInt(scanner.nextLine());
                CaesarCipher cipher = new CaesarCipher(key);
                String messageDecrypt = cipher.decryptMessage(message);
                System.out.println("Mensagem descriptografada: " + messageDecrypt);
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

    private static void encryptMessageInternal(Scanner scanner) {
        System.out.println("""
                -------------------------
                Você deseja Encriptar em:
                Cifra de César, Digite: 1
                Código Morse, Digite: 2""");

        int userResponse = scanner.nextInt();
        scanner.nextLine();

        switch (userResponse) {
            case 1 -> {
                System.out.println("Digite a frase que deseja Encriptar: ");
                String message = scanner.nextLine();
                System.out.println("Digite a chave da cifra de César: ");
                int key = Integer.parseInt(scanner.nextLine());
                CaesarCipher cipher = new CaesarCipher(key);
                String messageEncrypt = cipher.encryptMessage(message);
                System.out.println("Mensagem criptografada: " + messageEncrypt);
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

    public static void decryptMessage(Scanner scanner) {
        decryptMessageInternal(scanner);
    }
    public static void encryptMessage(Scanner scanner) {
        encryptMessageInternal(scanner);
    }
}
