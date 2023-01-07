class TroopStats {
    protected int attack;
    protected int speed;
    protected int health;
    protected int carryingCapacity;

    protected int amount;

    public int getAmount(){
        return amount;
    }

    public int getAttack(){
        return attack;
    }

    public int getSpeed(){
        return speed;
    }

    public int getHealth(){
        return health;
    }

    public int getCarryingCapacity(){
        return carryingCapacity;
    }

    public void increaseAmount(int num) {
        amount += num;
    }

    public void decreaseAmount(int num) {
        amount -= num;
    }

}

class Swordsmen extends TroopStats {

    public Swordsmen() {
        attack = 20;
        speed = 1;
        health = 30;
        carryingCapacity = 4;
        amount = 0;
    }

}

class Archers extends TroopStats {

    public Archers() {
        attack = 10;
        speed = 2;
        health = 10;
        carryingCapacity = 8;
        amount = 0;
    }

}

class Cavalry extends TroopStats {

    public Cavalry() {

        attack = 30;
        speed = 4;
        health = 20;
        carryingCapacity = 15;
        amount = 0;

    }

}