package cryptoMethods.cryptography;

public class CaesarCipher {
    private int key; //variável da chave privada,

    // Esta variável é privada para que somente os métodos dentro desta classe possam acessá-la diretamente.
    // Isso ajuda a garantir a segurança dos dados.

    //Construtor: Há um construtor público que recebe a chave como parâmetro e a atribui à variável 'key'.
    public CaesarCipher(int key) {
        this.key = key;
    }

    private String processMessage(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) { // Verifica se o caractere é uma letra do alfabeto
                int originalAlphabetPosition = Character.toLowerCase(character) - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                if (newAlphabetPosition < 0) { // Lidar com valores negativos
                    newAlphabetPosition += 26;
                }
                char newCharacter = (char) ('a' + newAlphabetPosition);
                if (Character.isUpperCase(character)) { // Manter a capitalização original
                    result.append(Character.toUpperCase(newCharacter));
                } else {
                    result.append(newCharacter);
                }
            } else if (Character.isDigit(character)) { // Verifica se o caractere é um dígito
                int originalDigit = character - '0';
                int newDigit = (originalDigit + offset) % 10;
                if (newDigit < 0) {
                    newDigit += 10;
                }
                result.append((char) ('0' + newDigit));
            }
            else {
                result.append(character); // Mantém caracteres que não estão no alfabeto intactos
            }
        }
        return result.toString();
    }

    public String encryptMessage(String message) {return processMessage(message, key); }

    public String decryptMessage(String message) {return processMessage(message, -key);}

}
