package players;

import passwords.Password;

import java.util.ArrayList;

/**
 * @brief this class implements players in the game
 */
public class Player {
    /**
     * @param password this variable is needed for getting the key word from Password class
     * @param health this variable stores information of counts of possible moves of the player
     * @param name this variable stores information about player's name
     * @param chooses this list stores infromation of previous chosen letters by a player
     */
    private Password password;
    private int health;
    private String name;
    private ArrayList<Character> chooses;
    public Player(Password password) {
        this.password = password;
        this.health = 6;
        this.chooses = new ArrayList<>();
    }

    /**
     * @param input this variable stores the information about player's chosen letter
     * @brief this method changes the symbol '_' into letter from key word or decrement count of player's health if the players made a mistake
     */
    public void choose(char input) {
        StringBuilder encryptedWordBuilder = new StringBuilder(password.getEncryptedWord());
        chooses.add(input);
        boolean found = false;

        for (int i = 0; i < password.getWord().length(); i++) {
            if (input == password.getWord().charAt(i)) {
                found = true;
                encryptedWordBuilder.setCharAt(i, input);
            }
        }

        if (!found) {
            health--;
            System.out.println("WRONG !");
        }

        String encryptedWord = encryptedWordBuilder.toString();
        password.setEncryptedWord(encryptedWord);

    }

    /**
     *
     * @return boolean value in depending on player's health
     */
    public boolean lose(){
        if(health == 0)
            return true;
        return false;
    }

    /**
     * @brief this method prints the actual state of players possible count of moves
     */
    public void printState(){
        if(health == 6){
            System.out.println("    " + " --------   " +"\n"+
                               "    " + " |      |   " +"\n"+
                               "    " + " |          " +"\n"+
                               "    " + " |          " +"\n"+
                               "    " + " |          " +"\n"+
                               "    " + "^^^         " +"\n"+
                               " "    + "  ^^^^^     " +"\n"+
                           "  ^^^^^^^             ");
        }else if(health == 5){
            System.out.println("    " + " --------   " +"\n"+
                               "    " + " |      |   " +"\n"+
                               "    " + " |      O   " +"\n"+
                               "    " + " |          " +"\n"+
                               "    " + " |          " +"\n"+
                               "    " + "^^^         " +"\n"+
                               " "    + "  ^^^^^     " +"\n"+
                               "  ^^^^^^^             ");
        }else if(health == 4){
            System.out.println("    " + " --------   " +"\n"+
                               "    " + " |      |   " +"\n"+
                               "    " + " |      O   " +"\n"+
                               "    " + " |     [_]  " +"\n"+
                               "    " + " |          " +"\n"+
                               "    " + "^^^         " +"\n"+
                               " "    + "  ^^^^^     " +"\n"+
                               "  ^^^^^^^             ");
        }else if(health == 3){
            System.out.println("    " + " --------   " +"\n"+
                               "    " + " |      |   " +"\n"+
                               "    " + " |      O   " +"\n"+
                               "    " + " |   --[_]  " +"\n"+
                               "    " + " |          " +"\n"+
                               "    " + "^^^         " +"\n"+
                               " "    + "  ^^^^^     " +"\n"+
                               "  ^^^^^^^             ");
        }else if(health == 2){
            System.out.println("    " + " --------   " +"\n"+
                               "    " + " |      |   " +"\n"+
                               "    " + " |      O   " +"\n"+
                               "    " + " |   --[_]--" +"\n"+
                               "    " + " |          " +"\n"+
                               "    " + "^^^         " +"\n"+
                               " "    + "  ^^^^^     " +"\n"+
                               "  ^^^^^^^             ");
        }else if(health == 1){
            System.out.println("    " + " --------   " +"\n"+
                               "    " + " |      |   " +"\n"+
                               "    " + " |      O   " +"\n"+
                               "    " + " |   --[_]--" +"\n"+
                               "    " + " |     |    " +"\n"+
                               "    " + "^^^         " +"\n"+
                               " "    + "  ^^^^^     " +"\n"+
                               "  ^^^^^^^             ");
        }else if(health == 0){
            System.out.println("    " + " --------   " +"\n"+
                               "    " + " |      |   " +"\n"+
                               "    " + " |      O   " +"\n"+
                               "    " + " |   --[_]--" +"\n"+
                               "    " + " |     | |  " +"\n"+
                               "    " + "^^^         " +"\n"+
                               " "    + "  ^^^^^     " +"\n"+
                               "  ^^^^^^^             "+"\n"+
                               "          YOU LOST           ");
        }
    }

    public Password getPassword() {
        return password;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<Character> getChooses() {
        return chooses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
