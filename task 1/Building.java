class Building {
    protected String type;
    protected int id;
    protected byte level;

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

        if (type.equals("Farm")) {

            resources.increaseFood(level * 10);

        } else if (type.equals("Lumber Mill")) {

            resources.increaseWood(level * 10);

        } else if (type.equals("Forge")) {

            resources.increaseMetal(level * 10);

        }

    }

}

class TroopBuilding extends Building {

    public TroopBuilding(String type, int id) {
        super(type, id);
    }

}