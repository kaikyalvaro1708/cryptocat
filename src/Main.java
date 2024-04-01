import java.util.Scanner;
import cryptoMethods.Methods;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userResponse;
        boolean userPlaying = true;

        System.out.println("""
                --------------------------------
                Olá, seja bem-vindo ao CryptoCat!
                        /\\_/\\ 
                       ( o.o )
                        > ^ <\
                """);

        while (userPlaying) {
            System.out.print("""
                    ----------------------------------
                    O que você deseja?
                     - Decriptar uma frase, digite: 1
                     - Encriptar uma frase, digite: 2
                     - Sair do programa, digite: 3
                                    
                    Sua resposta:
                    """);

            // Verifica se a próxima entrada é um número inteiro
            if (scanner.hasNextInt()) {
                userResponse = scanner.nextInt();

                if (userResponse == 1) {
                    Methods.decryptMessage(scanner);
                } else if (userResponse == 2) {
                    Methods.encryptMessage(scanner);
                } else if (userResponse == 3) {
                    System.out.println("""
                            ----------------------------------
                            Obrigado por participar! Até logo!
                             /\\_/\\ 
                            ( o.o )
                             > ^ <\
                            """);
                    userPlaying = false;
                } else {
                    System.out.println("Por favor, digite um número válido");
                }
            } else {
                // Limpa o buffer do scanner e exibe uma mensagem de erro
                System.out.println("Por favor, digite um número válido");
                scanner.next(); // Limpa o buffer do scanner
            }
        }
    }
}
