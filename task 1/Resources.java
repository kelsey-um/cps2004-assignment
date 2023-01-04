public class Resources {
    private int food;
    private int wood;
    private int metal;

    // public Resources(){ //every village starts with enough resources to build one
    // of each resource generating buildings
    // this.food = 40;
    // this.wood = 50;
    // this.metal = 70;
    // }

    public Resources() {
        this.food = 10000;
        this.wood = 10000;
        this.metal = 10000;
    }

    public void printResources() { // display resources to the user
        System.out.println("\nCurrent Resources:");

        System.out.println("Food:  " + food);
        System.out.println("Wood:  " + wood);
        System.out.println("Metal: " + metal + "\n");
    }

    // get methods
    public int getFood() {
        return food;
    }

    public int getWood() {
        return wood;
    }

    public int getMetal() {
        return metal;
    }

    // increase/decrease resources methods
    public void increaseFood(int num) {
        this.food += num;
    }

    public void decreaseFood(int num) {
        this.food -= num;
    }

    public void increaseWood(int num) {
        this.wood += num;
    }

    public void decreaseWood(int num) {
        this.wood -= num;
    }

    public void increaseMetal(int num) {
        this.metal += num;
    }

    public void decreaseMetal(int num) {
        this.metal -= num;
    }
}