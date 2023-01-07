public class Player {

    protected byte playerID;
    protected String playerName;

    // location coordinates
    protected int locationX;
    protected int locationY;
    protected Village village;

    public Player(byte playerID, String playerName, int locationX, int locationY) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.locationX = locationX;
        this.locationY = locationY;
        this.village = new Village();

    }

    public byte getPlayerID(){
        return playerID;
    }
    
    public Village getVillage() {
        return village;
    }

    public int getXCoordinate(){
        return locationX;
    }

    public int getYCoordinate(){
        return locationY;
    }
    
}


class HumanPlayer extends Player {

    
    public HumanPlayer(byte playerID, String playerName, int locationX, int locationY){
        super(playerID, playerName, locationX, locationY);
    }
    

    

}

class AIPlayer extends Player{

    public AIPlayer(byte playerID, String playerName, int locationX, int locationY){
        super(playerID, playerName, locationX, locationY);
    }

}
