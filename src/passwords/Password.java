package passwords;

/**
 * @brief this class implements the key word which players have to guess
 */
public class Password {
    /**
     * @param character this variable stores a char which means an encrypted letter from the key word
     * @param word this variable stores a key word
     * @param encryptedWord this variable is for printing '_' symbol that means encrypted key word
     */
    private char character;
    private String word;
    private String encryptedWord = "";


    public Password(String word) {
        this.character = '_';
        this.word = word;
        for (int i = 0; i < word.length(); i++) {
            encryptedWord += character;
        }
    }

    public void printState(){
        System.out.println(encryptedWord);
    }


    public String getWord() {
        return word;
    }

    public char getCharacter() {
        return character;
    }

    public String getEncryptedWord() {
        return encryptedWord;
    }

    public void setEncryptedWord(String encryptedWord) {
        this.encryptedWord = encryptedWord;
    }
}
