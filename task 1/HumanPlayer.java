public class HumanPlayer{
    
    private byte playerID;
    private String playerName;

    //location coordinates
    private int locationX;
    private int locationY;
    private Village village;

    public HumanPlayer(byte playerID, String playerName, int locationX, int locationY){
        this.playerID = playerID;
        this.playerName = playerName;
        this.locationX = locationX;
        this.locationY = locationY;
        this.village = new Village();
    
    }

    Village getVillage(){
        return village;
    }

}