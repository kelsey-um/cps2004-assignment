public class HumanPlayer{
    
    byte playerID;
    String playerName;

    //location coordinates
    int locationX;
    int locationY;
    Village village;

    public HumanPlayer(byte playerID, String playerName, int locationX, int locationY){
        this.playerID = playerID;
        this.playerName = playerName;
        this.locationX = locationX;
        this.locationY = locationY;
        this.village = new Village();
    
    }

}