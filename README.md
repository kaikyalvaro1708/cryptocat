# Sistema de criptografia - CryptoCat

# Funcionamento do projeto

O nosso sistema de criptografia consiste em um menu com duas opções: Decriptar ou Encriptar. 
Logo após o usuário escolher a opção desejada, é perguntado qual sistema de criptografia quer utilizar: cifra de césar ou código morse.

## Cifra de César
![image](https://github.com/kaikyalvaro1708/dynamic_task/assets/126626704/8dacd21f-2223-427f-b8d7-680d04481779)

- Caso o usuário deseja encriptar uma mensagem em cifra de césar, basta digitar "1".
- Logo depois é perguntado a frase ou palavra.
- E em seguída, o número da "chave" que seria a quantidade de casas para frente que é pulado. No caso acima, a chave é 3.

### Resultado: hahpsor whvwh

Para decriptar a mensagem, o passo a passo é o mesmo.

![image](https://github.com/kaikyalvaro1708/dynamic_task/assets/126626704/2f363eb0-70b2-4e70-9880-0e7cccc9ccc4)

- O usuário escolhe decriptar com cifra de césar digitando "1".
- Logo após, basta colocar a texto que deseja decriptar "hahpsor whvwh"
- Em seguída, a chave, que nesse caso é 3.

### Resultado: exemplo teste

## Código Morse

![image](https://github.com/kaikyalvaro1708/dynamic_task/assets/126626704/ac0fd763-cd5e-4e5f-abae-63a4249e3600)

- Para encriptar um texto em código morse, basta escolher a opção "2" de código morse
- Em seguída, colocar o texto que deseja encriptar

### Resultado: . -..- . -- .--. .-.. --- / - . ... - .

![image](https://github.com/kaikyalvaro1708/dynamic_task/assets/126626704/38720d53-e847-4dfa-81b8-dab9762f5302)

- Para decriptar uma mensagem, basta digitar a opção "2".
- Após isso, colocar o código corse que logo é descriptografado.

### Resultado: EXEMPLO TESTE

---

# Entendendo o código 

## Arquivo Main.java
```Java
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
```
- Importações de Pacotes: O código importa a classe Scanner do pacote java.util e uma classe Methods d0 pacote chamado br.com.cryptography.cryptoMethods.
  
- Inicialização de Variáveis: Inicializa um objeto Scanner para entrada do usuário, bem como outras variáveis como userResponse para armazenar a resposta do usuário e userPlaying para controlar se o usuário deseja continuar no programa.

- Instanciação de Methods: Cria uma instância da classe Methods.
  
- Mensagem de Boas-Vindas: Imprime uma mensagem de boas-vindas, com o menu de opções.
  
- Loop While: Inicia um loop while que continuará enquanto userPlaying for verdadeiro, ou seja, estiver ativo.
  
- Menu de Opções: Imprime um menu de opções para o usuário, pedindo-lhe para escolher entre descriptografar uma frase (opção 1), criptografar uma frase (opção 2) ou sair do programa (opção 3).

- Entrada do Usuário: O programa espera pela entrada do usuário usando o Scanner.
  
- Processamento da Entrada: Verifica se a entrada do usuário é um número inteiro. Se for, processa a entrada de acordo com a escolha do usuário.

- Chamada de Métodos: Se o usuário escolher descriptografar uma frase (opção 1), chama o método decryptMessage da instância de Methods; se escolher criptografar uma frase (opção 2), chama o método encryptMessage da instância de Methods; se escolher sair do programa (opção 3), imprime uma mensagem de despedida e define userPlaying como falso para encerrar o loop.

- Mensagem de Erro: Se o usuário inserir uma entrada inválida (não um número inteiro), o programa imprime uma mensagem de erro e espera por uma nova entrada.

- Fechamento do Scanner: Após o loop while terminar, o programa fecha o Scanner para liberar recursos.

## Arquivo Methods.java
```Java
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
                    scanner.nextLine();
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

```

- Pacote e Imports: Este código está contido no pacote br.com.cryptography.cryptoMethods. Ele importa duas classes específicas de pacotes relacionados à criptografia: CaesarCipher e MorseCode, ambas pertencentes a br.com.cryptography.cryptoMethods.cryptography.

- Declaração da Classe Methods: Define uma classe chamada Methods.

- Método decryptMessage: Este método lida com a descriptografia de mensagens. Ele primeiro solicita ao usuário que escolha entre dois métodos de descriptografia: Cifra de César ou Código Morse.

- Tratamento de Exceção: O código envolve a entrada do usuário em um bloco try-catch para capturar exceções do tipo InputMismatchException, que podem ocorrer se o usuário inserir uma entrada inválida.

- Switch Case: Com base na escolha do usuário, o método prossegue para descriptografar a mensagem usando a opção selecionada.

- Cifra de César: Se o usuário escolher Cifra de César, o método solicita a mensagem e a chave de descriptografia. Em seguida, ele instancia um objeto CaesarCipher com a chave fornecida e usa esse objeto para descriptografar a mensagem.

- Código Morse: Se o usuário escolher Código Morse, o método simplesmente chama o método estático decrypt da classe MorseCode para descriptografar a mensagem.

- Método encryptMessage: Este método lida com a criptografia de mensagens de maneira semelhante ao método decryptMessage, mas, em vez disso, solicita ao usuário que escolha entre os métodos de criptografia.

- Switch Case: Com base na escolha do usuário, o método prossegue para criptografar a mensagem usando a opção selecionada.

- Cifra de César e Código Morse: Para ambas as opções, a lógica é semelhante à explicada no método decryptMessage, mas desta vez para criptografar a mensagem.

- Tratamento de Exceção: Novamente, há tratamento de exceção para garantir que a entrada do usuário seja válida.

## Arquivo CaesarCipher.java
```Java
package br.com.cryptography.cryptoMethods.cryptography;

public class CaesarCipher {
    private int key;

    public CaesarCipher(int key) {
        this.key = key;
    }


    private char encryptChar(char character, int offset) {
        if (Character.isLetter(character)) {
            int originalAlphabetPosition = Character.toLowerCase(character) - 'a';
            int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
            if (newAlphabetPosition < 0) {
                newAlphabetPosition += 26;
            }
            char newCharacter = (char) ('a' + newAlphabetPosition);
            return Character.isUpperCase(character) ? Character.toUpperCase(newCharacter) : newCharacter;
        } else if (Character.isDigit(character)) {
            int originalDigit = character - '0';
            int newDigit = (originalDigit + key) % 10;
            if (newDigit < 0) {
                newDigit += 10;
            }
            return (char) ('0' + newDigit);
        } else {
            return character;
        }
    }

    private String processMessage(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            result.append(encryptChar(character, offset));
        }
        return result.toString();
    }

    public String encryptMessage(String message) {
        return processMessage(message, key);
    }

    public String decryptMessage(String message) {
        return processMessage(message, -key);
    }

}
```

- Pacote e Declaração da Classe CaesarCipher: Este código está contido no pacote br.com.cryptography.cryptoMethods.cryptography. Define uma classe chamada CaesarCipher, que implementa a cifra de César, um tipo simples de criptografia de substituição.

- Variável de Instância: A classe possui uma variável de instância chamada 'key', que representa o deslocamento usado na cifra de César para criptografar ou descriptografar uma mensagem.

- Construtor: A classe possui um construtor que recebe a chave como parâmetro e a atribui à variável 'key'.

- Método encryptChar: Este método privado recebe um caractere e um deslocamento como parâmetros e retorna o caractere criptografado correspondente. Ele verifica se o caractere é uma letra ou um dígito e realiza a criptografia de acordo com as regras da cifra de César.

- Método processMessage: Este método privado recebe uma mensagem e um deslocamento como parâmetros e processa cada caractere da mensagem chamando o método encryptChar. Em seguida, retorna a mensagem criptografada ou descriptografada.

- Método encryptMessage: Este método público recebe uma mensagem como parâmetro e a criptografa chamando o método processMessage com o deslocamento positivo (chave).

- Método decryptMessage: Este método público recebe uma mensagem como parâmetro e a descriptografa chamando o método processMessage com o deslocamento negativo (-chave).

## Arquivo MorseCode.java
```Java
    package br.com.cryptography.cryptoMethods.cryptography;

    import java.util.HashMap;

    public class MorseCode {

        private static final HashMap<Character, String> morseAlphabet = new HashMap<>();
        private static final HashMap<String, Character> reverseMorseAlphabet = new HashMap<>();

        static {
            morseAlphabet.put('A', ".-");
            morseAlphabet.put('B', "-...");
            morseAlphabet.put('C', "-.-.");
            morseAlphabet.put('D', "-..");
            morseAlphabet.put('E', ".");
            morseAlphabet.put('F', "..-.");
            morseAlphabet.put('G', "--.");
            morseAlphabet.put('H', "....");
            morseAlphabet.put('I', "..");
            morseAlphabet.put('J', ".---");
            morseAlphabet.put('K', "-.-");
            morseAlphabet.put('L', ".-..");
            morseAlphabet.put('M', "--");
            morseAlphabet.put('N', "-.");
            morseAlphabet.put('O', "---");
            morseAlphabet.put('P', ".--.");
            morseAlphabet.put('Q', "--.-");
            morseAlphabet.put('R', ".-.");
            morseAlphabet.put('S', "...");
            morseAlphabet.put('T', "-");
            morseAlphabet.put('U', "..-");
            morseAlphabet.put('V', "...-");
            morseAlphabet.put('W', ".--");
            morseAlphabet.put('X', "-..-");
            morseAlphabet.put('Y', "-.--");
            morseAlphabet.put('Z', "--..");
            morseAlphabet.put('0', "-----");
            morseAlphabet.put('1', ".----");
            morseAlphabet.put('2', "..---");
            morseAlphabet.put('3', "...--");
            morseAlphabet.put('4', "....-");
            morseAlphabet.put('5', ".....");
            morseAlphabet.put('6', "-....");
            morseAlphabet.put('7', "--...");
            morseAlphabet.put('8', "---..");
            morseAlphabet.put('9', "----.");
            morseAlphabet.put('.', ".-.-.-");
            morseAlphabet.put(',', "--..--");
            morseAlphabet.put('?', "..--..");
            morseAlphabet.put('!', "-.-.--");

            for (char letter : morseAlphabet.keySet()) {
                String morse = morseAlphabet.get(letter);
                reverseMorseAlphabet.put(morse, letter);
            }
        }

        private static String encryptCode(String message) {
            StringBuilder encrytedMessage = new StringBuilder();
            for (char letter : message.toUpperCase().toCharArray()){
                if (morseAlphabet.containsKey(letter)) {
                    encrytedMessage.append(morseAlphabet.get(letter) + " ");
                } else if (letter == ' ' ) {
                    encrytedMessage.append("/ ");
                } else if (!morseAlphabet.containsKey(letter)) {
                   throw new IllegalArgumentException("Caractere inválido para o código morse: " + letter);
                }
            }
            return encrytedMessage.toString().trim();
        }

        private static String decryptCode(String morsecode) {
            StringBuilder decryptedMessage = new StringBuilder();
            String[] words = morsecode.split("/");
            for (String word : words) {
                String[] letters = word.split(" ");
                for (String morse : letters) {
                    if (reverseMorseAlphabet.containsKey(morse)) {
                        decryptedMessage.append(reverseMorseAlphabet.get(morse));
                    }
                    decryptedMessage.append(" ");
                }
            }
            return decryptedMessage.toString().trim();
        }

        public static String encrypt(String morsecode) {return encryptCode(morsecode);}

        public static String decrypt(String morsecode) {return decryptCode(morsecode);}
    }
```
- Pacote e Declaração da Classe MorseCode: Este código está contido no pacote br.com.cryptography.cryptoMethods.cryptography. Ele define uma classe chamada MorseCode, que lida com a codificação e decodificação de mensagens em código Morse.

- HashMaps para Mapeamento: Duas variáveis estáticas finais são definidas para armazenar o mapeamento entre caracteres e seus equivalentes em código Morse e vice-versa. Isso é feito usando HashMaps.

- Inicialização Estática: Um bloco estático é usado para inicializar os HashMaps com os mapeamentos entre caracteres e seus equivalentes em código Morse, bem como vice-versa.

- Mapeamento de Caracteres: Os caracteres alfabéticos de A a Z, os dígitos de 0 a 9 e alguns caracteres especiais são mapeados para seus equivalentes em código Morse, como definido internacionalmente.

- Método encryptCode: Este método privado recebe uma mensagem como parâmetro e itera sobre cada caractere da mensagem. Para cada caractere, verifica se está presente no mapa morseAlphabet. Se estiver, adiciona a representação em código Morse ao StringBuilder; caso contrário, lança uma exceção IllegalArgumentException para indicar que o caractere não é suportado.

- Método decryptCode: Este método privado recebe uma string de código Morse como parâmetro e decodifica-a de volta para a mensagem original. Divide a string em palavras e, em seguida, divide cada palavra em letras. Usa o mapa reverseMorseAlphabet para encontrar o caractere correspondente ao código Morse de cada letra.

- Métodos Públicos: A classe fornece métodos públicos estáticos encrypt e decrypt que chamam os métodos privados correspondentes. Eles são estáticos para que possam ser chamados sem a necessidade de uma instância da classe MorseCode.
