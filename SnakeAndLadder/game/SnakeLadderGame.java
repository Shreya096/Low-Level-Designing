package SnakeAndLadder.game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

import SnakeAndLadder.entities.Dice;
import SnakeAndLadder.entities.Player;
import SnakeAndLadder.entities.SnakeLadderBoard;

public class SnakeLadderGame {

    private static final int NO_OF_PLAYERS = 3;
    private static final int NO_OF_DICE = 1;
    private static final int BOARD_DIMENSION = 10;
    private static Queue<Player> players = null;

    public static void main(String[] args) {
        registerPlayers();
        SnakeLadderBoard.buildSnakeLadderBoard(BOARD_DIMENSION);
        Player player = null;
        int newPosition = 0;
        int diceRollValue = 0;
        while (true) {

            player = players.poll();
            System.out.println(
                    player.getDisplayName() + " at position \"" + player.getCurrPosition() + "\" is rolling dice.....");

            diceRollValue = Dice.rollDice(NO_OF_DICE);
            System.out.println(" Dice gives value \"" + diceRollValue + "\"");

            newPosition = diceRollValue + player.getCurrPosition();
            System.out.println(" New position == " + newPosition);

            if (newPosition == SnakeLadderBoard.getMaxPosition()) {
                player.setCurrPosition(newPosition);
                System.out.println(player.getDisplayName() + " won the game .....\n GAME OVER !!!!");
                break;

            } else if (newPosition > SnakeLadderBoard.getMaxPosition()) {
                System.out.println(" Cannot move player , new position out of board....");
                newPosition = player.getCurrPosition();

            } else {
                if (SnakeLadderBoard.isSnakePresent(newPosition)) {
                    System.out.println(" Snake bite the player at new position ......");
                    newPosition = SnakeLadderBoard.getSnake(newPosition).getEnd();

                } else if (SnakeLadderBoard.isLadderPresent(newPosition)) {
                    System.out.println("Player climbling board from new position ....");
                    newPosition = SnakeLadderBoard.getLadder(newPosition).getEnd();
                }
                System.out.println(player.getDisplayName() + " 's new Postion == " + newPosition);
                player.setCurrPosition(newPosition);
            }
            players.add(player);

        }
        System.out.println("-----------------------Player : " + player.getDisplayName() + " won the match------------------");
    }

    private static void registerPlayers() {
        players = new LinkedList<>();
        Player player = null;
        for (int i = 0; i < NO_OF_PLAYERS; i++) {
            player = new Player();
            player.setPlayerId(UUID.randomUUID().toString());
            player.setDisplayName(" Player " + (i+1));
            players.add(player);
        }
    }

}
