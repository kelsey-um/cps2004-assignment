class Building {
    String type;
    byte level;

    public Building(String type){
        this.type = type;
        this.level = 1;
    }
}

class ResourceBuilding extends Building{

    public ResourceBuilding(String type){
        super(type);
    }

    public void generateResource(Resources resources){

        if(type.equals("Farm")){
          
            resources.increaseFood(level*10);
        
        } else if (type.equals("Lumber Mill")){
            
            resources.increaseWood(level*10);
        
        } else if (type.equals("Forge")){

            resources.increaseMetal(level*10);
            
        }

    }

}

class TroopBuilding extends Building{

    public TroopBuilding(String type){
        super(type);
    }



}