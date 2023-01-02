import java.util.*;

public class Village {
    
    
    int health;
    // Resources resources;
    Troops troops;
    
    ArrayList<Farm> farms = new ArrayList<Farm>();
    ArrayList<Lumbermill> lumbermills = new ArrayList<Lumbermill>();
    ArrayList<Forge> forges = new ArrayList<Forge>();
    ArrayList<Barracks> barracks = new ArrayList<Barracks>();
    ArrayList<ArcheryRange> archeryranges = new ArrayList<ArcheryRange>();
    ArrayList<Stables> stables = new ArrayList<Stables>();


    public Village(){
        this.health = 100;
        troops = new Troops();    
    }



}
