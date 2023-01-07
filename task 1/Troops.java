public class Troops {

    protected Swordsmen swordsmen;
    protected Archers archers;
    protected Cavalry cavalry;

    public Troops() {
        this.swordsmen = new Swordsmen();
        this.archers = new Archers();
        this.cavalry = new Cavalry();
    }

    public Swordsmen getSwordsmen() {
        return swordsmen;
    }

    public Archers getArchers() {
        return archers;
    }

    public Cavalry getCavalry() {
        return cavalry;
    }

    public void increaseSwordsmen(int amount) {
        swordsmen.increaseAmount(amount);
    }

    public void decreaseSwordsmen(int amount){
        swordsmen.decreaseAmount(amount);
    }

    public void increaseArchers(int amount) {
        archers.increaseAmount(amount);
    }

    public void decreaseArchers(int amount){
        archers.decreaseAmount(amount);
    }

    public void increaseCavalry(int amount) {
        cavalry.increaseAmount(amount);
    }

    public void decreaseCavalry(int amount){
        cavalry.decreaseAmount(amount);
    }
}

class Army extends Troops{

    private int totalAttack;
    private int totalHealth;
    private int carryingCapacity;
    private int marchingSpeed;

    private Player owner;

    //current location
    private int currentX;
    private int currentY;
    
    //coordinates of village to attack
    private int attackX;
    private int attackY;

    public Army(){

        this.totalAttack = 0;
        this.totalHealth = 0;
        this.carryingCapacity = 0;
        this.marchingSpeed = 0;
        
    }

    public int getCurrentX(){
        return currentX;
    }

    public int getCurrentY(){
        return currentY;
    }

    public int getAttackX(){
        return attackX;
    }

    public int getAttackY(){
        return attackY;
    }

    public Player getOwner(){
        return owner;
    }

    public void updateStats(int attackX , int attackY, Player owner, Map map){
        this.totalAttack = (swordsmen.getAmount() * swordsmen.getAttack()) + (archers.getAmount() * archers.getAttack()) + (cavalry.getAmount() * cavalry.getAttack());

        this.totalHealth = (swordsmen.getAmount() * swordsmen.getHealth()) + (archers.getAmount() * archers.getHealth()) + (cavalry.getAmount() * cavalry.getHealth());

        this.carryingCapacity = (swordsmen.getAmount() * swordsmen.getCarryingCapacity()) + (archers.getAmount() * archers.getCarryingCapacity()) + (cavalry.getAmount() * cavalry.getCarryingCapacity());

        if(cavalry.getAmount() > 0){
            this.marchingSpeed = cavalry.getSpeed();
        } else if (archers.getAmount() > 0){
            this.marchingSpeed = archers.getSpeed();
        } else if (swordsmen.getAmount() > 0){
            this.marchingSpeed = swordsmen.getSpeed();
        }
    
        this.attackX = attackX;
        this.attackY = attackY;

        this.owner = owner;

        this.currentX = owner.getXCoordinate();
        this.currentY = owner.getYCoordinate();

        map.addArmy(this);


    }

}
