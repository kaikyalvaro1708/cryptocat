# Sistema de criptografia - CryptoCat

## Equipe

|           NOME           |  RM   |
| :----------------------: | :---: |
| Kaiky Alvaro de Miranda  | 98118 |
| Lucas Rodrigues da Silva | 98344 |
| Juan Pinheiro de França  | 552202|

---

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

## Estrutura dos arquivos
Para melhor compreendimento do sistema, temos que analisar em como está a estrutura de pastas.

![image](https://github.com/kaikyalvaro1708/dynamic_task/assets/126626704/5cfea352-642c-4421-839c-ac91360f1c32)

- Primeiro, temos o arquivo main, que guarda o menu principal.
- Depois, dentro do package cryptoMethods, temos um arquivo chamado de "Methods.java", é onde temos os dois métodos: encrypt e decrypt(encriptar e decriptar).
- Dentro do package de cryptoMethods, temos mais um package chamado de "cryptography", que é onde temos os códigos de código morse e cifra de césar,
separados em "MorseCode" e "CaesarCipher", respectivamente.  

## Código

## Arquivo Main.java
```Java
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



```
- O código importa duas classes: Scanner para entrada do usuário e Methods para métodos de criptografia e descriptografia.
- O método main é o ponto de entrada do programa.
- O programa exibe uma saudação e um desenho de um gato ASCII.
- Ele entra em um loop while enquanto o usuário estiver jogando.
- Dentro do loop, exibe um menu de opções para o usuário: descriptografar uma frase (opção 1), criptografar uma frase (opção 2) ou sair do programa (opção 3).
- Ele usa Scanner para ler a resposta do usuário e trata casos em que a entrada não é um número inteiro.
- Com base na resposta do usuário, chama os métodos apropriados da classe Methods para descriptografar ou criptografar uma frase, ou sai do programa.
- Se o usuário escolher sair do programa, uma mensagem de despedida é exibida antes de encerrar o loop.
- O programa continua executando até que o usuário decida sair.

## Arquivo Methods.java
```Java
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

        int userResponse;
        try {
            userResponse = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner
        } catch (Exception e) {
            System.out.println("Por favor, digite um número válido");
            scanner.nextLine(); // Limpa o buffer do scanner
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
                } catch (Exception e) {
                    System.out.println("Por favor, digite um número válido como chave");
                    scanner.nextLine(); // Limpa o buffer do scanner
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

    private static void encryptMessageInternal(Scanner scanner) {
        System.out.println("""
                -------------------------
                Você deseja Encriptar em:
                Cifra de César, Digite: 1
                Código Morse, Digite: 2""");

        int userResponse;
        try {
            userResponse = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner
        } catch (Exception e) {
            System.out.println("Por favor, digite um número válido");
            scanner.nextLine(); // Limpa o buffer do scanner
            return;
        }

        switch (userResponse) {
            case 1 -> {
                System.out.println("Digite a frase que deseja Encriptar: ");
                String message = scanner.nextLine();
                System.out.println("Digite a chave da cifra de César: ");
                try {
                    int key = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do scanner
                    CaesarCipher cipher = new CaesarCipher(key);
                    String messageEncrypt = cipher.encryptMessage(message);
                    System.out.println("Mensagem criptografada: " + messageEncrypt);
                } catch (Exception e) {
                    System.out.println("Por favor, digite um número válido como chave");
                    scanner.nextLine(); // Limpa o buffer do scanner
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

    public static void decryptMessage(Scanner scanner) {
        decryptMessageInternal(scanner);
    }

    public static void encryptMessage(Scanner scanner) {
        encryptMessageInternal(scanner);
    }
}

```

- A classe Methods contém métodos estáticos para manipular as operações de criptografia e descriptografia.
- Há métodos privados decryptMessageInternal e encryptMessageInternal, que lidam com a lógica específica de cada operação de descriptografia e criptografia, respectivamente.
- Cada método interno exibe um menu para o usuário escolher o método de criptografia (Cifra de César ou Código Morse).
- A entrada do usuário é validada e processada de acordo com a escolha feita.
- Caso o usuário escolha a cifra de César, ele é solicitado a inserir a chave de deslocamento.
- A entrada do usuário é validada e, se for bem-sucedida, a mensagem é criptografada ou descriptografada usando o método apropriado da classe CaesarCipher.
- Se o usuário escolher o Código Morse, a mensagem é criptografada ou descriptografada usando os métodos da classe MorseCode.
- Os métodos públicos decryptMessage e encryptMessage são fornecidos para facilitar o acesso às funcionalidades de criptografia e descriptografia.

## Arquivo CaesarCipher.java
```Java
package cryptoMethods.cryptography;

public class CaesarCipher {
    private int key; //variável da chave privada,

    // Construtor: Há um construtor público que recebe a chave como parâmetro e a atribui à variável 'key'.
    public CaesarCipher(int key) {
        this.key = key;
    }

    // Método privado para processar a mensagem. Ele recebe uma mensagem e um deslocamento como parâmetros.
    private String processMessage(String message, int offset) {
        // Inicializa uma string vazia para armazenar o resultado da cifragem ou decifragem
        String result = "";
        // Itera sobre cada caractere na mensagem.
        for (char character : message.toCharArray()) {
            // Verifica se o caractere é uma letra do alfabeto
            if (Character.isLetter(character)) {
                int originalAlphabetPosition = Character.toLowerCase(character) - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                // Lidar com valores negativos
                if (newAlphabetPosition < 0) {
                    newAlphabetPosition += 26;
                }
                char newCharacter = (char) ('a' + newAlphabetPosition);
                // Manter a capitalização original
                if (Character.isUpperCase(character)) {
                    result += Character.toUpperCase(newCharacter);
                } else {
                    result += newCharacter;
                }
            } else if (Character.isDigit(character)) { // Verifica se o caractere é um dígito
                int originalDigit = character - '0';
                int newDigit = (originalDigit + offset) % 10;
                if (newDigit < 0) {
                    newDigit += 10;
                }
                result += (char) ('0' + newDigit);
            }
            else {
                result += character; // Mantém caracteres que não estão no alfabeto intactos
            }
        }
        return result;
    }

    // Método público para criptografar a mensagem. Ele chama o método processMessage com o deslocamento da chave.
    public String encryptMessage(String message) {return processMessage(message, key); }

    // Método público para descriptografar a mensagem. Ele chama o método processMessage com o deslocamento inverso da chave.
    public String decryptMessage(String message) {return processMessage(message, -key);}

}


```

- A classe CaesarCipher, responsável pela cifra de César, é um método de criptografia simples que desloca os caracteres em uma quantidade fixa de posições no alfabeto.
- Atributo key: Este atributo armazena a chave de deslocamento utilizada na cifra de César. É um valor inteiro que determina quantas posições no alfabeto os caracteres serão deslocados.
- Construtor: O construtor público permite que um objeto CaesarCipher seja instanciado com uma chave específica. Isso permite que diferentes instâncias da classe usem chaves diferentes, fornecendo flexibilidade para criptografar e descriptografar mensagens com diferentes deslocamentos.
- Método processMessage: Este método privado é responsável por processar a mensagem, aplicando o deslocamento aos caracteres de acordo com a chave fornecida. Ele itera sobre cada caractere da mensagem, verificando se é uma letra do alfabeto, um dígito ou outro caractere. Em seguida, aplica o deslocamento apropriado e constrói a mensagem resultante.
- Método encryptMessage: Este método público recebe uma mensagem como entrada e a criptografa utilizando a cifra de César. Ele chama o método processMessage com o deslocamento da chave fornecida no construtor. Isso resulta na mensagem criptografada de acordo com a chave especificada.
- Método decryptMessage: Similar ao método de criptografia, este método público recebe uma mensagem criptografada como entrada e a descriptografa utilizando a cifra de César. Ele chama - o método processMessage com o deslocamento inverso da chave fornecida no construtor. Isso restaura a mensagem original a partir da mensagem criptografada.
## Arquivo MorseCode.java
```Java
    package cryptoMethods.cryptography;

    import java.util.HashMap;

    public class MorseCode {

        private static final HashMap<Character, String> morseAlphabet = new HashMap<>();
        //Mapeia caracteres do alfabeto para seus equivalentes em código morse
        private static final HashMap<String, Character> reverseMorseAlphabet = new HashMap<>();
        //Mapeia o código Morse de volta para caracteres do alfabeto

        // Bloco de inicialização estática para preencher os mapas
        static {
            // Mapeamento de letras para código Morse
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

            // Loop para inverter os mapeamentos e preencher o mapa reverseMorseAlphabet
            for (char letter : morseAlphabet.keySet()) {
                String morse = morseAlphabet.get(letter);
                reverseMorseAlphabet.put(morse, letter);
            }
            // Após o mapeamento das letras para código Morse, um loop é usado para inverter os mapeamentos,
            // colocando o código Morse como chave e a letra como valor no mapa reverseMorseAlphabet.
        }

        // Método privado para criptografar uma mensagem em código Morse
        private static String encryptCode(String message) {
            // String para armazenar a mensagem criptografada
            String encryptedMessage = "";
            // Itera sobre cada caractere da mensagem, convertendo-os para maiúsculas
            for (char letter : message.toUpperCase().toCharArray()){
                if (morseAlphabet.containsKey(letter)) {
                    // Se o caractere estiver presente no mapa, adiciona seu código Morse à mensagem criptografada
                    encryptedMessage += morseAlphabet.get(letter) + " ";
                } else if (letter == ' ' ) {
                    // Se for um espaço, adiciona "/" para separar as palavras na mensagem criptografada
                    encryptedMessage += ("/ ");
                }
            }
            return encryptedMessage.trim();
            // Remove espaços extras no final e retorna a mensagem criptografada
        }

        // Método privado para descriptografar uma mensagem em código Morse
        private static String decryptCode(String morsecode) {
            // String para armazenar a mensagem descriptografada
            String decryptedMessage = "";
            // Divide a sequência de código Morse em palavras usando "/" como delimitador
            String[] words = morsecode.split("/");
            //Início de um loop que itera sobre cada palavra.
            for (String word : words) {
                // Divide cada palavra em caracteres Morse individuais usando " " como delimitador
                String[] letters = word.split(" ");
                // Itera sobre cada caractere Morse
                for (String morse : letters) {
                    if (reverseMorseAlphabet.containsKey(morse)) {
                        // Se o código Morse estiver presente no mapa, adiciona o caractere correspondente à mensagem descriptografada
                        decryptedMessage += reverseMorseAlphabet.get(morse);
                    }
                    // Adiciona um espaço após cada caractere na mensagem descriptografada
                    decryptedMessage += " ";
                }

            }
            return decryptedMessage.trim();
            // Remove espaços extras no final e retorna a mensagem descriptografada
        }

        // Método público para criptografar uma mensagem em código Morse
        public static String encrypt(String morsecode) {return encryptCode(morsecode); }

        // Método público para descriptografar uma mensagem em código Morse
        public static String decrypt(String morsecode) {return decryptCode(morsecode);}
    }

```
- A classe MorseCode implementa a funcionalidade de criptografia e descriptografia de mensagens usando o código Morse.
- HashMaps morseAlphabet e reverseMorseAlphabet: Esses mapas são usados para mapear caracteres do alfabeto para seus equivalentes em código Morse e vice-versa. O morseAlphabet mapeia caracteres para códigos Morse, enquanto o reverseMorseAlphabet mapeia códigos Morse de volta para caracteres do alfabeto.
- Bloco de inicialização estática: Este bloco é executado uma vez quando a classe é carregada, preenchendo os mapas com os respectivos mapeamentos de caracteres para código Morse e vice-versa.
- Método encryptCode: Este método privado recebe uma mensagem como entrada e a criptografa em código Morse. Ele itera sobre cada caractere da mensagem, convertendo-os para maiúsculas e verificando se estão presentes no mapa morseAlphabet. Se estiverem presentes, adiciona o código Morse correspondente à mensagem criptografada.
- Método decryptCode: Este método privado recebe uma sequência de código Morse como entrada e a descriptografa, retornando a mensagem original. Ele divide a sequência de código Morse em palavras usando "/" como delimitador e, em seguida, divide cada palavra em caracteres Morse individuais. Em seguida, itera sobre cada caractere Morse, verificando se está presente no mapa reverseMorseAlphabet e adicionando o caractere correspondente à mensagem descriptografada.
- Métodos encrypt e decrypt: Esses métodos públicos fornecem uma interface para criptografar e descriptografar mensagens em código Morse. Eles chamam os métodos encryptCode e decryptCode, respectivamente.
