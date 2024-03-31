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