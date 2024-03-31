package cryptoMethods.cryptography;

import java.util.HashMap;

public class MorseCode {

    private static final HashMap<Character, String> morseAlphabet = new HashMap<>();
    //Mapeia caracteres do alfabeto para seus equivalentes em código morse
    private static final HashMap<String, Character> reverseMorseAlphabet = new HashMap<>();
    //Mapeia o código Morse de volta para caracteres do alfabeto

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


        for (char letter : morseAlphabet.keySet()) {
            String morse = morseAlphabet.get(letter);
            reverseMorseAlphabet.put(morse, letter);
        }
        // Após o mapeamento das letras para código Morse, um loop é usado para inverter os mapeamentos,
        // colocando o código Morse como chave e a letra como valor no mapa reverseMorseAlphabet.
    }
    // Dentro do bloco estático de inicialização,
    // são inseridos os mapeamentos de letras para código Morse no mapa morseAlphabet.


    public static String encrypt (String message) {
        StringBuilder encryptedMessage = new StringBuilder(); //StringBuilder para construir a messagem criptografada
        for (char letter : message.toUpperCase().toCharArray()){ //Início de um loop que itera sobre cada caractere da mensagem, convertendo-os para maiúsculas.
            if (morseAlphabet.containsKey(letter)) {
                encryptedMessage.append(morseAlphabet.get(letter)).append(" ");
            } else if (letter == ' ' ) {
                encryptedMessage.append("/ ");
            }
        }
        //Verifica se o caractere está presente no mapa morseAlphabet, se estiver, adiciona seu código Morse à mensagem
        //criptografada. Se for um espaço, adiciona "/" para separar as palavras.
        return encryptedMessage.toString();
        //Retorna a mensagem criptografada como uma string.
    }

    //Declaração do método decrypt, que descriptografa uma mensagem em código Morse.
    public static String decrypt(String morsecode) {
        StringBuilder decryptedMessage = new StringBuilder();
        String[] words = morsecode.split("/"); //Divide a sequência de código Morse em palavras usando "/" como delimitador.
        for (String word : words) { //Início de um loop que itera sobre cada palavra.
            String[] letters = word.split(" "); //Divide cada palavra em caracteres Morse individuais usando " " como delimitador.
            for (String morse : letters) { //Início de um loop que itera sobre cada caractere Morse.
                if (reverseMorseAlphabet.containsKey(morse)) {
                    decryptedMessage.append(reverseMorseAlphabet.get(morse));
                }
                //Verifica se o código Morse está presente no mapa reverseMorseAlphabet e, se estiver, adiciona o
                //caractere correspondente à mensagem descriptografada.
                decryptedMessage.append(" ");
                //Adiciona um espaço após cada palavra na mensagem descriptografada.
            }

        }
        return decryptedMessage.toString();
    }

}