public class HumanPlayer{
    
    String playerName;

    //location coordinates
    int locationX;
    int locationY;
    Village village;

    public HumanPlayer(String playerName, int locationX, int locationY){
        this.playerName = playerName;
        this.locationX = locationX;
        this.locationY = locationY;
        this.village = new Village();
    
    }

}