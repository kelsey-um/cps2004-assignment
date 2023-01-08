class Building {
    protected String type;
    protected int id;
    protected int level;

    public Building(String type, int id) {
        this.id = id;
        this.type = type;
        this.level = 1;
    }

    public int getBuildingLevel() {
        return level;
    }

    public String getBuildingType() {
        return type;
    }

    public int getBuildingID() {
        return id;
    }

    public void increaseLevel() {
        level++;
    }
}

class ResourceBuilding extends Building {

    public ResourceBuilding(String type, int id) {
        super(type, id);

    }

    public void generateResource(Resources resources) {

        //increase resource according to building level
        switch (type) {

            case "Farm": {
                resources.increaseFood(level * 10);
                break;
            }

            case "Lumber Mill": {
                resources.increaseWood(level * 10);
                break;
            }

            case "Forge": {
                resources.increaseMetal(level * 10);
                break;
            }

        }

    }

}

class TroopBuilding extends Building {

    public TroopBuilding(String type, int id) {
        super(type, id);
    }

    public void trainTroop(Resources resources, Troops troops, int numberToTrain) {

        //train troops and decrease resources required
        switch (type) {

            case "Barracks": {
                troops.getSwordsmen().increaseAmount(numberToTrain);

                resources.decreaseWood(20);
                resources.decreaseFood(20);
                resources.decreaseMetal(40);
            }

            case "Archery Range": {
                troops.getArchers().increaseAmount(numberToTrain);

                resources.decreaseWood(30);
                resources.decreaseFood(20);
                resources.decreaseMetal(20);
            }

            case "Stables": {
                troops.getCavalry().increaseAmount(numberToTrain);

                resources.decreaseWood(20);
                resources.decreaseFood(40);
                resources.decreaseMetal(30);
            }

        }

    }

}