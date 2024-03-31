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

            userResponse = scanner.nextInt();

            switch (userResponse) {
                case 1 -> Methods.decryptMessage(scanner);
                case 2 -> Methods.encryptMessage(scanner);
                case 3 -> {
                    System.out.println("""
                            Obrigado por participar! Até logo!
                             /\\_/\\ 
                            ( o.o )
                             > ^ <\
                            """);
                    userPlaying = false;
                }
                default -> System.out.println("Por favor, digite um número válido");

            }
        }
    }
}