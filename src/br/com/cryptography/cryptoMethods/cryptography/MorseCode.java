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