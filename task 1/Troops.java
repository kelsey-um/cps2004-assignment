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

    public void decreaseSwordsmen(int amount) {
        swordsmen.decreaseAmount(amount);
    }

    public void increaseArchers(int amount) {
        archers.increaseAmount(amount);
    }

    public void decreaseArchers(int amount) {
        archers.decreaseAmount(amount);
    }

    public void increaseCavalry(int amount) {
        cavalry.increaseAmount(amount);
    }

    public void decreaseCavalry(int amount) {
        cavalry.decreaseAmount(amount);
    }
}

class Army extends Troops {

    private int totalAttack;
    private int totalHealth;
    private int carryingCapacity;
    private int marchingSpeed;

    private Resources resources;

    private Player owner;

    // current location
    private int currentX;
    private int currentY;

    // coordinates of village to attack
    private int targetX;
    private int targetY;
    private Player targetPlayer;

    public Army(Player owner) {

        this.totalAttack = 0;
        this.totalHealth = 0;
        this.carryingCapacity = 0;
        this.marchingSpeed = 0;
        this.owner = owner;
        this.currentX = owner.getXCoordinate();
        this.currentY = owner.getYCoordinate();
        this.resources = new Resources();

    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }

    public void setTargets(Player targetPlayer) {
        this.targetPlayer = targetPlayer;

        this.targetX = targetPlayer.getXCoordinate();
        this.targetY = targetPlayer.getYCoordinate();
    }

    public Player getTargetPlayer() {
        return targetPlayer;
    }

    public Player getOwner() {
        return owner;
    }

    public int getSpeed() {
        return marchingSpeed;
    }

    public Resources getResources() {
        return resources;
    }

    public void updateStats() {
        this.totalAttack = (swordsmen.getAmount() * swordsmen.getAttack()) + (archers.getAmount() * archers.getAttack())
                + (cavalry.getAmount() * cavalry.getAttack());

        this.totalHealth = (swordsmen.getAmount() * swordsmen.getHealth()) + (archers.getAmount() * archers.getHealth())
                + (cavalry.getAmount() * cavalry.getHealth());

        this.carryingCapacity = (swordsmen.getAmount() * swordsmen.getCarryingCapacity())
                + (archers.getAmount() * archers.getCarryingCapacity())
                + (cavalry.getAmount() * cavalry.getCarryingCapacity());

        if (swordsmen.getAmount() > 0) {

            this.marchingSpeed = swordsmen.getSpeed();

        } else if (archers.getAmount() > 0) {

            this.marchingSpeed = archers.getSpeed();

        } else if (cavalry.getAmount() > 0) {

            this.marchingSpeed = cavalry.getSpeed();

        }

    }

    public void friendlyArrival() {

        System.out.println("\nAn army has arrived back at the village\n");

        owner.getVillage().armyArrival(this);

    }

    public Boolean attackVillage(Player targetPlayer) {

        Village targetVillage = targetPlayer.getVillage();
        Troops targetTroops = targetVillage.getTroops();
        int randomNum;

        // calculating attack of village
        int villageAttack = (targetTroops.getSwordsmen().getAmount() * swordsmen.getAttack())
                + (targetTroops.getArchers().getAmount() * archers.getAttack())
                + (targetTroops.getCavalry().getAmount() * cavalry.getAttack());

        int villageHealth = targetVillage.getHealth();

        // army attacks village
        while (villageAttack != 0 && totalHealth > villageAttack) {

            // choose troop at random to kill
            randomNum = (int) (Math.random() * (3 - 1)) + 1;

            switch (randomNum) {

                case 1: { // kill swordsman

                    if (this.swordsmen.getAmount() > 0) {

                        this.swordsmen.decreaseAmount(1);

                    }

                    break;
                }

                case 2: { // kill archer

                    if (this.archers.getAmount() > 0) {

                        this.archers.decreaseAmount(1);

                    }

                    break;
                }

                case 3: { // kill cavalry

                    if (this.cavalry.getAmount() > 0) {

                        this.cavalry.decreaseAmount(1);

                    }

                    break;
                }


            }

            updateStats();

        }

        // village attacks army
        while (villageHealth > totalAttack) {

            // choose troop at random to kill
            randomNum = (int) (Math.random() * (3 - 1)) + 1;

            switch (randomNum) {

                case 1: { // kill swordsman

                    if (targetTroops.getSwordsmen().getAmount() > 0) {

                        targetTroops.getSwordsmen().decreaseAmount(1);

                    }

                    break;
                }

                case 2: { // kill archer

                    if (targetTroops.getArchers().getAmount() > 0) {

                        targetTroops.getArchers().decreaseAmount(1);

                    }

                    break;
                }

                case 3: { // kill cavalry

                    if (targetTroops.getCavalry().getAmount() > 0) {

                        targetTroops.getCavalry().decreaseAmount(1);

                    }

                    break;
                }

            }

            villageHealth = (targetTroops.getSwordsmen().getAmount() * swordsmen.getHealth())
                    + (targetTroops.getArchers().getAmount() * archers.getHealth())
                    + (targetTroops.getCavalry().getAmount() * cavalry.getHealth());

        }

        if (totalAttack > 0) { // attacker still has troops standing

            // damage village
            targetVillage.decreaseHealth(totalAttack);

            // steal resources
            Resources targetResources = targetVillage.getResources();

            for (int i = 0; i < carryingCapacity; i++) {
                // choose resource at random to steal
                randomNum = (int) (Math.random() * (3 - 1)) + 1;

                switch (randomNum) {

                    case 1: { // steal wood
                        if (targetResources.getWood() > 0) {

                            targetResources.decreaseWood(1);
                            resources.increaseWood(1);

                        } else {

                            i--;

                        }

                        break;
                    }

                    case 2: { // steal food

                        if (targetResources.getFood() > 0) {

                            targetResources.decreaseFood(1);
                            resources.increaseFood(1);

                        } else {

                            i--;

                        }

                        break;
                    }

                    case 3: { // steal metal

                        if (targetResources.getMetal() > 0) {

                            targetResources.decreaseMetal(1);
                            resources.increaseMetal(1);

                        } else {

                            i--;

                        }

                        break;
                    }


                }
            }

            return true;

        } else { // attacker lost
            return false;
        }
    }
}
