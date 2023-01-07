public class Player {

    protected int playerID;
    protected String playerName;

    // location coordinates
    protected int locationX;
    protected int locationY;
    protected Village village;

    public Player(int playerID, String playerName, int locationX, int locationY) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.locationX = locationX;
        this.locationY = locationY;
        this.village = new Village();

    }

    public int getPlayerID() {
        return playerID;
    }

    public Village getVillage() {
        return village;
    }

    public int getXCoordinate() {
        return locationX;
    }

    public int getYCoordinate() {
        return locationY;
    }

    public String getPlayerName() {
        return playerName;
    }

}

class HumanPlayer extends Player {

    public HumanPlayer(int playerID, String playerName, int locationX, int locationY) {
        super(playerID, playerName, locationX, locationY);
    }

}

class AIPlayer extends Player {

    public AIPlayer(int playerID, String playerName, int locationX, int locationY) {
        super(playerID, playerName, locationX, locationY);
    }

}
