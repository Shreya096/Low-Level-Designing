package SnakeAndLadder.entities;

public class Dice {

    public static int rollDice(int noOfDice) {
        int min = 1;
        int max = noOfDice * 6;
        return (int) ((Math.random() * (max - min)) + min);
    }

}
