package SnakeAndLadder.entities;

public class BoardItem {

    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public static void createBoardItemPosition(BoardItem boardItem, int maxPosition, int minPosition) {
        int start = (int) ((Math.random() * (maxPosition - minPosition)) + minPosition);
        int end = (int) ((Math.random() * (maxPosition - (start + 1))
                + (start + 1)));

        if (boardItem instanceof Ladder) {
            boardItem.setStart(start);
            boardItem.setEnd(end);
        } else {
            boardItem.setStart(end);
            boardItem.setEnd(start);
        }
    }
}
