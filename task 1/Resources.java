public class Resources {
    int food;
    int wood;
    int metal;

    public Resources(){
        this.food = 25;
        this.wood = 20;
        this.metal = 35;
    }

    void displayResources(){ //display resources to the user
        System.out.println("\nCurrent Resources:");

        System.out.println("Food:  "+ food);
        System.out.println("Wood:  " + wood);
        System.out.println("Metal: "+ metal + "\n");
    } 

    // increase/decrease resources functions
    void increaseFood(int num){
        this.food += num;
    }
    
    void decreaseFood(int num){
        this.food -= num;
    }
    
    void increaseWood(int num){
        this.wood += num;
    }
    
    void decreaseWood(int num){
        this.wood -= num;
    }
    
    void increaseMetal(int num){
        this.metal += num;
    }
    
    void decreaseMetal(int num){
        this.metal -= num;
    }
}
