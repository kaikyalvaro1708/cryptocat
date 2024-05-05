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
