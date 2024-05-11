import java.util.Scanner;

import br.com.cryptography.cryptoMethods.Methods;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userResponse;
        boolean userPlaying = true;

        Methods methods = new Methods();

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

            if (scanner.hasNextInt()) {
                userResponse = scanner.nextInt();

                if (userResponse == 1) {
                    methods.decryptMessage(scanner);
                } else if (userResponse == 2) {
                    methods.encryptMessage(scanner);
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
                System.out.println("Por favor, digite um número válido");
                scanner.next();
            }
        }
        scanner.close();
    }
}
