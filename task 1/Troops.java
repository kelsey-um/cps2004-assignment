public class Troops {
    
    private Swordsmen swordsmen;
    private Archers archers;
    private Cavalry cavalry;

    public Troops(){
        this.swordsmen = new Swordsmen();
        this.archers = new Archers();
        this.cavalry = new Cavalry();
    }

    public Swordsmen getSwordsmen(){
        return swordsmen;
    }

    public Archers getArchers(){
        return archers;
    }

    public Cavalry getCavalry(){
        return cavalry;
    }

}
