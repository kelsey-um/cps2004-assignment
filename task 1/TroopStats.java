class TroopStats {
    protected int attack;
    protected int speed;
    protected int health;

    protected int amount;

    public void increaseAmount(int num){
        amount += num;
    }

    public void decreaseAmount(int num){
        amount -= num;
    }

}

class Swordsmen extends TroopStats {

    public Swordsmen() {
        attack = 20;
        speed = 10;
        health = 30;
        amount = 0;
    }

}

class Archers extends TroopStats {

    public Archers() {
        attack = 10;
        speed = 10;
        health = 10;
        amount = 0;
    }

}

class Cavalry extends TroopStats {

    public Cavalry() {

        attack = 30;
        speed = 30;
        health = 20;
        amount = 0;

    }

}