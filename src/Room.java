import java.util.ArrayList;
class Room{
    private final String name;
    private final GameO g;
    Room (String name){
        this.name = name;
        this.g = null;
    }
    Room (String name,GameO g){
        this.name = name;
        this.g =g;
    }
    public Room add(GameO g){
        return new Room(this.name,g);         
    }
    public Room tick(){
        return new Room(this.name, g.tickk());
    }
    public String toString(){
        return g.toString();
    }
}
