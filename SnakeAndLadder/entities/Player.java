package SnakeAndLadder.entities;

public class Player {
    private String playerId;
    private String displayName;
    private int currPosition;
    public String getPlayerId() {
        return playerId;
    }
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public int getCurrPosition() {
        return currPosition;
    }
    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }   
}
