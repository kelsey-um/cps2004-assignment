public class Resources {
    int food;
    int wood;
    int metal;

    public Resources(){
        this.food = 0;
        this.wood = 0;
        this.metal = 0;
    }

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
