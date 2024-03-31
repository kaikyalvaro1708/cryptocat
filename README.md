# Sistema de criptografia - CryptoCat

## Equipe

|           NOME           |  RM   |
| :----------------------: | :---: |
| Kaiky Alvaro de Miranda  | 98118 |
| Lucas Rodrigues da Silva | 98344 |
| Lucas Pinheiro de França | 552202|

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
import java.util.Scanner; // Importa a classe Scanner para entrada do usuário
import cryptoMethods.Methods; // Importa os métodos de criptografia/descriptografia

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria uma instância de Scanner para entrada do usuário
        int userResponse; // Variável para armazenar a resposta do usuário
        boolean userPlaying = true; // Variável para controlar se o usuário está jogando ou não

        // Mensagem de boas-vindas
        System.out.println("""
                --------------------------------
                Olá, seja bem-vindo ao CryptoCat!
                        /\\_/\\ 
                       ( o.o )
                        > ^ <\
                """);

        // Loop principal do programa
        while (userPlaying) {
            // Menu de opções
            System.out.print("""
                    ----------------------------------
                    O que você deseja?
                     - Decriptar uma frase, digite: 1
                     - Encriptar uma frase, digite: 2
                     - Sair do programa, digite: 3
                                    
                    Sua resposta:
                    """);

            // Entrada do usuário
            userResponse = scanner.nextInt();

            // Estrutura switch-case para escolha do usuário
            switch (userResponse) {
                // Caso o usuário queira descriptografar uma frase
                case 1 -> Methods.decryptMessage(scanner);
                // Caso o usuário queira criptografar uma frase
                case 2 -> Methods.encryptMessage(scanner);
                // Caso o usuário queira sair do programa
                case 3 -> {
                    // Mensagem de despedida
                    System.out.println("""
                            Obrigado por participar! Até logo!
                             /\\_/\\ 
                            ( o.o )
                             > ^ <\
                            """);
                    userPlaying = false; // Define userPlaying como falso para encerrar o loop
                }
                // Caso o usuário digite uma opção inválida
                default -> System.out.println("Por favor, digite um número válido");

            }
        }
    }
}


```
- Importações: Importa as classes Scanner para entrada de usuário e Methods para métodos de criptografia/descriptografia.
- Classe Main: Declaração da classe principal do programa.
- Método main: Ponto de entrada do programa.
- Inicialização de variáveis: Cria instâncias de Scanner e variáveis para armazenar a resposta do usuário e controlar a continuação do jogo.
- Mensagem de boas-vindas: Sauda o usuário quando o programa é iniciado.
- Loop while: Mantém o programa em execução enquanto o usuário quiser continuar.
- Menu de opções: Exibe as opções disponíveis para o usuário.
- Entrada do usuário: Lê a resposta do usuário.
- Switch-case: Executa a ação correspondente à escolha do usuário: descriptografar, criptografar ou sair do programa.

## Arquivo Methods.java
```Java
package cryptoMethods;

// Import statements
import cryptoMethods.cryptography.CaesarCipher;
import cryptoMethods.cryptography.MorseCode;
import java.util.Scanner;

public class Methods {

    // Método para decriptar mensagem
    private static void decryptMessageInternal(Scanner scanner) {
        // Menu para escolher o método de decriptação
        System.out.println("""
                -------------------------
                Você deseja Decriptar em:
                Cifra de César, Digite: 1
                Código Morse, Digite: 2""");

        // Ler a escolha do usuário
        int userResponse = scanner.nextInt();
        scanner.nextLine();

        // Executar decriptação com base na escolha do usuário
        switch (userResponse) {
            case 1 -> {
                // Decriptação usando Cifra de César
                System.out.println("Digite a frase que deseja Decriptar: ");
                String message = scanner.nextLine();
                System.out.println("Digite a chave da cifra de César: ");
                int key = Integer.parseInt(scanner.nextLine());
                CaesarCipher cipher = new CaesarCipher(key);
                String messageDecrypt = cipher.decryptMessage(message);
                System.out.println("Mensagem descriptografada: " + messageDecrypt);
            }
            case 2 -> {
                // Decriptação usando Código Morse
                System.out.println("Digite a frase que deseja Decriptar: ");
                String message = scanner.nextLine();
                String decryptedMessage = MorseCode.decrypt(message);
                System.out.println("Mensagem descriptografada: " + decryptedMessage);
            }
            default -> System.out.println("Por favor, digite um número válido");
        }
    }

    // Método para encriptar mensagem
    private static void encryptMessageInternal(Scanner scanner) {
        // Menu para escolher o método de encriptação
        System.out.println("""
                -------------------------
                Você deseja Encriptar em:
                Cifra de César, Digite: 1
                Código Morse, Digite: 2""");

        // Ler a escolha do usuário
        int userResponse = scanner.nextInt();
        scanner.nextLine();

        // Executar encriptação com base na escolha do usuário
        switch (userResponse) {
            case 1 -> {
                // Encriptação usando Cifra de César
                System.out.println("Digite a frase que deseja Encriptar: ");
                String message = scanner.nextLine();
                System.out.println("Digite a chave da cifra de César: ");
                int key = Integer.parseInt(scanner.nextLine());
                CaesarCipher cipher = new CaesarCipher(key);
                String messageEncrypt = cipher.encryptMessage(message);
                System.out.println("Mensagem criptografada: " + messageEncrypt);
            }
            case 2 -> {
                // Encriptação usando Código Morse
                System.out.println("Digite a frase que deseja Encriptar: ");
                String message = scanner.nextLine();
                String encryptedMessage = MorseCode.encrypt(message);
                System.out.println("Mensagem criptografada: " + encryptedMessage);
            }
            default -> System.out.println("Por favor, digite um número válido");
        }
    }

    // Método público para decriptar mensagem
    public static void decryptMessage(Scanner scanner) {
        decryptMessageInternal(scanner);
    }

    // Método público para encriptar mensagem
    public static void encryptMessage(Scanner scanner) {
        encryptMessageInternal(scanner);
    }
}

```

- O código está contido no pacote cryptoMethods.
- Ele importa duas classes de criptografia: CaesarCipher e MorseCode.
- Há a utilização da classe Scanner para entrada de dados pelo usuário.
- Existe uma classe chamada Methods, que contém métodos para criptografar e descriptografar mensagens.
- Os métodos decryptMessageInternal e encryptMessageInternal são métodos privados que realizam a descriptografia e a criptografia, respectivamente.
- Ambos os métodos exibem um menu para o usuário escolher o método de criptografia ou descriptografia: Cifra de César ou Código Morse.
- Os métodos realizam a operação correspondente com base na escolha do usuário.
- O programa lida com entradas do usuário para as mensagens e, no caso da Cifra de César, para a chave de criptografia.
- Existem métodos públicos decryptMessage e encryptMessage, que servem como ponto de entrada para o usuário iniciar o processo de criptografia ou descriptografia.

## Arquivo CaesarCipher.java
```Java
package cryptoMethods.cryptography;

public class CaesarCipher {
    private int chave; // Variável privada da chave,

    // Esta variável é privada para que somente os métodos dentro desta classe possam acessá-la diretamente.
    // Isso ajuda a garantir a segurança dos dados.

    // Construtor: Existe um construtor público que recebe a chave como parâmetro e a atribui à variável 'chave'.
    public CaesarCipher(int chave) {
        this.chave = chave;
    }

    // Método privado para processar a mensagem com base no deslocamento fornecido
    private String processarMensagem(String mensagem, int deslocamento) {
        StringBuilder resultado = new StringBuilder();
        for (char caractere : mensagem.toCharArray()) {
            if (Character.isLetter(caractere)) { // Verifica se o caractere é uma letra do alfabeto
                int posicaoAlfabetoOriginal = Character.toLowerCase(caractere) - 'a';
                int novaPosicaoAlfabeto = (posicaoAlfabetoOriginal + deslocamento) % 26;
                if (novaPosicaoAlfabeto < 0) { // Lidar com valores negativos
                    novaPosicaoAlfabeto += 26;
                }
                char novoCaractere = (char) ('a' + novaPosicaoAlfabeto);
                if (Character.isUpperCase(caractere)) { // Manter a capitalização original
                    resultado.append(Character.toUpperCase(novoCaractere));
                } else {
                    resultado.append(novoCaractere);
                }
            } else if (Character.isDigit(caractere)) { // Verifica se o caractere é um dígito
                int digitoOriginal = caractere - '0';
                int novoDigito = (digitoOriginal + deslocamento) % 10;
                if (novoDigito < 0) {
                    novoDigito += 10;
                }
                resultado.append((char) ('0' + novoDigito));
            } else {
                resultado.append(caractere); // Mantém caracteres que não estão no alfabeto intactos
            }
        }
        return resultado.toString();
    }

    // Método para criptografar a mensagem usando a Cifra de César
    public String criptografarMensagem(String mensagem) {
        return processarMensagem(mensagem, chave);
    }

    // Método para descriptografar a mensagem usando a Cifra de César
    public String descriptografarMensagem(String mensagem) {
        return processarMensagem(mensagem, -chave);
    }
}

```

### Variáveis de Instância:
- chave: Armazena a chave de criptografia. É privada para garantir segurança dos dados.

### Construtor:
- CaesarCipher(int chave): Inicializa a classe com a chave de criptografia fornecida.

### Métodos:
- processarMensagem(String mensagem, int deslocamento): Método privado para processar a mensagem com base no deslocamento especificado.
- criptografarMensagem(String mensagem): Criptografa a mensagem usando a cifra de César com a chave fornecida.
- descriptografarMensagem(String mensagem): Descriptografa a mensagem usando a cifra de César com a chave fornecida.

### Funcionalidades:
-- Criptografa e descriptografa mensagens de texto usando a cifra de César, mantendo a capitalização e caracteres não alfabéticos intactos.
-- Suporta criptografia de letras do alfabeto (maiúsculas e minúsculas) e dígitos.

## Arquivo MorseCode.java
```Java
  package cryptoMethods.cryptography;

import java.util.HashMap;

public class MorseCode {

    // Mapa para mapear caracteres do alfabeto para código Morse
    private static final HashMap<Character, String> morseAlphabet = new HashMap<>();
    // Mapa para mapear código Morse de volta para caracteres do alfabeto
    private static final HashMap<String, Character> reverseMorseAlphabet = new HashMap<>();

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
    }

    // Método para criptografar uma mensagem em código Morse
    public static String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        // Itera sobre cada caractere da mensagem, convertendo-os para maiúsculas
        for (char letter : message.toUpperCase().toCharArray()) {
            if (morseAlphabet.containsKey(letter)) {
                // Se o caractere estiver presente no mapa, adiciona seu código Morse à mensagem criptografada
                encryptedMessage.append(morseAlphabet.get(letter)).append(" ");
            } else if (letter == ' ') {
                // Se for um espaço, adiciona "/" para separar as palavras na mensagem criptografada
                encryptedMessage.append("/ ");
            }
        }
        return encryptedMessage.toString();
    }

    // Método para descriptografar uma mensagem em código Morse
    public static String decrypt(String morsecode) {
        StringBuilder decryptedMessage = new StringBuilder();
        // Divide a sequência de código Morse em palavras usando "/" como delimitador
        String[] words = morsecode.split("/");
        // Itera sobre cada palavra
        for (String word : words) {
            // Divide cada palavra em caracteres Morse individuais usando " " como delimitador
            String[] letters = word.split(" ");
            // Itera sobre cada caractere Morse
            for (String morse : letters) {
                if (reverseMorseAlphabet.containsKey(morse)) {
                    // Se o código Morse estiver presente no mapa, adiciona o caractere correspondente à mensagem descriptografada
                    decryptedMessage.append(reverseMorseAlphabet.get(morse));
                }
                // Adiciona um espaço após cada caractere na mensagem descriptografada
                decryptedMessage.append(" ");
            }
        }
        return decryptedMessage.toString();
    }
}

```
### Declaração da classe MorseCode no pacote cryptoMethods.cryptography.
### Declaração de dois mapas estáticos: morseAlphabet e reverseMorseAlphabet.
### Inicialização estática dos mapas com mapeamentos de letras para código Morse e vice-versa.
### Método estático encrypt para criptografar uma mensagem em código Morse:
- Recebe uma String de entrada.
- Itera sobre cada caractere da mensagem, convertendo-os para maiúsculas.
- Verifica se o caractere está presente no mapa morseAlphabet.
- Adiciona o código Morse correspondente à mensagem criptografada.
- Adiciona "/" para separar as palavras na mensagem criptografada.
- Retorna a mensagem criptografada como uma String.
### Método estático decrypt para descriptografar uma mensagem em código Morse:
- Recebe uma String de entrada contendo código Morse.
- Divide a sequência de código Morse em palavras usando "/" como delimitador.
- Divide cada palavra em caracteres Morse individuais usando " " como delimitador.
- Verifica se o código Morse está presente no mapa reverseMorseAlphabet.
- Adiciona o caractere correspondente à mensagem descriptografada.
- Adiciona um espaço após cada caractere na mensagem descriptografada.
- Retorna a mensagem descriptografada como uma String.
