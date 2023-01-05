public class Troops {

    private Swordsmen swordsmen;
    private Archers archers;
    private Cavalry cavalry;

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

    public void trainSwordsmen(int amount) {
        swordsmen.increaseAmount(amount);
    }

    public void trainArchers(int amount) {
        archers.increaseAmount(amount);
    }

    public void trainCavalry(int amount) {
        cavalry.increaseAmount(amount);
    }
}
