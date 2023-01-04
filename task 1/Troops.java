class Troops {
    protected int attack;
    protected int speed;
    protected int health;

    protected int amount;

}

class Swordsmen extends Troops {

    public Swordsmen() {
        attack = 20;
        speed = 10;
        health = 30;
        amount = 0;
    }

}

class Archers extends Troops {

    public Archers() {
        attack = 10;
        speed = 10;
        health = 10;
        amount = 0;
    }

}

class Cavalry extends Troops {

    public Cavalry() {

        attack = 30;
        speed = 30;
        health = 20;
        amount = 0;

    }

}