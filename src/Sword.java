public class Sword extends GameO{
    Sword(){
        super();
    }
    @Override
    GameO tickk(){
        return new Sword();
    }
    public String toString(){
        return "Sword is shimmering.";
    }
}
