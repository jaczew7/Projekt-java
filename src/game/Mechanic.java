package game;
import org.apache.log4j.Logger;
import passwords.Password;
import players.Player;

import java.util.Scanner;

/**
 * @brief This class implements thw whole mechanics of the game
 */
public class Mechanic {
    /**
     * @param numberOfPlayers this variable stores information of number of players
     * @param players this variable is an array which stores players
     * @param name this variable stores infromation of player's name
     * @param move this variable stores infromation about turn
     * @param winner this variable stores information about winner's player name
     * @param won this variable describes if game is still running
     * @param logger this is the logger
     */
    int numberOfPlayers;
    Player[] players;
    String name;
    int move = 0;
    char choose;
    String winner;
    boolean won = false;
    private static Logger logger = Logger.getLogger(Mechanic.class);

    public void start(){
        Scanner scanner = new Scanner(System.in);
        String keyWord = " ";

        System.out.println("Choose number of players (max 4): ");
        numberOfPlayers = scanner.nextInt();
        logger.info("NUMBER OF PLAYERS: " + numberOfPlayers);

        if(numberOfPlayers > 4) {
            System.out.println("ERROR: Too many players, run the game once more");
            logger.info("SHUTTING DOWN - TOO MANY PLAYERS INSERTED");
            System.exit(9999);
        }

        System.out.println("Insert a key word: ");
        keyWord = scanner.next();
        logger.info("KEYWORD: " + keyWord);
        Password password = new Password(keyWord);

        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(password);
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Insert player name: ");
            name = scanner.next();
            players[i].setName(name);
        }

        logger.info("PLAYERS: ");
        for (int i = 0; i < numberOfPlayers; i++) {
            logger.info(players[i].getName());
        }

        logger.info("GAME START !");

        while(!won){
            System.out.println("YOUR TURN " + actualPlayer().getName());
            actualPlayer().printState();
            System.out.println();
            System.out.println("PASSWORD: ");
            System.out.println(password.getEncryptedWord());
            System.out.println("Your previous chooses: ");
            for (int i = 0; i < actualPlayer().getChooses().size(); i++) {
                System.out.println(actualPlayer().getChooses().get(i));
            }
            System.out.println("Choose a letter: ");
            choose = scanner.next().charAt(0);
            logger.info(actualPlayer().getName() + "CHOSEN: " + choose);
            actualPlayer().choose(choose);

            if(actualPlayer().lose()) {
                logger.info(actualPlayer().getName() + "LOST");
                numberOfPlayers--;
            }
            if(numberOfPlayers == 0){
                logger.info("GAME OVER - EVERY PLAYER LOST");
                System.out.println("GAME OVER\nevery player lost");
                break;
            }

            move++;

            if(move == numberOfPlayers)
                move = 0;

            if(password.getEncryptedWord().equals(password.getWord())){
                won = true;
                winner = actualPlayer().getName();
                System.out.println("WIN !!!\n" + winner + "IS THE BEST");
                logger.info("WIN !!!");
                logger.info(winner + "IS THE BEST");
            }
        }
    }

    /**
     *
     * @return which player is actually choosing a word
     */
    public Player actualPlayer() {
        if (numberOfPlayers == 4) {
            if (move == 0)
                return players[0];
            else if (move == 1)
                return players[1];
            else if (move == 2)
                return players[2];
            else
                return players[3];
        }else if(numberOfPlayers == 3){
            if (move == 0)
                return players[0];
            else if (move == 1)
                return players[1];
            else
                return players[2];
        }else if(numberOfPlayers == 2){
            if (move == 0)
                return players[0];
            else
                return players[1];
        }else
            return players[0];
    }
}
