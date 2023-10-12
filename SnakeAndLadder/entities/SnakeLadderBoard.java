package SnakeAndLadder.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderBoard {

    private static final int TOTAL_BOARD_ITEMS = 10;
    private static int dimension;
    private static List<Snake> snakes;
    private static List<Ladder> ladders;
    private static Map<Integer, BoardItem> boardItemPositionMap;
    private static String[][] board;
    private static Map<Integer, BoardPosition> boardPositions;

    public static int getMaxPosition() {
        return dimension * dimension;
    }

    public static void buildSnakeLadderBoard(int dimension) {
        SnakeLadderBoard.dimension = dimension;
        boardItemPositionMap = new HashMap<>();
        boardPositions = new HashMap<>();
        board = new String[dimension][dimension];
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        fillBoardMatrix();
        placeBoardItems();
        printSnakeLadderBoard();
    }

    private static void fillBoardMatrix() {
        int i = dimension - 1;
        int j = 0;
        int value = 1;
        boolean leftToRight = true;
        while (i >= 0) {

            if (leftToRight) {
                j = 0;
                while (j <= dimension - 1) {
                    boardPositions.put(value, new BoardPosition(i, j));
                    board[i][j] = value + " ";
                    j++;
                    value++;

                }
                leftToRight = false;
            } else {
                j = dimension - 1;
                while (j >= 0) {
                    boardPositions.put(value, new BoardPosition(i, j));
                    board[i][j] = value + " ";
                    j--;
                    value++;

                }
                leftToRight = true;
            }
            i--;
        }
    }

    private static void printSnakeLadderBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(String.format("%" + 10 + "s", board[i][j])+" ");
            }
            System.out.println();
        }
    }

    private static void placeBoardItems() {
        int totalEntites = (int) (Math.random() * TOTAL_BOARD_ITEMS) + 2;
        int noOfLadders = (int) ((Math.random() * (TOTAL_BOARD_ITEMS / 3)) + 1);
        int noOfSnakes = totalEntites - noOfLadders +1;
        createPlaceLadders(noOfLadders);
        createAndPlaceSnakes(noOfSnakes);
    }

    private static void createAndPlaceSnakes(int noOfSnakes) {
        Snake snake = null;
        for (int i = 1; i <= noOfSnakes; i++) {
            snake = new Snake();
            snake.setSnakeId("s"+i);
            BoardItem.createBoardItemPosition(snake, getMaxPosition() - 1, 1);
            while (boardItemPositionMap.get(snake.getStart()) != null
                    || boardItemPositionMap.get(snake.getEnd()) != null) {
                BoardItem.createBoardItemPosition(snake, getMaxPosition() - 1, 1);
            }
          
            BoardPosition boardPosition= boardPositions.get(snake.getStart());
            board[boardPosition.getX()][boardPosition.getY()] +=" "+ snake.getSnakeId()+"Start";

            boardPosition= boardPositions.get(snake.getEnd());
            board[boardPosition.getX()][boardPosition.getY()] +=" "+ snake.getSnakeId()+"End";

            boardItemPositionMap.put(snake.getStart(), snake);
            boardItemPositionMap.put(snake.getEnd(), snake);
            snakes.add(snake);
        }
    }

    private static void createPlaceLadders(int noOfLadders) {
        Ladder ladder = null;
        for (int i = 1; i <= noOfLadders; i++) {
            ladder = new Ladder();
            ladder.setLadderId("l"+i);
            BoardItem.createBoardItemPosition(ladder, getMaxPosition() - 1, 1);
            while (boardItemPositionMap.get(ladder.getStart()) != null
                    || boardItemPositionMap.get(ladder.getEnd()) != null) {
                BoardItem.createBoardItemPosition(ladder, getMaxPosition() - 1, 1);
            }
             BoardPosition boardPosition= boardPositions.get(ladder.getStart());
            board[boardPosition.getX()][boardPosition.getY()] +=" "+ ladder.getLadderId()+"Start";

            boardPosition= boardPositions.get(ladder.getEnd());
            board[boardPosition.getX()][boardPosition.getY()] +=" "+ ladder.getLadderId()+"End";

            boardItemPositionMap.put(ladder.getStart(), ladder);
            boardItemPositionMap.put(ladder.getEnd(), ladder);
            ladders.add(ladder);
        }
    }

    public static boolean isSnakePresent(int newPosition) {
        BoardItem boardItem = boardItemPositionMap.get(newPosition);
        if (boardItem != null && boardItem instanceof Snake && boardItem.getStart() == newPosition) {
            return true;
        }
        return false;
    }

    public static boolean isLadderPresent(int newPosition) {
        BoardItem boardItem = boardItemPositionMap.get(newPosition);
        if (boardItem != null && boardItem instanceof Ladder && boardItem.getStart() == newPosition) {
            return true;
        }
        return false;
    }

    public static Snake getSnake(int newPosition) {
        return (Snake) boardItemPositionMap.get(newPosition);
    }

    public static Ladder getLadder(int newPosition) {
        return (Ladder) boardItemPositionMap.get(newPosition);
    }

}
