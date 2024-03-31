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
